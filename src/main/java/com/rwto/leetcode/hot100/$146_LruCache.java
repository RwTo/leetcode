package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.*;
//Design a data structure that follows the constraints of a Least Recently Used 
//(LRU) cache. 
//
// Implement the LRUCache class: 
//
// 
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity. 
//
// int get(int key) Return the value of the key if the key exists, otherwise ret
//urn -1. 
// void put(int key, int value) Update the value of the key if the key exists. O
//therwise, add the key-value pair to the cache. If the number of keys exceeds the
// capacity from this operation, evict the least recently used key. 
// 
//
// The functions get and put must each run in O(1) average time complexity. 
//
// 
// Example 1: 
//
// 
//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 104 
// 0 <= value <= 105 
// At most 2 * 105 calls will be made to get and put. 
// 
// Related Topics Hash Table Linked List Design Doubly-Linked List 
// 👍 20313 👎 986
 
/**
    @author: renmw
    @date: 2024-04-11 22:49:03
    @title: LRU Cache
    @questionId: 146
    最近最少使用
    map存储数据，双向链表控制删除
    tail ，head 辅助结点  两辅助节点之间是真正的链表
**/
public class  $146_LruCache {
    public static void main(String[] args) {
        LRUCache solution = new $146_LruCache().new LRUCache(1);
        solution.put(2,1);
        solution.get(2);
        solution.put(2,2);
        solution.get(1);
        solution.put(3,3);
        solution.get(2);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    Map<Integer,Node> map;

    int capacity;
    Node head,tail;

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;


    }
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity+1);
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.pre = tail;
        tail.next = head;

    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        //移动节点到最前端
        node.pre.next = node.next;
        node.next.pre = node.pre;

        head.pre.next = node;
        node.pre = head.pre;
        head.pre = node;
        node.next = head;
        return node.value;
    }

    public void put(int key, int value) {
        //组装node

        if(!map.containsKey(key)){
            Node node = new Node();
            node.value = value;
            node.key = key;
            if(map.size() +1 > capacity){
                //删除尾节点 tail.next
                Node tmp = tail.next;
                map.remove(tmp.key);
                tmp.pre.next = tmp.next;
                tmp.next.pre = tmp.pre;

            }
            //加到最前端
            head.pre.next = node;
            node.pre = head.pre;
            head.pre = node;
            node.next = head;

            map.put(key,node);
        }else{
            //node 已经存在
            Node node = map.get(key);
            node.value = value;
            //移动节点到最前端
            node.pre.next = node.next;
            node.next.pre = node.pre;

            head.pre.next = node;
            node.pre = head.pre;
            head.pre = node;
            node.next = head;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}

