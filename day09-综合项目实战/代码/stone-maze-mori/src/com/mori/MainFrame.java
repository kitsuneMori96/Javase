package com.mori;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MainFrame extends JFrame {
    private static final String IMAGE_PATH = "D:\\Download\\javaseaiproject\\day09-综合项目实战\\代码\\stone-maze-mori\\src\\image\\";
    private int[][] data = new int[][]{
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };


    public MainFrame() {
        //初始化窗口
        initWindow();
        // 初始化数据
        initData();
        //初始化界面图片
        initPanel();
        //初始化菜单
        initMenu();
        //绑定按键事件
        initKeyPressEvent();
        //将窗口始终设置为焦点
        this.setFocusable(true);
        this.setVisible(true);
    }

    private void initKeyPressEvent() {
        //绑定上下左右按键事件
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        dataMove(KeyEvent.VK_UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        dataMove(KeyEvent.VK_DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        dataMove(KeyEvent.VK_LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        dataMove(KeyEvent.VK_RIGHT);
                        break;
                    default:
                        break;
                }
                initPanel();
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    protected void dataMove(int vkRight) {
        if(vkRight==KeyEvent.VK_UP) {
            // 上移
            for(int i=0;i<data.length;i++){
                for(int j=0;j<data[i].length;j++){
                    if(data[i][j]==0){
                        if(i!=data.length-1){
                            int temp=data[i][j];
                            data[i][j]=data[i+1][j];
                            data[i+1][j]=temp;
                            return;
                        }
                    }
                }
            }
        } else if(vkRight==KeyEvent.VK_DOWN) {
            // 下移
            for(int i=0;i<data.length;i++){
                for(int j=0;j<data[i].length;j++){
                    if(data[i][j]==0){
                        if(i!=0){
                            int temp=data[i][j];
                            data[i][j]=data[i-1][j];
                            data[i-1][j]=temp;
                            return;
                        }
                    }
                }
            }
        } else if(vkRight==KeyEvent.VK_LEFT) {
            // 左移
            for(int i=0;i<data.length;i++){
                for(int j=0;j<data[i].length;j++){
                    if(data[i][j]==0){
                        if(j!=data[i].length-1){
                            int temp=data[i][j];
                            data[i][j]=data[i][j+1];
                            data[i][j+1]=temp;
                            return;
                        }
                    }
                }
            }
        } else if(vkRight==KeyEvent.VK_RIGHT) {
            // 右移
            for(int i=0;i<data.length;i++){
                for(int j=0;j<data[i].length;j++){
                    if(data[i][j]==0){
                        if(j!=0){
                            int temp=data[i][j];
                            data[i][j]=data[i][j-1];
                            data[i][j-1]=temp;
                            return;
                        }
                    }
                }
            }
        }
    }

    private void initData() {
        //打乱二维数组中的元素
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int x = (int) (Math.random() * data.length );
                int y = (int) (Math.random() * data[i].length );
                int temp = data[i][j];
                data[i][j] = data[x][y];
                data[x][y] = temp;
            }
        }
    }

    public void initWindow() {
        //初始化窗口
        setTitle("石头迷阵");
        setSize(465, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void initMenu() {
        //初始化菜单
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("设置");
        JMenuItem item1 = new JMenuItem("重启游戏");
        JMenuItem item2 = new JMenuItem("退出");
        menu.add(item1);
        menu.add(item2);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        item1.addActionListener(e -> {
            //重启游戏

        });
        item2.addActionListener(e -> {
            //退出游戏

        });
    }
    public void initPanel() {

        getContentPane().removeAll(); // 移除所有组件

        // 初始化界面图片(先添加前景图片)
        setLayout(null);
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                JLabel imageLabel = new JLabel(new ImageIcon(IMAGE_PATH + data[i][j] + ".png"));
                add(imageLabel);
                imageLabel.setBounds(20+j * 100, 60+i * 100, 100, 100);
            }
        }

        // 最后添加背景图（确保在最底层）
        JLabel label = new JLabel(new ImageIcon(IMAGE_PATH + "background.png"));
        add(label);
        label.setBounds(0, 0, 450, 484);

        revalidate(); // 重新计算布局
        repaint();    // 重绘界面

    }

}

class Application {
    static void main(String[] args) {
        new MainFrame();
    }
}
