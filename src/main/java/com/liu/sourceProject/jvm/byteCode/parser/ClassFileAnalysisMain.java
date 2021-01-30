package com.liu.sourceProject.jvm.byteCode.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

import com.liu.sourceProject.jvm.byteCode.parser.type.ClassFile;
import com.liu.sourceProject.jvm.byteCode.parser.utils.ClassFileAnalysiser;

/**
 * @author liu
 * @Date 2021/1/30 10:51
 */
public class ClassFileAnalysisMain {
	public static ByteBuffer readFile(String classPath) throws Exception {
		File file = new File(classPath);
		if (!file.exists()) {
			throw new Exception("file not exists!");
		}
		byte[] byteCoderBuffer = new byte[4096];
		int length;
		try (InputStream in = new FileInputStream(file)) {
			length = in.read(byteCoderBuffer);
		}
		if (length < 1) {
			throw new Exception("not read byte code.");
		}
		// 把字节数组包装成byteBuffer
		return ByteBuffer.wrap(byteCoderBuffer, 0, length).asReadOnlyBuffer();

	}

	public static void main(String[] args) throws Exception {
		ByteBuffer codeBuffer = readFile("xxx.class");
		ClassFile classFile = ClassFileAnalysiser.analysis(codeBuffer);
		System.out.println(classFile.getMagic());
	}
}
