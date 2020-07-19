学习笔记
# HashMap 源码分析
### HashMap put(key,value)
```java
    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     *
     * @param key key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with {@code key}, or
     *         {@code null} if there was no mapping for {@code key}.
     *         (A {@code null} return can also indicate that the map
     *         previously associated {@code null} with {@code key}.)
     */
    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }
```
### HashMap putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict)
```java
    /**
     * Implements Map.put and related methods.
     *
     * @param hash hash for key
     * @param key the key
     * @param value the value to put
     * @param onlyIfAbsent if true, don't change existing value
     * @param evict if false, the table is in creation mode.
     * @return previous value, or null if none
     */
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

# 二叉树（Binary Tree） 概念知识总结
##### 高度 Height 节点的高度 = 节点到叶子节点的最长路径。
##### 深度 Depth  节点的深度 = 根节点到这个节点所经历的边的个数。
##### 层 Level    节点的层数 = 根节点深度+1
##### 树的高度 =  根节点高度。

##### 满二叉树：
##### 完全二叉树：
##### 满二叉树是完全二叉树的特殊情况。

## 二叉树存储方式
### 链式存储法:
    - 每个节点有三个字段，一个存储数据，另两个指向左右子节点的指针。是常用的二叉树存储方式。
### 顺序存储法(基于数组):
    - 我们把根节点存储在下标 i 的位置，左子节点在 2*i 的位置，右子节点在 2*i+1 的位置，父节点在 i/2 的位置。这种方式制药指导根节点存储位置(一般情况下，为了方便计算节点，根节点会存储在下标为1的位置)，就可以吧整棵树串起来。
据此来看 完全二叉树适合用数组存储

## 二叉树的遍历
#### 前序遍历 PreOrder - 根左右
#### 中序遍历 InOrder - 左根右
#### 后续遍历 PostOrder - 左右根
#### 核心思想：递归 尝试java写一下

## 二叉查找树 Binary Search Tree (二叉搜索树)
### 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值。

### 二叉查找树，递归搜索Java实现
```java
    public Node find(int data){
        Node p = tree;
        // 循环递归
        while (p!=null){
            if(data < p.data){
                // 目标值小于当前节点，则左叶子节点继续递归
                p = p.left;
            } else if(data > p.data){
                // 目标值大于当前节点，则右叶子节点继续递归
                p = p.right;
            } else {
                // 等于则返回该节点
                return p;
            }
        }
        // 循环结束说明该树中不存在这个节点。
        return null;
    }
```

### 二叉查找树，插入一个节点 Java实现
```java
    public void insert(int data){

        // 如果是空树,则创建独立节点的树
        if(tree == null){
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while(p != null){
            if(data > p.data){
                // 目标值大于当前节点,右子节点为空则创建右节点，否则向右递归
                if(p.right == null){
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else if(data < p.data>){
                // 目标值小于当前节点,左子节点为空则创建左节点，否则向左递归
                if(p.left == null){
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }
```
### 二叉查找树，删除一个节点 Java实现
#### 思路：
    - 情况1：该节点没有子节点，把该节点父节点中指向该节点的指针指向null。
    - 情况2：该节点有一个子节点，把该节点父节点中指向该节点的指针指向该节点的唯一子节点。
    - 情况3：该节点有两个子节点，1.找到右子树中最小节点; 2.用右子树中最小节点替换要删除的节点，并删除最小节点。
```java
    public void delete(int data){
        Node p = tree; // p指向要删除的节点
        Node pparent = null; // 记录p的父节点

        // 循环递归找到该数据节点
        while(p != null && p.data != data){
            pparent = p;
            if(data > p.data){
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没找到该数据
        if(p == null){
            return;
        }

        // 要删除的节点有两个子节点
        if(p.left != null && p.right !=null){
            // 查找右子树中最小节点
            Node minP = p.right;
            Node minPP = p; // minPP记录minP的父节点
            while(minP.left != null){
                minPP = minP;
                minP = minP.left;
            }
            // 将minP的数据替换到p中
            p.data = minP.data;
            p = minP;
            // 删除最小子节点
            // 难点理解：将最小字节点父节点赋给父节点，在程序最后一步做了删除操作。
            // 这段代码精妙之处
            pparent = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node pChild; // 用来记录p的子节点
        if(p.left != null){
            pChild = p.left;
        } else {
            pChild = null;
        }

        if(pParent == null){
            // 删除根节点
            tree = pChild;
        } else if (pParent.left == p){
            pParent.left = pChild;
        } else {
            pParent.right = pChild;
        }
    }
```
