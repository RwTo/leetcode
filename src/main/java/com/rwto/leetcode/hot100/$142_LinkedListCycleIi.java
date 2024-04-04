package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.List;
//Given the head of a linked list, return the node where the cycle begins. If th
//ere is no cycle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to (0
//-indexed). It is -1 if there is no cycle. Note that pos is not passed as a param
//eter. 
//
// Do not modify the linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Hash Table Linked List Two Pointers 
// 👍 13213 👎 917
 
/**
    @author: renmw
    @date: 2024-03-05 15:46:56
    @title: Linked List Cycle II
    @questionId: 142
    1. 方法1：使用set，遍历元素，第一个已经遍历过的就是环入口
    2. 方法2：证明
       假设 头到环入口 的距离为a，环长b。
       快慢指针一定会相遇，相遇时  快指针走了 f，慢指针走了  s
       f = 2s
       快指针一定在环内相遇，f一定比s多走了 nb距离，f = s + nb
       所以  s = nb 即 s 一共走了 n倍的b距离
       当一个指针走了 a+xb ，x为0到正无穷，指针的位置一定是 环入口
      而当快慢指针相遇时，s = nb 所以再走a步，慢指针就到了环入口
      所以当慢指针相遇后，快指针从头开始走，当他们都走a步，相遇，即到了环入口

**/
public class  $142_LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new $142_LinkedListCycleIi().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(true){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        fast = head;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


//    public ListNode detectCycle(ListNode head) {
//        HashSet<ListNode> nodes = new HashSet<>();
//        while(head !=  null){
//            boolean add = nodes.add(head);
//            if(!add){
//                return head;
//            }
//            head = head.next;
//        }
//        return null;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

