package com.rwto.leetcode.classify.array;
//Given a sorted array of distinct integers and a target value, return the index
// if the target is found. If not, return the index where it would be if it were i
//nserted in order. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,6], target = 5
//Output: 2
// 
//
// Example 2: 
//
// 
//Input: nums = [1,3,5,6], target = 2
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [1,3,5,6], target = 7
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums contains distinct values sorted in ascending order. 
// -104 <= target <= 104 
// 
// Related Topics Array Binary Search 
// 👍 15843 👎 715
 
/**
    @author: renmw
    @date: 2024-05-08 16:26:49
    @title: Search Insert Position 搜索插入位置
    @questionId: 35
**/
public class  $35_SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new $35_SearchInsertPosition().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        int left = 0;
        int right = nums.length;
        //[) left = right 不合法 例如 [0,0)
        while(left < right){
            //保证每次进入循环都是[) ，即 right 不会参与查找
            res = left + (right - left)/2;
            if(nums[res] == target){
                //如果存在相同元素，则向前找靠前的位置
                return res;
            }else if (nums[res] > target){
                //保证每次进入循环都是 [)
                right = res;
            }else{
                left = res + 1;
            }
        }
        return nums[res] > target ? res : res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

