package com.shang;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shang on 2018/5/12.
 * 给定一个字符串，找字符中的最大非重复子串
 *
 * 解题思路：
 * 用start记录当前处理的开始位置 历遍字符串，
 * 当当前字符从开始位置start开始已经出现过的时候，子串开始位置+1，否则更新map中的hash值为当前位置
 *
 */
public class Solution {

    public static void main(String[] args) {
        String s = "abcdseasedzdgwa";
//        s = s.substring(0,2);
//        System.out.println(s);

        int i = lengthOfLongestSub(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSub(String s){

        if(s==null){
            return -1;
        }
        //开始位置
        int start = 0;
        //记录最大的非重复字符串的长度
        int result = 0;

//        StringBuilder sb = new StringBuilder();

        Map<Character,Integer> map = new HashMap<>(s.length());

        for (int i = 0; i <s.length() ; i++) {

            char ch = s.charAt(i);

            if(map.containsKey(ch) && map.get(ch) >= start){
                start = map.get(ch)+1;
//                sb = new StringBuilder(s.substring(start,i)+ch);
            }else{
                result = Math.max(result,i-start+1);
//                sb.append(ch);
            }

            map.put(ch,i);
        }
        return result;


    }
}
