package com.demo.test;

import java.util.Scanner;

import com.demo.circularlinkedlist.CircularLinkedList;

public class Test {

	  
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Circular Linked List Menu ---");
            System.out.println("1. Insert at position");
            System.out.println("2. Delete by data");
            System.out.println("3. Modify node");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter position: ");
                    int pos = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    list.insertAtPosition(pos, val);
                    break;
                case 2:
                    System.out.print("Enter data to delete: ");
                    int delVal = sc.nextInt();
                    list.deleteByData(delVal);
                    break;
                case 3:
                    list.modifyNode();
                    break;
                case 4:
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}


