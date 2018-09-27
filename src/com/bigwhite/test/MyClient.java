package com.bigwhite.test;

import java.lang.reflect.Proxy;

import com.bigwhite.service.ISomeService;
import com.bigwhite.service.ServiceEntrust;
import com.bigwhite.service.SomeServiceImpl;

public class MyClient {
	/*步骤
	 * 1、目标类必须实现业务接口
	 * 2、用的为类Proxy.newProxyInstance()
	 * 3、客户类中需有目标对象
	 * 4、需要定义一个实现invocationhandler的接口
	 * */
	public static void main(String[] args) {
		
//	传说中的目标对象target
		ISomeService target = new SomeServiceImpl();
		
		ServiceEntrust hi = new ServiceEntrust(target);
		
		/*
		 * loader：目标类的类加载器
		 * interfaces：目标类实现的所有接口
		 * h：委托类对象
		 * */
		ISomeService someservice = (ISomeService) Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				hi);
		System.out.println(someservice.doFirst());
		System.out.println(someservice.doSecond());
	}
}
