package com.duxinyu.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.duxinyu.community.dao")

@SpringBootApplication
/**
 * Spring的配置类，启动该类时:
 * 	1.可以启动spring内置的Tomcat
 * 	2.自动创建一个Spring容器
 * 	3.扫描与该类在同一个包下及子包下的bean，并自动装配到Spring容器中
 *
 * 	注：该包下的类要想被装配进去需要添加注解：
 * @Component(根注解，添加它一定能被识别为bean,以下三个注解与该注解等价，不过在不同作用的类中最好用相应的注解)
 *  1.@Controller（控制类中一般用它）
 *  2.@Service（服务类中一般用他）
 *  3.@Repository（与数据库有关的操作，一般用他）
 */

public class CommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
