package linked_list.circular_linked_list;

import java.security.PublicKey;

public class CircularSinglyLinkedList {
    static class Node
    {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next=null;
        }
    }

    Node head=null;
    public void insertAtMiddle(int data,int position)
    {
        Node newNode=new Node(data);
        Node temp=head;
        if(head==null)
        {
            head=newNode;
            newNode.next=head;
        }
        else {
            for (int i = 1; i < position && temp.next != head; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    public void insertAtBeginning(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
            newNode.next=head;
        }
        else{
            Node temp=head;
            while (temp.next !=head)
            {
                temp=temp.next;
            }
            temp.next=newNode;
            newNode.next=head;
            head=newNode;
        }
    }
    public void insertAtEnd(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head=newNode;
            newNode.next=head;
        }
        else {
            Node temp=head;
            while (temp.next !=head) temp=temp.next;
            temp.next=newNode;
            newNode.next=head;
        }
    }
    public void traverse()
    {
        if(head==null) System.out.println("List is empty");
        Node temp=head;
        do {
            System.out.println(temp.data);
            temp=temp.next;
        }
        while (temp !=head);
        {
            System.out.println();
        }
    }
    public void deleteAtBeginning()
    {
        if (head==null) System.out.println("List is empty");
        if(head.next==head)
        {
            head.next=null;
        }else{
            Node temp=head;
            while (temp.next !=head)
            {
                temp=temp.next;
            }
            temp.next=head.next;
            head=head.next;
        }
    }

    public void deleteAtMiddle(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        // Traverse to the node before the position
        for (int i = 1; i < position-1; i++) {
            temp = temp.next;
        }
        // `temp.next` is the node to delete
        Node toDelete = temp.next;
        // Update `temp.next` to skip the node to delete
        temp.next = temp.next.next;
        // Optional: Dereference the deleted node (not required in Java)
        toDelete.next = null;
    }
    public void deleteAtEnd()
    {
        if(head==null)
        {
            System.out.println("Empty");
            return;
        }
        if(head.next == head)
        {
            head=null;
            return;
        }
        Node temp=head;
        while (temp.next.next !=head)
        {
            temp=temp.next;
        }
        Node deleteNode=temp.next;
        temp.next=head;
        deleteNode.next=null;
    }
    public static void main(String[] args) {
        CircularSinglyLinkedList list=new CircularSinglyLinkedList();
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.traverse();
        System.out.println("/////////////////////////////");
        list.insertAtBeginning(10);
        list.traverse();
        System.out.println("/////////////////////////");
        list.deleteAtMiddle(3);
        list.traverse();
        list.deleteAtEnd();
        System.out.println("/////////////////////////");
        list.traverse();

    }
}
