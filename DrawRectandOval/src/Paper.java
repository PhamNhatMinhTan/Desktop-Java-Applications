
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Minh Tan
 */
public class Paper extends JPanel {

    protected static Random random;
    protected ArrayList<Object> shapes;

    Paper() {
        this.random = new Random();
        this.shapes = new ArrayList<Object>();
    }

    public static Color randomRBGA() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256),
                random.nextInt(256));
    }

    public void addShape(String type, int maxX, int maxY) {
        int x = random.nextInt(maxX * 3 / 4);
        int y = random.nextInt(maxY * 3 / 4);
        int width = random.nextInt(maxX / 2);
        int height = random.nextInt(maxY / 2);
        Color line = randomRBGA();
        Color fill = randomRBGA();
        int lineThickness = random.nextInt(20) + 1;
        shapes.add(new Shape(type, x, y, width, height, lineThickness, line, fill));
        repaint();
    }
    
    public void clear() {
        shapes.clear();
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            ((Shape)s).draw(g);
        }
    }
}
