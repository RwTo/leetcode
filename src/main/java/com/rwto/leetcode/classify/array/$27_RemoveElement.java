package com.rwto.leetcode.classify.array;
//Given an integer array nums and an integer val, remove all occurrences of val
//in nums in-place. The order of the elements may be changed. Then return the numb
//er of elements in nums which are not equal to val. 
//
// Consider the number of elements in nums which are not equal to val be k, to g
//et accepted, you need to do the following things: 
//
// 
// Change the array nums such that the first k elements of nums contain the elem
//ents which are not equal to val. The remaining elements of nums are not importan
//t as well as the size of nums. 
// Return k. 
// 
//
// Custom Judge: 
//
// The judge will test your solution with the following code: 
//
// 
//int[] nums = [...]; // Input array
//int val = ...; // Value to remove
//int[] expectedNums = [...]; // The expected answer with correct length.
//                            // It is sorted with no values equaling val.
//
//int k = removeElement(nums, val); // Calls your implementation
//
//assert k == expectedNums.length;
//sort(nums, 0, k); // Sort the first k elements of nums
//for (int i = 0; i < actualLength; i++) {
//    assert nums[i] == expectedNums[i];
//}
// 
//
// If all assertions pass, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of
// nums being 2.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements o
//f nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 2314 👎 3351
 
/**
    @author: renmw
    @date: 2024-05-11 14:25:37
    @title: Remove Element
    @questionId: 27
**/
public class  $27_RemoveElement {
    public static void main(String[] args) {
        Solution solution = new $27_RemoveElement().new Solution();
        int i = solution.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(i);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            //快慢指针，找到满足条件的值放入 前面的位置
            if(nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

