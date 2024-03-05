package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
//        子数组是数组中元素的连续非空序列。
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics Array Hash Table Prefix Sum 
// 👍 20557 👎 615
 
/**
    @author: renmw
    @date: 2024-01-11 10:30:19
    @title: 子数组Sum等于K
    @questionId: 560
    连续  -> 双指针
 1. 暴力
 2. 前缀和，前缀和A-前缀和B = K 表示 A-B的范围存在 和为K
    注意 A = K的情况
**/
public class  $560_SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new $560_SubarraySumEqualsK().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 0, -1}, 0));
        System.out.println(solution.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(solution.subarraySum(new int[]{1, 2, 3}, 3));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int subarraySum(int[] nums, int k) {
//        if(null == nums || nums.length == 0){
//            return 0;
//        }
//        int count = 0;
//        for(int i = 0; i < nums.length; i++){
//            int sum = 0;
//            for(int j = i; j < nums.length; j++){
//                sum += nums[j];
//                if(sum == k){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//}
class Solution {
        /*
使用前缀和的方法可以解决这个问题，因为我们需要找到和为k的连续子数组的个数。通过计算前缀和，我们可以将问题转化为求解两个前缀和之差等于k的情况。

假设数组的前缀和数组为prefixSum，其中prefixSum[i]表示从数组起始位置到第i个位置的元素之和。那么对于任意的两个下标i和j（i < j），如果prefixSum[j] - prefixSum[i] = k，即从第i个位置到第j个位置的元素之和等于k，那么说明从第i+1个位置到第j个位置的连续子数组的和为k。

通过遍历数组，计算每个位置的前缀和，并使用一个哈希表来存储每个前缀和出现的次数。在遍历的过程中，我们检查是否存在prefixSum[j] - k的前缀和，如果存在，说明从某个位置到当前位置的连续子数组的和为k，我们将对应的次数累加到结果中。

这样，通过遍历一次数组，我们可以统计出和为k的连续子数组的个数，并且时间复杂度为O(n)，其中n为数组的长度。
        *
        * */
    public int subarraySum(int[] nums, int k) {
        if(null == nums || nums.length == 0){
            return 0;
        }
        //key 为前缀和，value 为 出现的次数
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        //前缀和为0，代表当前值就是k
        int count = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            //寻找之前已经遍历的前缀和，满足条件相加，可以看成满足条件的慢指针的个数
            count+=map.getOrDefault(sum-k,0);
            //注意：自己满足条件的情况
            if(sum == k){
                count++;
            }
            //存储前缀和
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

