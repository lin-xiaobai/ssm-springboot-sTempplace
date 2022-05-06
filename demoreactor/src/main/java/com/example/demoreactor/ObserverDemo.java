package com.example.demoreactor;

import java.util.Observable;

/**
 * @date 2021/8/4 -23:34
 *模仿观察者
 *
 * Observer是一个接口
 * Observer是观察者，
 * Observable是被观察者，这里实现了Observer中的update方法
 *
 * 输出的顺序：
 * 手动被观察者通知，准备改变
 * 发生变化
 * 理由：少定义了一个data属性和dataChanged方法  没体现出数据的变化，就去通知了
 */
public class ObserverDemo extends Observable {
    public static void main(String[] args) {

//        创建对象
      ObserverDemo observer=  new ObserverDemo();
        //    addObserver：添加观察者
//     addObserver方法里面 添加一个 lambda表达式
//        lambda表达式表达式里面的参数o 也是observable
      observer.addObserver((o,arg)->{
//          添加提示输出
          System.out.println("发生变化");
        });
//      再添加一个观察者
        observer.addObserver((o,arg)->{
            System.out.println("手动被观察者通知，准备改变");
        });
//        监控数据变化
        observer.setChanged();//数据变化

        observer.notifyObservers();//通知
    }

}
