package com.nyknstyn.code_pg.singlyLinkedList;

/**
 * Created by NG™
 * Date: 10/04/20
 */

import com.nyknstyn.code_pg.singlyLinkedList.LinkedList.Node;
public class MiddleNode {


    public <T> T getMiddleNodeUsingNormalTraversal(LinkedList<T> linkedList){
        Node<T> pointer = linkedList.getHead();
        int length = 0;
        if(pointer==null){
            return null;
        }
        while(pointer!=null){
            pointer = pointer.getNext();
            length++;
        }
        int count = 0;
        pointer = linkedList.getHead();
        while(pointer!=null){
            if(count==length/2){
                break;
            }
            pointer = pointer.getNext();
            count++;
        }
        return pointer.getData();
    }

    public <T> T getMiddleNodeUsingTwoPointers(LinkedList<T> linkedList){
        Node<T> fastPointer = linkedList.getHead();
        Node<T> slowPointer = linkedList.getHead();

        if(slowPointer==null){
            return null;
        }

        while (fastPointer!=null && fastPointer.getNext()!=null) {
            slowPointer = slowPointer.getNext();
            fastPointer = fastPointer.getNext().getNext();
        }
        return slowPointer.getData();
    }


    public <T> T getMiddleNodeUsingMiddleNode(LinkedList<T> linkedList) {
        Node<T> pointer = linkedList.getHead();
        Node<T> middlePointer = linkedList.getHead();
        if(pointer == null){
            return null;
        }
        int count = 0;
        while(pointer.getNext()!=null){
            if(count%2==0){
                middlePointer = middlePointer.getNext();
            }
            count++;
            pointer = pointer.getNext();
        }
        return middlePointer.getData();
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(12);
        linkedList.append(10);
        linkedList.append(9);
        linkedList.append(23);
        linkedList.append(12);
//        linkedList.append(100);

        MiddleNode middleNode = new MiddleNode();
        System.out.println(middleNode.getMiddleNodeUsingMiddleNode(linkedList));
        System.out.println(middleNode.getMiddleNodeUsingTwoPointers(linkedList));
        System.out.println(middleNode.getMiddleNodeUsingNormalTraversal(linkedList));
    }
}
