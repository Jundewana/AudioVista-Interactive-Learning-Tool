/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asset;

import com.twelvemonkeys.image.ImageUtil;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
/**
 *
 * @author MUHAMMAD NAZLAN R
 */
public class DBackground extends JComponent {
    private Icon image;
    private BufferedImage bufferedImage;
    
    public DBackground(){
        image = new ImageIcon(getClass().getResource("/asset/DbgFlat.png"));
       
    }
    
   private void createImage() {
        if (image != null) {
            int width = getWidth();
            int height = getHeight();
            if (width > 0 && height > 0) {
                bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = bufferedImage.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                Rectangle rec = getAutoSize(image);
                g2.drawImage(((ImageIcon) image).getImage(), rec.x, rec.y, rec.width, rec.height, null);
                
                createBlurImage(g2);
                g2.dispose();
            }
        }
    }
    
   private void createBlurImage(Graphics2D g){
       int x =0;
       int y =0;
        int width = getWidth();
        int height = getHeight();
        int shadow = 8;
        if (width > 0 && height > 0) {
            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            g2.drawImage(ImageUtil.blur(bufferedImage.getSubimage(x, y, width, height), 0f), 0, 0, null);
                    
            g2.dispose();
            
            g.drawImage(img, x, y, null);
        }
        
       
   }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g); // Correct method call
        if (bufferedImage != null) {
            g.drawImage(bufferedImage, 0, 0, this);
        }
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createImage();
                repaint();
            }
        });
        
        
    }
     
    private Rectangle getAutoSize(Icon image) {
        int w = getWidth();
        int h = getHeight();
        int iw = image.getIconWidth();
        int ih = image.getIconHeight();
        double xScale = (double) w / iw;
        double yScale = (double) h / ih;
        double scale = Math.max(xScale, yScale);
        int width = (int) (scale * iw);
        int height = (int) (scale * ih);
        if (width < 1) {
            width = 1;
        }
        if (height < 1) {
            height = 1;
        }
        int x = (w - width) / 2;
        int y = (h - height) / 2;
        return new Rectangle(new Point(x, y), new Dimension(width, height));
    }
}

