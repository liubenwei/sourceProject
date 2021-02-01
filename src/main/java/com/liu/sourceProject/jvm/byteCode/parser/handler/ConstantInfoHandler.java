package com.liu.sourceProject.jvm.byteCode.parser.handler;

import java.nio.ByteBuffer;

/**
 * @author liu
 * @Date 2021/1/30 14:54
 */
public interface ConstantInfoHandler {

	void read(ByteBuffer codeBuffer) throws Exception;
}
