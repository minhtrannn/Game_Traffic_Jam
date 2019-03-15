import game.GamePanel;
import game.GameWindow;
import game.Settings;
import game.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GameWindow window = new GameWindow();
        window.setTitle("Game Traffic Jam");
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        panel.setPreferredSize(
                new Dimension(Settings.GAME_WIDTH, Settings.GAME_HEIGHT)
        );
        window.add(panel);
        window.pack();
        panel.setBackground(Color.CYAN);
        window.setVisible(true);
        panel.gameLoop();
    }
}
