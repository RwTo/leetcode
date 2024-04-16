package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//Given the root of a binary tree, return its maximum depth. 
//
// A binary tree's maximum depth is the number of nodes along the longest path f
//rom the root node down to the farthest leaf node. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 12578 👎 220
 
/**
    @author: renmw
    @date: 2024-04-16 10:12:19
    @title: Maximum Depth of Binary Tree
    @questionId: 104
**/
public class  $104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new $104_MaximumDepthOfBinaryTree().new Solution();
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
/*class Solution {
    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
/*BFS-层序遍历，找最大的层数
两层循环
第一层遍历 queue
第二层 遍历层序遍历的一层，队列的size大小就是 这层的大小
*/
class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(null == root){
            return depth;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                if(null != node.left){
                    queue.offer(node.left);
                }
                if(null != node.right){
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
}

