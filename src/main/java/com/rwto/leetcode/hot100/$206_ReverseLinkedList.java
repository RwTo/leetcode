package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//Given the head of a singly linked list, reverse the list, and return the rever
//sed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. C
//ould you implement both? 
// Related Topics Linked List Recursion 
// 👍 20694 👎 406
 
/**
    @author: renmw
    @date: 2024-03-05 14:35:35
    @title: 反转链表
    @questionId: 206
    1. 递归 => 从后往前推
        1.1 找退出条件， 找到最后一个值
        1.2 确定返回值   返回新链表即最后老链表的尾部
            注意 反转后的链表尾部 置为null

    2. while 循环
       三个变量 pre，cur，next(临时记录)
       以pre 和 cur 为一组，反转指针
**/
public class  $206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new $206_ReverseLinkedList().new Solution();
        
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
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//
//        while(cur != null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
//    }

    public ListNode reverseList(ListNode head) {
        /*递归退出条件*/
        if(null == head || head.next == null){
            return head;
        }
        /*获取新的链表头*/
        ListNode newHead = reverseList(head.next);

        /*反转链表*/
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

