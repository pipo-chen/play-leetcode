# play-leetcode

## 二叉树
- [x] 102. 二叉树的层序遍历 <br/>
    解题思路：层序遍历，递归

## 栈和队列
- [x] 150. 逆波兰表达式求值 <br/>
    解题思路：栈，遇到符号出栈处理，处理完毕入栈。

- [x] 面试题 03.04. 化栈为队<br/>
    解题思路：用两个栈 装过来倒过去，实现队列的先进先出

- [x] 1441. 用栈操作构建数组<br/>
    解题思路：顺序输出 1-n 或者 1-数组最大元素。如果数组中有该顺序 则直接"Push"否则的话就"Push"再"Pop"。
    🏁重点是题目意思。

## 链表模块
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
         
- [x] 剑指offer 22 链表中倒数第 K 个节点</br>
    - 解题思路：要想知道链表中倒数第几个节点，必须知道链表的长度；知道链表的长度，自然就知道倒数第 k 个节点，就是正数第 len-k+1 个节点。
        - 通过遍历找到正数第 len-k 节点的 next 指针即可。
        - 考虑点：
            - 当 k 超出长度的时候，返回的还是当前全链表
            - 当链表为 null 的时候，直接返回

- [x] 1019 链表中的下一个更大节点</br>
    - 解题思路：一道很有意思的题目
        - 1. 将链表转入数组或者 list 这样可以保证用下标就可以查询的到
        - 2. 创建一个空的单调栈
        - 3. 循环数组
            - 如果碰到当前数据小于或者等于栈顶元素的，则直接入栈（当前数组元素下标）。
            - 如果碰到当前数据大于当前栈顶元素的，则出栈（直到小于栈顶元素）,所出栈的下标对应元素统一赋值为当前数组元素。
        - 4. 数组遍历结束完成，检查当前栈中遗留的元素，遗留的元素统一置 0;
       
- [x] 剑指offer 06 从尾到头打印链表</br>
    - 解题思路：
        1. 遍历链表计算数组应该创建的长度。
        2. 遍历链表：链表元素从头往后输出，数组元素从 length - 1 下标开始添加                     
        
- [x] 面试题 02.02. 返回倒数第 k 个节点</br>
    - 解题思路：
        统计总长度，倒数第 k 节点 就是正数 len - k + 1位置的元素

- [x] 面试题 02.04. 分割链表</br>
    - 解题思路：
        遍历 head 链表，创建左右两个链表。
        - 1. 比较 head 当前的元素 与 x 的大小关系
            - 小于 x 则插入到左边链表，左链表为正着插入。
            - 大于 x 则插入到右边链表，右链表为倒着插入。
        - 2. 遍历完成之后，将 左链表.next 指向右链表

- [x] 21. 合并两个有序链表</br>
    - 初步解题思路：
        -遍历 l1 和 l2 假设 不为空情况下：
            - 如果最小值在 l1 这边，则移动 l1 = l1.next
            - 如果最小值在 l2 这边，则移动 l2 = l2.next
        - 如果 l1 为空 但 l2 仍然有值的情况下，为了一直只移动 l2 必须将 l1 的值设定为 大于 l2
            即：int v1 = l1 == null ? l2.val + 1 : l1.val;
            l2 同理。

- [x] 86. 分割链表</br>
    - 解题思路：
        创建左右两个链表，左边->->->添加小于 x 的元素
        右边<-<-<-添加大于等于 x 的元素
        最后 left.next = 右边链表的头部
        ⚠️倒着创建链表或者正着创建链表，决定了分割是否能够保持原有链表的顺序

- [x] 面试题 02.01. 移除重复节点 <br/>
    - ❌：用 set 然后重创一个 链表 进行数据导入。无序，所以错误。
    - 调整：【效率低】用了 arraylist 顺序保住了，但是效率较低。1. 循环遍历链表，未曾出现的元素加入list 2. 循环 list 添加入链表
    
- [x] 面试题 02.06. 回文链表 <br/>
    - 解题思路：1. 遍历，创建一个反转链表 2.遍历比较是否和反转的链表一一对应。

- [x] 328. 奇偶链表 <br/>
    - 解题思路：
        1.遍历 head 为 偶编号的节点 单独抽离形成 evenList 偶链表
        2. odd.next = evenHead.next;
        

- [x] 160 回文链表 <br/>
    - 解题思路：用栈 前半段 pop 后半段 push 待优化。
        
