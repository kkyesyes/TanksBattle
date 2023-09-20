package com.TankGame;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    // 定义一个MyPanel
    MyPanel mp = null;
    public static void main(String[] args) {
        Game game = new Game();
    }

    public Game() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
