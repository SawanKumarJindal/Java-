/*
 *IntegerationClass.java
 *
 *Version 1.0
 *   $Id$
 *
 * Revisions: 
 * $ Log$
 *
 */

/*
 * This is the main class where the whole execution of integrating the function is taking place by 
 * dividing them into threads and calculating the average height.  
 */
public class IntegerationClass {
    static double integerate = 0;
    
    /*
     *This is the function which returns the values of the function defined.
     */
    public double function(double x, double y) {
	return x*x + y + y;
    }
    /*
     * This is the Calculation function where the whole calculation of dividing the co-ordinates into threads and
     * then calculating the height of the function and then taking the average of it.
     */
    public void Calculation(double x1, double x2, double y1, double y2, int xSegs, int ySegs) {
	double xSegSize = (x2 - x1) / xSegs; //0.1
	double ySegSize = (y2 - y1) / ySegs;  //0.1
	/*
	 * This is the inner class which executes the calculation part of every thread.
	 */
	class CreatingThread extends Thread{	
	    double i,j,x1,y1,x2,y2;
	    double xSegSize,ySegSize;
	    // Constructor which will initialise the values of the parameters.
	    CreatingThread (int i,int j,double x1,double x2,double y1,double y2,double xSegSize,double ySegSize){
		this.i=i;
		this.j=j;
		this.ySegSize=ySegSize;
		this.y1=y1;
		this.x1=x1;
		this.x2=x2;
		this.y2=y2;
		this.xSegSize=xSegSize;
	    }
	    // This is the run function which will execute when the Thread's start method will call and will calculate the integration by calculating the average height.
	    public void run(){
		double height = function(x1 + (xSegSize * i), y1 + (ySegSize * j));
		height += function(x1 + (xSegSize * (i + 1)), y1 + (ySegSize * j));
		height += function(x1 + (xSegSize * (i + 1)), y1 + (ySegSize * (j + 1)));
		height += function(x1 + (xSegSize * i), y1 + (ySegSize * (j + 1)));
		height /= 4;
		integerate += xSegSize * ySegSize * height;
	    }
	}
	// This multi-for loop which create Thread for each x and y segment.
	for (int i = 0; i < xSegs; i++) {
	    for (int j = 0; j < ySegs; j++) {
	        new CreatingThread(i,j,x1,x2,y1,y2,xSegSize,ySegSize).start();
	    }
	}
    }
    /*
     * This is the function where the execution begins.
     *
     *@param args no command line.
     */
    public static void main( String[] args){
	IntegerationClass ic = new IntegerationClass();
	int xl= -1, xu=1,yl=-2,yu=2;
	int xseg = (int) (xu-xl/0.1);
	int yseg= (int) (yu-yl/0.1);
	ic.Calculation(xl, xu, yl, yu, xseg, yseg);
	System.out.println("Integerate:"+integerate);
    }
}
