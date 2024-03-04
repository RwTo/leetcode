package com.rwto.leetcode.hot100;
import com.rwto.leetcode.utils.ListNode;

import java.lang.reflect.Array;
import java.util.*;
//
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
////
////        异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s and p consist of lowercase English letters. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 12035 👎 331
 
/**
    @author: renmw
    @date: 2024-01-11 09:09:24
    @title: Find All Anagrams in a String
    @questionId: 438
    子串  ->  滑动窗口  右边一直动，寻找左边界改变时机
    连续  ->  双指针
**/
public class  $438_FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new $438_FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution.findAnagrams("abab", "ab"));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private Map<Character, Integer> charMap = null;

    /**
     * 先构建固定窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen=s.length();
        int pLen=p.length();

        if(sLen<pLen){
            return ans;
        }
        //建立两个数组存放字符串中字母出现的词频，并以此作为标准比较
        int [] scount=new int[26];
        int [] pcount=new int[26];

        //当滑动窗口的首位在s[0]处时 （相当于放置滑动窗口进入数组）
        for(int i=0;i<pLen;i++){
            ++scount[s.charAt(i)-'a']; //记录s中前pLen个字母的词频
            ++pcount[p.charAt(i)-'a']; //记录要寻找的字符串中每个字母的词频(只用进行一次来确定)
        }

        //判断放置处是否有异位词     (在放置时只需判断一次)
        if(Arrays.equals(scount,pcount)){
            ans.add(0);
        }

        //开始让窗口进行滑动
        for(int i=0;i<sLen-pLen;i++){ //i是滑动前的首位
            --scount[s.charAt(i) -'a'];       //将滑动前首位的词频删去
            ++scount[s.charAt(i+pLen) -'a'];  //增加滑动后最后一位的词频（以此达到滑动的效果）

            //判断滑动后处，是否有异位词
            if(Arrays.equals(scount,pcount)){
                ans.add(i+1);
            }
        }

        return ans;
    }


//    public List<Integer> findAnagrams(String s, String p) {
//        if(null == p || null == s){
//            return null;
//        }
//
//        List<Integer> res = new ArrayList<>();
//        int plen = p.length();
//        for(int i = 0; i <= s.length()-plen; i++){
//            if(findStr(plen,s,i,getCharMap(p))){
//                res.add(i);
//            }
//        }
//        return res;
//    }

    private boolean findStr(int len, String s, int start, Map<Character,Integer> map){
        if(start == 0){
            StringBuilder sb = new StringBuilder();
            while(len-- != 0){
                sb.append(s.charAt(start++));
            }
            charMap = getCharMap(sb.toString());
            return equalCharMap(charMap,map);
        }
        if(charMap.get(s.charAt(start-1)) == 1){
            charMap.remove(s.charAt(start-1));
        }else{
            charMap.put(s.charAt(start-1),charMap.get(s.charAt(start-1))-1);
        }
        char c = s.charAt(start+len-1);
        charMap.putIfAbsent(c,0);
        charMap.put(c,charMap.get(c)+1);
        return equalCharMap(charMap,map);
    }

    private boolean equalCharMap(Map<Character,Integer> map1,Map<Character,Integer> map2){
        if(map1.size() != map2.size()){
            return false;
        }
        Set<Map.Entry<Character, Integer>> entrySet = map1.entrySet();
        for(Map.Entry<Character,Integer> entry : entrySet){
            if(!map2.containsKey(entry.getKey()) || !map2.get(entry.getKey()).equals(entry.getValue())){
                return false;
            }
        }
        return true;
    }

    private Map<Character,Integer> getCharMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        if(null == s){
            return map;
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.putIfAbsent(c,0);
            map.put(c,map.get(c)+1);
        }
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

