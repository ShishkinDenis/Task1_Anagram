package ru.denisshishin.task1anagram;



import java.util.HashSet;


public class Anagram {
    public static String reverseString(String text, String exceptions) {
        char[] charText = text.toCharArray();
        char[] charExceptions = exceptions.toCharArray();

        HashSet<Character> setOfExceptions = new HashSet<>();
        for (char c : charExceptions) {
            setOfExceptions.add(c);
        }

        int r = charText.length - 1;
        int l = 0;

                while (l < r) {
                    if (setOfExceptions.contains(charText[l])) {
                        l++;
                    } else if (setOfExceptions.contains(charText[r])) {
                        r--;
                    } else {
                            char tmp = charText[l];
                            charText[l] = charText[r];
                            charText[r] = tmp;
                            l++;
                            r--;
                    }
                }
        return new String(charText);
    }

    public static String createAnagram(String text,String exceptions) {
        StringBuilder anagram = new StringBuilder();
    for (String part : text.split(" ")){
              anagram.append(reverseString(part, exceptions)).append(" ");
             }
    return anagram.toString().trim();
    }





}
