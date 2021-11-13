package com.bikercoder.study.algorithm.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author caoguo
 * @Description： 387. 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @date：2021/11/11 5:06 下午
 **/
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar3("loveleetcode"));
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

    /**
     * 借助哈希存储索引，借助队列来存放顺序
     * 时间复杂度O(n) n为字符串的长度
     * 空间复杂度O(|Σ|) Σ为字符集
     *
     * @param s
     * @return
     */
    public static int firstUniqChar3(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                map.put(ch, -1);
                while (!queue.isEmpty() && map.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        return queue.isEmpty() ? -1 : queue.peek().pos;

    }
}

class Pair {
    char ch;
    int pos;

    Pair(char ch, int pos) {
        this.ch = ch;
        this.pos = pos;
    }
}
