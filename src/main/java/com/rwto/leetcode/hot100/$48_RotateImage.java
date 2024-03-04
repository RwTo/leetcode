package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.Arrays;
import java.util.List;
//You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise). 
//
// You have to rotate the image in-place, which means you have to modify the inp
//ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation. 
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
        //考虑单个元素
        int n = matrix.length;//行,列
        for(int k = 0; k < n/2; k++){
            //旋转层数
            for(int i = k; i < n - k - 1; i++){
                //旋转
                int tmp1 = matrix[i][n-k-1];
                matrix[i][n-k-1] = matrix[k][i];

                int tmp2 = matrix[n-k-1][n-k-1-i];
                matrix[n-k-1][n-k-1-i] = tmp1;

                tmp1 = matrix[n-k-1-i][k];
                matrix[n-k-1-i][k] = tmp2;

                matrix[k][i] = tmp1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

