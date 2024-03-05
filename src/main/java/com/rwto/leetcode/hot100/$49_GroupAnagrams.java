package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;


import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//        字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
// 
// Example 1: 
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2: 
// Input: strs = [""]
//Output: [[""]]
// Example 3: 
// Input: strs = ["a"]
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] consists of lowercase English letters. 
// 
// Related Topics Array Hash Table String Sorting 
// 👍 17982 👎 538
 
/**
    @author: renmw
    @date: 2024-01-09 10:30:07
    @title: 字母异位词分组
    @questionId: 49
    判断异位词  -> 1. int[26] 记录字母出现的频率  2. 排序判断
    Map<String,List<>>
    key 为 sort(" ")
**/
public class  $49_GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new $49_GroupAnagrams().new Solution();
        solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String,List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            char[] cs = str.toCharArray();
//            Arrays.sort(cs);
//            String key = new String(cs);
//            if(map.containsKey(key)){
//                map.get(key).add(str);
//            }else{
//                List<String> list = new ArrayList<>();
//                list.add(str);
//                map.put(key, list);
//            }
//        }
//        return new ArrayList<>(map.values());
//    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

