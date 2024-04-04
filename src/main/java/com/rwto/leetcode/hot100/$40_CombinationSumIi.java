package com.rwto.leetcode.hot100;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics Array Backtracking 
// 👍 10222 👎 283

/**
    @author: renmw
    @date: 2024-04-03 13:03:38
    @title: Combination Sum II
    @questionId: 40
    难点：一个数字只能选用一次
    排序后进行深搜，
    对于每一层，第一个数字深搜后，相同数字每一层只能使用一次

    每一个dfs函数就是一层
    dfs里的for循环是向下延申遍历
    所以可以在dfs方法里new一set局部变量，对于使用过的数字直接跳过

    进阶 观看每一层的树结构
    只有位置 n 和n-1 的数字相同，就代表重复
    但是对于每一列，还需要使用相同的数字
    为了避免 列 被去重 i > begin  才是每一层！！！！！！！！
    i < begin 代表的是上一层的树
    每个dfs方法都是一层树，这一层树 i 是从begin开始的，所以 i> begin 才是 一层树，去重自然也要限制 i> begin
**/
public class  $40_CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new $40_CombinationSumIi().new Solution();
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates,target,0,new LinkedList<>(),res,0);

        return res;
    }

    private void dfs(int[] candidates, int target, int start,LinkedList<Integer> tmpRes, List<List<Integer>> res,int sum) {
        if(sum == target){
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        //剪枝,可以不写
        if(sum > target){
            return;
        }

        for (int i = start;  i < candidates.length; i++){
            /*针对每一层去重*/
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            tmpRes.add(candidates[i]);
            dfs(candidates,target,i+1, tmpRes, res, sum);
            sum -= candidates[i];
            tmpRes.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

