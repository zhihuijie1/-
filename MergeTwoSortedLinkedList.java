package Novice_class;
/*
* 两个有序链表的合并
* 给定两个有序链表的头节点head1和head2，
返回合并之后的大链表，要求依然有序
例子     1 -> 3 -> 3 -> 5 -> 7          2 -> 2 -> 3 -> 3-> 7
返回     1 -> 2 -> 2 -> 3 -> 3 -> 3 -> 3 -> 5 -> 7
* */
public class MergeTwoSortedLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // 最后要返回的头节点
        ListNode head = null;
        // 穿针引线的节点
        ListNode cur = new ListNode();
        head = cur;

        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                cur.next = head1;
                cur = head1;
                head1 = head1.next;
            }else {
                cur.next = head2;
                cur = head2;
                head2 = head2.next;
            }
        }

        while(head1 != null) {
            cur.next = head1;
            cur = cur.next;
            head1 = head1.next;
        }

        while(head2 != null) {
            cur.next = head2;
            cur = cur.next;
            head2 = head2.next;
        }

        return head.next;
    }
}
