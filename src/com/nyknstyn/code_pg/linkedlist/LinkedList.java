package com.nyknstyn.code_pg.linkedlist;

/**
 * Created by NG™
 * Date: 05/04/20
 */

public class LinkedList {

    Node head;

    static class Node {
        private int data;
        private Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void append(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
            return;
        }
        Node pointer = this.head;
        while(pointer.next!=null){
            pointer = pointer.next;
        }
        pointer.next = newNode;
    }


    public void insertAfter(int data){
        Node newNode = new Node(data);

    }

    public void printList(){
        Node pointer = this.head;
        while (pointer !=null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.printList();
        list.push(0);
        list.printList();
    }
}
