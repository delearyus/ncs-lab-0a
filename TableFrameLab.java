
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.*;
import javax.swing.*;


/**
 * @author Jamie Leary January 17, 2018 8:30 PM
 */

public class TableFrameLab {

    public static void main(String[] args) {
        JFrame displayFrame = new JFrame("Display Window");
        JFrame inputFrame   = new JFrame("Input Window");
        displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int[] ints = new int []{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 ,100, 23, 1, 0};
        int cols = 6;

        DisplayPanel displayPanel = new DisplayPanel(ints,cols);
        InputPanel   inputPanel   = new InputPanel(displayPanel);

        displayFrame.getContentPane().add(displayPanel, BorderLayout.CENTER);
        inputFrame.getContentPane().add(inputPanel, BorderLayout.CENTER);

        displayFrame.pack();
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(true);

        inputFrame.pack();
        inputFrame.setLocationRelativeTo(null);
        inputFrame.setVisible(true);

    }
}

