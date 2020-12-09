package com.liu.sourceProject.leetcode.number100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu
 * @Date 2020/12/9 18:29
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 通过次数139,591提交次数200,633
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Number118 {
	public List<List<Integer>> generate(int numRows) {
		if (numRows == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		res.add(temp);
		if (numRows == 1) {
			return res;
		}
		for (int i = 1; i < numRows; i++) {
			List<Integer> last = res.get(res.size() - 1);
			temp = new ArrayList<>();
			temp.add(1);
			for (int j = 1; j < i; j++) {
				temp.add(last.get(j - 1) + last.get(j));
			}
			temp.add(1);
			res.add(temp);
		}
		return res;
	}
}
