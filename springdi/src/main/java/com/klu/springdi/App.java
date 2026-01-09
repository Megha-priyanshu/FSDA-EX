package com.klu.springdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student s1 = (Student) context.getBean("s1");
        System.out.println(s1);
    }

}
