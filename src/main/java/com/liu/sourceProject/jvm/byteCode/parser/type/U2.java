package com.liu.sourceProject.jvm.byteCode.parser.type;

/**
 * @author liu
 * @Date 2021/1/27 15:47
 */
public class U2 {
	private byte[] value;

	public U2(byte b1, byte b2) {
		value = new byte[] { b1, b2 };
	}

	public Integer toInt() {
		return (value[0] & 0xff) << 8 | (value[1] & 0xff);
	}

	/**
	 * 把byte转成16进制
	 * 
	 * @return
	 */
	public String toHexString() {
		char[] hexChar = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder hexString = new StringBuilder();
		for (int i = 1; i >= 0; i--) {
			int v = value[i] & 0xff;
			while (v > 0) {
				int c = v % 16;
				v = v >>> 4;
				hexString.insert(0, hexChar[c]);
			}
			if ((hexString.length() & 01) == 1) {
				hexString.insert(0, '0');
			}
		}

		return "0x" + (hexString.length() == 0 ? "00" : hexString.toString());
	}
}
