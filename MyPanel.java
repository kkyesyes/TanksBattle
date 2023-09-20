package com.TankGame;

import javax.swing.*;
import java.awt.*;

/**
 * @author KK
 * @version 1.0
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel {
    // 定义我的坦克
    Hero hero = null;

    public MyPanel() {
        hero = new Hero(100, 100); // 初始化坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        drawTank(hero.getX(), hero.getY(), g, 0, 0);
    }

    // 编写方法画出坦克

    /**
     *
     * @param x 坦克左上角x坐标
     * @param y 坦克左上角y坐标
     * @param g 画笔
     * @param direction 坦克方向(上下左右)
     * @param type 坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direction, int type) {

        // 根据不同类型的坦克设置不同的颜色
        switch (type) {
            case 0: // 友方坦克
                g.setColor(Color.cyan);
                break;
            case 1: // 敌方坦克
                g.setColor(Color.yellow);
                break;
        }

        // 根据坦克的方向来绘制坦克
        switch (direction) {
            case 0: // 表示向上
                g.fill3DRect(x, y, 10, 60, false); // 画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); // 画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y); // 画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }
}
