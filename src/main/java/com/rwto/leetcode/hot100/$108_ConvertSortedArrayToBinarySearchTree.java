package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import com.rwto.leetcode.utils.TreeNode;

import java.util.List;
//Given an integer array nums where the elements are sorted in ascending order, 
//convert it to a height-balanced binary search tree. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-10,-3,0,5,9]
//Output: [0,-3,9,-10,null,5]
//Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3]
//Output: [3,1]
//Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums is sorted in a strictly increasing order. 
// 
// Related Topics Array Divide and Conquer Tree Binary Search Tree Binary Tree 
// 👍 10789 👎 546
 
/**
    @author: renmw
    @date: 2024-04-17 16:02:27
    @title: Convert Sorted Array to Binary Search Tree
    @questionId: 108
**/
public class  $108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new $108_ConvertSortedArrayToBinarySearchTree().new Solution();
        
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(null == nums || 0 == nums.length){
            return null;
        }

        return sortTree(nums,0,nums.length-1);
    }

    private TreeNode sortTree(int[] nums,int left, int right) {
        if(left > right){
            return null;
        }
        int mid  = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortTree(nums,left,mid-1);
        node.right = sortTree(nums,mid+1,right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

