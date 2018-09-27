package com.bigwhite.service;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * 
 * @author beryl
 *代理类：客户类通过代理类访问委托类，访问目标类进行增强操作
 */
public class CglibProxy {
	
	//tc:目标类
	//mi:委托类对象
	public static Object newProxyInstance(Class tc,MethodInterceptor mi){
		
		//增强器
		Enhancer enhancer = new Enhancer();
		//指定目标类，即指定父类对象
		enhancer.setSuperclass(SomeService.class);
		//指定委托对象
		enhancer.setCallback(mi);
		return enhancer.create();
	}
}