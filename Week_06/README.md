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
