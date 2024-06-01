package Homework2;//In my Main folder needed to package it into Homework 2

public class Problem3 {//This will be our sorted priority queue
    private int[] arrayTypeInt;//Using our Java array of type int
    private int sizeOfQueue;//int for the size of the queue

    public Problem3(int capacity) {//Constructor for our sorted priority queue
        arrayTypeInt = new int[capacity];
        sizeOfQueue = 0;
    }

    public void add(int value) {
        if (sizeOfQueue == arrayTypeInt.length) {//if the size of the queue is the same as the length we will thro our runtime exception
            throw new RuntimeException("Queue is full");
        }

        if (sizeOfQueue == 0 || value < arrayTypeInt[0]) {
            // If the queue is empty or the value is smaller than the first element,
            // insert it at the beginning of the array.
            System.arraycopy(arrayTypeInt, 0, arrayTypeInt, 1, sizeOfQueue);
            arrayTypeInt[0] = value;
        } 
        
        else {
            // Find the index where the value should be inserted
            int left = 0;
            int right = sizeOfQueue;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arrayTypeInt[mid] < value) {
                    left = mid + 1; // Move the left pointer to the right if the middle element is smaller than the value
                } else {
                    right = mid; // Move the right pointer to the middle if the middle element is greater than or equal to the value
                }
            }
            // Insert the value at the found index.
            System.arraycopy(arrayTypeInt, left, arrayTypeInt, left + 1, sizeOfQueue - left);
            arrayTypeInt[left] = value;
        }

        sizeOfQueue++;
    }

    public int remove() {
        if (sizeOfQueue == 0) {//If the queue is empty we will throw a runtime exception
            throw new RuntimeException("Queue is empty");
        }

        int value = arrayTypeInt[0];
        System.arraycopy(arrayTypeInt, 1, arrayTypeInt, 0, sizeOfQueue - 1);
        sizeOfQueue--;

        return value;
    }
    public static void main(String[] args) {
        Problem3 queue = new Problem3(4);

        queue.add(3);
        queue.add(1);
        queue.add(4);
        queue.add(2);

        System.out.println(queue.remove()); // prints 1
        System.out.println(queue.remove()); // prints 2

        queue.add(5);

        System.out.println(queue.remove()); // prints 3
        System.out.println(queue.remove()); // prints 4
        System.out.println(queue.remove()); // prints 5

        try {
            queue.remove(); // should throw a RuntimeException because queue is empty
        } catch (RuntimeException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        queue.add(7);
        queue.add(6);
        queue.add(8);
        queue.add(9);

        try {
            queue.add(10); // should throw a RuntimeException because the queue is full
        } catch (RuntimeException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }

        System.out.println(queue.remove()); // prints 6
        System.out.println(queue.remove()); // prints 7
        System.out.println(queue.remove()); // prints 8
        System.out.println(queue.remove()); // prints 9

        try {
            queue.remove(); // should throw a RuntimeException because queue is empty
        } catch (RuntimeException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}