package com.itheima.interface7;

public class Test {
    static void main(String[] args) {
        HomeSystem[] home = new HomeSystem[10];
        home[0] = new Furniture("台灯", "关");
        home[1] = new Furniture("电灯泡", "关");
        home[2] = new Furniture("冰箱", "开");
        home[3] = new Furniture("洗衣机", "关");
        home[4] = new Furniture("微波炉", "开");
        home[5] = new Furniture("沙发", "开");
        home[6] = new Furniture("床", "开");
        home[7] = new Furniture("衣柜", "关");
        home[8] = new Furniture("抽油烟机", "关");
        home[9] = new Furniture("热水器", "关");

        OperatorFurniture operator = new OperatorFurniture(home);
        operator.PrintAllFurniture();
        System.out.println("-------------------当前家具状态-------------------");
        home[9].Close();
        home[9].Show();
        home[9].Open();
        home[9].Show();
    }
}
