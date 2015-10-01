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

/*
 *This program prints the image in a single thread and then using mouse,
 *it will cut the selected portion and zoom it.
 * 
 * @author Sawan
 * @author Prateek
 */
import java.awt.Color;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
/*
 *This is the main class in which the main implementation of graphics 
 *printing is done.
 * 
 */
public class Mandelbrot extends JFrame implements MouseListener 
{
    private final int MAX = 5000;
    private final int LENGTH   = 800;
    private final double ZOOM  = 1000;
    private BufferedImage I;
    private double  xx , yy,zx, zy, cX, cY, tmp;
    private int[] colors = new int[MAX];
    private Point start = new Point();  
    private Point end = new Point(); 
    private double xf , yf ;
    private JWindow size = new JWindow(); 
    /*
     *This is the constructor which will initialise the colour method,
     *size of the panel and will attach the mouse with the constructor.
     * 
     */
    public Mandelbrot()
    {
        super("Mandelbrot Set");
	initColors();
        setBounds(100, 100, LENGTH, LENGTH);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	addMouseListener(this);
    }
    /*
     *This method is the implementation of of mouse which will get the points 
     *that will obtain on clicking the mouse and it will print it.
*/
    public void mousePressed(java.awt.event.MouseEvent e)  
    {  
	start = e.getPoint(); 
	System.out.println("X1::"+start.getX());
	System.out.println("Y1::"+start.getY());
	size.setVisible(true);  
    } 
	/*
	 *This method is the implementation of of mouse which will get the points 
	 *that will obtain by dragging the mouse and releasing it and it will print it.
	 */		
    public void mouseReleased(java.awt.event.MouseEvent mouseEvent)  
    {  
            end = mouseEvent.getPoint(); 
	    System.out.println("X2::"+end.getX());
	    System.out.println("Y2::"+end.getY());
	    zoom(start.getX(),start.getY(),end.getX(),end.getY()); 
    }
    
    public void mouseEntered(MouseEvent e) {
    }
    
    public void mouseExited(MouseEvent e) {
    }
    
    public void mouseClicked(MouseEvent e) {
    }
    /*
     * This is the createSet function which will create the Threads of smallest possible group of x and y co-ordinates and draws the image.
     */
    public void createSet()	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (x - LENGTH) / ZOOM;
                cY = (y - LENGTH) / ZOOM;
                int iter = 0;
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
    }
    /*
     *This method will initialize the colours for the image.
     */
    public void initColors() {
        for (int index = 0; index < MAX; index++) {
            colors[index] = Color.HSBtoRGB(index/256f, 1, index/(index+8f));
        }
    }
    /*
     *This method is the implementation of the zoom technique which will work as it will first
     *get the points of the start and the end points of the mouse dragged image portion
     *and will consider the new start coordinates as the top left and the new end coordinates
     *as the bottom right and will print the image.
     */
    public void zoom(double x1 , double y1 , double x2 , double y2)	{
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	repaint(); 
	yy = y1;
	xf = (x2 - x1)/LENGTH ; 
	yf = (y2 - y1)/LENGTH;
        for (int y = 0; y < getHeight(); y++) {
	    xx = x1;
            for (int x = 0; x < getWidth(); x++) {
                zx = zy = 0;
                cX = (xx - LENGTH) / ZOOM;
                cY = (yy - LENGTH) / ZOOM;
                int iter = 0;
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
		xx = xx + xf;
            }
	    yy = yy + yf;
        }
    }
    /*
     *This method will print the image by taking the co-ordinates.
     */
    @Override
	public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }
    /*
     * This is the main function where the execution begins.
     *
     *@param args no command line.
     */
    public static void main(String[] args) {
        Mandelbrot aMandelbrot = new Mandelbrot();
	aMandelbrot.setVisible(true);
	aMandelbrot.createSet();
    }
}