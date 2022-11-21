public class demo1 {
    /**
     * 在链表中删除指定值的节点
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
    public static Node removeValue(Node head, int num) {
        //如果第一个值就与num一样，那头节点就往后移动。直到头节点指向的第一个的值不是num
        while(head.value == num) {
            head = head.next;
        }
        //两个指针，pre：慢 cur：快 cur走过的地方不是num，那pre就跟上cur，
        // 如果cur指向的地方是num，那pre.next = cur.next;
        Node pre = head;
        Node cur = head;
        while(cur != null) {
            if(cur.value == num) {
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
