package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.List;
//Given the root of a binary tree, return the length of the diameter of the tree
//. 
//
// The diameter of a binary tree is the length of the longest path between any t
//wo nodes in a tree. This path may or may not pass through the root. 
//
// The length of a path between two nodes is represented by the number of edges 
//between them. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5]
//Output: 3
//Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
// 
//
// Example 2: 
//
// 
//Input: root = [1,2]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 13566 👎 970
 
/**
    @author: renmw
    @date: 2024-04-17 10:07:41
    @title: Diameter of Binary Tree
    @questionId: 543
**/
public class  $543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new $543_DiameterOfBinaryTree().new Solution();
        
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
* 左子树的深度+右子树的深度
* 超时
* */
/*class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(null == root){
            return 0;
        }
        *//*找每个节点，左子树+右子树的深度*//*
        return traverse(root);
    }

    private int traverse(TreeNode root) {
        if(null == root){
            return 0;
        }
        traverse(root.left);
        traverse(root.right);
        return Math.max(maxDepth(root.left) + maxDepth(root.right),Math.max(traverse(root.right),traverse(root.left)));
    }

    private int maxDepth(TreeNode node) {
        if(null == node){
            return 0;
        }
        return Math.max(maxDepth(node.left),maxDepth(node.right))+1;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
class Solution {
    int res = 1;
    public int diameterOfBinaryTree(TreeNode root) {
        if(null == root){
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(null == root){
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(l+r,res);
        return Math.max(l,r)+1;
    }

}
}

