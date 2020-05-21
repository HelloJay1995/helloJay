/**
 *
 */
package cn.hello.jay.practice.jdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyDescriptor;
import java.util.Date;

/**
 * @author 周健以
 * @Date 2019年01月14日
 */
public class ClassTest
        implements InitializingBean,
                           DisposableBean,
                           ApplicationContextAware,
                           BeanFactoryAware,
                           BeanPostProcessor,
                           InstantiationAwareBeanPostProcessor,
                           BeanFactoryPostProcessor {

    private Integer args;

    // 1
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

    // 2
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

    // 3
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInstantiation:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
        return null;
    }

    // 4
    public ClassTest() {
        System.out.println("ClassTest:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

    // 5
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInstantiation:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
        return false;
    }

    // 6
    public void setArgs(Integer args) {
        this.args = args;
        System.out.println("setArgs:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

    // 7
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

    // 8
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
        return null;
    }

    // 9
    @Override
    public void afterPropertiesSet() {
        System.out.println("afterPropertiesSet:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

    // 10
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
        return null;
    }

    //11
    @Override
    public void destroy() {
        System.out.println("destroy:" + JSON.toJSONString(new Date(), SerializerFeature.WriteDateUseDateFormat));
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        return null;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        context.getBean("ClassTest");
        ((ClassPathXmlApplicationContext) context).close();
    }
}
