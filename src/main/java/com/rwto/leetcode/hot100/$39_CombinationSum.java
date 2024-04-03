package com.rwto.leetcode.hot100;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Given an array of distinct integers candidates and a target integer target, re
//turn a list of all unique combinations of candidates where the chosen numbers su
//m to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. T
//wo combinations are unique if the frequency of at least one of the chosen number
//s is different. 
//
// The test cases are generated such that the number of unique combinations that
// sum up to target is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
//mes.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// All elements of candidates are distinct. 
// 1 <= target <= 40 
// 
// Related Topics Array Backtracking 
// 👍 18425 👎 396

/**
    @author: renmw
    @date: 2024-04-03 13:03:36
    @title: Combination Sum
    @questionId: 39
    先画树型结构
    注意题目允许出现重复，startIndex 取当前值，不需要+1
    注意递归退出条件，防止死循环  大于目标值后就要退出
    扩展思考：
    如果题目可以存在负数，我觉得应该需要判断几种场景
    1 如果存在0，抛异常，有无数个解
    2 如果有正有负，抛异常，因为一定存在最小公倍数，使二者和为0，有无数个解
    3 如果都是正数或都是负数，用回溯解，就是递归退出条件不同
**/
public class  $39_CombinationSum {
    public static void main(String[] args) {
        Solution solution = new $39_CombinationSum().new Solution();
        solution.combinationSum(new int[]{2,3,6,7},7);
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer> > res = new ArrayList<>();

        dfs(candidates,target,0,new LinkedList<>(),0,res);

        System.out.println(res);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, LinkedList<Integer> tmpRes,int sum, List<List<Integer> > res) {
        if(sum == target){
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            System.out.println(candidates[i]);
            tmpRes.add(candidates[i]);
            sum += candidates[i];
            dfs(candidates,target,i,tmpRes,sum,res);
            tmpRes.removeLast();
            sum -= candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

