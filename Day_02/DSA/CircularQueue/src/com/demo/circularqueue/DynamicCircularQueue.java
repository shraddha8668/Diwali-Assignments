package com.demo.circularqueue;

public class DynamicCircularQueue {

	    private int[] arr;
	    private int front, rear;
	    private int size;

	    public DynamicCircularQueue() {
	        this(5);
	    }

	   
	    public DynamicCircularQueue(int size) {
	        arr = new int[size];
	        front = -1;
	        rear = -1;
	        this.size = size;
	    }

	
	    public boolean isEmpty() {
	        return front == -1;
	    }

	  
	    public boolean isFull() {
	        return (front == (rear + 1) % size);
	    }

	    
	    private void resize() {
	        int newSize = size * 2;
	        int[] newArr = new int[newSize];
	        int i = 0;

	       
	        if (front <= rear) {
	            for (int j = front; j <= rear; j++) {
	                newArr[i++] = arr[j];
	            }
	        } else {
	            for (int j = front; j < size; j++) {
	                newArr[i++] = arr[j];
	            }
	            for (int j = 0; j <= rear; j++) {
	                newArr[i++] = arr[j];
	            }
	        }

	       
	        front = 0;
	        rear = i - 1;
	        size = newSize;
	        arr = newArr;
	        System.out.println("Queue resized to " + size);
	    }

	   
	    public void enqueue(int val) {
	        if (isFull()) {
	            resize();
	        }

	        // First insertion
	        if (front == -1) {
	            front = 0;
	        }

	        rear = (rear + 1) % size;
	        arr[rear] = val;
	        System.out.println("Enqueued: " + val);
	    }


	    public int dequeue() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty. Cannot dequeue.");
	            return -1;
	        }

	        int val = arr[front];

	       
	        if (front == rear) {
	            front = rear = -1;
	        } else {
	            front = (front + 1) % size;
	        }

	        System.out.println("Dequeued: " + val);
	        return val;
	    }

	  
	    public void display() {
	        if (isEmpty()) {
	            System.out.println("Queue is empty.");
	            return;
	        }

	        System.out.print("Queue elements: ");
	        int i = front;
	        while (true) {
	            System.out.print(arr[i] + " ");
	            if (i == rear) break;
	            i = (i + 1) % size;
	        }
	        System.out.println();
	    }

}
