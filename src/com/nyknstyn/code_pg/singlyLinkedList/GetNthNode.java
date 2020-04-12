package com.nyknstyn.code_pg.singlyLinkedList;

/**
 * Created by NG™
 * Date: 08/04/20
 */

import com.nyknstyn.code_pg.singlyLinkedList.LinkedList.Node;
public class GetNthNode {

    public <T> T getNthNode(LinkedList<T> linkedList, int position){
        if(linkedList==null || linkedList.getHead() == null){
            return null;
        }
        LinkedList.Node<T> pointer = linkedList.getHead();
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

    public <T> T getNthNodeRecurs(Node<T> pointer, int position, int currentPosition){
        if(pointer==null){
            return null;
        }
        if(position==currentPosition){
            return pointer.getData();
        }
        return getNthNodeRecurs(pointer.getNext(), position, ++currentPosition);
    }

    public <T> T getNthNodeRecursV2(Node<T> pointer, int position){

        int count = 1;

        if(pointer==null){
            return null;
        }
        if(position==count){
            return pointer.getData();
        }
        return getNthNodeRecursV2(pointer.getNext(), --position);
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);

        GetNthNode getNthNode = new GetNthNode();
        Integer value = getNthNode.getNthNodeRecurs(linkedList.getHead(), 2, 0);
        System.out.println(value);


    }
}
