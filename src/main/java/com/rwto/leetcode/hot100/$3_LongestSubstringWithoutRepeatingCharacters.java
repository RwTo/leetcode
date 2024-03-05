package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长
//子串
// 的长度。
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 38409 👎 1767
 
/**
    @author: renmw
    @date: 2024-01-10 17:51:17
    @title: 不重复字符的最长子字符串
    @questionId: 3
    字串 -> 连续  -> 双指针 / 滑动窗口
    while
        右指针移动
        判断元素是否在Map集合中
        如果有：左指针移动 Map.get()+1
        取最大值
        存入Map
**/
public class  $3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new $3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("abba"));
        System.out.println(solution.lengthOfLongestSubstring("abad"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(null == s){
            throw new IllegalArgumentException();
        }
        char[] cs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>(s.length());
        /*建立快慢指针*/
        int slw = 0,ft = 0;
        int res = 0;
        while(slw < s.length() && ft < s.length()){
            /*如果字符已经存在，更新左边界*/
            if(map.containsKey(cs[ft])){
                /*取最大值，防止重复计算*/
                slw = Math.max(map.get(cs[ft]) + 1,slw);
            }
            /*存储*/
            map.put(cs[ft],ft);
            res = Math.max(res,ft-slw+1);
            /*更新右边界*/
            ft++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

