package com.leke.studyrecorde.observer;

/**
 * @classname NBAObserver
 * @description
 * @date 2020/8/21 10:10
 * @created by weiwensi
 */
public class NBAObserver extends Observer {
    public NBAObserver(String name, Subject subject) {
        super(name, subject);
    }

    @Override
    public void update() {
        System.out.println(subject.getAction() + "\n" + name + "关闭NBA，继续工作");
    }
}
