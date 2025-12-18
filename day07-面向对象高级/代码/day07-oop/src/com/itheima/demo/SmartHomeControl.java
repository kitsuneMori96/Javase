package com.itheima.demo;
// 智能控制系统类。
public class SmartHomeControl {
    // 多态。
    public void control(JD jd) {
        System.out.println(jd.getName() + "状态目前是：" + (jd.isStatus() ? "开着" : "关闭！"));
        System.out.println("开始您的操作。。。。。");
        jd.press(); // 按下开关。
        System.out.println(jd.getName() + "状态已经是：" + (jd.isStatus() ? "开着" : "关闭！"));
    }

    public void printAllStatus(JD[] jds) {
        // 使用for循环，根据索引遍历每个设备。
        for (int i = 0; i < jds.length; i++) {
            JD jd = jds[i];
            System.out.println((i + 1) + "," + jd.getName() + "状态目前是：" + (jd.isStatus() ? "开着" : "关闭！"));
        }
    }
}
