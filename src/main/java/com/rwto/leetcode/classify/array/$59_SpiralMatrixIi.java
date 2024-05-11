package com.rwto.leetcode.classify.array;
//Given a positive integer n, generate an n x n matrix filled with elements from
// 1 to n2 in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics Array Matrix Simulation 
// 👍 6283 👎 257
 
/**
    @author: renmw
    @date: 2024-05-11 16:19:09
    @title: Spiral Matrix II
    @questionId: 59
**/
public class  $59_SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new $59_SpiralMatrixIi().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int value = 1;
        int i = 0, j = 0;
        /**/
        int direction = 0;
        while(true){
            if(j < n && j >=0 && i>= 0 && i < n && res[i][j] == 0){
                res[i][j] = value++;
            }
            //四个方向都不能走
            if((j + 1 >= n || res[i][j+1] != 0)
                && (i + 1 >= n || res[i+1][j] != 0)
                && (j -1 < 0 || res[i][j-1] != 0)
                && (i-1 < 0 || res[i-1][j] != 0)){
                break;
            }
            direction = direction % 4;
            //向右
            if(0 == direction){
                while(true){
                    if(j + 1 >= n || res[i][j+1] != 0){
                        i++;
                        break;
                    }
                    res[i][++j] = value++;
                }
            }

            if(1 == direction){
                while(true){
                    if(i + 1 >= n || res[i+1][j] != 0){
                        j--;
                        break;
                    }
                    res[++i][j] = value++;
                }
            }


            if(2 == direction){
                while(true){
                    if(j -1 < 0 || res[i][j-1] != 0){
                        i--;
                        break;
                    }
                    res[i][--j] = value++;
                }
            }

            if(3 == direction){
                while(true){
                    if(i-1 < 0 || res[i-1][j] != 0){
                        j++;
                        break;
                    }
                    res[--i][j] = value++;
                }
            }


            direction++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

