package array.二维数组;

/**
 * @date 2021/3/18 -18:50
 */
public class MyStack {
    Object[] elements;
    int index;

    //    定义一个无参有参构造方法
    public MyStack() {
        Object[] object = new Object[10];
        index = -1;

    }

    public MyStack(Object[] elements, int index) {
        this.elements = elements;
        this.index = index;
    }

    //    定义方法
    public void push(Object[] elements) {
        if (index >= elements.length - 1) {
            System.out.println("栈满了");
            return;
        }
        index++;
        this.elements[index] = elements;
        System.out.println("压栈" + elements + "成功" + index);
    }

}