## 数组模块
- [x] 26. 删除排序数组中的重复项 简单</br>
    - 解题思路：快慢指针，快指针寻找到每组不相同的元素为止，慢指针用来替换成快指针停留下来的元素内容

- [x] 面试题 16.20. T9 键盘</br>
    - 解题思路：
        - 1. 把 words 放入 list 中 便于删除
        - 2. 遍历 num 每个取值，内部遍历 words 中每个字符串对应 num 位置的字母。
        - 排除：num 和 words 中字符串长度不一的，可直接删除。
        
- [x] 48. 旋转图像 </br>
    - 解题思路：
        - 1. 上下对称
        - 2. 右对角线对称
    - 核心代码：
        1. matrix[row][col] <-> matrix[total_row - row - 1][col] (条件是：row < 1/2 total_row && col < total_col)
        2. matrix[row][col] <-> matrix[col][row] (条件是：row < total_row & col < row)

- [x] 162. 寻找峰值 </br>
    - 解题思路：
        - 1. 数组长度小于 2 个 直接范围峰值下标 0；
        - 2. 数组长度大于 2 的时候，查询中间的峰值
        - 3. 比较最后一位与最后第二位的大小，如果最后一位更大则进行下标返回，否则意味着没有峰值
 

- [x] 剑指 Offer 53 - II. 0～n-1中缺失的数字</br>
    - 简单：比较从 0 开始每位数字是否同下标一致，不一致则返回下标
    - 注意点：[0] -> 1 [0,1] -> 2 如果数组正常不存在缺失，则返回后一位元素


- [x] 209 长度最小的子数组</br>
    - 解题思路：双指针，因为是连续子数组，如果 sum > s 则 start 指针往后移 如果 sum < s 则 end 指针向后增加元素。
    - 每组达到条件的长度都进行记录，取最小值。
    - ⚠️ start 进入循环的条件 如果定义成 < end 则无法取同一个点，例如[1,4,4]
    - ⚠️ 通过内循环找到合适的 start 位置 
    

- [x] 1051. 高度检查器</br>
    - 原始解题思路（效率较低）：1. 复制排序之前的数组 2. 数组排序 3. 遍历比较排序前和排序后数组对应位置元素是否产生变化.
    - 优化：实际上就是采取的排序算法不同，使用桶排序. 
        - ⚠️ 1. 不能使用 result[height] = 1;进行计数，而应该使用 result[height]++;
        - ⚠️ 2. 循环桶数组，判断内部进行 heights 数组循环的条件 为（ result[i] != 0 ）
            - while (result[i] != 0) {
                if ( i != heights[j])
                    count++;     
                result[i]--;           
              }
              j++;//不管是否 i 与 heights[j] 相等，只要 i 位置上有值，j 都应该进行相加    
              
- [x] 88. 合并两个有序数组 </br>
    - 解题思路：三个指针：p1 指向数组数据尾部 nums1 p2 指向数组 nums2 尾部，tail 指向合并长度的尾部。
    - 从大到小进行比较，从后往前进行数组填入。如果从前往后从小往大，必然涉及数组元素统一后移，所以不可行
    - ⚠️循环条件不能为 p1 >= 0 原因：nums1:[0],nums2[1],m=0,n=1 的情况。
     
- [x] 283. 移动零 </br>
    - 初始方法（效率低）：双指针，指针 i 指向每组为 0 下标的地方，指针 j 指向非 0 数字的下标，在 j 不是最后一位元素的时候，进行 o - x 数字交换。
    - 解题思路：
        - 1. 所有非零元素不停的往前移动。
        - 2. 非零以外都置零
        
- [x] 27. 移除元素 <br/>
    - 解题思路：
        - 1. 所有非 val 元素不停的往前移动
        - 2. 返回移动完之后返回最后一个非 val 下标即 count
        
- [x] 80. 删除排序数组中的重复项 II<br/>
    - 解题思路3：
        - 1.三个变量 i 控制数组循环 j 慢指针用于数据覆盖位 count 统计相同数字数量是否超过 2个
        - 核心代码：
            - 1. int i = 1; i < nums.length; i++
            - 2. if (nums[i] == nums[i - 1]) count++; else count = 0;
            - 3. if (count < 2) nums[j] = nums[i]; j++;

- [x] 面试题 10.01. 合并排序的数组<br/>
    - 解题思路：
        1. 三个指针，i 指向数组 A 有元素的最后一位； j 指向数组 A 最后一位； k 指向数组 B 最后一位；
        2. 分别比较当前 i 指向的元素与 k 指向元素的大小，大的存入 j 位置。哪边大，哪边可以往前移
        ⚠️A[0] m = 0 B[2] n = 1，情况，初识位置 i = -1 则应该进行的默认赋值。

