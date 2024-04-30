package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.List;
//Given the root of a binary tree and an integer targetSum, return the number of
// paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
//
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -109 <= Node.val <= 109 
// -1000 <= targetSum <= 1000 
// 
// Related Topics Tree Depth-First Search Binary Tree 
// 👍 10786 👎 514
 
/**
    @author: renmw
    @date: 2024-04-30 15:55:33
    @title: Path Sum III 路径总和三
    @questionId: 437
**/
public class  $437_PathSumIii {
    public static void main(String[] args) {
        Solution solution = new $437_PathSumIii().new Solution();
        TreeNode head = new TreeNode(-3);
        head.right=new TreeNode(11);
        solution.pathSum(head,8);
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
    Integer ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        traverse(root,targetSum);
        return ans;
    }

    private void traverse(TreeNode node, int targetSum) {
        if(null == node){
            return;
        }
        dfs(node,0,targetSum);
        traverse(node.left,targetSum);
        traverse(node.right,targetSum);
    }

    public void dfs(TreeNode node,long sum, int target){
        if(null == node){
            return;
        }
        //错误写法
        /*if(sum == target){
            ans++;
        }*/
        /**/
        if(sum + node.val == target){
            ans++;
        }
        dfs(node.left,sum + node.val,target);
        dfs(node.right,sum + node.val,target);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

