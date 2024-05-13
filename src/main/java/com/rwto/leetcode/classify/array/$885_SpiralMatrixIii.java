package com.rwto.leetcode.classify.array;
//You start at the cell (rStart, cStart) of an rows x cols grid facing east. The
// northwest corner is at the first row and column in the grid, and the southeast 
//corner is at the last row and column. 
//
// You will walk in a clockwise spiral shape to visit every position in this gri
//d. Whenever you move outside the grid's boundary, we continue our walk outside t
//he grid (but may return to the grid boundary later.). Eventually, we reach all r
//ows * cols spaces of the grid. 
//
// Return an array of coordinates representing the positions of the grid in the 
//order you visited them. 
//
// 
// Example 1: 
//
// 
//Input: rows = 1, cols = 4, rStart = 0, cStart = 0
//Output: [[0,0],[0,1],[0,2],[0,3]]
// 
//
// Example 2: 
//
// 
//Input: rows = 5, cols = 6, rStart = 1, cStart = 4
//Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,
//3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1]
//,[4,0],[3,0],[2,0],[1,0],[0,0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= rows, cols <= 100 
// 0 <= rStart < rows 
// 0 <= cStart < cols 
// 
// Related Topics Array Matrix Simulation 
// 👍 915 👎 862
 
/**
    @author: renmw
    @date: 2024-05-13 13:44:18
    @title: 螺旋矩阵 3
    @questionId: 885
**/
public class  $885_SpiralMatrixIii {
    public static void main(String[] args) {
        Solution solution = new $885_SpiralMatrixIii().new Solution();
        solution.spiralMatrixIII(5,6,1,4);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int size = rows * cols;
        int[][] res = new int[rows * cols][2];
        int i = rStart, j = cStart;
        int d = 0;//方向
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int step = 0;//步长
        int t = 0;
        res[t++] = new int[]{i,j};
        while(t<size){
            d = d % 4;
            //每两次步长 + 1
            if(d % 2 == 0){
                step++;
            }
            //向一个方向走 step 步
            for(int k = 1; k <= step; k++){
                i += direction[d][0];
                j += direction[d][1];
                if(i < rows && j < cols && i >= 0 && j >= 0){
                    res[t++] = new int[]{i,j};
                }
            }
            d++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

