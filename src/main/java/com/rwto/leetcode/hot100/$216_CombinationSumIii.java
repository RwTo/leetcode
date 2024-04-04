package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//Find all valid combinations of k numbers that sum up to n such that the follow
//ing conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain t
//he same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics Array Backtracking 
// 👍 5837 👎 109
 
/**
    @author: renmw
    @date: 2024-04-04 11:03:44
    @title: Combination Sum III
    @questionId: 216
    有两个判断条件
**/
public class  $216_CombinationSumIii {
    public static void main(String[] args) {
        Solution solution = new $216_CombinationSumIii().new Solution();
        
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer> > res = new ArrayList<>();

        dfs(k, n, new LinkedList<Integer>(), res, 0,1);

        return res;
    }

    public void dfs(int k, int n, LinkedList<Integer> tmpRes, List<List<Integer>> res, int sum, int start){
        if(tmpRes.size() == k && sum == n){
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        if(sum > n){
            return;
        }
        if(tmpRes.size() >= k){
            return;
        }

        for(int i = start; i <= 9; i++){
            sum += i;
            tmpRes.add(i);
            dfs(k, n, tmpRes, res,sum,i+1);
            sum -= i ;
            tmpRes.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

