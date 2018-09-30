package cn.hello.jay.util;

import cn.hello.jay.model.vo.ConfirmResponse;
import cn.hello.jay.model.vo.LoginResponse;
import cn.hello.jay.model.vo.SeatResponse;
import cn.hello.jay.model.vo.SelectResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

import static cn.hello.jay.util.HttpUtil.*;

public class RequestUtil {

    private static Logger logger = LoggerFactory.getLogger(RequestUtil.class);

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    public static LoginResponse login(String name, String password) {
        String url = "http://mob.huanghuai.edu.cn/huanghuai/booksLogin";
        Map<String, String> params = new HashMap<>();
        params.put("jszh", name);
        params.put("password", password);
        Map<String, String> headers = new HashMap<>();
        headers.put("cache", "60");
        headers.put("Host", "mob.huanghuai.edu.cn");
        headers.put("User-Agent", "okhttp/3.9.0");
        headers.put("Cache-Control", "max-age=2592000");
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        LoginResponse loginResponse = null;
        try {
            loginResponse = JSON.parseObject(postForm(url, params, headers), LoginResponse.class);
        } catch (IOException e) {
            logger.error("登录异常,请求:{}", JSON.toJSONString(params), e);
            e.printStackTrace();
        }
        logger.info("登录,请求:{},响应:{}", new Object[]{JSON.toJSONString(params), JSON.toJSONString(loginResponse)});
        return loginResponse;
    }

    /**
     * 静轩房间
     *
     * @return
     */
    private static List<SeatResponse> fetchJingXuanRoomSeat() {
        String url = "http://mob.huanghuai.edu.cn/huanghuai/libraryTourField_orderAll?roomName=%E9%9D%99%E8%BD%A9";
        Map<String, String> headers = new HashMap<>();
        headers.put("cache", "0");
        headers.put("Host", "mob.huanghuai.edu.cn");
        headers.put("User-Agent", "okhttp/3.9.0");
        headers.put("If-Modified-Since", new Date().toString());
        List<SeatResponse> list = new ArrayList<>();
        try {
            list = JSONArray.parseArray(JSON.parseObject(get(url, headers)).get("param").toString(), SeatResponse.class);
        } catch (IOException e) {
            logger.error("静轩房间异常", e);
            e.printStackTrace();
        }
        logger.info("静轩房间,响应:{}", JSON.toJSONString(list));
        return list;
    }

    /**
     * 萃雅房间
     *
     * @return
     */
    private static List<SeatResponse> fetchCuiYaRoomSeat() {
        String url = "http://mob.huanghuai.edu.cn/huanghuai/libraryTourField_orderAll?roomName=%E8%90%83%E9%9B%85";
        Map<String, String> headers = new HashMap<>();
        headers.put("cache", "0");
        headers.put("Host", "mob.huanghuai.edu.cn");
        headers.put("User-Agent", "okhttp/3.9.0");
        headers.put("If-Modified-Since", new Date().toString());
        List<SeatResponse> list = new ArrayList<>();
        try {
            list = JSONArray.parseArray(JSON.parseObject(get(url, headers)).get("param").toString(), SeatResponse.class);
        } catch (IOException e) {
            logger.error("萃雅房间异常", e);
            e.printStackTrace();
        }
        logger.info("萃雅房间,响应:{}", JSON.toJSONString(list));
        return list;
    }

    public static List<SeatResponse> fetchAllSeats() {
        List<SeatResponse> all = new ArrayList<>();
        all.addAll(fetchJingXuanRoomSeat());
        all.addAll(fetchCuiYaRoomSeat());
        return all;
    }

    /**
     * 选择位置
     *
     * @param cardnum
     * @param seatId
     * @return
     */
    public static SelectResponse selectSeat(String cardnum, String seatId) {
        String url = "http://mob.huanghuai.edu.cn/huanghuai/libraryAppointmentOrder_appointSeat?cardnum=" + cardnum + "&seatId=" + seatId;
        Map<String, String> params = new HashMap<>();
        params.put("cardnum", cardnum);
        params.put("seatId", seatId);
        Map<String, String> headers = new HashMap<>();
        headers.put("cache", "0");
        headers.put("Host", "mob.huanghuai.edu.cn");
        headers.put("User-Agent", "okhttp/3.9.0");
        headers.put("If-Modified-Since", new Date().toString());
        SelectResponse selectResponse = null;
        try {
            selectResponse = JSON.parseObject(get(url, headers), SelectResponse.class);
        } catch (IOException e) {
            logger.error("选择位置异常,请求:{}", JSON.toJSONString(params), e);
            e.printStackTrace();
        }
        logger.info("选择位置,请求:{},响应:{}", new Object[]{JSON.toJSONString(params), JSON.toJSONString(selectResponse)});
        return selectResponse;
    }

    /**
     * 确认位置
     *
     * @param cardnum
     * @return
     */
    public static ConfirmResponse confirmSeat(String cardnum) {
        String url = "http://mob.huanghuai.edu.cn/huanghuai/libraryAppointmentOrder_getAppoint?cardnum=" + cardnum;
        Map<String, String> headers = new HashMap<>();
        headers.put("cache", "0");
        headers.put("Host", "mob.huanghuai.edu.cn");
        headers.put("User-Agent", "okhttp/3.9.0");
        ConfirmResponse confirmResponse = null;
        try {
            confirmResponse = JSON.parseObject(get(url, headers), ConfirmResponse.class);
        } catch (IOException e) {
            logger.error("确认位置,请求:{}", JSON.toJSONString(cardnum), e);
            e.printStackTrace();
        }
        logger.info("确认位置,请求:{},响应:{}", new Object[]{JSON.toJSONString(cardnum), JSON.toJSONString(confirmResponse)});
        return confirmResponse;
    }

}
