package ru.denisshishin.task1anagram;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateAnagramTest {
    @Test
    public void reverseOfStringIsCorrect() {
        assertEquals("вба1 cba2", Anagram.reverseString("abc1 абв2","12"));
    }
    @Test
    public void anagramOfEachWordIsCorrect() {
        assertEquals("cba1 вба2", Anagram.createAnagram("abc1 абв2","12"));
    }
}
