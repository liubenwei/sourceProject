package com.liu.sourceProject.jvm.byteCode.parser.utils;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.liu.sourceProject.jvm.byteCode.parser.handler.BaseByteCodeHandler;
import com.liu.sourceProject.jvm.byteCode.parser.handler.MagicHandler;
import com.liu.sourceProject.jvm.byteCode.parser.handler.VersionHandler;
import com.liu.sourceProject.jvm.byteCode.parser.type.ClassFile;

/**
 * 实现了管理和调度解析器工作的总指挥
 * 
 * @author liu
 * @Date 2021/1/27 16:27
 */
public class ClassFileAnalysiser {
	private final static List<BaseByteCodeHandler> handlers = new ArrayList<>();

	/**
	 * mybatis源码通过static添加TypeHandler
	 */
	static {
		handlers.add(new MagicHandler());
		handlers.add(new VersionHandler());
		handlers.sort(Comparator.comparingInt(BaseByteCodeHandler::order));
	}

	/**
	 * 将传入的从class文件读取的字节缓存，解析生成一个ClassFile对象 使用byteBuffer 而不使用byte[]读取class文件
	 * 是因为ByteBuffer能更好的控制顺序读取
	 * 
	 * @param codeBuffer
	 * @return
	 */
	public static ClassFile analysis(ByteBuffer codeBuffer) throws Exception {
		codeBuffer.position(0);
		ClassFile classFile = new ClassFile();
		for (BaseByteCodeHandler handler : handlers) {
			handler.read(codeBuffer, classFile);
		}
		return classFile;
	}
}
