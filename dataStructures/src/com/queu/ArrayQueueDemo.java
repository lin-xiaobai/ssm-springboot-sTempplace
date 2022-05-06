package com.queu;

/**
 * @date 2021/8/17 -18:33
 * 数组模拟队列 :添加数据
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueueDemo arrayQueueDemo=new ArrayQueueDemo();
        try {
            arrayQueueDemo.addData(10);
        } catch (DException e) {
            e.printStackTrace();
        }
    }
        public void addData(int num) throws DException {
            int max = 10;
            int ref = -1;
            int front;
            if (num == 0 || max - 1 == num + ref) {
                throw new DException("队列语句已满");
            } else {
                ref = ref + num;
            }
            System.out.println("队列现在到了" + ref);
        }

    }
    class  DException extends Exception{
        public  DException(String msg){
            super(msg);
        }
}



