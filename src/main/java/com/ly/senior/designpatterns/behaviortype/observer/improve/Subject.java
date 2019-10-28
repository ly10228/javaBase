package com.ly.senior.designpatterns.behaviortype.observer.improve;

/**
 * @author luoyong
 * @Description: Subject
 * @create 2019-09-22 11:02
 * @last modify by [LuoYong 2019-09-22 11:02]
 **/
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}
