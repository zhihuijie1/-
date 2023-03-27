package Novice_class;
/*
* 两个链表相加
* 给定两个链表的头节点head1和head2，
认为从左到右是某个数字从低位到高位，返回相加之后的链表
例子     4 -> 3 -> 6        2 -> 5 -> 3
返回     6 -> 8 -> 9
解释     634 + 352 = 986
* */
public class AddTwoNumbers {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
    * 思路：1：找到长链表L，短链表S
    * 2：划分成3个阶段，阶段1：长链表L，短链表S都有，阶段2：长链表L有，短链表S无，阶段3：长链表L无，短链表S无
    * 3：注意进位，不额外开辟空间，直接将相加的结果放到长链表L上。
    * */
    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        // 标注长短链表
        ListNode L = listLength(head1) > listLength(head2)  ? head1 : head2;
        ListNode S = L == head1 ? head2 : head1;
        // 标注当前链表的指向节点
        ListNode curL = L;
        ListNode curS = S;
        // 进位
        int carry = 0;
        // 当前长节点要填的数
        int curNuber = 0;
        // 一直记录着长链表的尾节点，用于连接第三阶段的节点
        ListNode last = L;
        // 第一阶段：长链表L，短链表S都有
        while(curS != null) {
            int curNum = curL.val + curS.val + carry;
            carry = curNum / 10;
            curNuber = curNum % 10;
            curL.val = curNuber;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        // 第二阶段：长链表L有，短链表S无
        while(curL != null) {
            int curNum = curL.val + carry;
            carry = curNum / 10;
            curNuber = curNum % 10;
            curL.val = curNuber;
            last = curL;
            curL = curL.next;
        }
        // 第三阶段
        if(carry == 1) {
            ListNode node = new ListNode(1);
            last.next = node;
        }
        return L;
    }


    // 计算链表的长度
    public static int listLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
