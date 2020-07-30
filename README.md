# play-leetcode
- [x] 1343 大小为 K 且平均数大于等于阈值的子数组个数</br>
  ps：排序找到最开始超过阈值的下标进行计算。❌：子数组是在原有数组基础上进行的查找
- [x] 1144 递减元素使数组呈锯齿状</br>
   解题思路：指针下标step为2，依次指向峰值位置 -> 判断是否小于等于左边数值（考虑下标>0）如满足，则计算差值 且 + 1 -> 同理判断是否小于等于右边数值(考虑不为最后一位) -> 取奇偶锯齿状最短操作数
- [x] 473 火柴拼正方形</br>
    -排除常规不可能 1.边数少于4 2. 总长度不能被 4 整除
    - ❌：原始思路错误点：双指针，求和为平均数。忽略[3,3,3,3,4,4,4,4,5,5,5,5]这种边长为 12 由两条以上边组成情况
    - 解决思路：**回溯** 创建 4 个桶。
        - 结束条件：所有边被访问完。
        - 进桶条件：当前+桶内 < target(目标边长)
        - 不满足：则回退当前桶值 
- [x] 206 反转链表</br>
    - 操作 3 个指针，分别 pre、cur、next
        - next = cur->next;
        - cur->next = pre
        - pre = cur;
        - cur = next;
- [x] 92 反转链表II</br>
    - 解题思路：1. 分段操作 中间段进行反转 2. 链表拼接 
        - pre = null;
        - cur、next = head;
        - 前段拷贝：
            pre = cur;
            cur = cur->next;
        - 中段反转
            ⚠️ 反转前记录 pre 和 cur 的位置 【作为中段链表的头、尾、届时进行链表拼接】
            - pre2 = pre; cur2 = cur;
            - 开始经典反转 4 步骤
                - next = cur->next;
                - cur->next = pre;
                - pre = cur;
                - cur = next;
        - 链表拼接
            - head 始终为该链表的头部
            - pre2->next = pre;
            - cur2->next = cur;
- [x] 83 删除有序链表中重复元素</br>
    - 解题思路：遍历链表，设置两个链表指针 cur、next 
        - 如果 cur->val == next->val 则删除当前next指针。删除方式：cur->next = next->next。⚠️切勿进行 cur = cur->next的操作。否则将变成两两比较 测试用例：[1,1,1,1]
        - 如果 cur->val != next->val 则cur进入下一步 cur = cur->next
        - ⚠️注意判断：cur 以及 cur->next 为 null 的情况，作为循环终止条件
    - 错误思路：1.设置虚拟头指针 导致起始位置比较的时候，创建数值可能会等于head真正的第一个元素

- [x] 445 两数相加II</br>
    - ❌ 1. 获取第一个链表的和 2. 获取第二个链表的总和 3. 将两和相加结果倒入结果链表。
        - 错误原因：求和一定要注意内存占用长度会不会比分配的类型大
    - 解题思路：
        - 1. 第一个链表数据存入栈中
        - 2. 第二个链表数据存入栈中
        - 3. 依次从两个链表中获取数据 将求和结果倒入结果链表 
            - ⚠️ a. 链表是否为空
            - ⚠️ b. 是否需要进位
            - ⚠️ c. 注意 [5] [5] 情况下链表结果
    - 倒入链表
        - node = new ListNode(x);
        - node->next = p;
        - p = node;

- [x] 82 删除排序链表中重复元素II</br>
    - 解题思路：
        - 1. 设置三个指针，分别是 pre、cur、next。
        - 2. 遍历链表，如果遇到重复的元素，则： 
            - cur->next = next->next;
            - ⚠️按题意来说出现重复 cur 也应该要删除
        - 3. 设置一个flag判断 cur 是否为删除后留下的唯一元素。
            - 如果 cur 是待删除的唯一元素则：pre = cur->next; (跳过对cur当前的指针连接)
            - 如果 cur 不是待删除指针：pre = cur; 
            - cur = next;
        - ❌：善后：当 cur 和 next 为空的时候，flag 为 true 说明最后一个元素的 cur 仍然需要绕过：pre->next = null;
- [x] 1528 重新排列字符串</b
    - 提升的解题思路：字符数组，下标为【indices[i]】 内容为【s.charAt()[i]】
    - 我一开始使用：map<key,value>存一遍、取一遍 

- [x] 剑指offer 25 合并两个排序链表</br>
    - 解题思路：
        - 遍历两个链表，选择当前两个链表元素中最小的节点，被选中的链表指针移动至next
        - 考虑到两个链表长度不一，如果另一个链表已经移动到null节点，比较方式为：(这样肯定是当前有剩余的链表元素为"小")
            - l1 = l1 != null ? l1.val : l2.val + 1;
            - l2 = l2 != null ? l2.val : l1.val + 1;

- [x] 剑指offer 24 反转链表</br>
   - 解题思路： 
       - 创建头指针 pre 将其指向 null
       - 遍历链表采用经典反转四步骤
           - next = cur.next;
           - cur.next = pre;
           - pre = cur;
           - cur = next;
           
