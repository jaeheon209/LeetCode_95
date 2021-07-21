package com.leetcode.interview._3_937;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 937. https://leetcode.com/problems/reorder-data-in-log-files/
public class Solution {

    // 요구 조건을 얼마나 깔끔하게 처리 할 수 있는지 묻는 문제
    // compare & comapareTo 설명 : https://st-lab.tistory.com/243
    // 람다 비교 예시 코드 : https://broduck.tistory.com/5
    // 람다 다중 정렬 : https://broduck.tistory.com/6
    // list to array or array to list : https://ilovejinwon.tistory.com/54
    public static void main(String[] args) {

        String[] logs = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] logs2 = {"6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"};
        String[] sortLogs = reorderLogFiles(logs2);

        for(String log : sortLogs) {
            System.out.println(log);
        }

    }


    public static String[] reorderLogFiles(String[] logs) {

        List<String> lets = new ArrayList<>();
        List<String> digs = new ArrayList<>();

        //1. 문자로그 숫자로그 구분 O(n)
        for (String log : logs) {
            String element = log.split(" ")[1];
            if (isNumber(element)) {
                digs.add(log);
            } else {
                lets.add(log);
            }
        }

        //2. 문자로그 정렬 (Sorting)
        //{"let1 art can", "let2 own kit dig", "let3 art zero"};
        lets.sort(Comparator.comparing((String let) -> let.split(" ", 2)[1])
                .thenComparing((String let) -> let.split(" ", 2)[0]));

        //3. 문자/숫자 로그 합치기
        lets.addAll(digs);
        return lets.toArray(new String[lets.size()]);
    }


    public static Boolean isNumber(String element) {
        try {
            Double.parseDouble(element); // 숫자가 크면 integer로 판독 불가로 Double 사용
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
