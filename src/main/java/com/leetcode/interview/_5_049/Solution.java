package com.leetcode.interview._5_049;

import java.util.*;
import java.util.stream.Collectors;

// 049. https://leetcode.com/problems/group-anagrams/
public class Solution {
    public static void main(String[] args) {
        // 1. input
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        // 2. groupAnagrams
        List<List<String>> answer = groupAnagrams(strs);

        // 3. answer 출력
        for (List<String> ans : answer) {
            System.out.println("answer : " + ans.toString());
        }
//        Output:[["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs) {
            //1.단어를 분리하고 알파벳 순 정렬
            String key = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());

            //2. map에서 알파벳 순으로 정렬된 키 검색, 없으며 리스트 생성
            List<String> groups = anagramGroups.getOrDefault(key, new ArrayList<String>());

            //3. 가져온 value(list)에 단어 추가 및 맵에 put
            groups.add(str);
            anagramGroups.put(key, groups);
        }
        return new ArrayList<>(anagramGroups.values());
    }

// 1. 문제 파악
// 2. 요구 사항 정리
// 3. 논리 전개
// 4. 코딩

    // 설명 정리.
    public static List<List<String>> groupAnagrams2(String[] strs) {
        //1. str : {"eat", "tea", "tan", "ate", "nat", "bat"}

        //2. anagramGroups를 저장할 공간을 미리 만들어둔다.
        Map<String, List<String>> anagramGroups = new HashMap<>();
        // 1) 기대하는 아웃 형상으로 자료구조를 만든다.
        // 2) Output:[  ["bat"],["nat","tan"],["ate","eat","tea"]   ]
        // 3) str의 원소 재배열을 통해서, 동일한 원소를가진 word를 모아야한다.
        //    (1) str 원소의 재배열 (String) - key
        //    (2) 동일한 원소를 가진 word를 모운다. (array, list -> List) value
        // 4) key, value => String, List<String>
        // 5) Map<String, List<String>>
        //  => Map<'str 원소 재배열 값', '재배열값과 동일한 원소를가지는 word'>

        for (String str : strs) {
            //1.단어를 분리하고 알파벳 순 정렬 후 병합해서 key를 만듦

            // case 1
            //1) 단어를 알파벳으로 스플릿
            String[] strArr = str.split("");

            //2) 스플릿한 단어를 오름차순 정렬
            Arrays.sort(strArr);

            //3) 정렬한 알파벳을 하나로 합쳐 단어로 만든다
            String key2 = Arrays.toString(strArr);

            // case 2
            // 1) + 2) + 3)
            String key = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());

            //2. map에서 알파벳 순으로 정렬된 키 검색, 없으며 리스트 생성
            // input : eat -> aet
            // key : aet
            // value : eat

            // case 1 - 값이 있고 없고에 따라 달라짐.
            if (anagramGroups.get(key) == null) {
                // 1) 기존에 값이 없다.
                List<String> group1 = new ArrayList<String>();
                group1.add(str);
                anagramGroups.put(key, group1);
            } else {
                // 2) 기존에 값이 있다.
                List<String> group1 = anagramGroups.get(key);
                group1.add(str);
                anagramGroups.put(key, group1);
            }

            // case 2
            List<String> groups = anagramGroups.getOrDefault(key, new ArrayList<String>());
            groups.add(str);
            anagramGroups.put(key, groups);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    // 숙제 - merge sort랑 tim sort 에 대해서 공부하기 ( 노션 정리 )
    // 1) 논리적 로직 정리
    // 2) 코드로 구현해보기

}
