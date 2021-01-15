package com.setsailfeng.spring.cloud.handler;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.setsailfeng.spring.cloud.utils.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.setsailfeng.spring.cloud.entity.Employee;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeHandler {

	private Logger logger = LoggerFactory.getLogger(EmployeeHandler.class);

	//指定当前方法出现问题时调用的备份方法。指定熔断方法。
	@HystrixCommand(fallbackMethod = "getEmpWithCircuitBreakerBackup")
	@RequestMapping("/provider/get/emp/with/circuit/breaker")
	public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal) throws InterruptedException {

		if("挂了".equals(signal)){
			throw new RuntimeException("服务器挂了");
		}

		if("超时".equals(signal)){
			Thread.sleep(5000);
		}
		return ResultEntity.successWithData(new Employee(666, "Name666", 6666.66));
	}

	public ResultEntity<Employee> getEmpWithCircuitBreakerBackup(@RequestParam("signal") String signal){
		String message = "方法出现问题，执行断路（熔断）";
		return ResultEntity.failed(message);
	}

	@RequestMapping("/provider/get/employee/list/remote")
	public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword) {

		logger.info("keyword="+keyword);

		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(33, "empName33", 333.33));
		empList.add(new Employee(44, "empName44", 444.44));
		empList.add(new Employee(55, "empName55", 555.55));

		return empList;
	}
	
	@RequestMapping("/provider/get/emp/remote")
	public Employee getEmployeeRemote(HttpServletRequest request) {
		// 获取当前服务的端口号
		int serverPort = request.getServerPort();
		return new Employee(555, "tom555 "+ serverPort, 555.55);
	}
	@RequestMapping("/provider/get/employee/remote")
	public Employee getEmployeeRemote() {
		return new Employee(555, "tom555 ", 555.55);
	}
}
