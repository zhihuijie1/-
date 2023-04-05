package Novice_class;

import java.util.Comparator;
import java.util.PriorityQueue;

//  合并 K 个升序链表
public class MergeKSortedLists {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            // 节点值小的放在前面
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        // 所有链表的头节点入堆
        for (int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        if(heap.isEmpty()) {
            return null;
        }

        ListNode head = heap.poll();
        ListNode cur = head;
        while(!heap.isEmpty()) {
            if(cur.next != null) {
                heap.add(cur.next);
            }
            ListNode node = heap.poll();
            cur.next = node;
            cur = node;
        }
        return head;
    }
}
