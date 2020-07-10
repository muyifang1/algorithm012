package leetcode.mergetwosortedlists;

/**
 * recursion
 *
 * @author YangQi
 */
public class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
        }

        return list1.val < list2.val ? list1 : list2;
    }

    public void printList(ListNode root) {
        System.out.println("for list nodes = " + root.val);
        if (root.next == null) {
            return;
        }
        printList(root.next);
    }
}
