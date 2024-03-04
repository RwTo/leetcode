package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
//
// You must do it in place. 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//Output: [[1,0,1],[0,0,0],[1,0,1]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -231 <= matrix[i][j] <= 231 - 1 
// 
//
// 
// Follow up: 
//
// 
// A straightforward solution using O(mn) space is probably a bad idea. 
// A simple improvement uses O(m + n) space, but still not the best solution. 
// Could you devise a constant space solution? 
// 
// Related Topics Array Hash Table Matrix 
// 👍 13763 👎 689
 
/**
    @author: renmw
    @date: 2024-01-11 15:50:45
    @title: Set Matrix Zeroes
    @questionId: 73
 1. 使用标记数组，标记哪些行列有0
 2. 用第一行和第一列做标记数组
**/
public class  $73_SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new $73_SetMatrixZeroes().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public void setZeroes(int[][] matrix) {
//        if(null == matrix || matrix.length == 0){
//            return;
//        }
//        int[] rows = new int[matrix.length];
//        int[] cols = new int[matrix[0].length];
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                if(matrix[i][j] == 0){
//                    rows[i] = 1;
//                    cols[j] = 1;
//                }
//            }
//        }
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                if(rows[i] == 1 || cols[j] == 1){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    public void setZeroes(int[][] matrix) {
        if(null == matrix || matrix.length == 0){
            return;
        }
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

