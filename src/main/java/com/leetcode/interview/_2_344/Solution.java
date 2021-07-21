package com.leetcode.interview._2_344;

// 344. https://leetcode.com/problems/reverse-string/
public class Solution {
    public static void main(String[] args) {

//        char[] ss = new char[10];
        char[] s = {'h','e','l','l','o'};
        System.out.println("test");
        reverseString(s);


        System.out.print("test : ");
        for(char c : s){
            System.out.print(c);
        }
        System.out.print("");


    }


    public static void reverseString(char[] s) {

        char[] c = s.clone();

        //1. for 문으로 인덱스를 끝에서부터 시작
        for (int i = s.length -1 ; 0 <= i; i--) {
            System.out.println("c " + i + " : " + c[i]);
            int a = s.length - i - 1 ;
            System.out.println("s " + a + " : " + s[a]);
            System.out.println();
            s[a] = c[i];
        }

    }
}
