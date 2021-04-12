package com.duxinyu.community;

import com.duxinyu.community.dao.AlphaDao;
import com.duxinyu.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
//在测试代码中启用CommunityApplication类作为配置类(正式环境下就是用该类作为配置类)
@ContextConfiguration(classes = CommunityApplication.class)
//实现ApplicationContextAware接口可在启动时创建Spring的容器
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	@Test
	public void testApplicationContext(){
		System.out.println(applicationContext);

//		将bean装配到Spring容器中
		AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class);
		System.out.println(alphaDao.select());

		alphaDao=applicationContext.getBean("alphaHibernate",AlphaDao.class);
		System.out.println(alphaDao.select());
	}

	@Test
	public void testManagement(){
//		被Spring容器管理的bean默认是单例模式的(即只会被实例化一次)
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);

		alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
	}

	@Test
	public void testBeanConfig(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
/**
 * 依赖注入的实现：
 * 		属性注入、构造器注入、set注入
 * 	    指在其前加注解@Autowired	、@Qualifier等
 */


	@Autowired
//	指定哪个bean注入给alphaDao
	@Qualifier("alphaHibernate")
//	当前的bean依赖的是接口，其底层的实现不与它直接耦合(解耦合)
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;


	@Test
	public void testDI(){
		System.out.println(alphaDao);
		System.out.println(alphaService);
		System.out.println(simpleDateFormat);
	}

}
