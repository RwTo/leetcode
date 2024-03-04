package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//        子数组
//        是数组中的一个连续部分。
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 32975 👎 1378
 
/**
    @author: renmw
    @date: 2024-01-11 13:19:13
    @title: Maximum Subarray
    @questionId: 53
**/
public class  $53_MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new $53_MaximumSubarray().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{-2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length == 0){
            throw new IllegalArgumentException();
        }
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum+=num;
            res = Math.max(res,sum);
            if(sum < 0){
                sum=0;
            }

        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

