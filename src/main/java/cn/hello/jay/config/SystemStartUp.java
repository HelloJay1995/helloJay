package cn.hello.jay.config;

import com.alibaba.dubbo.common.utils.NetUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SystemStartUp implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            String ip = NetUtils.getLocalHost();
            log.info(String.format("系统[%s]-IP[%s]正常启动完毕", "APPLICATION", ip));
        }
    }
}