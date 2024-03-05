package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//        每行的元素从左到右升序排列。
//        每列的元素从上到下升序排列。
// 
//
// 
// Example 1: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 5
//Output: true
// 
//
// Example 2: 
//
// 
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
//8,21,23,26,30]], target = 20
//Output: false
// 
//
// 
// Constraints: 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matrix[i][j] <= 109 
// All the integers in each row are sorted in ascending order. 
// All the integers in each column are sorted in ascending order. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search Divide and Conquer Matrix 
// 👍 11636 👎 196
 
/**
    @author: renmw
    @date: 2024-03-05 13:26:18
    @title: Search a 2D Matrix II
    @questionId: 240
    思考： 搜索+有序 =》 二分查找
    找到二分点： 右上
    找到退出条件：数组越界
**/
public class  $240_SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new $240_SearchA2dMatrixIi().new Solution();

    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || matrix.length == 0){
            throw new IllegalArgumentException();
        }
        int i = 0, j = matrix[0].length-1;
        while(i < matrix.length && j >= 0){

            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }


        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

