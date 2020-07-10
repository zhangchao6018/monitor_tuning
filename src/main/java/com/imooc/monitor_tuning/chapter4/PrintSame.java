package com.imooc.monitor_tuning.chapter4;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;

@BTrace
public class PrintSame {
	
	@OnMethod(
	        clazz="com.imooc.monitor_tuning.chapter4.Ch4Controller",
	        method="same"
	)
	/**
	 * 方法重载根据参数列表匹配对应方法  这里匹配的是same3
	 */
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int id) {
		BTraceUtils.println(pcn+","+pmn + "," + id);
		BTraceUtils.println();
    }
}
