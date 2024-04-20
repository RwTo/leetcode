package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.List;
//Given the root of a binary tree, flatten the tree into a "linked list": 
//
// 
// The "linked list" should use the same TreeNode class where the right child po
//inter points to the next node in the list and the left child pointer is always n
//ull. 
// The "linked list" should be in the same order as a pre-order traversal of the
// binary tree. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,5,3,4,null,6]
//Output: [1,null,2,null,3,null,4,null,5,null,6]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related 
//Topics Linked List Stack Tree Depth-First Search Binary Tree 
// 👍 12031 👎 554
 
/**
    @author: renmw
    @date: 2024-04-20 12:16:21
    @title: Flatten Binary Tree to Linked List
    @questionId: 114
**/
public class  $114_FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new $114_FlattenBinaryTreeToLinkedList().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode pre;
    public void flatten(TreeNode root) {
        dfs(root);
    }

    public void dfs(TreeNode root){
        if(null == root){
            return;
        }
        TreeNode r=root.right;//这里很重要,因为我们很可能在深处修改了节点的指针,那么当返回来的时候指针已经修改了,就不能正常进行前序遍历了,因此要记录下当前节点的左右结点.
        TreeNode l=root.left;
        if(pre==null) {pre=root;}
        else{
            pre.right=root;
            pre.left=null;
            pre=root;
        }
        dfs(l);
        dfs(r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

