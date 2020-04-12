package com.nyknstyn.code_pg.singlyLinkedList;

import java.util.function.Consumer;

/**
 * Created by NG™
 * Date: 05/04/20
 */

public class LinkedList<T> {

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    private Node<T> head;

    static class Node<T> {
        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        private T data;

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        private Node<T> next;

        Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    //Add at Beginning
    public void push(T data){
        Node<T> newNode = new Node<T>(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void deleteList(){
        this.head = null;
    }

    //Add at End
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


    public void insertAfter(T refData, T data){
        Node<T> newNode = new Node<T>(data);
        Node<T> pointer = this.head;
        while(pointer!=null){
            if(pointer.getData()==refData){
                newNode.setNext(pointer.getNext());
                pointer.setNext(newNode);
            }
            pointer = pointer.getNext();
        }
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

    public boolean searchData(T data){
        if(this.head==null){
            return false;
        }
        Node pointer = this.head;
        while(pointer!=null){
            if(pointer.data == data){
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public boolean searchData(Node pointer, T data){
        if(pointer==null){
            return false;
        }
        if(pointer.data==data){
            return true;
        }
        return searchData(pointer.next, data);
    }

    public int countElements(){
        Node pointer = this.head;
        int length = 0;
        while (pointer!=null){
            length ++;
            pointer = pointer.next;
        }
        return length;

        //For recursive call
        //return recursiveLength(pointer);
    }

    private int recursiveLength(Node pointer){
        if(pointer==null){
            return 0;
        }
        return 1 + recursiveLength(pointer.next);
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

        //InsertAfter
        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList1.append(1);
        linkedList1.append(2);
        linkedList1.append(3);
        linkedList1.actionOnTraverse(System.out::println);
        linkedList1.insertAfter(3,4);
        linkedList1.actionOnTraverse(System.out::println);
    }
}
