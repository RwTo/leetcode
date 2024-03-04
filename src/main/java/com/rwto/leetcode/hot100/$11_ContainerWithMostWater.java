package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//        返回容器可以储存的最大水量。
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics Array Two Pointers Greedy 
// 👍 27808 👎 1584
 
/**
    @author: renmw
    @date: 2024-01-10 14:31:44
    @title: Container With Most Water
    @questionId: 11
**/
public class  $11_ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new $11_ContainerWithMostWater().new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++){
            for(int j = i+1; j < height.length; j++){
                int area = Math.min(height[j],height[i]) * (j-i);
                max = Math.max(max,area);
            }
        }
        return max;
    }
}*/
class Solution {
    public int maxArea(int[] height) {
        if(null == height || height.length == 0){
            return 0;
        }
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i != j){
            int area = Math.min(height[j],height[i]) * (j - i);
            max = Math.max(max,area);
            if(height[j] > height[i]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