- [x] 剑指 Offer 53 - I. 在排序数组中查找数字 I <br/>
    - ❌桶排序进行统计，但是无法预估数据范围，不可行。
    - 原始解题：一一对比，效率较低。
    - 解法二：双指针，最后算两个指针直接的距离。但是要考虑的点：
        - 1. 当数组长度为 1 的时候，遍历起来 有匹配和没有匹配，都会产生 left == right. 所以需要提前排除
        - 2. 当数组为空的时候
        - 3. 常规：right < left return 0; right >= left return right - left + 1;
        
- [x] 53. 最大子序和 <br/>
    - 解题思路：动态规划。
        sum += nums[i];
        如果 nums[i] > sum 那么 sum = nums[i]
        不停的判断当前的 sum 是否 > maxSum 如果大于的话则 maxSum = sum;
        
- [x] 1. 两数之和 <br/>
    - 解题思路：哈希表。下标为value 元素为 key
        - 核心代码：map.containsKey(target-x)
        - 匹配到了的时候，还需要判断 匹配到的元素，与当前元素不是同一个下标 例如⚠️ 为了排除元素重复情况：[3,3,2]
            - if (i != map.get(target-x)) 
            -   return new int[] {i, map.get(target-x)} 
        - 注意案例：[3,2,4] ❌ [0,0] -> [1,2]

- [x] 15. 三数之和 <br/>
    - 解题思路：1. 排序 2. a + b + c = 0; 
        - 从 a 开始枚举，遇到上一个同一元素的枚举则跳过。
            - b 从 a + 1 位置开始枚举。同样遇到上一个同一元素的枚举则跳过。
                - c 指针从尾部开始与 b 相加判断 c 是否继续往前移动
                    - 如果 b 与 c 指向位置相同，则本轮无 a + b + c = 0; 
                    - 如果位置不同，则判断 b 与 c 元素相加是否为 -a，如是，则加入 list
    
    - 核心：排序，枚举内嵌从下一个开始

- [x] 34.在排序数组中查找元素的第一个和最后一个位置 <br/>
    - 解题思路：
        - 1. 控制循环的条件就是 begin <= tail (注意等于，[1] target = 1 情况，begin 跟 tail 指针一开始就相同位置)
        - 2. begin 指针不停的右移动，直到 >= target， tail 指针不停的向左移动，直到 <= target
        - 3. 指针停下来的时候判断，
            begin/tail 位置上当前的元素如果不等于 target 说明无法查询到target，反之，就返回 begin 跟 tail 的位置即可。
        
- [x] 75. 颜色分类 <br/>
    - 解题思路：排序数组数字较小，桶排序。

- [x] 215. 数组中的第K个最大元素<br/>
    -解题思路：使用快速排序实现。待优化
    
- [x] 167. 两数之和 II - 输入有序数组<br/>
    - 解题思路：两个指针一个从 0 开始，一个从数组末尾开始。因为是求 target ，而且数组为排序好的。
        - 当 numbers[i] + numbers[j] > target 则 j 往左移 减和
        - 当 numbers[i] + numbers[j] < target 则 i 往右移 增和
        - 相等 返回下标

- [x] 125. 验证回文串<br/>
    - 解题思路：双指针 注意题目要求字母和数字

- [x] 345. 反转字符串中的元音字母<br/>
    - 解题思路：双指针。注意元音字母大小写 以及交换之前判断 i 是否小于 j

- [x] 11. 盛最多水的容器 <br/>
    - 解题思路：双指针。
    - 每次两边指针指向的数值，求面积，并更新最大面积的值。 下一步：短边移动。

- [x] 面试题 01.07. 旋转矩阵 <br/>
    - 解题思路：先左右对称，后对角线对称，形成旋转效果。
        ⚠️：对角线对称，i 与 j 的交换关系

- [x] 面试题 01.08. 零矩阵 <br/>
    - 原始思路：因为无法一边变更 matrix 数组，一边进行行列统计。
        - 1. 循环遍历，统计应该置为 0 的行、列 放入 list 里面
        - 2. 循环遍历，如果该 行 包含在 zero_list_i 行里面，则整行置 0；同理该 列 包含在 zero_list_j 里面则整列置 0。
    - 优化思路：行跟列 分开清理，不需要全部遍历，效率会更高。 

