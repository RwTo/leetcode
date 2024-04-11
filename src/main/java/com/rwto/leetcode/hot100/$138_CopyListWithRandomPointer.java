package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.Node;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//A linked list of length n is given such that each node contains an additional 
//random pointer, which could point to any node in the list, or null. 
//
// Construct a deep copy of the list. The deep copy should consist of exactly n 
//brand new nodes, where each new node has its value set to the value of its corre
//sponding original node. Both the next and random pointer of the new nodes should
// point to new nodes in the copied list such that the pointers in the original li
//st and copied list represent the same list state. None of the pointers in the ne
//w list should point to nodes in the original list. 
//
// For example, if there are two nodes X and Y in the original list, where X.ran
//dom --> Y, then for the corresponding two nodes x and y in the copied list, x.ra
//ndom --> y. 
//
// Return the head of the copied linked list. 
//
// The linked list is represented in the input/output as a list of n nodes. Each
// node is represented as a pair of [val, random_index] where: 
//
// 
// val: an integer representing Node.val 
// random_index: the index of the node (range from 0 to n-1) that the random poi
//nter points to, or null if it does not point to any node. 
// 
//
// Your code will only be given the head of the original linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// Example 2: 
//
// 
//Input: head = [[1,1],[2,1]]
//Output: [[1,1],[2,1]]
// 
//
// Example 3: 
//
// 
//
// 
//Input: head = [[3,null],[3,0],[3,null]]
//Output: [[3,null],[3,0],[3,null]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 1000 
// -104 <= Node.val <= 104 
// Node.random is null or is pointing to some node in the linked list. 
// 
// Related Topics Hash Table Linked List 
// 👍 13586 👎 1435
 
/**
    @author: renmw
    @date: 2024-04-12 00:09:57
    @title: Copy List with Random Pointer
    @questionId: 138
    map 存储 新旧关系 key 是源值，value 是复制的目标值
    第一次遍历 构建next指针顺序
    第二次遍历map 构建 randomNext 顺序
**/
public class  $138_CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new $138_CopyListWithRandomPointer().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //k 原数据，v复制的数据
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node newHead = new Node(1);
        Node node = newHead;
        //遍历复制
        while(head != null){
            node.next = new Node(head.val);
            node = node.next;
            map.put(head,node);
            head = head.next;
        }
        for(Map.Entry<Node,Node> entry : map.entrySet()){
            entry.getValue().random = map.get(entry.getKey().random);
        }

        return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

