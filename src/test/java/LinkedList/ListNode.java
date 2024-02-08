package LinkedList;

public class ListNode
{
    int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode arrayToList(int arr[])
    {
        ListNode root = new ListNode(arr[0]), current = root;
        for (int i = 1; i < arr.length; i++)
        {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return root;
    }

    public boolean compare(ListNode list)
    {
        ListNode current1 = this;
        ListNode current2 = list;

        while (current1 != null && current2 != null)
        {
            if (current1.val != current2.val)
                return false;

            current1 = current1.next;
            current2 = current2.next;
        }

        return current1 == null && current2 == null;
    }
}