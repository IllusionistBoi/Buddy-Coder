package com.rd;
public class PQLinkedList {
    // Node
    static class Node {
        Double data;
        Double priority;
        Node next;

    }

    public static Node head = null;

    private Node newNode(Double d, Double p) {
        Node temp = new Node();
        temp.data = d;
        temp.priority = p;
        temp.next = null;
        return temp;
    }

    public void insert(double data, double priority) {
        Node newNode = newNode(data, priority);
        if (head == null) {
            head = newNode;
        } else {
            push(data, priority);
        }
    }

    // Removes the element with the
    // highest priority form the list
    public Double getMin() {
        Node temp = head;
        head = head.next;
        return temp.data;
    }

    private void push(Double d, Double p) {
        Node start = head;
        Node temp = newNode(d, p);
        if (head.priority > p) {
            temp.next = head;
            head = temp;
        } else {
            while (start.next != null && start.next.priority < p) {
                start = start.next;
            }
            temp.next = start.next;
            start.next = temp;
        }
    }

    // Function to check is list is empty
    public Boolean isEmpty() {
        return head == null;
    }
}