package com.leetcode.interview._1_125;

// 125. https://leetcode.com/problems/valid-palindrome/
public class Solution {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        isPalindrome(s);
    }
    public static boolean isPalindrome(String s) {
        // ### 1. 문제를 파악한다.
        // - 파라미터로 들어오는 s의 값이
        // - 회문인지 아닌지 판단한다.
        // - 대소문자 무시.
        // - 회문은 앞으로 읽으나 뒤로 읽으나 같은 문장

        // ### 2. 문제를 해결할 논리를 작성
        // 1) 띄워쓰기랑 특수문자 제외해야한다.
        // 2) 전부다 소문자로 변경 (대소문자 무시니까 맞춰준다.)
        // 3) 문자열을 뒤집는다.
        // 4) 기존 문자열과 뒤집은 문자열을 비교
        // 5) 비교한 결과를 리턴한다.
        //  ㄴ 글자가 같으면 true
        //  ㄴ 글자가 틀리면 false

        // ### 3. 코드를 짠다.
        // 2) 전부다 소문자로 변경 (대소문자 무시니까 맞춰준다.)
        String lower = s.toLowerCase();

        // 1) 띄워쓰기랑 특수문자 제외해야한다.
        String[] value = lower.replaceAll("[^a-z0-9]", "").split("");
        // 삭제 - 3) 문자열을 뒤집는다.
        // 4) 기존 문자열과 뒤집은 문자열을 비교
        // 홀수  7  /2 = 3
        // 짝수  6 / 2 = 3

        // 5) 비교한 결과를 리턴한다.
        //  ㄴ 글자가 같으면 true
        //  ㄴ 글자가 틀리면 false;

        // Two Point 기법
        for (int i = 0; i < value.length / 2; i++) {
            if (!value[i].equals(value[value.length - i - 1])) {
                return false;
            }
        }
        return true;
    }
}
