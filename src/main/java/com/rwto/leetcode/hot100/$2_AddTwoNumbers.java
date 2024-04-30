package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// 👍 30334 👎 5984

/**
    @author: renmw
    @date: 2024-04-07 09:43:25
    @title: Add Two Numbers 两数相加
    @questionId: 2
**/
public class $2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new $2_AddTwoNumbers().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int tmp = 0;//进位
        while(l1 != null && l2 != null){
            node.next = new ListNode();
            int sum = l1.val + l2.val + tmp;
            tmp = sum / 10;
            node.next.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
            node = node.next;

        }
        while(l1 != null){
            node.next = new ListNode();
            int sum = l1.val + tmp;
            tmp = sum / 10;
            node.next.val = sum % 10;
            l1 = l1.next;
            node = node.next;
        }

        while(l2 != null){
            node.next = new ListNode();
            int sum = l2.val + tmp;
            tmp = sum / 10;
            node.next.val = sum % 10;
            l2 = l2.next;
            node = node.next;
        }

        if(tmp > 0){
            node.next = new ListNode();
            node.next.val = tmp;
        }

        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

