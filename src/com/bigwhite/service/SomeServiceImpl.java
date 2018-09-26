package com.bigwhite.service;

public class SomeServiceImpl implements ISomeService {

	@Override
	public String doFirst() {
		System.out.println("执行doFirst");
		return "beiJing";
	}

	@Override
	public String doSecond() {
		System.out.println("执行doSecond");
		return "ShangHai";
	}
}
