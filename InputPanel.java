import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.LinkedList;

public class InputPanel extends JPanel {

    private static final long serialVersionUID = 43L;
    
    private DisplayPanel displayPanel;

    JTextArea textArea = new JTextArea(5,20);
    JScrollPane scrollPane = new JScrollPane(textArea);

    public InputPanel(DisplayPanel displayPanel) {
        super(new BorderLayout());
        this.displayPanel = displayPanel;
        setPreferredSize(new Dimension(400,400));
        setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.black,3),
                    "Input Panel"));


        add(scrollPane,BorderLayout.CENTER);
        add(new ComboBox(displayPanel), BorderLayout.PAGE_END);

        setUpTextListener();
    }

    private void setUpTextListener() {
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                attemptUpdate();
            }
            public void removeUpdate(DocumentEvent e) {
                attemptUpdate();
            }
            public void changedUpdate(DocumentEvent e) {
                attemptUpdate();
            }
        });
    }

    private void attemptUpdate() {
        System.out.println("attempting update");
        LinkedList<Integer> ints = new LinkedList<>();
        for (String s : textArea.getText().split("\\s+")) {
            try {
                ints.add(Integer.parseInt(s));
            } catch (Exception e) {
                System.out.println("parse failed on substring " + s);
            }
        }
        int[] intList = new int[ints.size()];
        for (int i = 0; i < ints.size(); i++) {
            intList[i] = ints.get(i);
        }
        displayPanel.setInts(intList);
    }
}
