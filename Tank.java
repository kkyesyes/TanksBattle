package com.TankGame;

/**
 * @author KK
 * @version 1.0
 */
public class Tank {
    private int x;
    private int y;
    private int direction; // 坦克方向0上1右2下3左

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private int speed = 5;


    // 上下左右移动方法
    public void moveUp() {
        y -= speed;
    }
    public void moveDown() {
        y += speed;
    }
    public void moveRight() {
        x += speed;
    }
    public void moveLift() {
        x -= speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
