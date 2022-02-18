//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7487 👎 0

package leetcode.editor.cn;

// Java：两数相加
// question number: 2
public class AddTwoNumbers {
	public static void main(String[] args) {
		Solution solution = new AddTwoNumbers().new Solution();
		// TO TESTnew ListNode(5, new ListNode(6, new ListNode(4)))
		ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
		ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, null)));
		System.out.println(solution.addTwoNumbers(l1, l2));
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode() {}
	 * ListNode(int val) { this.val = val; }
	 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			int carry = 0;
			ListNode rst = new ListNode();
			ListNode head = rst;
			ListNode copyL1 = l1;
			ListNode copyL2 = l2;

			while (copyL1 != null && copyL2 != null) {
				int val = copyL1.val + copyL2.val;
				copyL1 = copyL1.next;
				copyL2 = copyL2.next;

				val = val + carry;
				if (val >= 10) {
					carry = 1;
				} else {
					carry = 0;
				}

				head.val = val % 10;

				if (copyL1 != null && copyL2 != null) {
					head.next = new ListNode();
					head = head.next;
				}
			}

			while (copyL1 != null) {
				int val = copyL1.val + carry;
				val = val + carry;
				if (val >= 10) {
					carry = 1;
				} else {
					carry = 0;
				}

				head.val = val % 10;

				copyL1 = copyL1.next;
				head.next = new ListNode();
				head = head.next;
			}

			while (copyL2 != null) {
				int val = copyL2.val + carry;
				val = val + carry;
				if (val >= 10) {
					carry = 1;
				} else {
					carry = 0;
				}

				head.val = val % 10;

				head.next = new ListNode();
				head = head.next;
			}

			if (carry != 0) {
				head.val = carry;
			} else {
				head = null;
			}

			return rst;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}