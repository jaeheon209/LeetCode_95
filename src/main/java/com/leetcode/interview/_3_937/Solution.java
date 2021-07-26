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

        for (String log : sortLogs) {
            System.out.println(log);
        }

    }


    public static String[] reorderLogFiles(String[] logs) {

        List<String> lets = new ArrayList<>();
        List<String> digs = new ArrayList<>();

        //1. 문자로그 숫자로그 구분 O(n)
        for (String log : logs) {
            String element = log.split(" ")[1];
//            if (isNumber(element)) { -- 더간단한 방법으로
            if (!Character.isDigit(element.charAt(0))) {
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

    public static class lamda {
        public static void main(String[] args) {
            List<String> lets = new ArrayList<>();

            //2-1. 구현체 버전
            lets.sort(new letComparator());

            //2-2. 익명 함수
            lets.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.split(" ", 2)[1].compareTo(o2.split(" ", 2)[1]);
                }
            });

            //2-3. 람다 시전
            lets.sort((String o1, String o2) -> o1.split(" ", 2)[1].compareTo(o2.split(" ", 2)[1]));

            //2-4. 람다 시전 : 파라미터 추론
            lets.sort((o1, o2) -> o1.split(" ", 2)[1].compareTo(o2.split(" ", 2)[1]));

            //2-5. Comparator는 Comparable 키를 추출해서 Comparator 객체로 만드는 Function 함수를 인수로 받는 정적 메서드 comparing 을 포함 => comparing 을 사용!
            lets.sort(Comparator.comparing((String let) -> let.split(" ", 2)[1]));
            //2-6. 메서드 레퍼런스 사용 : inventory.sort(Comparator.comparing(Apple::getWeight));

        }
    }

    public static class letComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o1.split(" ", 2)[1].compareTo(o2.split(" ", 2)[1]);
        }
    }

}


