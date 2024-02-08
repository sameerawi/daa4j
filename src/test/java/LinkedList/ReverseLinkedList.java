package LinkedList;

import org.junit.Test;

// leetcode 206 - Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.

public class ReverseLinkedList
{
    public ListNode reverseList(ListNode head)
    {
        ListNode prev = null, current = head;
        while (current != null)
        {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;

            current = temp;
        }

        return prev;
    }

    @Test
    public void test()
    {
        assert ( reverseList(ListNode.arrayToList(new int[] {1,2,3,4,5})).compare(ListNode.arrayToList(new int[] {5,4,3,2,1})));
        assert ( reverseList(ListNode.arrayToList(new int[] {1,2})).compare(ListNode.arrayToList(new int[] {2,1})));
    }
}
