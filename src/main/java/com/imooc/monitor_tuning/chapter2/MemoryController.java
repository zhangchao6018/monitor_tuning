package com.imooc.monitor_tuning.chapter2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 触发内存溢出
 */
@RestController
public class MemoryController {
	
	private List<User>  userList = new ArrayList<User>();
	private List<Class<?>>  classList = new ArrayList<Class<?>>();
	
	/**
	 * 堆内存溢出
	 * 启动参数需设置如下参数
	 *
	 * -Xmx32M -Xms32M
	 *
	 * java.lang.OutOfMemoryError: Java heap space
	 * */
	@GetMapping("/heap")
	public String heap() {
		int i=0;
		while(true) {
			userList.add(new User(i++, UUID.randomUUID().toString()));
		}
	}
	
	
	/**
	 * 非堆内存溢出
	 * 启动参数需设置如下参数
	 * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
	 *
	 * Exception in thread "http-nio-12345-exec-1" java.lang.OutOfMemoryError: Metaspace
	 * */
	@GetMapping("/nonheap")
	public String nonheap() {
		while(true) {
			classList.addAll(Metaspace.createClasses());
		}
	}
	
}
