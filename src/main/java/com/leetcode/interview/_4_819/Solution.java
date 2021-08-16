package com.leetcode.interview._4_819;


import java.util.*;

// 819. https://leetcode.com/problems/most-common-word/
public class Solution {
    public static void main(String[] args) {
        // case1
//        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
//        String[] banned = {"hit"};

        // case2
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};

        String answer = mostCommonWord(paragraph, banned);
        System.out.println("answer : " + answer);

    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        //1. paragraph 전처리 : 소문자, 특수문자, split
        String[] paragraphArr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase().split("\\s+");
        // "\\s : 단일 공백 문자
        // "\\s+ : 하나 이상의 공백 문자 입니다.

        //2. banned to hashset
        Set<String> bannedSet = new HashSet<>();
        for (String bannedWord : banned) {
            bannedSet.add(bannedWord);
        }

        //3. word count
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : paragraphArr) {
            if (!bannedSet.contains(word)) {
                int count = wordCount.getOrDefault(word, 0);
                wordCount.put(word, count + 1);
            }
        }

//       4. find max count
//        int max = 0;
//        String maxCountWord = "";
//        for (String key : wordCount.keySet()) {
//            if (max < wordCount.get(key)) {
//                max = wordCount.get(key);
//                maxCountWord = key;
//            }
//        }
//        return maxCountWord;



        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }







}
