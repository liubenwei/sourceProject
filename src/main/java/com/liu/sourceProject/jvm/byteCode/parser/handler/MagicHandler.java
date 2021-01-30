package com.liu.sourceProject.jvm.byteCode.parser.handler;

import java.nio.ByteBuffer;

import com.liu.sourceProject.jvm.byteCode.parser.type.ClassFile;
import com.liu.sourceProject.jvm.byteCode.parser.type.U4;

/**
 * @author liu
 * @Date 2021/1/27 16:26
 */
public class MagicHandler implements BaseByteCodeHandler {
	@Override
	public int order() {
		return 0;
	}

	@Override
	public void read(ByteBuffer codeBuffer, ClassFile classFile)
			throws Exception {
		classFile.setMagic(new U4(codeBuffer.get(), codeBuffer.get(),
				codeBuffer.get(), codeBuffer.get()));
		if (!"0xCAFEBABE"
				.equalsIgnoreCase(classFile.getMagic().toHexString())) {
			throw new Exception("这不是一个Class文件");
		}
	}
}
