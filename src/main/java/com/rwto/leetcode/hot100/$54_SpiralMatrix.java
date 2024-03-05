package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics Array Matrix Simulation 
// 👍 14279 👎 1254
 
/**
    @author: renmw
    @date: 2024-03-04 16:59:49
    @title: Spiral Matrix
    @questionId: 54
 1. 有标记数组，标记是否访问，while（） list.add
 2. 内层循环 top,left right bottom
    注意 内层为一维数组的情况
**/
public class  $54_SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new $54_SpiralMatrix().new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (null == matrix || null == matrix[0]){
            throw new IllegalArgumentException();
        }
        List<Integer> res = new ArrayList<>();
        int top = 0, left = 0, bottom = matrix.length-1, right = matrix[0].length-1;
        while(top <= bottom && left <= right){
            //向右
            for (int i = left ; i <= right; i++){
                res.add(matrix[top][i]);
            }
            //向下
            for(int i = top + 1; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            /*防止重复遍历  防止 left = right 或者 top = bottom*/
            if(top < bottom && left < right){
                //向左
                for(int i = right - 1; i >= left; i--){
                    res.add(matrix[bottom][i]);
                }

                //向上
                for(int i = bottom - 1; i > top; i--){
                    res.add(matrix[i][left]);
                }
            }


            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

