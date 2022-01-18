package zzfree;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //服务发现客户端
public class AdminAdminManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminAdminManageApplication.class,args);
    }
}
