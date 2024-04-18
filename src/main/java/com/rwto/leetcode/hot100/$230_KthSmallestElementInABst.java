package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.List;
//Given the root of a binary search tree, and an integer k, return the kth small
//est value (1-indexed) of all the values of the nodes in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,1,4,null,2], k = 1
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,null,1], k = 3
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is n. 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
// Follow up: If the BST is modified often (i.e., we can do insert and delete op
//erations) and you need to find the kth smallest frequently, how would you optimi
//ze? 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 11268 👎 222
 
/**
    @author: renmw
    @date: 2024-04-18 22:54:57
    @title: Kth Smallest Element in a BST
    @questionId: 230
**/
public class  $230_KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new $230_KthSmallestElementInABst().new Solution();
        
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
//中序遍历
class Solution {
    private int res;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(count<=0 || null == root){
            return;
        }
        dfs(root.left);
        count--;
        if(count == 0){
            res = root.val;
            return;
        }
        dfs(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

