package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related Topics
// Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 15071 👎 367
 
/**
    @author: renmw
    @date: 2024-04-17 09:18:37
    @title: Symmetric Tree
    @questionId: 101
**/
public class  $101_SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new $101_SymmetricTree().new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        solution.isSymmetric(treeNode);
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
/**
 * 层序遍历——BFS
 * 队列大小判断一层 是否回文
 * */
/*class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(null == root){
            throw new IllegalArgumentException("root is null !");
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            if(size != 1 && size%2 != 0){
                return false;
            }
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(null == node){
                    list.add(null);
                    continue;
                }
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if(!huiwen(list)){
                return false;
            }
        }


        return true;
    }

    private boolean huiwen(List<Integer> list) {
        int left = 0, right = list.size()-1;
        while(left <= right){
            if( !(null == list.get(left) && null == list.get(right))
                && !(null != list.get(left) && null != list.get(right) && list.get(left).equals(list.get(right)))
               ){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
/*
* 递归比较：左子树的左节点和右子树的右节点
* */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            throw new IllegalArgumentException("root is null !");
        }

        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(null == left && null == right){
            return true;
        }
        if(null == left || null == right){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        return isSymmetric(left.right,right.left) && isSymmetric(left.left,right.right);
    }

}
}

