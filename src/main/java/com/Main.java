package com;

import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import java.util.List;

/**
 * Created by igor on 16.10.2014.
 */

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(".\\spring-context.xml");

        UserService userService = (UserService) context.getBean("UserServiceImpl");

        try {
            User user1 = new User(1, "first user");
            User user2 = new User(2, "second user");
            userService.add(user1, user2);
        } catch (Exception e){
            System.out.println("Exception: "+ e.getMessage());
        }

        List<User> users = userService.getAll();

        System.out.println("User list:");
        for (User user: users){
            System.out.println(user.toString());
        }

    }
}
