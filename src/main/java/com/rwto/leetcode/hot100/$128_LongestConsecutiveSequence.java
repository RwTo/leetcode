package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
//        请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//
// 
// Example 1: 
//
// 
//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Theref
//ore its length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,3,7,2,5,8,4,6,0,1]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array Hash Table Union Find 
// 👍 19058 👎 896
 
/**
    @author: renmw
    @date: 2024-01-09 12:21:23
    @title: 最长连续序列
    @questionId: 128
**/
public class  $128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new $128_LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if(null == nums){
            throw new IllegalArgumentException();
        }
        if(0 == nums.length || nums.length == 1){
            return nums.length;
        }
        HashSet<Object> set = new HashSet<>(nums.length);
        int res = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int num : nums){
            /*找最大值*/
            if(set.contains(num+1)){
                continue;
            }
            int curNum = num;
            int longest = 1;
            /*找到最大值后，逐渐找连续最小值*/
            while(set.contains(--curNum)){
                longest++;
            }
            res = Math.max(longest,res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

