package com.setsailfeng.spring.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

//启用仪表盘监控的功能
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardMainType {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMainType.class, args);
    }
}
