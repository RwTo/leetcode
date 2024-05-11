package com.rwto.leetcode.classify.array;
//Given an array of integers nums which is sorted in ascending order, and an int
//eger target, write a function to search target in nums. If target exists, then r
//eturn its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 < nums[i], target < 104 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array Binary Search 
// 👍 11617 👎 244
 
/**
    @author: renmw
    @date: 2024-05-08 15:36:11
    @title: Binary Search 二分查找
    @questionId: 704
**/
public class  $704_BinarySearch {
    public static void main(String[] args) {
        Solution solution = new $704_BinarySearch().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //left == right 时 是合法参数，所以<=
        while(left <= right){
            //保证每次进入循环 都是 []
            int mid = left + (right - left)/2; //防止溢出
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                //要保证 [] 所以 是mid -1
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

