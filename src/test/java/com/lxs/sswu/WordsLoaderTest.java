package com.lxs.sswu;


import org.junit.Assert;
import org.junit.Test;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class WordsLoaderTest {

    @Test
    public void testGetWordsMap() {
        Assert.assertFalse(WordsLoader.getWordsMap().isEmpty());
    }
}
