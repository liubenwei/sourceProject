package com.liu.sourceProject.jdk.expcetion.try_with_ressources;

import java.io.IOException;

/**
 * @author liu
 * @Date 2020/12/31 16:38
 */
public class AutoCloseResource implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("closeing...");
		throw new RuntimeException("exception in close()");
	}

	public void work() throws IOException {
		System.out.println("working...");
		throw new IOException("exception on  work()");
	}
}
