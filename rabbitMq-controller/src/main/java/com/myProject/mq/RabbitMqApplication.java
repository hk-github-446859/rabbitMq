package com.myProject.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.myProject.*"})
@MapperScan("com.myProject.**.dao")
//@EnableMybatisRepositories(mapperLocations = {"classpath*:mapper/*.xml"})
//@ImportResource({"classpath*:mapper/*.xml"})
@PropertySource(value = {"classpath:config/${spring.profiles.active}/database.properties","classpath:config/${spring.profiles.active}/global.properties"}, ignoreResourceNotFound = true)
public class RabbitMqApplication {
    private static volatile boolean running = true;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(RabbitMqApplication.class, args);

        System.out.println("启动成功");
        synchronized (RabbitMqApplication.class) {
            while (running) {
                try {
                    RabbitMqApplication.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    SpringApplication.exit(context);
                }
            }
        }
    }
}
