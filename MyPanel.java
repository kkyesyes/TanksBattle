package com.TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author KK
 * @version 1.0
 * 坦克大战的绘图区域
 */
public class MyPanel extends JPanel implements KeyListener {
    // 定义我的坦克
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<EnemyTank>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100, 0); // 初始化坦克

        for (int i = 0; i < enemyTankSize; ++i) {
            enemyTanks.add(new EnemyTank( (100 * (i + 1)), 0, 2) );
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        // 创建己方坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 1);

        // 创建敌人坦克
        for (int i = 0; i < enemyTanks.size(); ++i) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirection(), 0);
        }
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
        // 0上1右2下3左
        switch (direction) {
            case 0: // 上
                g.fill3DRect(x, y, 10, 60, false); // 画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); // 画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y); // 画出炮筒
                break;
            case 1: // 右
                g.fill3DRect(x, y, 60, 10, false); // 画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); // 画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20); // 画出炮筒
                break;
            case 2: // 下
                g.fill3DRect(x, y, 10, 60, false); // 画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false); // 画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false); // 画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20); // 画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60); // 画出炮筒
                break;
            case 3: // 左
                g.fill3DRect(x, y, 60, 10, false); // 画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false); // 画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false); // 画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20); // 画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20); // 画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 处理wasd按键情况
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:// 按下W键
                hero.setDirection(0);
                hero.moveUp();
                break;
            case KeyEvent.VK_A:
                hero.setDirection(3);
                hero.moveLift();
                break;
            case KeyEvent.VK_S:
                hero.setDirection(2);
                hero.moveDown();
                break;
            case KeyEvent.VK_D:
                hero.setDirection(1);
                hero.moveRight();
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
