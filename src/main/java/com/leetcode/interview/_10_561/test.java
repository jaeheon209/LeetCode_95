package com.leetcode.interview._10_561;

public class test {

    public static void main(String[] args) {

//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";

        System.out.println("answer : " + isPalindrome(s));

    }

    public static boolean isPalindrome(String s) {
        String[] sArr = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase().split("");
        for (int i = 0; i < sArr.length / 2; i++) {
            if (!sArr[i].equals(sArr[sArr.length - 1 - i])) {
                return false;
            }
        }
        return true;
    }

}
