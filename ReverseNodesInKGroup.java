package Novice_class;
// K 个一组翻转链表

public class ReverseNodesInKGroup {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = getKGroupEnd(start , k);
        if(end == null) {
            return head;
        }
        // 说明有第一段
        head = end;
        reverse(start, end);
        while(start.next != null) {
            ListNode lastEnd = start;
            start = lastEnd.next;
            end = getKGroupEnd(start,k);
            if(end == null) {
                return head;
            }
            // 说明有第二段
            reverse(start, end);
            lastEnd.next = end;
        }
        return head;
    }

    // 得到一段区域的末尾节点
    public static ListNode getKGroupEnd(ListNode start, int k) {
        for (int i = 1; start != null && i < k; i++) {
            start = start.next;
        }
        return start;
    }

    // 把这一段进行反转
    public static void reverse(ListNode start, ListNode end) {
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while(pre != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = cur;
    }
}
