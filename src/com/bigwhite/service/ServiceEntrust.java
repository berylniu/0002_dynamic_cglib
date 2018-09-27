package com.bigwhite.service;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * 
 * @author beryl
 *委托类
 *
 */
public class ServiceEntrust implements MethodInterceptor {
	/*
	 *Obj:代理对象
	 *method：目标方法
	 *args：目标方法的参数列表
	 *proxy：目标方法的代理对象 
	 * 
	 */
	//通过构造器关联目标类和委托类
	private SomeService target;
	public ServiceEntrust(SomeService target) {
		super();
		this.target = target;
	}
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
	Object result =	method.invoke(target, args);
		if(result != null){
			result = ((String)result).toUpperCase();
		}
		return result;
	}
}
