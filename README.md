[远程仓库地址](https://github.com/set-sail-feng/spring-cloud-example.git)

<h1>SpringCloud环境搭建测试案例</h1>

<h2>目前已经测试通过的场景如下：</h2>

[Eureka注册中心](http://localhost:5000/)

[ribbon负载均衡演示](http://localhost:4000/consumer/ribbon/get/employee)

[Feign远程访问Service接口演示1](http://localhost:7000/feign/consumer/get/employee)

[Feign远程访问Service接口演示2](http://localhost:7000/feign/consumer/search)

[CircuitBreaker正常访问](http://localhost:2020/provider/get/emp/with/circuit/breaker?signal=222)

[CircuitBreaker超时访问,HystrixCommand指定备份方法](http://localhost:2020/provider/get/emp/with/circuit/breaker?signal=超时)

[CircuitBreaker挂了访问,HystrixCommand指定备份方法](http://localhost:2020/provider/get/emp/with/circuit/breaker?signal=挂了)

[仪表盘监控地址](http://localhost:8000/hystrix)

[需要被监控的微服务](http://localhost:2020/actuator/hystrix.stream)

[zuul+微服务名称+url功能访问](http://localhost:9000/setsail-feign-consumer/feign/consumer/test/fallback?signal=222)

[zuul给微服务起别名+url功能访问（优点：不暴露微服务的名称）](http://localhost:9000/zuul-emp/feign/consumer/test/fallback?signal=222)  

[zuul+Context-path+prefix+别名+url功能访问](http://localhost:9000/love/oldboy/zuul-emp/feign/consumer/test/fallback?signal=222)     