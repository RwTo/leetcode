package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
//
//        题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//        请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
// 
// Example 1: 
// Input: nums = [1,2,3,4]
//Output: [24,12,8,6]
// Example 2: 
// Input: nums = [-1,1,0,-3,3]
//Output: [0,0,9,0,0]
// 
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 105 
// -30 <= nums[i] <= 30 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
//
// 
// Follow up: Can you solve the problem in O(1) extra space complexity? (The out
//put array does not count as extra space for space complexity analysis.) 
// Related Topics Array Prefix Sum 
// 👍 21109 👎 1236
 
/**
    @author: renmw
    @date: 2024-01-11 15:28:22
    @title: Product of Array Except Self
    @questionId: 238
**/
public class  $238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new $238_ProductOfArrayExceptSelf().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixNum = new int[nums.length+1];
        int[] suffixNum = new int[nums.length+1];
        prefixNum[0] = 1;
        suffixNum[0] = 1;
        int product = 1;
        for(int i = 0; i < nums.length; i++){
            product *= nums[i];
            prefixNum[i+1] = product;
        }
        product = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            product *= nums[i];
            suffixNum[nums.length - i] = product;
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = prefixNum[i] * suffixNum[nums.length-i-1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

