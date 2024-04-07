package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//Given the head of a linked list, remove the nth node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
// Related Topics Linked List Two Pointers 
// 👍 18511 👎 780
 
/**
    @author: renmw
    @date: 2024-04-07 09:55:48
    @title: Remove Nth Node From End of List
    @questionId: 19
**/
public class  $19_RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new $19_RemoveNthNodeFromEndOfList().new Solution();
        
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            if(n < 0){
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if(n == 0){
            return head.next;
        }
        if(null != slow.next){
            slow.next = slow.next.next;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

