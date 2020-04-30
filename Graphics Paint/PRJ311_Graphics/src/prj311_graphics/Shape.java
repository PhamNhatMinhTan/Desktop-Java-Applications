package prj311_graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author KhanhVH@fe.edu.vn
 */
class Shape {
    protected int x, y, width, height;
    protected Color line, fill;
    protected int lineThickness;
    protected String type;

    public Shape(String type, int x, int y, int width, int height, 
                 int lineThickness, Color line, Color fill) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lineThickness = lineThickness;
        this.line = line;
        this.fill = fill;
    }
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        
        //draws fill shape
        g2D.setColor(fill);
        if (type.equals("rect")) {
            g2D.fillRect(x, y, width, height);
        } else  if (type.equals("oval")) {
            g2D.fillOval(x, y, width, height);
        }

        //draws outline
        g2D.setStroke(new BasicStroke(lineThickness));        
        g2D.setColor(line);
        if (type.equals("rect")) {
            g2D.drawRect(x, y, width, height);
        } else  if (type.equals("oval")) {
            g2D.drawOval(x, y, width, height);
        }
    }
}
