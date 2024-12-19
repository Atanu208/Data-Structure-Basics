package linked_list.simple_linked_list;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(10);
        ListNode l2=new ListNode(20);
        ListNode l3=new ListNode(30);

        l1.next=l2;
        l2.next=l3;
        l3.next=null;

        traverseALinkedList(l1);
    }

    public static void traverseALinkedList(ListNode head)
    {
        ListNode temp=head;
        while (temp != null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }
    }

    public ListNode insertAtBeginning(ListNode head,int value)
    {
        ListNode newNode=new ListNode(40);
        newNode.next=head;
        head=newNode;
        return head;
    }
    public ListNode insertAtEnd(ListNode head,int value)
    {
        ListNode newNode=new ListNode(50);
        ListNode ptr=head;
        while (ptr.next !=null)
        {
            ptr=ptr.next;
        }
        ptr.next=newNode;
        return head;
    }
    public ListNode insertIntoMiddle(ListNode head,int value,int position)
    {
        ListNode newNode=new ListNode(value);
        ListNode ptr=head;
        for (int i = 0; i <position ; i++) {
            ptr=ptr.next;
        }
        newNode.next=ptr.next;
        ptr.next=newNode;
        return head;
    }
    public ListNode deleteFromBeginning(ListNode head)
    {
        head=head.next;
        return head;
    }
    public ListNode deleteFromEnd(ListNode head)
    {
        ListNode ptr=head;
        while (ptr.next.next !=null)
        {
            ptr=ptr.next;
        }
        ptr.next=null;
        return head;
    }
    public ListNode deleteFromMiddle(ListNode head,int position)
    {
        ListNode ptr=head;
        for (int i = 0; i <position-1 ; i++) {
            ptr=ptr.next;
        }
//        ptr.next=ptr.next.next;
        ListNode deleteNode=ptr.next;
        ListNode nextNode=deleteNode.next;

        ptr.next=nextNode;

        return head;

    }
}
