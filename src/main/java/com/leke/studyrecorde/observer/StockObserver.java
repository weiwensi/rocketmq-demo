package com.leke.studyrecorde.observer;

/**
 * @classname StockObserver
 * @description
 * @date 2020/8/21 10:08
 * @created by weiwensi
 */
public class StockObserver extends Observer {
    public StockObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getAction() + "\n" + name + "关闭股票行情，继续工作");
    }
}
