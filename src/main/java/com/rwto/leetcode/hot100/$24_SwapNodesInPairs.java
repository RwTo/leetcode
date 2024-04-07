package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//Given a linked list, swap every two adjacent nodes and return its head. You mu
//st solve the problem without modifying the values in the list's nodes (i.e., onl
//y nodes themselves may be changed.) 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
// Related Topics Linked List Recursion 
// 👍 11784 👎 434
 
/**
    @author: renmw
    @date: 2024-04-07 10:20:53
    @title: Swap Nodes in Pairs
    @questionId: 24
    三个变量 pre，cur，next(临时变量)
    成对交换
**/
public class  $24_SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new $24_SwapNodesInPairs().new Solution();
        
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode newHead = head;
        while(cur != null){
            ListNode next = cur.next;
            if(next == null){
                break;
            }
            cur.next = next.next;
            next.next = cur;
            if(pre == null){
                newHead = next;
            }else{
                pre.next = next;
            }
            pre = next.next;
            cur = cur.next;
        }


        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

