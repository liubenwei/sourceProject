package com.liu.sourceProject.jvm.byteCode.parser.handler;

import java.nio.ByteBuffer;

import com.liu.sourceProject.jvm.byteCode.parser.type.ClassFile;

/**
 * 每个解析器应该只负责class文件结构中某一项的解析工作
 *
 * @author liu
 * @Date 2021/1/27 16:26
 */
public interface BaseByteCodeHandler {
	/**
	 * 解释器的排序
	 * 
	 * @return
	 */
	int order();

	/**
	 * 读取字节码
	 * 从字节缓存中读取相应的字节数据写入ClassFile对象。
	 * 由于解析是按顺序解析的，因此BASEByteCodeHandler接口定义的一个返回排序值的方法
	 * 用于实现解析器排序
	 * 
	 * @param codeBuffer
	 * @param classFile
	 * @throws Exception
	 */
	void read(ByteBuffer codeBuffer, ClassFile classFile) throws Exception;
}
