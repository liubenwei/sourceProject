package com.liu.sourceProject.jvm.byteCode.parser.handler;

import java.nio.ByteBuffer;

import com.liu.sourceProject.jvm.byteCode.parser.type.ClassFile;
import com.liu.sourceProject.jvm.byteCode.parser.type.U2;

/**
 * @author liu
 * @Date 2021/1/27 16:26
 */
public class VersionHandler implements BaseByteCodeHandler {
	@Override
	public int order() {
		return 1;
	}

	@Override
	public void read(ByteBuffer codeBuffer, ClassFile classFile)
			throws Exception {
		U2 minorVersion = new U2(codeBuffer.get(), codeBuffer.get());
		classFile.setMinorVersion(minorVersion);

		U2 majorVersion = new U2(codeBuffer.get(), codeBuffer.get());
		classFile.setMajorVersion(majorVersion);
	}
}
