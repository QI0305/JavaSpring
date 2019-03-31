package com.javaee.spring;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 测试生命周期的Bean
 * Created by qijichao on 2019/03/30.
 */
public class StudentBean implements ApplicationContextAware,InitializingBean, BeanNameAware, BeanFactoryAware {
    private String name;
    private int age;
    private String beanName;//实现了BeanNameAware接口，Spring可以将BeanName注入该属性中
    private BeanFactory beanFactory;//实现了BeanFactory接口，Spring可将BeanFactory注入该属性中


    public StudentBean() {
        System.out.println("1.Bean构造方法:学生类的无参构造方法");
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    public void setName(String name) {
        System.out.println("2.set注入:注入学生的name属性");
        this.name = name;
    }

    public void setAge(int age) {
        System.out.println("2.set注入:注入学生的age属性");
        this.age = age;
    }
    /**
     * 自己编写的初始化方法
     */
    public void myInit() {
        System.out.println("8.init-method:调用init-method属性配置的初始化方法");
    }
    /**
     * BeanFactoryAware接口的方法
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("4.BeanFactoryAware接口:调用BeanFactoryAware的setBeanFactory方法得到beanFactory引用");
    }

    /**
     * BeanNameAware接口的方法
     *
     * @param name
     */
    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("3.BeanNameAware接口:调用BeanNameAware的setBeanName方法得到Bean的名称");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("5.获取spring容器中其他的bean："+applicationContext.getBean("studentBean"));
    }
    /**
     * InitializingBean接口的方法
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("7.InitializingBean接口:调用InitializingBean接口的afterPropertiesSet方法");
    }

}
