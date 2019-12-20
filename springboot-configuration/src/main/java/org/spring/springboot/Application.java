package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot 应用启动类
 *
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }

    @RestController
    public class HelloWorldController {

        @RequestMapping("/")
        public String sayHello() {
            return "Hello,World!";
        }
    }


    //监听转发路由rouite:nihao
    @RestController
    public class ListenerController {

        @RequestMapping("/nihao")
        public String sayHello() {
            return "你好啊!";
        }
    }

}
