/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prj311_graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author Minh Tan
 */
public class SimplePainter extends javax.swing.JFrame {

    private PaperDragDrop p;
    private int startX, startY, endX, endY;
    private Color lineColor = Color.BLACK, fillColor = Color.WHITE;
    private String type = "line";
    private MouseInputAdapter dragDropListener;

    //Load image into buffer
    public static BufferedImage getImage(Component component) {
        BufferedImage img = new BufferedImage(component.getWidth(), component.getHeight(),
                BufferedImage.TYPE_INT_BGR);
        component.paint(img.getGraphics());
        return img;
    }

    /**
     * Creates new form SimplePainter
     */
    public SimplePainter() {
        initComponents();
        this.setLocationRelativeTo(null);

        p = new PaperDragDrop();
        pnlPaper.setSize(800, 400);
        pnlPaper.setLayout(new BorderLayout());
        pnlPaper.add(p, BorderLayout.CENTER);
        dragDropListener = new MouseInputAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                startX = evt.getX();
                startY = evt.getY();
                //show position [x, y]
                lblStatus.setText("[" + startX + "," + startY + "]; [" + startX + "," + startY + "]");
                p.addShape(type, startX, startY, 1, 1, sldLineThickness.getValue(), lineColor, fillColor);
            }

            @Override
            public void mouseDragged(MouseEvent evt) {
                endX = evt.getX();
                endY = evt.getY();
                lblStatus.setText("[" + startX + "," + startY + "] ; [" + endX + "," + endY + "]");
                
                //if type is "line"
                if (type.equals("line")) {
                    p.removeLast();
                    p.addShape(type, startX, startY, endX - startX + 1, endY - startY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                }
                
                //If type is "rectangle" or "Oval"
                //Drag from top right to bottom left
                if (startX < endX && startY < endY && !type.equals("line")) {
                    p.removeLast();
                    p.addShape(type, startX, startY, endX - startX + 1, endY - startY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                } else if (endX < startX && endY < startY && !type.equals("line")) {
                    //Drag from bottom right to top left
                    p.removeLast();
                    p.addShape(type, endX, endY, startX - endX + 1, startY - endY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                } else if (endX < startX && endY > startY && !type.equals("line")) {
                    //drag from top left to bottom right
                    p.removeLast();
                    p.addShape(type, endX, startY, startX - endX + 1, endY - startY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                } else if (startX < endX && startY > endY && !type.equals("line")) {
                    //Drag from bottom left to top right 
                    p.removeLast();
                    p.addShape(type, startX, endY, endX - startX + 1, startY - endY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                }

            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                endX = evt.getX();
                endY = evt.getY();
                lblStatus.setText("[" + startX + "," + startY + "]; [" + endX + "," + endY + "]");
                
                
                if (type.equals("line")) {
                    p.removeLast();
                    p.addShape(type, startX, startY, endX - startX + 1, endY - startY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                }

                //If type is "rectangle" or "Oval"
                //Drag from top right to bottom left
                if (startX < endX && startY < endY && !type.equals("line")) {
                    p.removeLast();
                    p.addShape(type, startX, startY, endX - startX + 1, endY - startY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                } else if (endX < startX && endY < startY && !type.equals("line")) {
                    //Drag from bottom right to top left
                    p.removeLast();
                    p.addShape(type, endX, endY, startX - endX + 1, startY - endY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                } else if (endX < startX && endY > startY && !type.equals("line")) {
                    //drag from top left to bottom right
                    p.removeLast();
                    p.addShape(type, endX, startY, startX - endX + 1, endY - startY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                } else if (startX < endX && startY > endY && !type.equals("line")) {
                    //Drag from bottom left to top right 
                    p.removeLast();
                    p.addShape(type, startX, endY, endX - startX + 1, startY - endY + 1,
                            sldLineThickness.getValue(), lineColor, fillColor);
                }
            }
        };
        p.addMouseListener(dragDropListener);
        p.addMouseMotionListener(dragDropListener);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileFile = new javax.swing.JFileChooser();
        pnlTool = new javax.swing.JPanel();
        btnLine = new javax.swing.JButton();
        btnRect = new javax.swing.JButton();
        btnOval = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        sldLineThickness = new javax.swing.JSlider();
        btnLineColor = new javax.swing.JButton();
        btnFillColor = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        pnlPaper = new javax.swing.JPanel();
        pnlStatus = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint ");
        setBackground(new java.awt.Color(255, 255, 255));

        pnlTool.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Drawing Tools", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        btnLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/line.png"))); // NOI18N
        btnLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineActionPerformed(evt);
            }
        });

        btnRect.setForeground(new java.awt.Color(255, 255, 255));
        btnRect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rect.png"))); // NOI18N
        btnRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectActionPerformed(evt);
            }
        });

        btnOval.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/oval.png"))); // NOI18N
        btnOval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOvalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Line Thickness");

        sldLineThickness.setMajorTickSpacing(20);
        sldLineThickness.setMaximum(200);
        sldLineThickness.setMinorTickSpacing(10);
        sldLineThickness.setPaintTicks(true);
        sldLineThickness.setValue(10);

        btnLineColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lineColor.png"))); // NOI18N
        btnLineColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineColorActionPerformed(evt);
            }
        });

        btnFillColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fill.png"))); // NOI18N
        btnFillColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFillColorActionPerformed(evt);
            }
        });

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.jpg"))); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlToolLayout = new javax.swing.GroupLayout(pnlTool);
        pnlTool.setLayout(pnlToolLayout);
        pnlToolLayout.setHorizontalGroup(
            pnlToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToolLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLine, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRect, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOval, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sldLineThickness, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnLineColor, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        pnlToolLayout.setVerticalGroup(
            pnlToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlToolLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlToolLayout.createSequentialGroup()
                        .addGroup(pnlToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sldLineThickness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlToolLayout.createSequentialGroup()
                                .addGroup(pnlToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLineColor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnFillColor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClear)
                                    .addGroup(pnlToolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnOval, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1)
                                        .addComponent(btnLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(8, 8, 8)))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(pnlToolLayout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(17, 17, 17))))
        );

        pnlPaper.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnlPaperLayout = new javax.swing.GroupLayout(pnlPaper);
        pnlPaper.setLayout(pnlPaperLayout);
        pnlPaperLayout.setHorizontalGroup(
            pnlPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 959, Short.MAX_VALUE)
        );
        pnlPaperLayout.setVerticalGroup(
            pnlPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        lblStatus.setText("[0, 0]; [0, 0]");

        javax.swing.GroupLayout pnlStatusLayout = new javax.swing.GroupLayout(pnlStatus);
        pnlStatus.setLayout(pnlStatusLayout);
        pnlStatusLayout.setHorizontalGroup(
            pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlStatusLayout.setVerticalGroup(
            pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTool, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPaper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnlTool, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlPaper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineActionPerformed
        type = "line";
    }//GEN-LAST:event_btnLineActionPerformed

    private void btnRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectActionPerformed
        type = "rect";
    }//GEN-LAST:event_btnRectActionPerformed

    private void btnOvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOvalActionPerformed
        type = "oval";
    }//GEN-LAST:event_btnOvalActionPerformed

    private void btnLineColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineColorActionPerformed
        lineColor = JColorChooser.showDialog(this, "Choose line color", Color.BLACK);
    }//GEN-LAST:event_btnLineColorActionPerformed

    private void btnFillColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFillColorActionPerformed
        fillColor = JColorChooser.showDialog(this, "Choose fill color", Color.WHITE);
    }//GEN-LAST:event_btnFillColorActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        p.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * Save image
     * @param evt 
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //show save dialog
        int choice = fileFile.showSaveDialog(this);
        //check location user choose
        if (choice == JFileChooser.APPROVE_OPTION) {
            File fSelect = fileFile.getSelectedFile();
            //set file always end with ".png" if we don't choose what type file to save
            fSelect = new File(fSelect.getAbsolutePath() + ".png");
            try {
                BufferedImage img = getImage(pnlPaper);
                ImageIO.write(img, "png", fSelect);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimplePainter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimplePainter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimplePainter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimplePainter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SimplePainter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnFillColor;
    private javax.swing.JButton btnLine;
    private javax.swing.JButton btnLineColor;
    private javax.swing.JButton btnOval;
    private javax.swing.JButton btnRect;
    private javax.swing.JButton btnSave;
    private javax.swing.JFileChooser fileFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JPanel pnlPaper;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JPanel pnlTool;
    private javax.swing.JSlider sldLineThickness;
    // End of variables declaration//GEN-END:variables
}
