package com.leke.studyrecorde.observer;

/**
 * @classname Client
 * @description
 * @date 2020/8/21 10:08
 * @created by weiwensi
 */
public class Client {

    public static void main(String[] args) {
        //前台为通知者
        Secretary secretary = new Secretary();

        StockObserver observer = new StockObserver("adam", secretary);
        NBAObserver observer2 = new NBAObserver("tom", secretary);

        //前台通知
        secretary.attach(observer);
        secretary.attach(observer2);

        //adam没被前台通知到，所以被老板抓了个现行
        secretary.detach(observer);

        //老板回来了
        secretary.setAction("小心！Boss回来了！");
        //发通知
        secretary.notifyObservers();
    }
}
