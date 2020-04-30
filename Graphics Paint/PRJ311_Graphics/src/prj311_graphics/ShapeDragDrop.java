/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj311_graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Minh Tan
 */
public class ShapeDragDrop extends Shape {

    public ShapeDragDrop(String type, int x, int y, int width, int height,
            int lineThickness, Color line, Color fill) {
        super(type, x, y, width, height, lineThickness, line, fill);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        //draw stroke
        g2D.setStroke(new BasicStroke(lineThickness));
        g2D.setColor(line);
        if (type.equals("rect")) {
            g2D.drawRect(x, y, width, height);
        } else if (type.equals("oval")) {
            g2D.drawOval(x, y, width, height);
        } else if (type.equals("line")) {
            g2D.drawLine(x, y, x + width - 1, y + height - 1);
        }
        
        //draw fill shape
        g2D.setColor(fill);
        if (type.equals("rect")) {
            g2D.fillRect(x, y, width, height);
        } else if (type.equals("oval")) {
            g2D.fillOval(x, y, width, height);
        }
        
    }
}
