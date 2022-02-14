//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 二分查找 👍 364 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

// Java：有序数组中的单一元素
// question number: 540
// 10:06	info
// 			解答成功:
// 			执行耗时:2 ms,击败了22.98% 的Java用户
// 			内存消耗:47.2 MB,击败了7.28% 的Java用户
public class SingleElementInASortedArray {
	public static void main(String[] args) {
		Solution solution = new SingleElementInASortedArray().new Solution();
		// TO TEST
		System.out.println(solution.singleNonDuplicate(new int[]{1,1,2}));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int singleNonDuplicate(int[] nums) {
			if (nums.length == 1) {
				return nums[0];
			}

			Arrays.sort(nums);
			for (int i = 0; i < nums.length; i += 2) {
				if (i == nums.length - 1) {
					return nums[i];
				}

				if (nums[i] != nums[i + 1]) {
					return nums[i];
				}
			}

			return 0;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}