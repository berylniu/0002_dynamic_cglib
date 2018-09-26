package com.bigwhite.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceEntrust implements InvocationHandler {
	//建立委托类
	private ISomeService target;
	public ServiceEntrust(ISomeService target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//异常的处理
		Object result = method.invoke(target, args);
		
		if (method.getName().equals("doFirst") && result != null) {
			result = ((String) result).toUpperCase();
		}
		return result;
	}
}
