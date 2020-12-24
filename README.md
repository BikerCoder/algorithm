#《小灰的算法之旅》学习笔记、代码
##2、数据结构基础
###2.1 数组

###2.2 链表

###2.3 栈和队列

### 2.4 散列表
##3、树
###3.1 树和二叉树

###3.2 二叉树的遍历
####3.2.1 深度优先遍历
#####前序遍历

#####中序遍历

#####后序遍历

####3.2.2 广度优先遍历
#####层序遍历

###3.3 二叉堆
二叉堆同样也是二叉树，分为最小堆和最大堆。二叉堆可以用数组来实现。左子节点坐标 = 父节点坐标 * 2 + 1；右子节点坐标 = 父节点坐标 * 2 + 1.
#####新增节点：直接新增在最后一个坐标对应的子节点处，再进行上浮操作调整
#####删除节点：删除处于堆顶的节点，并将数组坐标末尾的节点暂时代替堆顶，再进行下沉调整
####3.3.1 最小堆
最小堆中父节点的数据小于等于左右子节点的数据

####3.3.2 最大堆
最大堆中父节点的数据大于等于左右子节点的数据
###3.4 优先队列
普通的队列是先进先出，而优先队列则不一样，分为最小优先队列和最大优先队列。最大优先队列每一次出队的元素都是队列中最大的元素，最小优先队列则与之相反，每一次出队的元素都是队列中最小的元素
##4、排序
###4.1 冒泡排序
三种不同性能的冒泡排序
###4.2 鸡尾酒排序
###4.3 快速排序
####4.3.1 双边遍历法
####4.3.2 单边遍历法
####4.3.3 非递归的方式实现

