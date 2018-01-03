package com.zw.eureka;

import org.springframework.cloud.netflix.ribbon.RibbonClient;


/**
 * @Description 
 * @author 
 * @date 2017年12月14日  下午4:30:41
 * Company: zw
 * 
 * 除了可以用 注解方式@RibbonClient(name="RibbonEurekaProvider",configuration=MyConfig.class)
 * 实现之外 还可以通过配置文件的方式实现
 * 格式为：
 * 	clientName:
 *    ribbon:
 *      NFLoadBalancerRuleClassName: com.zw.eureka.MyRule
 */
//@RibbonClient(name="RibbonEurekaProvider",configuration=MyConfig.class)
public class MyClient {

}
