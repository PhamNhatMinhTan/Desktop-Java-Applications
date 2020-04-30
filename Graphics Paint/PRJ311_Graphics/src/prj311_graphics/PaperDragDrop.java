/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj311_graphics;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Minh Tan
 */
public class PaperDragDrop extends Paper{
    public void removeLast() {
        if (shapes.size() > 0) {
            shapes.remove(shapes.size() - 1);
        }
    }
    
    public void addShape(String type, int x, int y, int width, int height,
                            int lineThickness, Color line, Color fill) {
        shapes.add(new ShapeDragDrop(type, x, y, width, height, lineThickness, line, fill));
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for (Object s : shapes) {
            ((ShapeDragDrop)s).draw(g);
        }
    }
    
    
}
