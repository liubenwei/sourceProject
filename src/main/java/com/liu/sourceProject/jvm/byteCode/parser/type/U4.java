package com.liu.sourceProject.jvm.byteCode.parser.type;

/**
 * @author liu
 * @Date 2021/1/27 15:47
 */
public class U4 {
	private byte[] value;

	public U4(byte b1, byte b2, byte b3, byte b4) {
		value = new byte[] { b1, b2, b3, b4 };
	}

	public int toInt() {
		int a = (value[0] & 0xff) << 24;
		a |= (value[1] & 0xff) << 16;
		a |= (value[2] & 0xff) << 8;
		return a |= (value[3] & 0xff);
	}

	/**
	 * 转换成16进制
	 * 
	 * @return
	 */
	public String toHexString() {
		char[] hexChar = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder hexString = new StringBuilder();
		for (int i = 3; i >= 0; i--) {
			int v = (value[i] & 0xff);
			while (v > 0) {
				int c = v % 16;
				v = v >>> 4;
				hexString.insert(0, hexChar[c]);
			}
			// 如果字符串的长度是奇数（即 byte ==0 或 byte == f）
			if ((hexString.length() & 01) == 1) {
				hexString.insert(0, '0');
			}
		}
		return "0x" + hexString;
	}
}
