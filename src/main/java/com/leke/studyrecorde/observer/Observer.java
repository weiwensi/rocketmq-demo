package com.leke.studyrecorde.observer;

/**
 * 观察者
 *
 * @classname Observer
 * @description
 * @date 2020/8/21 9:59
 * @created by weiwensi
 */
public abstract class Observer {

    protected String name;
    protected Subject subject;

    public Observer(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
    }

    public abstract void update();
}
