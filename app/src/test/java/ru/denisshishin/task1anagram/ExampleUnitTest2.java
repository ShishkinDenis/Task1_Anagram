package ru.denisshishin.task1anagram;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class ExampleUnitTest2 {
    @Test
    public static void main(String[] args) {

        String str = "abcd4b.c.d,e'f,ghi";
        String stringException = "abcd";
        char[] charException = stringException.toCharArray();
        HashSet<Character> set = new HashSet<>();

        for (char c : charException) {
            set.add(c);
        }

        char[] charArray = str.toCharArray();
        System.out.println("Input string:" + str);
        reverseString(charArray,set);
        String reversedString = new String(charArray);
        System.out.println("Output string:" + reversedString);
    }



    public static void reverseString(char[] str, HashSet<Character> set) {
        int r = str.length - 1;
        int l = 0;

            while (l < r) {
                if (set.contains(str[l])) {
                    l++;
                } else if (set.contains(str[r])) {
                    r--;
                } else {
                    char tmp = str[l];
                    str[l] = str[r];
                    str[r] = tmp;
                    l++;
                    r--;
                }
            }
    }

}



