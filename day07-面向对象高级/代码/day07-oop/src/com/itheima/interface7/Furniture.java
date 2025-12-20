package com.itheima.interface7;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Furniture implements HomeSystem{
    private String name;
    private String status;

    @Override
    public void Open(){
        if("关".equals(status)){
            System.out.println(name + "已打开！");
            status = "开";
        }
        else{
            System.out.println(name + "已是开着的！");
        }
    }

    @Override
    public void Close(){
        if("开".equals(status)){
            System.out.println(name + "已关闭！");
            status = "关";
        }
        else{
            System.out.println(name + "已是关着的！");
        }
    }

    @Override
    public void Show(){
        System.out.println(name + "的状态是：" + status);
    }
}

