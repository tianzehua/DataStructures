package com.tianzehua.datastructures.queue;

public class ArrayQueue {

    /* 构建一个数组队列的类来模拟队列 */
    /* 数组队列有三大特点：1.队列的最大容量，2.队列的头位置，3.队列的尾部位置 */
        /**
         * 数组模拟队列
         */
        int[] ints;
        /**
         * 最大容量
         */
        private int maxSize;
        /**
         * 头部 指向第一个元素的前一个位置
         */
        private int front = -1;
        /**
         * 尾部 指向最后一个元素的位置
         */
        private int rear = -1;


        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            /* 初始化队列，队列的要素，容量，数组*/
            ints = new int[maxSize - 1];
        }

        /* 创建一些方法来服务队列  判断队列是否为空，判断队列是否已满，入队列，出队列，遍历队列 */
        /* 入队列要判断该队列是否已满，出队列要判断该队列是否为空 */

        /**
         * 判断队列是否为空
         *
         * @return
         */
        public boolean isEmptyQueue() {
            /* 如果头指针和尾指针相等的话，代表着队列是空的 */
            if (front == rear) {
                return true;
            }
            return false;
        }

        /**
         * 判断队列是否已满
         *
         * @return
         */
        public boolean isMaxQueue() {
            /* 如果 尾指针达到最大容量，那么代表着队列已经满了 */
            if (rear == maxSize - 1) {
                return true;
            }
            return false;
        }

        /**
         * 入队列
         *
         * @param value
         * @throws Exception
         */
        public void inQueue(int value) throws Exception {
            if (isMaxQueue()) {
                throw new Exception("队列已经满了，无法添加！");
            }
            rear += 1;
            ints[rear] = value;
        }

        /**
         * 出队列
         *
         * @return
         * @throws Exception
         */
        public int outQueue() throws Exception {
            if (isEmptyQueue()) {
                throw new Exception("队列是空的，无法出队列！");
            }
            front += 1;
            return ints[front];
        }

        /**
         * 展示队列
         */
        public void showQueue() {
            if (isEmptyQueue()) {
                System.out.println("队列是空的，无法显示该队列！");
                return;
            }
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }

        /**
         * 获取头信息
         * @return
         * @throws Exception
         */
        public int headQueue() throws Exception {
            if (isEmptyQueue()) {
                throw new Exception("队列是空的，无法显示头信息！");
            }
            return ints[front + 1];
        }

}
