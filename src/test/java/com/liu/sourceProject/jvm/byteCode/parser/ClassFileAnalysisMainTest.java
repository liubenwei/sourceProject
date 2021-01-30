package com.liu.sourceProject.jvm.byteCode.parser;

import java.nio.ByteBuffer;

import org.junit.Test;

import com.liu.sourceProject.jvm.byteCode.parser.type.ClassFile;
import com.liu.sourceProject.jvm.byteCode.parser.utils.ClassFileAnalysiser;

/**
 * @author liu
 * @Date 2021/1/30 11:09
 */
public class ClassFileAnalysisMainTest {

	@Test
	public void testMagicAndVersion() throws Exception {
		ByteBuffer codeBuffer = ClassFileAnalysisMain
				.readFile("D:\\ideaProject\\sourceProject\\target\\test-classes\\com\\liu\\sourceProject\\jvm\\javaagnet\\MyAgentTest.class");
		ClassFile classFile = ClassFileAnalysiser.analysis(codeBuffer);
		System.out.println(classFile.getMagic().toHexString());
		System.out.println(classFile.getMinorVersion().toHexString());
		System.out.println(classFile.getMajorVersion().toHexString());
	}
}