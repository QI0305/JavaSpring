package com.javaee.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestBean {
    public static void main(String[] args){
        System.out.println("--------------【初始化容器】---------------");
        String xmlPath = "com/javaee/spring/beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(xmlPath);
        System.out.println("-------------------【容器初始化成功】------------------");
        //得到studentBean，并显示其信息
        StudentBean studentBean = context.getBean("studentBean",StudentBean.class);
        System.out.println(studentBean);
    }
}