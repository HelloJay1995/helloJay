package cn.hello.jay.service;

import cn.hello.jay.mapper.UserMapperExt;
import cn.hello.jay.model.po.User;
import cn.hello.jay.model.vo.ConfirmResponse;
import cn.hello.jay.model.vo.SeatResponse;
import cn.hello.jay.model.vo.SelectResponse;
import cn.hello.jay.util.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class RogueService {


    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    private static ExecutorService login = Executors.newFixedThreadPool(1);

    private static Logger logger = LoggerFactory.getLogger(RogueService.class);

//    @Autowired
    private UserService userService;


    @Autowired
    public RogueService(@Lazy UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private UserMapperExt userMapper;

    public void rogue() {
        login();
        for (int i = 0; i < 20; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    realMan();
                }
            });
        }
    }

    private void realMan() {
        User user = queryUser();
        while (true) {
            try {
                if (user == null) {
                    break;
                }

                System.out.println(Thread.currentThread().getName());
                if (!isExceedingCancelDeadline("21:59:29")) {
                    sleep(1000 * 30);
                    continue;
                }

                String seatId = null;
                for (SeatResponse seat : RequestUtil.fetchAllSeats()) {
                    if (!"1".equals(seat.getStatus())) {
                        seatId = seat.getSeatId();
                    }
                }

                if (isExceedingCancelDeadline("22:20:00")) {
                    userMapper.updateAllNotDeleted();
                    continue;
                }

                if (StringUtils.isEmpty(seatId)) {
                    continue;
                }

                SelectResponse selectResponse;
                do {
                    selectResponse = RequestUtil.selectSeat(user.getJszh(), seatId);
                } while (selectResponse == null);

                if (selectResponse.isStatus()) {
                    deleteUser(user);
                    user = queryUser();
                    continue;
                }
                ConfirmResponse confirmResponseEnd = RequestUtil.confirmSeat(user.getJszh());
                if (confirmResponseEnd != null && confirmResponseEnd.isStatus()) {
                    deleteUser(user);
                    user = queryUser();
                    continue;
                }
                System.out.println();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteUser(User user) {
        user.setIsDeleted(true);
        userMapper.updateByPrimaryKeySelective(user);
    }

    private User queryUser() {
        List<User> users = userService.listEffectiveUser();
        if (!CollectionUtils.isEmpty(users)) {
            int index = Integer.parseInt(Thread.currentThread().getName().substring(Thread.currentThread().getName().lastIndexOf("-") + 1));
            if (index >= users.size()) {
                Random random = new Random();
                index = random.nextInt(users.size());
            }
            System.out.println("index:" + index);
            return users.get(index);
        }
        return null;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否超过截止时间
     *
     * @param deadline
     * @return
     */
    private boolean isExceedingCancelDeadline(String deadline) {
        boolean isExceeding = true;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            isExceeding = sdf.parse(sdf.format(new Date())).getTime() > sdf.parse(deadline).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isExceeding;
    }


    public void login() {
        login.submit(new Runnable() {
            @Override
            public void run() {

                List<User> users = userService.listEffectiveUser();
                while (true) {
                    try {

                        System.out.println("loginThread:" + Thread.currentThread().getName());
                        if (!isExceedingCancelDeadline("21:55:00")) {
                            sleep(1000 * 60);
                            continue;
                        }

                        for (User user : users) {
                            RequestUtil.login(user.getName(), user.getPassword());
                        }

                        if (isExceedingCancelDeadline("22:20:00")) {
                            break;
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }
        });
    }
}
