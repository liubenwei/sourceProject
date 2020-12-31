package com.liu.sourceProject.jdk.expcetion.try_with_ressources;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author liu
 * @Date 2020/12/31 16:41
 */
public class AutoCloseResourceTest {
	public static void main(String[] args) throws IOException {
		AutoCloseResourceTest test = new AutoCloseResourceTest();
		test.autoCloseTest();
	}


	public void autoCloseTest() throws IOException {
		File file;
		try (AutoCloseResource resource = new AutoCloseResource();
				FileInputStream fileInputStream = new FileInputStream(
						new File("D:\\test.txt"));) {
			resource.work();
		}finally {
			System.out.println("sdf");
		}
	}

	public void tryFinallyTest() throws IOException {
		AutoCloseResource resource = null;
		try {
			resource = new AutoCloseResource();
			resource.work();
		} finally {
			if (resource != null) {
				resource.close();

			}
		}
	}
}
