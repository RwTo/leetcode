package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Given the root of a binary tree, return the level order traversal of its nodes
//' values. (i.e., from left to right, level by level). 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: [[1]]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 2000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Breadth-First Search Binary Tree 
// 👍 15059 👎 305
 
/**
    @author: renmw
    @date: 2024-04-17 15:54:24
    @title: Binary Tree Level Order Traversal
    @questionId: 102
**/
public class  $102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new $102_BinaryTreeLevelOrderTraversal().new Solution();
        
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
层序遍历——BFS
* */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == root){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

