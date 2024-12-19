package linked_list.double_linked_list;

public class DoubleListNode {
    int value;
    DoubleListNode prev;
    DoubleListNode next;

    public DoubleListNode(int value)
    {
        this.value=value;
        prev=null;
        next=null;
    }

    public static void main(String[] args) {
        DoubleListNode l1=new DoubleListNode(10);
        DoubleListNode l2=new DoubleListNode(20);
        DoubleListNode l3=new DoubleListNode(30);

        l1.next=l2;
        l2.prev=l1;
        l2.next=l3;
        l3.prev=l2;
        insertFromTheEnd(l1,40);
        traverseFromTheBeginning(l3);
        deleteFromTheMiddle(l1,3);
        traverseFromTheBeginning(l1);

    }
    public static void traverseFromTheBeginning(DoubleListNode node)
    {
        while (node.prev !=null)
        {
            node=node.prev;
        }
        while (node !=null)
        {
            System.out.println(node.value);
            node=node.next;
        }
    }

    public static void traverseFromEnd(DoubleListNode node)
    {
        while (node.next !=null) node=node.next;
        while (node!=null)
        {
            System.out.println(node.value);
            node=node.prev;
        }
    }

   public static void insertFromTheBeginning(DoubleListNode node,int value)
    {
        while (node.prev !=null)
        {
            node=node.prev;
        }
        DoubleListNode temp=new DoubleListNode(value);
        temp.next=node;
        node.prev=temp;
    }

    public static void insertFromTheEnd(DoubleListNode node,int value)
    {
        while (node.next !=null) node=node.next;
        DoubleListNode temp=new DoubleListNode(value);
        temp.prev=node;
        node.next=temp;
    }
    public static void insertAtAnyPosition(DoubleListNode node,int value,int position)
    {
        while (node.prev !=null) node=node.prev;
        DoubleListNode temp=new DoubleListNode(value);
        for (int i = 0; 1 <position ; i++) {
            node=node.next;
        }
        temp.prev=node;
        temp.next=node.next;
        node.next.prev=temp;
        node.next=temp;
    }
    public static void deleteFromTheBeginning(DoubleListNode node)
    {
        while (node.prev !=null) node=node.prev;
        DoubleListNode temp=node.next;
        temp.next=null;
        temp.prev=null;
    }

    public static void deleteFromTheEnd(DoubleListNode node)
    {
        while (node.next !=null) node=node.next;
        DoubleListNode temp=node.prev;
        node.prev=null;
        temp.next=null;
    }
    public static void deleteFromTheMiddle(DoubleListNode node,int position)
    {
        while (node.prev !=null) node=node.prev;
        for (int i = 1; i < position ; i++) {
            node=node.next;
        }
        node.next.prev=node.prev;
        node.prev.next=node.next;
        node.prev=null;
        node.next=null;
    }
}
