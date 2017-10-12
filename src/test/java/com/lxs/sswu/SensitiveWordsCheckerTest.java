package com.lxs.sswu;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class SensitiveWordsCheckerTest {
    @Test
    public void testCheckSensitiveWord() {
        Set<String> ss = SensitiveWordsChecker.checkSensitiveWord("嫖是是正中国共产党哦啊撕裂weed断口每次你长者巍螺丝扣的阿里");
        Assert.assertTrue(ss.size() == 3);
        ss = SensitiveWordsChecker.checkSensitiveWord("是是正哦啊撕裂weed断口每次你巍螺丝扣的阿里");
        Assert.assertTrue(ss.isEmpty());
    }

    @Test
    public void testCheckSensitiveWordByHugeText() throws IOException {
        long st = System.currentTimeMillis();

        StringBuilder strb = new StringBuilder();
        try (InputStreamReader inReader = new InputStreamReader(ClassLoader.getSystemResourceAsStream("server.log"), "gbk");
             BufferedReader reader = new BufferedReader(inReader)) {
            reader.lines().forEach(strb::append);
        }

        String str = strb.toString();
        System.out.println("加载：" + str.length() + "数据，耗时：" + (System.currentTimeMillis() - st) / 1000);

        st = System.currentTimeMillis();
        Set<String> ss = SensitiveWordsChecker.checkSensitiveWord(str);
        System.out.println("耗时：" + (System.currentTimeMillis() - st) / 1000 + "，敏感词：" + ss);
        Assert.assertTrue(ss.size() == 4);
    }
}
