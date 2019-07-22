package com.tianzehua.datastructures.linkedlist;


/**
 * 双向链表实现水浒英雄排名
 * @author tianzehua
 * @date 2019/07/16
 */
public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Nodes node1 = new Nodes(1,"宋江");
        Nodes node2 = new Nodes(2,"公孙策");
        Nodes node3 = new Nodes(3,"吴用");
        Nodes node4 = new Nodes(4,"林冲");
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.showList();

        System.out.println("--------------------");
        try {
            list.delete(4);
            list.showList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

/* 创建节点的数据结构 */

/**
 * 节点对象
 */
class  Nodes{
    /* 编号 */

    public int no;
    /* 名称 */

    public String name;
    /* next对象 */

    public Nodes next;

    public Nodes pre;

    public Nodes(int no, String name) {
        this.no = no;
        this.name = name;
    }

}


/* 构建双向链表的数据结构 */

class  DoubleLinkedList{

    /**
     * 头节点
     */
    Nodes head;

    /**
     * 构造函数
     */
    public DoubleLinkedList() {
        /* 初始化头节点信息 */
        head = new Nodes(0,null);
    }

    /**
     * 普通的新增到最后
     * @param node
     */
    public void add(Nodes node){

        Nodes temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        node.pre = temp;
        temp.next = node;

    }

    /**
     * 遍历双向链表
     */
    public void showList(){
        Nodes temp = head.next;
        while (true){
            System.out.println("编号：" + temp.no + " 姓名：" + temp.name);
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 按顺序添加
     */
    public void  addList(Nodes node)  throws Exception {
        Nodes temp = head;
        while (true){
            if (temp.next == null){
                break;
            }else if (temp.next.no > node.no){
                break;
            }else if (temp.next.no == node.no){
                throw  new Exception("该编号已经存在，无法添加！");
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        node.pre = temp;
    }

    /**
     * 删除
     * @param no
     * @throws Exception
     */
    public  void  delete(int no) throws Exception{
        Nodes temp = head.next;
        boolean flag = false;
        while (true){
            if (temp == null){
                break;
            }else if (temp.no == no ){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            if (temp.next ==  null){
                temp.pre.next = null;
            }else {
                temp.next.pre = temp.pre;
                temp.pre.next = temp.next;
            }
        }else {
            throw  new Exception("该编号不存在，无法删除！");
        }
    }
}