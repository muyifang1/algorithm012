package leetcode.mergetwosortedlists;

/**
 * LeetCode #21
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author YangQi
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 一个初始节点dummy
        ListNode dummy = new ListNode(-1);
        // 一个用于头指针
        ListNode head = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                head.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            head = head.next;
        }

        if (list1 == null) {
            head.next = list2;
        }
        if (list2 == null) {
            head.next = list1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        root1.next = new ListNode(3);
        root1.next.next = new ListNode(5);
        root1.next.next.next = new ListNode(9);
        root1.next.next.next.next = new ListNode(10);

        ListNode root2 = new ListNode(2);
        root2.next = new ListNode(4);
        root2.next.next = new ListNode(6);
        root2.next.next.next = new ListNode(7);

        Solution2 solution = new Solution2();
        solution.printList(root1);
        solution.printList(root2);
        System.out.println("=======================");
        solution.printList(solution.mergeTwoLists(root1, root2));
    }

    public void printList(ListNode root) {
        System.out.println("for list nodes = " + root.val);
        if (root.next == null) {
            return;
        }
        printList(root.next);
    }
}
