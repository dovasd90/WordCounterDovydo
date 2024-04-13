package com.example.wordcounterdovydo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void GivenEmptyText_GetCharsCount_ReturnZero() {
        String givenString = "";

        int expectedValue = 0;
        int actualValue = TextCounter.getCharsCount(givenString);
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void GivenEmptyText_getWordsCount_ReturnZero() {
        TextCounter tc = new TextCounter();

        String givenString = "";

        int expectedValue = 0;
        int actualValue = tc.getWordsCount(givenString);
        assertEquals(expectedValue, actualValue);
    }

    //null
    //"
    //Labas 
}