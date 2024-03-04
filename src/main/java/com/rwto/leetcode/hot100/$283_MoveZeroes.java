package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done? Related Top
//ics Array Two Pointers 
// 👍 15964 👎 414
 
/**
    @author: renmw
    @date: 2024-01-09 12:45:49
    @title: 移动零
    @questionId: 283
**/
public class  $283_MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new $283_MoveZeroes().new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
//        int cur = 0;
//        for (int i = 0; i < nums.length; i++){
//            if(nums[i] != 0){
//                nums[cur++] = nums[i];
//            }
//        }
//        for(int i = cur; i < nums.length; i++){
//            nums[i] = 0;
//        }
        if(null == nums){
            throw new IllegalArgumentException();
        }
        if(0 == nums.length || 1 == nums.length){
            return;
        }

        int x = 0, y= 0;
        while(x < nums.length && y < nums.length){
            /*x 找到0的位置*/
            while(x < nums.length){
                if(nums[x] == 0){break;}
                x++;
            }
            y=x;
            /*y 找到非0 的位置*/
            while(y < nums.length){
                if(nums[y] != 0){
                    break;
                }
                y++;
            }
            if(x < nums.length && y < nums.length){
                /*位置交换*/
                int swap = nums[x];
                nums[x] = nums[y];
                nums[y] = swap;
                x++;
                y++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

