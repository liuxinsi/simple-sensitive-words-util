# simple-sensitive-words-util
基于DFA算法的敏感词检测

![](https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/DFA_example_multiplies_of_3.svg/500px-DFA_example_multiplies_of_3.svg.png)

## Usage

> 1.修改敏感词文件，每行一个敏感词。

> 2.按照下面顺序寻找文件。
>> 启动时配置的系统属性 -DswFilePath。全路径。

>> ${user.dir}/words.txt。一般是bin、domain etc...<br/>

>> ${classpath}/words.txt。环境变量里的默认配置。<br/>

```   
@Test
public void testCheckSensitiveWord() {
       Set<String> ss = SensitiveWordsChecker.checkSensitiveWord("嫖是是正中国共产党哦啊撕裂weed断口每次你长者巍螺丝扣的阿里");
       Assert.assertTrue(ss.size() == 3);
       ss = SensitiveWordsChecker.checkSensitiveWord("是是正哦啊撕裂weed断口每次你巍螺丝扣的阿里");
       Assert.assertTrue(ss.isEmpty());
}
```