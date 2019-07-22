package com.tianzehua.datastructures.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * 环形单链表应用---约瑟夫环问题
 *
 */
public class Josepfu {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(5);
        List<Integer> out = list.out(1, 2, 5);
        for (Integer integer : out) {
            System.out.println(integer);
        }
    }
}

/**
 * 构建单向环形链表节点
 */
class Node1{
    /* 编号 */
    public int no;
    /* next对象 */

    public Node1 next;

    public Node1(int no) {
        this.no = no;
    }
}

/**
 * 构建单向循环链表
 */
class LinkedList{

    /**
     * 新建一个first节点
     */
    private Node1 first;

    public LinkedList() {
        /* 初始化一个单向环形链表,标识first节点 当前没有编号 */
        first  = new Node1(0);
    }

    /**
     * 添加节点
     * @param nums
     */
    public  void  add(int nums){
       /* 创建一个辅助节点，代表指针 */
        Node1 temp = first;
        /* 代表着是第一个节点 */
        for (int i = 1;i<= nums; i++){
            Node1 node = new Node1(i);
            if (i == 1){
                first = node;
                first.next = first;
                temp = first;
            }else {
                temp.next = node;
                node.next = first;
                temp = node;
            }
        }
        }

    /**
     *
     * @param startNo 从哪个位置开始
     * @param countNo 数几位
     * @param num 一共有多少个节点
     */
    public List<Integer> out(int startNo,int countNo,int num){
        if (first == null || startNo < 1 || startNo > num){
            return null;
        }
        Node1 helper = first;
        /* 将辅助节点指向了first节点的前一个节点 */
        while (true){
            if (helper.next == first){
                break;
            }
            helper = helper.next;
        }
        /* 从第几个开始，将first和helper移动几个 */
        for (int i = 0; i < startNo -1; i++){
            first = first.next;
            helper = helper.next;
        }
        List<Integer> list = new ArrayList<>();
        /* 接下来开始数，不断的出圈 ，直到剩下一个元素为止，也就是helper == first  */
        while (true){
            if (helper == first){
                list.add(helper.no);
                break;
            }
            for (int i = 0; i < countNo -1; i++){
                first = first.next;
                helper = helper.next;
            }
            list.add(first.no);
            first = first.next;
            helper.next = first;
        }
        return list;
    }
}
