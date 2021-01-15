package com.setsailfeng.spring.cloud.handler;

import com.setsailfeng.spring.cloud.entity.Employee;
import com.setsailfeng.spring.cloud.api.EmployeeRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignHumanResourceHandler {

    // 装配调用远程微服务的接口，后面向调用本地方法一样直接使用
    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @RequestMapping("/feign/consumer/get/employee")
    public Employee getEmployeeRemote() {
        return employeeRemoteService.getEmployeeRemote();
    }

    @RequestMapping("/feign/consumer/search")
    public List<Employee> getEmpListRemote(String keyword) {

        return employeeRemoteService.getEmpListRemote(keyword);
    }
}
