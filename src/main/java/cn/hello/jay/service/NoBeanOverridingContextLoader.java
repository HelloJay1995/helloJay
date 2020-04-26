package cn.hello.jay.service;

import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoader;

import javax.servlet.ServletContext;

/**
 * @author 周健以
 * @Date 2020年03月10日
 */
@Component
public class NoBeanOverridingContextLoader extends ContextLoader {

    @Override
    protected void customizeContext(ServletContext servletContext, ConfigurableWebApplicationContext applicationContext) {
        super.customizeContext(servletContext, applicationContext);
        AbstractRefreshableApplicationContext arac = (AbstractRefreshableApplicationContext) applicationContext;
        arac.setAllowBeanDefinitionOverriding(false);
        arac.setAllowCircularReferences(false);
    }
}