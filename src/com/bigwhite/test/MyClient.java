package com.bigwhite.test;

import com.bigwhite.service.CglibProxy;
import com.bigwhite.service.ServiceEntrust;
import com.bigwhite.service.SomeService;

/**
 * 客户类：具体方法调用处
 * @author beryl
 *
 */
public class MyClient {
	/**
	 * @Author  beryl
	 * 思路：
	 * 业务对象建立
	 * 客户类
	 * 代理类-自定义代理类
	 * 委托类建立-增强目标-实现Methodinterceptor
	 * 
	 */
	public static void main(String[] args) {
		//目标对象
		SomeService target = new SomeService();
		//委托类对象
		ServiceEntrust mi = new ServiceEntrust(target);
		
		//获取动态代理对象
		SomeService  service = (SomeService) CglibProxy.newProxyInstance(SomeService.class, mi);
		System.out.println(service.doFirst());
		System.out.println(service.doSecond());
	}
}
