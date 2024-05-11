package com.rwto.leetcode.classify.array;
//Given an array of positive integers nums and a positive integer target, return
// the minimal length of a subarray whose sum is greater than or equal to target. 
//If there is no such subarray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem const
//raint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion of which the time complexity is O(n log(n)). Related Topics Array Binary Sea
//rch Sliding Window Prefix Sum 
// 👍 12412 👎 414
 
/**
    @author: renmw
    @date: 2024-05-11 15:37:42
    @title: Minimum Size Subarray Sum 长度最小的子数组
    @questionId: 209
**/
public class  $209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new $209_MinimumSizeSubarraySum().new Solution();
        int i = solution.minSubArrayLen(4, new int[]{1, 4, 4});
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = nums.length;
        boolean flag = false;

        int sum = 0;
        //滑动窗口，两指针一前一后形成窗口，不满足条件，前指针一直遍历，满足条件后，后指针前进，缩小窗口
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                flag = true;
                res = Math.min(res,i-j+1);
                sum -= nums[j++];
            }
        }
        return flag ? res : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

