package com.tzy777.testssm;

/**
 * @author lipu@csii.com.cn
 * @date 2018/6/28 10:52
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器 spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring/spring-dao.xml", "classpath:config/spring/spring-service.xml" })
public class BaseTest {
}
