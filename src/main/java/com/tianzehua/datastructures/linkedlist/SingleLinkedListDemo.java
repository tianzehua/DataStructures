package com.tianzehua.datastructures.linkedlist;



/**
 * 单链表应用---水浒传英雄排名
 * @author tianzehua
 * @date 2019/07/14
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        /* 单链表的新增 */
        /* 第一种方法： 在添加英雄的时候，直接添加到链表的尾部 */
        /* 第二种方法，在添加英雄的时候，根据英雄的排名将英雄插入到指定位置，如果这个味排名，添加失败，给出提示 */
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1,"宋江");
        Node node2 = new Node(3,"公孙策");
        Node node3 = new Node(6,"吴用");
        Node node4 = new Node(7,"林冲");
        Node node5 = new Node(4,"tiantian");
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.showList();

        System.out.println("----------------------");
        SingleLinkedList list1 = new SingleLinkedList();
        Node node11 = new Node(1,"宋江");
        Node node31 = new Node(3,"吴用");
        Node node41 = new Node(4,"林冲");
        Node node21 = new Node(2,"公孙策");
        Node node211 = new Node(2,"公孙策");
        try {
            list1.addNode(node11);
            list1.addNode(node21);
            list1.addNode(node31);
            list1.addNode(node41);
            list1.addNode(node211);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        list1.showList();
        System.out.println("----------------------");
        /* 单链表的修改 */
        /* 修改从给定节点的名称 */
        try {
            //list.update(node5);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        list.showList();

        System.out.println("----------------------");
        /*  删除单链表 */
        try {
           // list.delete(4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        list.showList();

        System.out.println("----------------------");
        /* 求单链表中的有效借点个数 */

        /* 思路： 遍历单链表 */
        int count = list.count();
        System.out.println("单链表中的有效借点个数：" + count);

        System.out.println("----------------------");
        /* 查找单链表中的倒数第K个节点 */

        /* 思路：先遍历查到总个数，然后再算出是第几个元素 */
        int count1 = list.count();
        int index = 1;
        if (count1 - index + 1 >0 ){
            try {
                Node node = list.showIndex(count1 - index + 1);
                System.out.println(node.no + ":" + node.name);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("该index不存在！");
        }

        System.out.println("----------------------");
        /* 将单链表反转*/

        /* 自己的思路： 遍历单链表，将每一个节点插入到新的单链表的头后面 */
        list.tranList();
        list.showList();

        System.out.println("----------------------");
        /*从尾到头来打印单链表  */
       // list.showList();

        System.out.println("----------------------");
        /* 合并两个有序的单链表，合并之后的链表仍然有序 */
       // SingleLinkedList list2 = new SingleLinkedList();
        SingleLinkedList list2 = new SingleLinkedList();
        Node nod1 = new Node(2,"宋江1");
        Node nod2 = new Node(4,"公孙策1");
        Node nod3 = new Node(5,"吴用1");
        Node nod4 = new Node(8,"林冲1");
        try {
            list.tranList();
            list2.addNode(nod1);
            list2.addNode(nod2);
            list2.addNode(nod3);
            list2.addNode(nod4);
            SingleLinkedList singleLinkedList = list.oneList(list2);
            singleLinkedList.showList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
}

/**
 * 定义节点对象
 */
class  Node{
    /* 编号 */

    public int no;
    /* 名称 */

    public String name;
    /* next对象 */

    public Node next;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

}

/**
 * 构建带有头节点的单链表
 */
class  SingleLinkedList{
    /**
     * 头节点
     */
    Node head;


    public SingleLinkedList() {
        /* 初始化头节点 */
       head  = new Node(0,null);
    }
    /**
     * 普通的插入数据方法
     */
    public void add(Node node){
       /* 将数据插入到链表的最后，先遍历找到该单链表的最后*/
        /* 当指针的next为空的时候，就是单链表的最后 */
        /* 初始化指针 */
        Node temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    /**
     * 排序的插入数据
     */
    public void  addNode(Node node) throws Exception {
        Node temp = head;
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
    }

    /**
     * 遍历单链表
     */
    public void showList(){
        Node temp = head.next;
        while (true){
            System.out.println("编号：" + temp.no + " 姓名：" + temp.name);
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改单链表
     * @param node
     * @throws Exception
     */
    public  void update(Node node) throws Exception{
        Node temp = head.next;
        while (true){
            if (temp == null){
                throw  new Exception("该编号不存在，无法修改！");
            }else if (temp.no == node.no){
                temp.name = node.name;
                break;
            }
            temp = temp.next;
        }
    }

    public void delete(int no) throws Exception{
        Node temp = head;
        boolean flag = false;
        while (true){

            if (temp.next == null){
                /* 说明单链表已经来到了最后，也就是说明了没有办法匹配，如果最后一个节点是匹配的，那么在上一个循环中就会被捕获 */
                break;
            }else if (temp.next.no == no ){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            temp.next = temp.next.next;
        }else {
            throw  new Exception("该编号不存在，无法删除！");
        }
    }

    /**
     * 单链表中的有效借点个数
     * @return
     */
    public int  count(){
        /* 不统计头节点，从头节点下一个开始 */
        Node temp = head.next;
        int count = 0;
        while (true){
            if (temp == null){
                break;
            }
            temp = temp.next;
            count++;
        }
        return count;
    }

    public Node  showIndex(int index) throws Exception{
        /* 不统计头节点，从头节点下一个开始 */
        Node temp = head.next;
        while (index != 1){
            if (temp.next == null){
                throw  new Exception("该index不存在！");
            }
            temp = temp.next;
           index--;
        }
        return temp;
    }

    public void tranList(){
       /* 遍历单链表，将新的节点插入到头节点的后面 */
        Node temp = head.next;
        Node temp1;

        while (true){
            if (temp == null){
               break;
            }
            temp1 = temp.next;
            if (temp == head.next){
                temp.next = null;
            }else {
                temp.next = head.next;
            }
            head.next = temp;
            temp = temp1;
        }
    }

    public SingleLinkedList oneList(SingleLinkedList list) throws  Exception{
        Node temp = head.next;
        Node temp2;
        while (true){
            if (temp == null){
                break;
            }
            Node temp1 = list.head;
            while (true){
                if (temp1.next == null){
                    break;
                }else if (temp1.next.no > temp.no){
                    break;
                }else if (temp1.next.no == temp.no){
                    throw  new Exception("该编号已经存在，无法添加！");
                }
                temp1 = temp1.next;
            }
            temp2 = temp.next;
            temp.next = temp1.next;
            temp1.next = temp;
            temp = temp2;
        }
        return list;
    }


}