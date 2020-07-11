学习笔记
# HomeWork
简单：
用 add first 或 add last 这套新的 API 改写 Deque 的代码
分析 Queue 和 Priority Queue 的源码
删除排序数组中的重复项（Facebook、字节跳动、微软在半年内面试中考过）
旋转数组（微软、亚马逊、PayPal 在半年内面试中考过）
合并两个有序链表（亚马逊、字节跳动在半年内面试常考）
合并两个有序数组（Facebook 在半年内面试常考）
两数之和（亚马逊、字节跳动、谷歌、Facebook、苹果、微软在半年内面试中高频常考）
移动零（Facebook、亚马逊、苹果在半年内面试中考过）
加一（谷歌、字节跳动、Facebook 在半年内面试中考过）
中等：
设计循环双端队列（Facebook 在 1 年内面试中考过）
困难：
接雨水（亚马逊、字节跳动、高盛集团、Facebook 在半年内面试常考）
下周预习
预习题目：
有效的字母异位词
二叉树的中序遍历
最小的 k 个数

========================================================
## 分析 Queue 和 PriorityQueue 源码
 ### Queue 接口
 方法 ：
    - add(E e) 将指定元素插入队列中。如果成功返回true；如果超出空间范围抛出 IllegalStateException异常
    - offer(E e) 将指定元素插入队列中。成功则返回true；与add区别是超出空间范围不抛异常。
    - remove 返回并删除队列head元素，如果队列空则抛 NoSuchElementException异常。
    - poll 返回并删除队列head元素，如果队列空则返回 null。
    - element 返回队列head元素，但不做删除操作,如果队列空则抛 NoSuchElementException异常。
    - peek 返回队列head元素，但不做删除操作，如果队列空则返回 null。

 ### AbstractQueue抽象类
 AbstractQueue implements Queue
    - add(E e)  直接调用 offer(e) 失败则抛异常 IllegalStateException("Queue full") 源码如下
    - remove() 和 element() 同理实现。
----------------------
    public boolean add(E e) {
        if (offer(e))
            return true;
        else
            throw new IllegalStateException("Queue full");
    }
----------------------
    - clear() 清空队列，实现方法是while循环执行 poll() 源码如下
----------------------
    public void clear() {
        while (poll() != null)
            ;
    }
----------------------
    - addAll(Collection<? extends E> c) 把指定集合追加到队列中，如果入参是null则抛出 NullPointerException；如入参是自己则抛出 IllegalArgumentException 源码如下；
----------------------
    public boolean addAll(Collection<? extends E> c) {
        if (c == null)
            throw new NullPointerException();
        if (c == this)
            throw new IllegalArgumentException();
        boolean modified = false;
        for (E e : c)
            if (add(e))
                modified = true;
        return modified;
    }
----------------------

 ### PriorityQueue类
 PriorityQueue extends AbstractQueue 
    - Object[] queue; 通过queue属性来存储，底层是Object数组。
    - int modCount 属性用来记录修改次数
    - private final Comparator<? super E> comparator; 属性comparator用来实现优先级比较。
    - ensureNonEmpty(Object[] es) 用来确保存在queue[0]元素，peek() 和 poll()实现的避免异常出现。源码如下
```
    private static Object[] ensureNonEmpty(Object[] es) {
        return (es.length > 0) ? es : new Object[1];
    }
```
    - void grow(int minCapacity) 扩容方法的具体实现。注意ArraysSupport.newLength方法
       新长度 = Max(指定长度减去原始长度，原始长度如果小于64 则 +2 否则 double) + 原始长度
----------------------
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = ArraysSupport.newLength(oldCapacity,
                minCapacity - oldCapacity, /* minimum growth */
                oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1
                                           /* preferred growth */);
        queue = Arrays.copyOf(queue, newCapacity);
    }
----------------------
    - int indexOf(Object o) 返回指定元素在数组中的索引。这个方法 用来实现 removeAt(i) 进而实现 remove(Object o)
----------------------
    private int indexOf(Object o) {
        if (o != null) {
            final Object[] es = queue;
            for (int i = 0, n = size; i < n; i++)
                if (o.equals(es[i]))
                    return i;
        }
        return -1;
    }
----------------------
       - boolean contains(Object o)实现也是通过 indexof来实现的 具体代码只有一行
----------------------
     public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }
----------------------
    - forEach(Consumer<? super E> action) 函数式编程
----------------------
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        final Object[] es = queue;
        for (int i = 0, n = size; i < n; i++)
            action.accept((E) es[i]);
        if (expectedModCount != modCount)
            throw new ConcurrentModificationException();
    }
----------------------