- [x] 148 排序链表</br>
    - 解题思路：归并排序
        - 原始思路：统计链表长度并存储在List里面，进行排序，最后重新存入新链表。（效率低 且不符合题目要求）

- [x] 24 两两交换链表中的节点</br>
    - 解题思路：穿针引线
        - 1. 设置虚拟头节点
        - 2. 设置四个节点：pre、node1、node2、next
        = 3. 肯定是需要两个节点进行交换：
            - node1 = pre.next;
            - node2 = node1.next;
            - next = node2.next;
            - node2.next = node1;
            - node1.next = next;
            - pre.next = node2;
            - 交换完成 将 pre 指针移动到当前 node1 位置 :  pre = node1;
        - ⚠️ 循环的结束条件：pre.next != null 并且 pre.next.next ！= null

- [x] 160 相交链表</br>
    - 提示：两个链表长度不一致，所以无法一一按顺序比对，直到链表相交点。[1,2,3,4,5] [5,6,4,5]
    - 解决思路：
        - pa = headA; pb = headB;
        - pa 一直往前移， pb 也一直往前移，并进行比对
        - 当 pa 结束了 A 链表的移动，直到 pa = null 的时候，pa 往 B链表继续移动。
        - 当 pb 结束了 B 链表的移动，直到 pb = null 的时候，pb 往 A 链表继续移动。
            - ⚠️ 两个链表的长度总和是一致的。
            - 循环结束条件：pa == pb


| 匹配结果 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 1 | 1 |
| :-----| ----: | :----: | :----: | :----: | :----: | :----: | :----: | :----: | :----: | 
| pa | 1 | 2 | 3 | 4 | 5 | 5 | 6 | 4 | 5 |
| pb | 5 | 6 | 4 | 5 | 1 | 2 | 3 | 4 | 5 |

- [x] 19 删除链表的倒数第N个节点</br>
    - 提示：⚠️要删除倒数第n个节点 则必须要找到倒数 n+1 节点的位置。
    - 解题思路：
        - 设置 p 和 q 两个节点 以及 虚拟头节点
        - dummyHead.next = head; pre = dummyHead;
        - 1. 寻找到 tail 的位置，tail 为 pre 向后移动 n+1 距离的节点
        - 2. pre 和 tail 同时向后移动，直到 tail 指针指向 null。则此时 pre 指针就准确的坐落在将删除指针元素的前一个位置。
        - 3. 删除方式：pre.next = pre.next.next.

- [x] 61 旋转链表</br>
    - 解题思路：
        - 1.统计链表实际总长度
        - 2. 寻找链表的尾部，使其尾部指向头部形成循环。 此时需要两个节点：tail->next = head;
        - 3. 寻找到该循环链表实际的尾部地址，地址 pos = len - (k % len); 
        - 4. 指定位置的下一个为返回链表的头部：result = tail.next; 再将指定位置的下一节点指向 null : tail.next = null;
    - ⚠️：a. 优先排除链表长度为空/长度=1情况的旋转。 b. 优先排除 k = 0 的旋转。
    - 核心代码：
        - 寻找尾部 
            ListNode tail = head;
            while(tail.next != null) 
                tail = tail.next;
        - 寻找实际的 tail ⚠️当前tail并不是从头开始，是从尾部开始，所以要比常规寻找 pos 多了一步 tail = tail.next
            for (int i = 0; i < pos; i++)
                tail = tail.next;
        - 放置尾部和实际头部
            result = tail.next;
            tail.next = null;
            
- [x] 18 删除链表的节点</br>
    - 解题思路：p.next = p.next.next; 经典删除方式。
        - 考虑点⚠️： 1. head 只有唯一一个元素需要删除，则需设立虚拟头节点 2. p.next.next 为空的时候指针 3. 循环的控制条件：p.next != null            
         
       
- [x] 面试题 02.05. 链表求和</br>
    - 解题思路：同 2 链表求和。
        - 注意：1. l1 或者 l2 不为空时继续循环。（ || ❌ &&）
        - new 链表节点的时候：p.next = new ListNode(值) 而不是 p = new ListNode(值);否则前面记录的节点前功尽弃。
        - 结束之后，注意进位 carry 是否为 1 的情况。 
        
- [x] 817 链表组件</br>
    - 解题思路：创建两个List集合：
        - 集合1：list 用于将数组转换成list 从而可以直接调用 contains 函数判断是否存在该元素
        - 集合2：temp 用于在遍历链表的时候，将持续contain的元素存入，从而判断是否增加计数
        - ⚠️：head 链表遍历完成之后，很有可能存在最后一组 temp 中是有元素的情况，所以仍然需要判断一次。
    - 核心代码：
        - list.add(G[i]) //创建集合1
        - list.contains(head.val)
            - list.remove((object) head.val);//⚠️此处注意：是移除元素，并不是移除指定index
            - temp.add(head.val);
        - if (!temp.isEmpty())
            - count++;
            - temp.clear();//⚠️此处注意：将用于统计的集合重新清空

- [x] 141 环状链表</br>
    - 解题思路：快慢指针
        - 快慢来比赛，套圈即是环
        - 经典步骤:
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) 
                    return true;
            }       
         
                