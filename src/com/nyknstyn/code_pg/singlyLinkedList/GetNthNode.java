package com.nyknstyn.code_pg.singlyLinkedList;

/**
 * Created by NG™
 * Date: 08/04/20
 */

public class GetNthNode {

    public <T> T getNthNode(LinkedList<T> linkedList, int position){
        if(linkedList==null || linkedList.head == null){
            return null;
        }
        LinkedList.Node<T> pointer = linkedList.head;
        int currentPosition = 0;
        while(pointer!=null){
            if(currentPosition == position){
                return pointer.getData();
            }
            currentPosition++;
            pointer = pointer.getNext();
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        GetNthNode getNthNode = new GetNthNode();
        Integer value = getNthNode.getNthNode(linkedList, 2);
        System.out.println(value);

        LinkedList<Integer> linkedList1 = new LinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.insertAfter(2,4);
        linkedList.actionOnTraverse(System.out::println);
    }
}
