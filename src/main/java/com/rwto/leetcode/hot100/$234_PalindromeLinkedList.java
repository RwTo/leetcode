package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//Given the head of a singly linked list, return true if it is a palindrome or f
//alse otherwise. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 15804 👎 856
 
/**
    @author: renmw
    @date: 2024-03-05 14:59:27
    @title: 回文链表
    @questionId: 234
 1. 存入数组，判断回文串
 2. 递归
 3. 快慢指针找到中点，反转后半部分链表 和 前半部分比较
**/
public class  $234_PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new $234_PalindromeLinkedList().new Solution();
        
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
    private ListNode p;

    public boolean isPalindrome(ListNode head) {
        p = head;
        return checkPalindrome(head);
    }

    private boolean checkPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        if(!checkPalindrome(head.next)){
            return false;
        }
        if(p.val != head.val){
            return false;
        }
        p = p.next;

        return true;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}

