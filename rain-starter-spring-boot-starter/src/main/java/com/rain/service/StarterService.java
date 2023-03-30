package com.rain.service;

import lombok.Data;

/**
 *  业务服务类（提供给外部调用）
 * @author Rain
 */
@Data
public class StarterService {

    private String rainName;

    public void print(){
        System.out.println("我被调用啦！");
    }
}
