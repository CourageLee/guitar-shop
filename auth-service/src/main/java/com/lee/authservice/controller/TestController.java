package com.lee.authservice.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Lee
 * @version 1.0
 * @date 2021/5/8 11:05
 */
@RestController
public class TestController {
    @GetMapping("/auth")
    public String listAuth() {
        return "/auth|GET";
    }
    @GetMapping("/auth/{id}")
    public String getAuth(@PathVariable("id") String id) {
        return "/auth/*|GET" + "  id";
    }

    @GetMapping("/auth-count")
    public String getAuthCount() {
        return "/auth-count|GET";
    }

    @PostMapping("/auth")
    public String addAuth(@RequestBody Map<String, String> body) {
        for (Map.Entry<String, String> entry: body.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
        return "/auth|POST  " + body.size();
    }

    @DeleteMapping("/auth/{id}")
    public String deleteAuth(@PathVariable("id") String id) {
        return "/auth/*|DELETE" + id;
    }

    @PutMapping("/auth/{id}")
    public String updateAuth(@PathVariable("id") String id, @RequestBody Map<String, String> body) {
        for (Map.Entry<String, String> entry: body.entrySet()) {
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
        return "/auth/*|PUT  " + id;
    }
}
