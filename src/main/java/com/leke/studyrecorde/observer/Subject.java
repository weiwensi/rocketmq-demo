package com.leke.studyrecorde.observer;


/**
 * 通知者接口
 * @classname Subject
 * @description
 * @date 2020/8/21 9:58
 * @created by weiwensi
 */
public interface Subject {

    //增加
     void attach(Observer observer);

    //删除
     void detach(Observer observer);

    //通知
     void notifyObservers();

    //状态
     void setAction(String action);

     String getAction();
}
