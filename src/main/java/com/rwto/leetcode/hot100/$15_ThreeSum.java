package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//
//        你返回所有和为 0 且不重复的三元组。
//
//        注意：答案中不可以包含重复的三元组。
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not mat
//ter.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
// 
//
// Example 3: 
//
// 
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
// 
// Constraints: 
//
// 
// 3 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics Array Two Pointers Sorting 
// 👍 29584 👎 2692
 
/**
    @author: renmw
    @date: 2024-01-10 14:53:31
    @title: 3Sum
    @questionId: 15
**/
public class  $15_ThreeSum {
    public static void main(String[] args) {
        Solution solution = new $15_ThreeSum().new Solution();
        System.out.println(solution.threeSum(new int[]{-2,0,0,2,2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(null == nums || nums.length < 3){
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        /*排序*/
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            /*找第一个数，排除重复的数*/
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] > 0){
                break;
            }
            /*第二个数*/
            int left = i + 1;
            /*第三个数*/
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    /*去重*/
                    while(left < right && nums[left] == nums[++left]);
                    while(left < right && nums[right] == nums[--right]);
                }else if(sum > 0){
                    while(left < right && nums[right] == nums[--right]);
                }else{
                    while(left < right && nums[left] == nums[++left]);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

