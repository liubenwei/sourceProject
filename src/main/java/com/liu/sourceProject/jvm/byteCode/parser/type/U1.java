package com.liu.sourceProject.jvm.byteCode.parser.type;

/**
 * @author liu
 * @Date 2021/1/30 14:51
 */
public class U1 {
	private byte value;

	public U1(byte value) {
		this.value = value;
	}

	public Integer toInt() {
		return value & 0xff;
	}

	public String toHexString() {
		char[] hexChar = new char[] { '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder hexString = new StringBuilder();
		int v = value & 0xff;
		while (v > 0) {
			int c = v % 16;
			v = v >>> 4;
			hexString.insert(0, hexChar[c]);
		}
		if ((hexString.length() & 01) == 1) {
			hexString.insert(0, '0');
		}

		return "0x" + (hexString.length() == 0 ? "00" : hexString.toString());

	}
}
