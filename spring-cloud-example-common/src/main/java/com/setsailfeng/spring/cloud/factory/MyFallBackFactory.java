package com.setsailfeng.spring.cloud.factory;

import com.setsailfeng.spring.cloud.api.EmployeeRemoteService;
import com.setsailfeng.spring.cloud.entity.Employee;
import com.setsailfeng.spring.cloud.utils.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 实现Consumer端服务降级功能。
 * 需要实现FallbackFactory接口，泛型需要传入@FeignClient标记的接口类型。
 * 此程序中是需要远程访问的EmployeeRemoteService接口.
 * 远程调用provider对应的方法失败后，会执行此类中EmployeeRemoteService中的实现的方法，
 * 从而实现Consumer端服务降级。
 */

@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {

    @Override
    public EmployeeRemoteService create(Throwable cause) {
        return new EmployeeRemoteService() {
            @Override
            public Employee getEmployeeRemote() {
                return null;
            }

            @Override
            public List<Employee> getEmpListRemote(String keyword) {
                return null;
            }

            @Override
            public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal) {
                return ResultEntity.failed("降级机制已经生效 " + cause.getMessage());
            }
        };
    }
}
