# algorithm

力扣（LeetCode）算法题解仓库，记录刷题过程中的 Java 实现与解题心得，目前已收录 **6 道题、9 种解法**。

## 项目信息

- **语言**：Java 17
- **构建工具**：Maven
- **包结构**：`com.kelei`，每道题一个类，命名规则 `Lettcode<题号>`，同一题多解法用 `_1`、`_2` 后缀区分

## 题解索引

| 题号 | 题目 | 难度 | 解法思路 | 相关类 |
| :--: | :--- | :--: | :------- | :----- |
| [402](https://leetcode.cn/problems/remove-k-digits/) | 移掉 K 位数字 | 中等 | 回溯（贪心枚举）、单调栈 | `Lettcode402` · `Lettcode402_1` |
| [413](https://leetcode.cn/problems/arithmetic-slices/) | 等差数列划分 | 中等 | 动态规划 | `Lettcode413` |
| [417](https://leetcode.cn/problems/pacific-atlantic-water-flow/) | 太平洋大西洋水流问题 | 中等 | 逐点 DFS、反向边界 DFS | `Lettcode417` · `Lettcode417_1` |
| [419](https://leetcode.cn/problems/battleships-in-a-board/) | 甲板上的战舰 | 中等 | DFS 沉没、左上角扫描 | `Lettcode419` · `Lettcode419_1` |
| [424](https://leetcode.cn/problems/longest-repeating-character-replacement/) | 替换后的最长重复字符 | 中等 | 滑动窗口 | `Lettcode424` |
| [427](https://leetcode.cn/problems/construct-quad-tree/) | 建立四叉树 | 中等 | 递归分治 | `Lettcode427` |

## 解题心得

根据提交记录整理的每道题关键点：

- **[402] 移掉 K 位数字**：要得到最小的数，关键是让高位尽可能小。回溯枚举删法可行但效率低；改用单调栈维护递增序列，遇到逆序就弹出，一次遍历即可
- **[413] 等差数列划分**：`dp[i]` 表示以 `i` 结尾的等差子数组个数，满足 `nums[i] - nums[i-1] == nums[i-1] - nums[i-2]` 时 `dp[i] = dp[i-1] + 1`
- **[417] 太平洋大西洋水流问题**：逐点 DFS 验证两边可达复杂度较高；改为从太平洋、大西洋边界反向 DFS 标记可达点，两者交集即为答案
- **[419] 甲板上的战舰**：DFS 沉没法直观；把握图的规律——战舰只能横/竖排列且互不相邻，因此只需统计「左上角」的 `X` 数量，O(1) 额外空间
- **[424] 替换后的最长重复字符**：滑动窗口，缩小窗口的条件判断是关键——`窗口长度 > 历史最大字符数 + k` 时才移动左指针
- **[427] 建立四叉树**：递归分治的典型应用，存在最小子问题时应优先考虑递归——区域内值全相同则为叶子节点，否则四等分继续递归

## 目录结构

```
src/main/java/com/kelei/
├── Lettcode402.java    # 402 移掉 K 位数字：回溯
├── Lettcode402_1.java  # 402 移掉 K 位数字：单调栈
├── Lettcode413.java    # 413 等差数列划分：动态规划
├── Lettcode417.java    # 417 太平洋大西洋水流问题：逐点 DFS
├── Lettcode417_1.java  # 417 太平洋大西洋水流问题：反向边界 DFS
├── Lettcode419.java    # 419 甲板上的战舰：DFS 沉没
├── Lettcode419_1.java  # 419 甲板上的战舰：左上角扫描
├── Lettcode424.java    # 424 替换后的最长重复字符：滑动窗口
├── Lettcode427.java    # 427 建立四叉树：递归分治
└── Main.java           # 本地调试入口
```

## 使用方式

- 每道题保留 LeetCode 原题的方法签名，可直接提交到力扣平台
- 本地调试在 `Main.java` 中编写测试用例，用 IDE 直接运行即可

## 提交规范

提交信息统一格式：

```
java算法 <本题心得> Lettcode<题号><题目名>
```

例如：

```
java算法 滑动窗口缩小窗口的条件判断 Lettcode424替换后的最长重复字符
```

持续更新中，欢迎交流与指正。