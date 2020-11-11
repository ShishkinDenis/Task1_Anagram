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
    @Test
    public void anagramOfSpaceIsCorrect() {
        assertEquals("", Anagram.createAnagram(" ","12"));
    }
    @Test
    public void emptyAnagramIsCorrect() {
        assertEquals("", Anagram.createAnagram("",""));
    }
    @Test
    public void anagramWithoutIgnoredCharsIsCorrect() {
        assertEquals("321", Anagram.createAnagram("123",""));
    }
    @Test
    public void anagramWithIgnoredDigitsIsCorrect() {
        assertEquals("dednimxoF looc 24/7", Anagram.createAnagram("Foxminded cool 24/7","0123456789"));
    }
    @Test
    public void anagramWithIgnoredXLIsCorrect() {
        assertEquals("dexdnimoF oocl 7/42", Anagram.createAnagram("Foxminded cool 24/7","xl"));
    }
    @Test
    public void anagramWithSameTextInBothInputsIsCorrect() {
        assertEquals("foxminded", Anagram.createAnagram("foxminded","foxminded"));
    }
    @Test
    public void anagramWithAllLettersIsCorrect() {
        assertEquals("ЬЫЪЩШЧЦХФУТСРПОНМЛКЙИЗЖЁЕДГВБАяюэьыъщшчцхфутсрпонXYZмлкйизжёедгвба" +
                "WVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcbaЭЮЯ",
                Anagram.createAnagram("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ","XYZЭЮЯ"));
    }
    @Test
    public void anagramWithSpecificSymbolsIsCorrect() {
        assertEquals(".~}|{`_^][@+?->=:<;/.,*)(’&%$#\"\\!",
                Anagram.createAnagram("!\\\"#$%&’()*+,-./:;<=>?@[]^_`{|}~.","+-:"));
    }



}
