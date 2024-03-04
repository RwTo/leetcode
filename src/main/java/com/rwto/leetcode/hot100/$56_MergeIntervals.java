package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
//        请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sorting 
// 👍 21440 👎 740
 
/**
    @author: renmw
    @date: 2024-01-11 13:32:42
    @title: Merge Intervals
    @questionId: 56
**/
public class  $56_MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new $56_MergeIntervals().new Solution();
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {10, 11}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution.merge(new int[][]{{1,4}, {2,3}})));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int[][] merge(int[][] intervals) {
//        if(null == intervals || intervals.length == 0){
//            return intervals;
//        }
//        Arrays.sort(intervals,(o1,o2)-> o1[0]-o2[0]);
//        List<int[]> res = new ArrayList<>();
//        int start = intervals[0][0]; int end = intervals[0][1];
//        for(int i = 1; i < intervals.length; i++){
//            if(intervals[i][0] <= end){
//                end = Math.max(intervals[i][1],end);
//            }else{
//                res.add(new int[]{start,end});
//                start = intervals[i][0];
//                end = Math.max(intervals[i][1],end);
//            }
//        }
//        res.add(new int[]{start,end});
//        return res.toArray(new int[][]{});
//    }

    public int[][] merge(int[][] intervals) {
        if(null == intervals || intervals.length == 0){
            return intervals;
        }
        List<int[]> res = new ArrayList<>();
        /*排序*/
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        /*开始和结束位置*/
        int start = intervals[0][0],end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < end){
                end = Math.max(end,intervals[i][1]);
            }else{
                res.add(new int[]{start,end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start,end});
        return res.toArray(new int[][]{});
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

