package com.setsailfeng.spring.cloud.api;

import com.setsailfeng.spring.cloud.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//表示当前接口和一个Provider对应，该Provider的名字是setsail-provider.
@FeignClient(value = "setsail-provider")
public interface EmployeeRemoteService {

    // 远程调用的接口方法
    // 要求@RequestMapping注解映射的地址一致
    // 要求方法声明一致
    // 用来获取请求参数的@RequestParam、@PathVariable、@RequestBody不能省略，两边一致
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote();

    @RequestMapping("/provider/get/employee/list/remote")
    public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);

}