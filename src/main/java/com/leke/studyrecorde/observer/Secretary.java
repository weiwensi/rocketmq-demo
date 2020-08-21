package com.leke.studyrecorde.observer;

import java.util.LinkedList;
import java.util.List;

/**
 * 具体的通知者
 *
 * @classname Secretary
 * @description
 * @date 2020/8/21 10:01
 * @created by weiwensi
 */
public class Secretary implements Subject {

    private List<Observer> observers = new LinkedList<>();
    private String action;

    //添加
    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    //删除
    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    //通知
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    //前台状态
    @Override
    public String getAction() {
        return action;
    }

    @Override
    public void setAction(String action) {
        this.action = action;
    }
}
