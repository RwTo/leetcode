package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.Arrays;
import java.util.List;
//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
// Constraints: 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics Array Math Matrix 
// 👍 16836 👎 758
 
/**
    @author: renmw
    @date: 2024-01-12 14:50:48
    @title: Rotate Image
    @questionId: 48
    1. 辅助数组： [a][b] -> [b][n-a-1]
    2. 先对折，再对角线对折
**/
public class  $48_RotateImage {
    public static void main(String[] args) {
        Solution solution = new $48_RotateImage().new Solution();
        int[][] nums = {{1,2,3,4},{4,5,6,7},{7,8,9,10},{11,12,13,14}};
        solution.rotate(nums);
        System.out.println(Arrays.deepToString(nums));
        int[][] nums2 = {{1,2,3},{4,5,6},{7,8,9}};
        solution.rotate(nums2);
        System.out.println(Arrays.deepToString(nums2));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
        if(null == matrix || matrix.length == 0){
            throw new IllegalArgumentException();
        }
        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                newMatrix[j][matrix.length-i-1] = matrix[i][j];
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = newMatrix[i][j];
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