- [x] 73. 矩阵置零 <br/>
    - 原始思路：1. 完全遍历 matrix 统计行、列为零的地方 2. 完全遍历 matrix 判断在行、列为零数组中的元素置 0；
    - 优化思路：
        1. 采用哪种方式统计（运行效率一致）
        2. 分别将 行、列单独循环置零。 
            行，直接遍历 matrix 总行数；
            列，选择在 zero_j 数组中的元素进行遍历，内部再遍历 matrix[i][j] -> 实现每行的 j 列元素置零。

- [x] 49. 字母异位词分组<br/>
    - 解题思路：
        0. 创建 map<String, List> 
        1. 遍历字符串数组,将字符串进行排序生成 key
        2. 判断 
            如果 key 在 map 里面，则获取 map 中 list 将该字符串进行添加
            如果 key 不在 map 里面，则创建 List 以 字符串排序后 为 key 将原始字符串添加进 list
        3. 遍历 map 将全部 list 加入 groupList 里面。
        核心思路：排序后的状态为 key，所有拥有相同 key 的元素，加入 list。
    - 优化：不需要通过遍历 map 获取 value 添加进入 groupList -> new ArrayList<>(map.values())

- [x] 3.无重复字符的最长子串 <br/>
    - 解题思路：滑动窗口。
    注意⚠️
        1. start 只能是递增状态 
        2. 每发现一个旧的字符存在在map里面 但是不需要调整start位置。记得更新当前最新位置。
    
- [x] 1550. 存在连续三个奇数的数组 <br/>
    - 解题思路：统计连续
    
- [x] 9.回文数 <br/>
    - 解题思路 1：转换成数组 双指针。
    
- [x] 16. 最接近的三数之和 <br/>
    - 解题思路：与三数之和不同的是，寻找最接近差值。
       - 1. 排序
       - 2. 固定 i 为，初始化首个 ans = nums[0] + nums[1] + nums[2];
       - 3. 从 i + 1 位置到末尾，设置双指针，start / end 
       - 4. 比较 i + s + e 的和 与 target 的差值 是否小于当前 ans 与 target 的差值，若小于，则更新 ans
       - 5. s 与 e 的移动规律与当前 sum 与 target 大小有关，若小于当前target 则 s++ 反之 e--

- [x] 713. 乘积小于K的子数组 <br/>
    - 解题思路：O(n) 
        滑动窗口

- [x] 20. 有效的括号<br/>
    - 解题思路：【栈】
        1. 长度非偶数。直接 false
        2. 利用栈，如果右括号遇到 stack顶部为相同左括号的。则出栈，反之，入栈。
        3. 遍历完成，栈为空则 true 栈有剩余，则 false

- [x] 面试题 16.06 最小差 <br/>
    - 解题思路：【双指针】 待优化
    
- [x] 202. 快乐数 <br/>
    

## 字符串模块
- [x] 344. 反转字符串 <br/>
    - 解题思路：双指针交换
    
- [x] 面试题 01.01. 判定字符是否唯一 <br/>
    - 解题思路：1. 排序 2. 比较
        - 核心代码：（字符串转字符数组并排序）
        char[] str = astr.toCharArray();
        Arrays.sort(str);
        
- [x] 面试题 01.02. 判定是否互为字符重排 <br/>
    - 解题思路：1.比较长度是否一致 2. 排序 3. 比较

- [x] 面试题 01.03. URL化 <br/>
    - 解题思路： 重新组装出一个字符串。如果是字符数组的话 "%20" 需要不停的拓展空间

- [x] 面试题 01.06. 字符串压缩 <br/>
    - 原始思路：统计相同的字符 相加。
    - （待优化）可优化的解题思路：双指针取连续字符

- [x] 面试题 01.09. 字符串轮转 <br/>
    - 解题思路：自己加自己。
    
- [x] 面试题 01.04. 回文排列 <br/>
    - 解题思路：类似字符串压缩，统计每个字符出现的次数。
        题目的本质：字符串中字符奇数个数只能 <= 1 个为回文。（⚠️：与字符串本身长度无关）

- [x] 557. 反转字符串中的单词 III<br/>
    - 解题思路：
       1. begin 和 end 指针分别指向遍历到单词的头和尾；
       2. 双指针进行单词交换实现反转；
       3. 进入下一个单词的遍历
  
- [x] 1003. 检查替换后的词是否有效 <br/>
    - 解题思路：（消消乐）循环如果 string 中存在 "abc" 将 abc 替换成空格 直到没有包含"abc"
        - 判断是否被消除完毕即可。
        
    