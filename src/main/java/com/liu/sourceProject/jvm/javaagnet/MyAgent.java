package com.liu.sourceProject.jvm.javaagnet;

import java.lang.instrument.Instrumentation;

/**
 * @author liu
 * @Date 2020/10/3 14:56
 */
public class MyAgent {
	//jvm
	public static void premains(String agentArgs,
			Instrumentation instrumentation) {
		System.out.println("hi! javaAgent" + agentArgs);
	}

	public static void premains(String agentArgs) {
		System.out.println("ddd");
	}
}
