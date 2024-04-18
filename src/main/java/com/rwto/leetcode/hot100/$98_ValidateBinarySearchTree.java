package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.List;
//Given the root of a binary tree, determine if it is a valid binary search tree
// (BST). 
//
// A valid BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [5,1,4,null,null,3,6]
//Output: false
//Explanation: The root node's value is 5 but its right child's value is 4.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 16554 👎 1356
 
/**
    @author: renmw
    @date: 2024-04-18 19:58:39
    @title: Validate Binary Search Tree
    @questionId: 98
**/
public class  $98_ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new $98_ValidateBinarySearchTree().new Solution();
        
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
/*
* 1. 递归，类似二分，每个节点有一个范围
*
* 2.
* 中序遍历生成数组
* 判断数组是否升序
* */
/*class Solution {
    private Integer pre;
    private boolean res = true;
    public boolean isValidBST(TreeNode root) {

        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(null == root || !res){
            return;
        }
        dfs(root.left);
        if(null != pre && pre > root.val){
            res = false;
            return;
        }
        pre = root.val;
        dfs(root.right);
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
/*每个节点满足一个范围*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
}

