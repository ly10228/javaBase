package com.ly.senior.designpatterns.uml.generalization;

import lombok.Data;

/**
 * @author luoyong
 * @Description: DaoSupport
 * @create 2019-09-07 16:48
 * @last modify by [LuoYong 2019-09-07 16:48]
 **/
@Data
public abstract class DaoSupport {
    public void save(Object entity) {
    }

    public void delete(Object id) {
    }
}
