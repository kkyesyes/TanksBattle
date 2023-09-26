package com.TankGame;


/**'
 * @author KK
 * @version 1.0
 * 射击
 */

public class Shoot implements Runnable {
    private int x; // 子弹的x坐标
    private int y; // 子弹的y坐标
    private int speed = 2; // 子弹的速度
    private int direction = 0; // 子弹的方向
    private boolean isLive = true;

    public Shoot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public boolean isLive() {
        return isLive;
    }

    @Override
    public void run() {
        while (isLive) {
            // 休眠50ms
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direction) {
                case 0: // 上
                    y -= speed;
                    break;
                case 1: // 右
                    x += speed;
                    break;
                case 2: // 下
                    y += speed;
                    break;
                case 3: // 左
                    x -= speed;
                    break;
            }

//            System.out.println("x的坐标：" + x + ", y的坐标：" + y);

            if ( !(x >= 0 && x <= 1000 && y >= 0 && y <= 750) ) {
                this.isLive = false;
            }
        }
    }
}
