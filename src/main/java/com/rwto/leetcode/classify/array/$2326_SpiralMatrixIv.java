package com.rwto.leetcode.classify.array;
import com.rwto.leetcode.utils.ListNode;
//You are given two integers m and n, which represent the dimensions of a matrix
//. 
//
// You are also given the head of a linked list of integers. 
//
// Generate an m x n matrix that contains the integers in the linked list presen
//ted in spiral order (clockwise), starting from the top-left of the matrix. If th
//ere are remaining empty spaces, fill them with -1. 
//
// Return the generated matrix. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
//Output: [[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
//Explanation: The diagram above shows how the values are printed in the matrix.
//
//Note that the remaining spaces in the matrix are filled with -1.
// 
//
// Example 2: 
//
// 
//Input: m = 1, n = 4, head = [0,1,2]
//Output: [[0,1,2,-1]]
//Explanation: The diagram above shows how the values are printed from left to r
//ight in the matrix.
//The last space in the matrix is set to -1. 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 105 
// 1 <= m * n <= 105 
// The number of nodes in the list is in the range [1, m * n]. 
// 0 <= Node.val <= 1000 
// 
// Related Topics Array Linked List Matrix Simulation 
// 👍 733 👎 27
 
/**
    @author: renmw
    @date: 2024-05-13 10:30:50
    @title: 螺旋矩阵 4
    @questionId: 2326
**/
public class  $2326_SpiralMatrixIv {
    public static void main(String[] args) {
        Solution solution = new $2326_SpiralMatrixIv().new Solution();
        solution.spiralMatrix(1,4,null);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int size = m * n;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                res[i][j] = -1;
            }
        }
        int d = 0;
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int i = 0, j = 0;
        while(null != head){
            //给当前元素赋值
            //如果当前元素不符合条件，退出循环，这里可以省略，因为链表的长度一定小于数组大小
            res[i][j] = head.val;
            head = head.next;
            //判断下一个元素的位置
            d = d % 4;
            int ni = direction[d][0];
            int nj = direction[d][1];
            //不符合条件，转向
            if(i+ni < 0 || i+ni >=m || j+nj < 0 || j+nj >= n || res[i+ni][j+nj] != -1){
                d = ++d % 4;
                ni = direction[d][0];
                nj = direction[d][1];
            }
            i += ni;
            j += nj;
        }


        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

