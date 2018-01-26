import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBox extends JPanel {
    private static final long serialVersionUID = 44L;

    private JLabel label = new JLabel("columns:");
    private JTextField field = new JTextField(10);
    private JButton button = new JButton("Go");

    private DisplayPanel displayPanel;

    private int[] ints;

    public ComboBox(DisplayPanel displayPanel) {
        super(new FlowLayout());
        this.displayPanel = displayPanel;
        setBorder(BorderFactory.createLineBorder(Color.black,3));
        setPreferredSize(new Dimension(0,40));

        setUpButtonHandler();

        add(label);
        add(field);
        add(button);
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    private void setUpButtonHandler() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clicked!");
                try {
                    displayPanel.setCols( Integer.parseInt(field.getText()));
                } catch (Exception x) {
                    JOptionPane.showMessageDialog(null,
                            "could not parse number of columns!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
