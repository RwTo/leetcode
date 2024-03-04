package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.HashMap;
import java.util.Map;
//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
//
// 
//Follow-up: Can you come up with an algorithm that is less than O(n2) time comp
//lexity? Related Topics Array Hash Table 
// 👍 54297 👎 1814
 
/**
    @author: renmw
    @date: 2024-01-09 10:04:37
    @title: 两数之和
    @questionId: 1
**/
public class  $1_TwoSum {
    public static void main(String[] args) {
        Solution solution = new $1_TwoSum().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(target-num)){
                return new int[]{map.get(target-num),i};
            }
            map.put(num,i);
        }


        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

