package com.liu.sourceProject.leetcode.number900;

/**
 * @author liu
 * @Date 2020/10/21 8:41
 */
public class Number925 {
	public static void main(String[] args) {
		boolean longPressedName = new Number925().isLongPressedName("alex",
				"aaleelx");
		System.out.println(longPressedName);
	}

	public boolean isLongPressedName(String name, String typed) {
		char[] nameCharArray = name.toCharArray();
		char[] tpyedCharArray = typed.toCharArray();
		int nameIndex = 0, typedIndex = 0;
		if(nameCharArray.length > tpyedCharArray.length){
			return false;
		}
		while (nameIndex < nameCharArray.length
				&& typedIndex < tpyedCharArray.length) {
			if (nameCharArray[nameIndex] == tpyedCharArray[typedIndex]) {
				nameIndex++;
				typedIndex++;
			} else if(typedIndex > 0 && tpyedCharArray[typedIndex] == tpyedCharArray[typedIndex - 1]){
				typedIndex++;
			}else{
				return false;
			}

		}
		while(typedIndex < tpyedCharArray.length){
			if(tpyedCharArray[typedIndex] == nameCharArray[nameIndex - 1]){
				typedIndex++;
			}else{
				return false;
			}
		}



		return nameIndex == nameCharArray.length;
	}
}
