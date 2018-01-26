import java.awt.*;
import javax.swing.*;

public class DisplayPanel extends JPanel {

    private static final long serialVersionUID = 42L;

    int[] ints;
    int cols, rows;
    int colWidth, rowHeight;
    int top, bottom, left, right;

    int PADDING = 40;
    int PREFERRED_CELL_SIZE = 80;

    public DisplayPanel(int[] ints,int cols) {
        super(new BorderLayout());
        this.ints = ints;
        this.cols = cols;
        updateSizes();
        setPreferredSize(new Dimension(PREFERRED_CELL_SIZE*cols + 2*PADDING,
                                       PREFERRED_CELL_SIZE*rows + 2*PADDING));
        setBorder(BorderFactory.createTitledBorder(
                    BorderFactory.createLineBorder(Color.black,3),
                    "Display Panel"));
    }

    public void setInts(int[] ints) {
        this.ints = ints;
        repaint();
    }

    public void setCols(int cols) {
        this.cols = cols;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateSizes();
        drawVals(g);
        drawGrid(g);
    }

    private void updateSizes() {
        rows = Math.max(1,(int)Math.ceil((double)ints.length / cols));
        colWidth =  Math.max(1,(getSize().width  - (2*PADDING)) / cols);
        rowHeight = Math.max(1,(getSize().height - (2*PADDING)) / rows);

        top = PADDING;
        bottom = Math.max(PADDING,getSize().height - PADDING);
        left = PADDING;
        right = Math.max(PADDING,getSize().width - PADDING);
    };


    private void drawVals(Graphics g) {
        int x = PADDING + (colWidth / 2);
        int y = PADDING + (rowHeight / 2);
        int tx;
        for (int i : this.ints) {
            tx = x - (Integer.toString(i).length() * 5);
            g.drawString(Integer.toString(i),tx,y);
            x+=colWidth;
            if (x >= right) {
                x = PADDING + (colWidth / 2);
                y += rowHeight;
            }
        }
    }

    private void drawGrid(Graphics g) {
        for (int x = left; x <= right; x+=colWidth) {
            g.drawLine(x,top,x,bottom);
        }
        for (int y = top; y <= bottom; y+=rowHeight) {
            g.drawLine(left,y,right,y);
        }
    }

}
