package cn.weiyin.group07;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.weiyin.group07.mapper")
public class CakeshopSpringBootDevApplication {

    public static void main(String[] args) {
        SpringApplication.run(CakeshopSpringBootDevApplication.class, args);
    }

}
