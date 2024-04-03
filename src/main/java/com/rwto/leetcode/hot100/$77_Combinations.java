package com.rwto.leetcode.hot100;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Given two integers n and k, return all possible combinations of k numbers chos
//en from the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to 
//be the same combination.
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
//Explanation: There is 1 choose 1 = 1 total combination.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics Backtracking 
// 👍 8097 👎 217

/**
    @author: renmw
    @date: 2024-04-03 12:19:00
    @title: Combinations
    @questionId: 77
    回溯dfs+剪枝
    两个必须的变量，res 代表结果，tmpRes 符合条件的数组
    tmpRes 负责一直回溯，所以当确定tmpRes符合结果时，要复制一份存到res中
    for 循环在dfs里面
**/
public class $77_Combinations {
    public static void main(String[] args) {
        Solution solution = new $77_Combinations().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        /*todo 处理特殊值*/
        List<List<Integer> > res = new ArrayList<>();
        dfs(n,k,1,res,new LinkedList<>());

        return res;
    }

    public void dfs(int n, int k, int startIdx, List<List<Integer>> res, List<Integer> tmpRes){
        if(tmpRes.size() == k){
            res.add(new ArrayList<>(tmpRes));
            return;
        }

        for(int i = startIdx; i <= n; i++){
            tmpRes.add(i);
            dfs(n,k,i+1,res,tmpRes);
            tmpRes.remove(tmpRes.size()-1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}

