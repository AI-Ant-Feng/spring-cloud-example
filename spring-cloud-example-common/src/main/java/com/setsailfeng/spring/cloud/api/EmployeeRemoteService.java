package com.setsailfeng.spring.cloud.api;

import com.setsailfeng.spring.cloud.entity.Employee;
import com.setsailfeng.spring.cloud.factory.MyFallBackFactory;
import com.setsailfeng.spring.cloud.utils.ResultEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@FeignClient表示当前接口和一个Provider对应，
//         value属性指定要调用Provider的setsail-provider微服务.
//         如果访问Provider失败,fallbackFactory属性指定提供备用方案的工厂类型。
@FeignClient(value = "setsail-provider", fallbackFactory = MyFallBackFactory.class)
public interface EmployeeRemoteService {
    // 远程调用的接口方法
    // 要求@RequestMapping注解映射的地址一致
    // 要求方法声明一致
    // 用来获取请求参数的@RequestParam、@PathVariable、@RequestBody不能省略，两边一致
    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote();

    @RequestMapping("/provider/get/employee/list/remote")
    public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword);

    @RequestMapping("/provider/get/emp/with/circuit/breaker")
    public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal);
}