# algorithm

力扣（LeetCode）算法题解仓库，记录自己在刷题过程中的解题思路与 Java 实现。

## 项目信息

- **语言**：Java 17
- **构建工具**：Maven
- **包结构**：`com.kelei`，每道题一个类，类名形如 `Lettcode<题号>`

## 已完成的题目

| 题号 | 题目 | 难度 | 解法思路 | 相关类 |
| :--: | :--- | :--: | :------- | :----- |
| [402](https://leetcode.cn/problems/remove-k-digits/) | 移掉 K 位数字 | 中等 | 回溯 + 贪心 | `Lettcode402` |
| [402](https://leetcode.cn/problems/remove-k-digits/) | 移掉 K 位数字 | 中等 | 单调栈（优化） | `Lettcode402_1` |
| [413](https://leetcode.cn/problems/arithmetic-slices/) | 等差数列划分 | 中等 | 动态规划 | `Lettcode413` |

## 目录结构

```
algorithm
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── kelei
                    ├── Lettcode402.java     # 402 题：回溯解法
                    ├── Lettcode402_1.java   # 402 题：单调栈解法
                    ├── Lettcode413.java     # 413 题：动态规划
                    └── Main.java            # 本地测试入口
```

## 使用方式

每道题提供 LeetCode 原题所需的方法签名，可直接提交到力扣平台；本地调试可在 `Main.java` 中编写测试用例运行：

```bash
mvn compile exec:java -Dexec.mainClass="com.kelei.Main"
```

## 说明

- 同一道题如有多种解法，用 `_1`、`_2` 后缀区分（如 `Lettcode402_1`）
- 持续更新中，欢迎交流与指正