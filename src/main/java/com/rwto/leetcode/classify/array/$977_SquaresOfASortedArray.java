package com.rwto.leetcode.classify.array;
//Given an integer array nums sorted in non-decreasing order, return an array of
// the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, co
//uld you find an O(n) solution using a different approach? Related Topics Array T
//wo Pointers Sorting 
// 👍 9222 👎 236
 
/**
    @author: renmw
    @date: 2024-05-11 15:04:22
    @title: Squares of a Sorted Array 有序数组的平法
    @questionId: 977
**/
public class  $977_SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution solution = new $977_SquaresOfASortedArray().new Solution();
        int[] ints = solution.sortedSquares(new int[]{-4, -1, 0, 3, 10});
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] sortedSquares(int[] nums) {
//
//        int[] res = new int[nums.length];
//        int left = -1; int right = nums.length;
//        int j = 0;
//        for(int i = 0 ; i < nums.length; i++){
//            if(nums[i] < 0){
//                left = i;
//            }
//            if(nums[i] == 0){
//                res[j++] = 0;
//            }
//            if(nums[i] > 0){
//                right = i;
//                break;
//            }
//        }
//
//        while(left >= 0 && right <= nums.length - 1){
//            if(Math.abs(nums[left]) < Math.abs(nums[right])){
//                res[j++] = nums[left] * nums[left];
//                left--;
//            }else{
//                res[j++] = nums[right] * nums[right];
//                right++;
//            }
//        }
//
//        while(left >= 0){
//            res[j++] = nums[left] * nums[left];
//            left--;
//        }
//
//        while(right <= nums.length - 1){
//            res[j++] = nums[right] * nums[right];
//            right++;
//        }
//
//        return res;
//    }
//}



class Solution {
    public int[] sortedSquares(int[] nums) {

        //数据的最大值要么在最左边，要么在最右边
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int idx = nums.length - 1;
        while(left <= right){
            int leftValue = nums[left] * nums[left];
            int rightValue = nums[right] * nums[right];
            if(leftValue < rightValue){
                res[idx] = rightValue;
                right--;
            }else {
                res[idx] = leftValue;
                left++;
            }
            idx--;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

