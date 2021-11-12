package com.bikercoder.study.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caoguo
 * @Description： 387. 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @date：2021/11/11 5:06 下午
 **/
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar2("loveleetcode"));
    }


    /**
     * 哈希存储字符索引
     * 时间复杂度 O(n) n为字符串长度
     * 空间复杂度 O(|Σ|) Σ为字符集
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int re = n;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value != -1 && value < re) {
                re = value;
            }
        }
        if (re == n) {
            return -1;
        }
        return re;
    }

    /**
     * 哈希存储字符频数
     * 时间复杂度O(n) n为字符串长度
     * 空间复杂度O(|Σ|) Σ为字符集
     *
     * @param s
     * @return
     */
    public static int firstUniqChar2(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }
}
