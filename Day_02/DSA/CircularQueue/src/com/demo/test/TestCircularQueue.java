package com.demo.test;

import com.demo.circularqueue.DynamicCircularQueue;

public class TestCircularQueue {

    public static void main(String[] args) {
        DynamicCircularQueue q = new DynamicCircularQueue(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();

        q.enqueue(40); 
        q.display();

        q.dequeue();
        q.dequeue();
        q.display();

        q.enqueue(50);
        q.enqueue(60);
        q.display();
    }
}

