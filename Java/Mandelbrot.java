/*
 *Mandelbrot.java
 *
 *Version 1.0
 *   $Id$
 *
 * Revisions: 
 * $ Log$
 *
 */
import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Mandelbrot extends JFrame implements MouseListener{
    
    private final int MAX = 5000;
    private final int LENGTH   = 800;
    private final double ZOOM  = 1000;
    private BufferedImage I;
    private double zx, zy, cX, cY, tmp;
    private int[] colors = new int[MAX];
    private Point start = new Point();  
    private Point end = new Point();  
   
    public Mandelbrot() {
        super("Mandelbrot Set");
	
	initColors();
        setBounds(100, 100, LENGTH, LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(this);
    }
	public void mousePressed(MouseEvent e)  
        {  
                done = false;  
                start = mouseEvent.getPoint();    
                    setCursorLabel();  
                    size.setVisible(true);  
        }  
		 public void mouseReleased(java.awt.event.MouseEvent mouseEvent)  
        {  
            end = mouseEvent.getPoint();  
          //  in = ImageStack.getImage();  
          //  BufferedImage i = createImage();  
              
            /*if(parent.getFloodFill())  
            {  
                floodFill();  
            }  
            else if(parent.getReplace())  
            {  
                replace();  
            }  
            else if(parent.getTransparent())  
            {  
                if(end.x < in.getWidth() && end.y < in.getHeight())   //the user clicked on the image  
                {  
                    Color color = new Color(in.getRGB(end.x, end.y));   //get the color  
                    BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(),BufferedImage.TYPE_INT_ARGB);  
                    Graphics2D g2d = out.createGraphics();                    
                    g2d.drawImage(TransparencyUtil.makeColorTransparent(in, color), 0, 0, null);    
                    g2d.dispose();  
                    ImageStack.addImage(out);  
                    parent.setTransparent(false);  
                }  
            }  
            else if(parent.getCrop())  
            {  
                size.setVisible(false);  
                //crop image  
                i = i.getSubimage(x1 + 1, y1 + 1, w - 1, h - 1);  
                //pop up a dialog  
                int choice = JOptionPane.showConfirmDialog(parent,"Width = " + (w - 2) + "\nHeight = " + (h - 2), "Crop", JOptionPane.OK_CANCEL_OPTION);  
                if(choice == JOptionPane.OK_OPTION)  
                {  
                    ImageStack.addImage(i);  
                }  
                parent.setCrop(false);  
            }  
            else  
            {  
                BufferedImage old = ImageStack.getImage();  
                if(parent.getConstrain() && old != null)  
                {  
                    i = i.getSubimage(0, 0, old.getWidth(), old.getHeight());  
                }  
                ImageStack.addImage(i);  
                current = null;  
            }  
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));  
            repaint();  
            revalidate();  
            free = null;    //probably very important. should maybe come before repaint()  
            overlayImage = null;  
            done = true;  
        } */
    /*
     * This is the createSet function which will create the Threads of smallest possible group of x and y co-ordinates and draws the image.
     */
    public void createSet()	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	/*
	 * This is the inner class which will execute each Thread.
	 */
	 
	class DrawIt extends Thread
	{
	    int x,y;
	    DrawIt(int a,int b){
		x=a;
		y=b;
	    }
	    /*
	     * This is the main Thread function which will execute the data and will then result in the image generation.
	     */
	    public void run(){
                zx = zy = 0;
                cX = (x - LENGTH) / ZOOM;
                cY = (y - LENGTH) / ZOOM;
                int iter = 0;
		// This is the while loop which will iterate up to the last element.
                while ( (zx * zx + zy * zy < 4 ) && ( iter < MAX - 1 ) ) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter++;
                }
		if ( iter > 0 )
		    I.setRGB(x, y, colors[iter]);
		else
		    I.setRGB(x, y, iter | (iter << 8));
		repaint();
            }
	}
	// These set of for loops will generate Threads for every possible set of x and y values.
	for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
		new DrawIt(x,y).start();
	    }
	}
    }
    public void initColors() {
        for (int index = 0; index < MAX; index++) {
            colors[index] = Color.HSBtoRGB(index/256f, 1, index/(index+8f));
        }
    }
    
    @Override
	public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
    /*
     * This is the function where the execution begins.
     *
     *@param args no command line.
     */
    public static void main(String[] args) {
        Mandelbrot aMandelbrot = new Mandelbrot();
	aMandelbrot.setVisible(true);
	aMandelbrot.createSet();
    }
}
