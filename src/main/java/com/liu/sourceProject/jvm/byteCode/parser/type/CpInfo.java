package com.liu.sourceProject.jvm.byteCode.parser.type;

/**
 * @author liu
 * @Date 2021/1/27 15:48
 */
public class CpInfo {
	private U1 tag;
	private U1 info[];

	public U1 getTag() {
		return tag;
	}

	public void setTag(U1 tag) {
		this.tag = tag;
	}

	public U1[] getInfo() {
		return info;
	}

	public void setInfo(U1[] info) {
		this.info = info;
	}
}
