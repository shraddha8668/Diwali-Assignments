package com.demo.circularlinkedlist;
import java.util.Scanner;

public class CircularLinkedList {
    Node head;

    // Inner Node class
    class Node {
        int data;
        Node next;

        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    // a) Insert new node at nth position
    public void insertAtPosition(int pos, int value) {
        Node newNode = new Node(value);

        // If list is empty
        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        // Insert at first position
        if (pos == 1) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            head = newNode;
            temp.next = head;
        } else {
            Node temp = head;
            for (int i = 1; i < pos - 1 && temp.next != head; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // b) Delete node according to data
    public void deleteByData(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head, prev = null;

        // If head node holds the value
        if (head.data == value) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }

            // If only one node
            if (head.next == head) {
                head = null;
                return;
            }

            head = head.next;
            last.next = head;
            return;
        }

        // Search for node to delete
        do {
            prev = temp;
            temp = temp.next;
            if (temp.data == value) {
                prev.next = temp.next;
                temp.next = null;
                return;
            }
        } while (temp != head);

        System.out.println("Node with value " + value + " not found.");
    }

    // c) Modify node (ask data from user)
    public void modifyNode() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter data of node to modify: ");
        int oldData = sc.nextInt();

        Node temp = head;
        boolean found = false;

        do {
            if (temp.data == oldData) {
                System.out.print("Enter new data: ");
                int newData = sc.nextInt();
                temp.data = newData;
                System.out.println("Node modified successfully.");
                found = true;
                break;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("Node with data " + oldData + " not found.");
    }

    // d) Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

}