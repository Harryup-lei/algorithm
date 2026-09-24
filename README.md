# algorithm

力扣（LeetCode）算法题解仓库，记录刷题过程中的 Java 实现与解题心得，目前已收录 **19 道题、26 种解法**。

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
| [430](https://leetcode.cn/problems/flatten-a-multilevel-doubly-linked-list/) | 扁平化多级双向链表 | 中等 | 递归拼接子链、前序遍历串链 | `Lettcode430` · `Lettcode430_1` |
| [433](https://leetcode.cn/problems/minimum-genetic-mutation/) | 最小基因变化 | 中等 | 广度优先搜索（BFS） | `Lettcode433` |
| [436](https://leetcode.cn/problems/find-right-interval/) | 寻找右区间 | 中等 | TreeMap 红黑树、排序 + 二分查找 | `Lettcode436` · `Lettcode436_1` |
| [447](https://leetcode.cn/problems/number-of-boomerangs/) | 回旋镖的数量 | 中等 | 暴力三重循环、哈希表计数 | `Lettcode447` · `Lettcode447_1` |
| [449](https://leetcode.cn/problems/serialize-and-deserialize-bst/) | 序列化和反序列化二叉搜索树 | 中等 | 前序遍历序列化 + 上下界递归建树 | `Lettcode449` |
| [451](https://leetcode.cn/problems/sort-characters-by-frequency/) | 根据字符出现频率排序 | 中等 | 哈希计数 + 优先队列、ASCII 编码映射 | `Lettcode451` · `Lettcode451_1` |
| [453](https://leetcode.cn/problems/minimum-moves-to-equal-array-elements/) | 最小操作次数使数组元素相等 | 中等 | 逆向思维 | `Lettcode453` |
| [456](https://leetcode.cn/problems/132-pattern/) | 132 模式 | 中等 | 单调栈 | `Lettcode456` |
| [457](https://leetcode.cn/problems/circular-array-loop/) | 环形数组是否存在循环 | 中等 | 模拟 + 方向判断 | `Lettcode457` |
| [462](https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/) | 最小操作次数使数组元素相等 II | 中等 | 中位数贪心 | `Lettcode462` |
| [464](https://leetcode.cn/problems/can-i-win/) | 我能赢吗 | 中等 | 博弈论 + 状态压缩 + 记忆化搜索 | `Lettcode464` |
| [467](https://leetcode.cn/problems/unique-substrings-in-wraparound-string/) | 环绕字符串中唯一的子字符串 | 中等 | 线性 DP + 问题转化 | `Lettcode467` |
| [473](https://leetcode.cn/problems/matchsticks-to-square/) | 火柴拼正方形 | 中等 | 状态压缩 + 记忆化 DFS | `Lettcode473` |

## 解题心得

根据提交记录整理的每道题关键点：

- **[402] 移掉 K 位数字**：要得到最小的数，关键是让高位尽可能小。回溯枚举删法可行但效率低；改用单调栈维护递增序列，遇到逆序就弹出，一次遍历即可
- **[413] 等差数列划分**：`dp[i]` 表示以 `i` 结尾的等差子数组个数，满足 `nums[i] - nums[i-1] == nums[i-1] - nums[i-2]` 时 `dp[i] = dp[i-1] + 1`
- **[417] 太平洋大西洋水流问题**：逐点 DFS 验证两边可达复杂度较高；改为从太平洋、大西洋边界反向 DFS 标记可达点，两者交集即为答案
- **[419] 甲板上的战舰**：DFS 沉没法直观；把握图的规律——战舰只能横/竖排列且互不相邻，因此只需统计「左上角」的 `X` 数量，O(1) 额外空间
- **[424] 替换后的最长重复字符**：滑动窗口，缩小窗口的条件判断是关键——`窗口长度 > 历史最大字符数 + k` 时才移动左指针
- **[427] 建立四叉树**：递归分治的典型应用，存在最小子问题时应优先考虑递归——区域内值全相同则为叶子节点，否则四等分继续递归
- **[430] 扁平化多级双向链表**：递归的应用。解法一在遇到 `child` 时递归拉平子链，再找到子链尾接回原 `next`；解法二借鉴二叉树遍历的思路，用全局 `prev` 指针按「根 → 子树 → 右兄弟」的前序顺序边遍历边串链，逻辑更简洁
- **[433] 最小基因变化**：BFS 求最短变化次数。合理剪枝是关键——新基因必须存在于 `bank` 且未被访问过，用 `map` 记录到达每个基因的步数，逐层扩展
- **[436] 寻找右区间**：本质是「找第一个起点 ≥ 当前终点的区间」。用 `TreeMap` 的 `ceilingKey` 直接拿到答案（红黑树，O(n log n)）；也可以把起点排序后二分查找，两种写法都要注意保存原始下标
- **[447] 回旋镖的数量**：以每个点为中心，统计与它距离相同的点的个数 `cnt`，贡献 `cnt × (cnt - 1)` 个有序排列。暴力三重循环直观但 O(n³)；哈希表按距离分组可降到 O(n²)，计算平方距离时注意用 `long` 防溢出
- **[449] 序列化和反序列化二叉搜索树**：序列化用前序遍历拼接成字符串；反序列化的关键在于**利用 BST 的性质**——递归建树时传入 `(min, max)` 上下界，队首元素不在范围内就说明该位置是空节点，无需存储 `null` 占位符，既保持原始树结构又节省空间
- **[451] 根据字符出现频率排序**：哈希表统计频次，优先队列按频次降序输出。解法一自己把字符映射成 `0~61` 的编号（小写 `0-25`、大写 `26-51`、数字 `52-61`）再手动还原，加深了对 ASCII 码的理解；解法二直接用 `char` 作为键更简洁，并在频次相同时按字符排序保证结果稳定
- **[453] 最小操作次数使数组元素相等**：逆向思维的脑筋急转弯。「每次让 n-1 个元素 +1」等价于「每次让 1 个元素 -1」，于是问题变成把所有元素都减到最小值，答案就是 `Σ(nums[i] - min)`
- **[456] 132 模式**：从右向左遍历，单调栈保持递减。`k` 记录所有被弹出的元素中的最大值，即「2」的最优候选；当 `nums[i] < k` 时说明存在 `nums[i] < k < 栈中某元素` 的 132 模式，直接返回 `true`
- **[457] 环形数组是否存在循环**：模拟走环的过程。两个判断点决定成败——① 方向必须始终一致（正负号不能中途变化），② 环长必须大于 1（自己指向自己不算环）；数组下标取模要注意负数，用 `((cur + nums[cur]) % n + n) % n` 保证落在 `[0, n)`。走超过 n 步还没回到起点说明不存在环
- **[462] 最小操作次数使数组元素相等 II**：中位数贪心。要让所有元素相等且总移动步数最小，目标值取**中位数**最优（取平均值会被极端值带偏）；排序后直接取 `nums[n/2]`，答案为 `Σ|x - median|`
- **[464] 我能赢吗**：博弈论 + 状态压缩。用位掩码 `state` 表示已选数字的集合，`f[state]` 记忆化搜索结果（`1` 表示当前行动方必胜，`-1` 表示必败），避免大量重复子状态。两个关键剪枝：可选最大值已经够到目标直接赢；所有数之和都不够则必输
- **[467] 环绕字符串中唯一的子字符串**：**问题的转化是核心**——直接统计不同的子串会重复计数，转成「以字符 `c` 结尾的连续子串最多有多长」，答案就是这 26 个长度的和。因为只要某个长度的子串存在，比它短的以同一字符结尾的子串必然也都存在，天然去重。判断连续性时注意 `z → a` 的环绕，差值 25 也算连续
- **[473] 火柴拼正方形**：状态压缩 + 记忆化 DFS。位掩码 `state` 表示火柴的使用情况，`dp[state]` 记录该状态能否拼成（`-1` 未计算、`0` 失败、`1` 成功），避免同一状态重复搜索。两个必要剪枝：总长度不能被 4 整除直接返回 `false`；`curr` 累加到边长 `avg` 时归零，开始拼下一条边

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
├── Lettcode430.java    # 430 扁平化多级双向链表：递归拼接子链
├── Lettcode430_1.java  # 430 扁平化多级双向链表：前序遍历串链
├── Lettcode433.java    # 433 最小基因变化：BFS
├── Lettcode436.java    # 436 寻找右区间：TreeMap
├── Lettcode436_1.java  # 436 寻找右区间：排序 + 二分查找
├── Lettcode447.java    # 447 回旋镖的数量：暴力三重循环
├── Lettcode447_1.java  # 447 回旋镖的数量：哈希表计数
├── Lettcode449.java    # 449 序列化和反序列化二叉搜索树：前序 + 上下界递归
├── Lettcode451.java    # 451 根据字符出现频率排序：ASCII 编码映射 + 优先队列
├── Lettcode451_1.java  # 451 根据字符出现频率排序：哈希计数 + 优先队列
├── Lettcode453.java    # 453 最小操作次数使数组元素相等：逆向思维
├── Lettcode456.java    # 456 132 模式：单调栈
├── Lettcode457.java    # 457 环形数组是否存在循环：模拟 + 方向判断
├── Lettcode462.java    # 462 最小操作次数使数组元素相等 II：中位数贪心
├── Lettcode464.java    # 464 我能赢吗：博弈论 + 状态压缩 + 记忆化搜索
├── Lettcode467.java    # 467 环绕字符串中唯一的子字符串：线性 DP + 问题转化
├── Lettcode473.java    # 473 火柴拼正方形：状态压缩 + 记忆化 DFS
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
java算法 线性dp条件转化 Lettcode467环绕字符中的唯一子字符串
java算法 状态压缩记忆化 Lettcode473火柴拼正方形
```

持续更新中，欢迎交流与指正。