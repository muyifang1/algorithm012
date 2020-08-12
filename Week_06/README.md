学习笔记
回顾
递归模板 Recursion
- 1.terminator
- 2.process logic
- 3.drill down
- 4.restore state

分治 Divide & Conquer
- 1.recursion terminator
- 2.prepare data
- 3.conquer sub problems
- 4.process and generate the final result
- 5.revert the current level states

感触
- 1.避免人肉递归，低效且累 (如果非要人肉递归 画递归状态树)
- 2.找到最近最简单方法，将其拆解成可重复解决的问题
- 3.数学归纳法思维（抵制人肉递归的诱惑）
- 总结本质：寻找重复性 --> 计算机指令集

动态规划 关键点 DP Dynamic Programming
- 1.动态规划和递归或者分治 没有根本上的区别(关键看有无最优的子结构)
- 2.共性：找到重复子问题
- 3.差异性：最优子结构、中途可以淘汰次优解

路径问题思路分析 动态规划关键点
- 1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)
- 2. 储存中间状态：opt[i]
- 3. 递推公式（美其名曰：状态转移方程或者DP方程）
    - Fib:opt[i]=opt[n-1]+opt[n-2]
    - 二维路径：opt[i,j]=opt[i+i,j]+opt[i,j+1](且判断a[i,j]是否空地)

动态规划小结：
    - 1.打破自己的思维惯性，形成机器思维
    - 2.理解复杂逻辑的关键
    - 3.也是职业进阶的要点要领