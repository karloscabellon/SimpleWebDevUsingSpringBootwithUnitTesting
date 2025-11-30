package com.example.ToDoList.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name:My Spring App}")
    public String appName;

    /**
     * Handles HTTP GET requests to the "/hello" path.
     * The method returns a string which is written directly to the HTTP response body.
     *
     * @return A greeting message including the application name.
     */
    @RequestMapping("/hello")
    public String index() {
        System.out.println("Hello from " + appName + "! Your application is using the REST pattern.");
        return "index.html";
    }
}