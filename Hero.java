package com.TankGame;

/**
 * @author KK
 * @version 1.0
 */
public class Hero extends Tank {
    private Shoot shoot = null;

    public Hero(int x, int y, int direction) {
        super(x, y, direction);
    }

    public Shoot getShoot() {
        return shoot;
    }

    public void shoot() {
        switch (getDirection()) {
            case 0:
                shoot = new Shoot(getX() + 20, getY(), 0);
                break;
            case 1:
                shoot = new Shoot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shoot = new Shoot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shoot = new Shoot(getX(), getY() + 20, 3);
                break;
        }

        // 启动线程
        new Thread(shoot).start();
        System.out.println("线程启动");
    }
}
