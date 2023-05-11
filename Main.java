class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode newHead = removeNNodes(head, 2);

        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static ListNode removeNNodes(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode current = head;
        for (int i = 0; i < n; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        ListNode newHead = current;
        ListNode previous = null;
        while (current != null) {
            previous = current;
            current = current.next;
        }
        previous.next = removeNNodes(newHead.next, n);
        return newHead;
    }
}
