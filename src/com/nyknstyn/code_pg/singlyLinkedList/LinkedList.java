package com.nyknstyn.code_pg.singlyLinkedList;

import java.util.function.Consumer;

/**
 * Created by NG™
 * Date: 05/04/20
 */

public class LinkedList<T> {

    Node<T> head;

    static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void append(T data){
        Node<T> newNode = new Node<T>(data);
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


    public void insertAfter(T data){
        Node<T> newNode = new Node<T>(data);

    }

    public void printList(){
        Node pointer = this.head;
        while (pointer !=null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }

    public void deleteNode(T key){
        // node1--->node2-->node3-->node4
        Node<T> pointer =  this.head;
        if(pointer==null){
            return;
        }
        if(pointer.data == key){
            this.head = pointer.next;
            return;
        }
        while (pointer.next!=null){
            if(pointer.next.data == key) {
                pointer.next = pointer.next.next;
                break;
            }
            pointer = pointer.next;
        }
    }

    public void deleteNodeAtPosition(int position){
        Node pointer = this.head;
        int positionCounter = 0;
        if(positionCounter==position){
            this.head = pointer.next;
            return;
        }
        positionCounter+=1;
        while(pointer.next!=null){
            if(positionCounter==position){
                pointer.next = pointer.next.next;
                break;
            }
            pointer = pointer.next;
            positionCounter+=1;
        }
    }

    public void actionOnTraverse(Consumer<T> function){
        Node<T> pointer = this.head;
        while (pointer!=null){
            function.accept(pointer.data);
            pointer = pointer.next;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.head = new Node<String>("ab");
        list.head.next = new Node<String>("abc");
        list.head.next.next = new Node<String>("abcd");
        list.actionOnTraverse(System.out::println);
        list.push("a");
        list.actionOnTraverse(System.out::println);
        list.deleteNodeAtPosition(3);
        list.actionOnTraverse(System.out::println);
    }
}
