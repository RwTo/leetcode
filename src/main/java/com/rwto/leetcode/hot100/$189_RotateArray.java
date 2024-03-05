package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;
import java.util.List;
//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3,4,5,6,7], k = 3
//Output: [5,6,7,1,2,3,4]
//Explanation:
//rotate 1 steps to the right: [7,1,2,3,4,5,6]
//rotate 2 steps to the right: [6,7,1,2,3,4,5]
//rotate 3 steps to the right: [5,6,7,1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,-100,3,99], k = 2
//Output: [3,99,-1,-100]
//Explanation: 
//rotate 1 steps to the right: [99,-1,-100,3]
//rotate 2 steps to the right: [3,99,-1,-100]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -231 <= nums[i] <= 231 - 1 
// 0 <= k <= 105 
// 
//
// 
// Follow up: 
//
// 
// Try to come up with as many solutions as you can. There are at least three di
//fferent ways to solve this problem. 
// Could you do it in-place with O(1) extra space? 
// 
// Related Topics Array Math Two Pointers 
// 👍 17061 👎 1853
 
/**
    @author: renmw
    @date: 2024-01-11 14:13:50
    @title: 旋转的数组
    @questionId: 189
    1. k取余，模拟旋转
    2. 辅助数组 记录要旋转的k取余个数组
**/
public class  $189_RotateArray {
    public static void main(String[] args) {
        Solution solution = new $189_RotateArray().new Solution();
        solution.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public void rotate(int[] nums, int k) {
//        if(null == nums || nums.length == 0){
//            throw new IllegalArgumentException();
//        }
//        if(nums.length == 1){
//            return;
//        }
//        for(int i = 0; i < k; i++){
//            int tmp = nums[nums.length-1];
//            for(int j = nums.length - 1; j >= 1; j--){
//                nums[j] = nums[j-1];
//            }
//            nums[0] = tmp;
//        }
//    }
//}
class Solution {
    public void rotate(int[] nums, int k) {
        if(null == nums || nums.length == 0){
            throw new IllegalArgumentException();
        }
        if(nums.length == 1){
            return;
        }
        k = k % nums.length;
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = nums[nums.length - k + i];
        }
        for(int i = nums.length - 1; i >= k; i--){
            nums[i] = nums[i-k];
        }
        for(int i = 0; i < k; i++){
            nums[i] = arr[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

