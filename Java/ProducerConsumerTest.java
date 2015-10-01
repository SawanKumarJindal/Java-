public class ProducerConsumerTest extends Thread {
    
    static int screwCount=0,baseCount=0,standCount=0,socketCount=0,bulbCount=0,lampsCount=0;
	static int ArraySize=100;
    static int[] screwArray = new int[ArraySize];
    static int[] baseArray = new int[ArraySize];
    static int[] standArray = new int[ArraySize];
    static int[] socketArray = new int[ArraySize];
    static int[] bulbArray = new int[ArraySize];
    static int waitTime =  2000;
    
    int machineid;
    public ProducerConsumerTest( int machineid ) {
	this.machineid = machineid;
	initialise();
    }
    /*
      public void run() {
      int value = 0;
      for (int i = 0; i < 10; i++) {
      value = lamp.get();
      System.out.println("Consumer #" 
      + this.number
      + " got: " + value);
      }
      }
    */
    
    /*   public Producer( int machineid ) {
	 this.machineid = machineid;
	 initialise();
	 }
    */
    void initialise() {
	for (int i = 0; i<ArraySize;i++)
	    {
		screwArray[i] = 0;
		baseArray[i] = 0;
		standArray[i] = 0;
		socketArray[i] = 0;
		bulbArray[i] = 0;
	    }
    }
	public void printArrays()
	{
	System.out.println("Screws:::"+screwCount);
	System.out.println("Bulbs:::"+bulbCount);
	System.out.println("Stand:::"+standCount);
	System.out.println("Base:::"+baseCount);
	System.out.println("Socket:::"+socketCount);
	System.out.println("No of Lamps:"+lampsCount);
	}
    
     void produceScrew(int machineid){
	synchronized(screwArray){
	if(machineid==1){
	//System.out.println("Abc.."+screwCount);
	    if(screwCount < ArraySize) {
		
		screwArray[screwCount]=1;
		screwArray[(screwCount+1)>=(ArraySize-1)?(ArraySize-1):screwCount+1]=1;
		screwArray[(screwCount+2)>=(ArraySize-1)?(ArraySize-1):screwCount+2]=1;
		screwArray[(screwCount+3)>=(ArraySize-1)?(ArraySize-1):screwCount+3]=1;
		 screwCount+=4;
	    if(screwCount>=ArraySize)
		screwCount=(ArraySize-1);
		printArrays();
	    try {
			screwArray.wait(waitTime);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }
	    }
	   
	    //(screwCount>ArraySize)?ArraySize:screwCount;
	}
	else if(machineid==6 || machineid==7)
	    {
		if(screwCount >= 4)
		    {
			screwArray[screwCount]=0;
			screwArray[screwCount-1]=0;
			screwArray[screwCount-2]=0;
			screwArray[screwCount-3]=0;
			screwCount-=4;
			printArrays();
			screwArray.notifyAll();
		    }
		//	System.out.println("Abc"+screwCount);
		
	    }
		}
    }
    
    
     void produceBase(int machineid){
	synchronized(baseArray){
	if(machineid==2){
	    if(baseCount < ArraySize) {
		
		baseArray[baseCount]=1;
		baseArray[(baseCount+1)>=(ArraySize-1)?(ArraySize-1):baseCount+1]=1;
	     baseCount+=2;
	    if(baseCount>=ArraySize)
		baseCount=(ArraySize-1);
		printArrays();
		    try {
			baseArray.wait(waitTime);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }
   }
	    
	   
	}
	else if(machineid==6 || machineid==7)
	    {
		if(baseCount >= 1)
		    {
			baseArray[baseCount]=0;
			baseCount-=1;
			printArrays();
			baseArray.notifyAll();
		    }
		
	    }}
	
    }
    
     void produceStand(int machineid){
	synchronized(standArray){
	if(machineid==3){
	    if(standCount < ArraySize) {
		standArray[standCount]=1;
		standArray[(standCount+1)>=(ArraySize-1)?(ArraySize-1):standCount+1]=1;
		standArray[(standCount+2)>=(ArraySize-1)?(ArraySize-1):standCount+2]=1;
		standArray[(standCount+3)>=(ArraySize-1)?(ArraySize-1):standCount+3]=1;
		standCount+=4;
	    if(standCount>=ArraySize)
		standCount=(ArraySize-1);
		printArrays();
	    try {
				standArray.wait(waitTime);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }
	    }
	    
	}
	else if(machineid==6 || machineid==7)
	    {
		if(standCount >= 1)
		    {
			standArray[standCount]=0;
			standCount-=1;
			printArrays();
			standArray.notifyAll();
		    }
		
	    }
		}
    }
    
    void produceSocket(int machineid){
	synchronized(socketArray){
	if(machineid==4){
	    if(socketCount < ArraySize) {
		socketArray[socketCount]=1;
		socketArray[(socketCount+1)>=(ArraySize-1)?(ArraySize-1):socketCount+1]=1;
		socketArray[(socketCount+2)>=(ArraySize-1)?(ArraySize-1):socketCount+2]=1;
		socketArray[(socketCount+3)>=(ArraySize-1)?(ArraySize-1):socketCount+3]=1;
		socketArray[(socketCount+4)>=(ArraySize-1)?(ArraySize-1):socketCount+4]=1;
		socketArray[(socketCount+5)>=(ArraySize-1)?(ArraySize-1):socketCount+5]=1;
		socketArray[(socketCount+6)>=(ArraySize-1)?(ArraySize-1):socketCount+6]=1;
		 socketCount+=7;
	    if(socketCount>=ArraySize)
		socketCount=(ArraySize-1);
		printArrays();
	    try {
			socketArray.wait(waitTime);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }
	    }
	   
	}
	else if(machineid==6 || machineid==7)
	    {		
		if(socketCount >= 3)
		    {
			socketArray[socketCount]=0;
			socketArray[socketCount-1]=0;
			socketArray[socketCount-2]=0;
			socketCount-=3;
			printArrays();
			socketArray.notifyAll();
		    }
		
	    }
		}
    }
    
    void produceBulb(int machineid){
	synchronized (bulbArray){
	if(machineid==5){
	    if(bulbCount < ArraySize) {
		bulbArray[bulbCount]=1;
		bulbArray[((bulbCount+1)>=(ArraySize-1))?(ArraySize-1):bulbCount+1]=1;
		bulbArray[((bulbCount+2)>=(ArraySize-1))?(ArraySize-1):bulbCount+2]=1;
		bulbArray[((bulbCount+3)>=(ArraySize-1))?(ArraySize-1):bulbCount+3]=1;
		bulbCount+=4;
	    if(bulbCount>=ArraySize)
		bulbCount=(ArraySize-1);
		printArrays();
			    try {
			bulbArray.wait(waitTime);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }

	    } 
	}
	else if(machineid==6 || machineid==7)
	    {
		if(bulbCount >= 3)
		    {
			bulbArray[bulbCount]=0;
			bulbArray[bulbCount-1]=0;
			bulbArray[bulbCount-2]=0;
			bulbCount-=3;
			printArrays();
			bulbArray.notifyAll();
		    }
		
	    }
		}
    }
    
    public void run() {
	//System.out.println("Machine Id"+machineid);
	if(machineid == 1) {
	 //  System.out.println("pqr");
	    while(screwCount<=ArraySize)
		{
		    produceScrew(machineid);
/*		    try {
			wait(waitTime);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }*/
		}
	}
	
	else if( machineid == 2) {
	    while(baseCount<=ArraySize)
		{
		    produceBase(machineid);
		    
		    /*try {
			//this.wait(450);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }*/
		    
		}
	}
	
	else if( machineid == 3) {
	    while(standCount<=ArraySize)
		{
		    produceStand(machineid);
		    /*try {
			//this.wait(650);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }*/
		    
		}
	}
	
	else if( machineid == 4) {
	    while(socketCount<=ArraySize)
		{
		    produceSocket(machineid);
		    /*try {
			//this.wait(600);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }*/
		    
		}
	}
	
	else if( machineid == 5) {
	    while(bulbCount<=ArraySize)
		{
		    produceBulb(machineid);
		    /*try {
			//this.wait(500);
		    }
		    catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }*/
		    
		}
	}
	else if(machineid==6 || machineid==7){
	while(true){
	try{
	this.sleep(500);
	produceScrew(machineid);
	this.sleep(500);
	produceBase(machineid);
	this.sleep(500);
	produceStand(machineid);
	this.sleep(500);
	produceSocket(machineid);
	this.sleep(500);
	produceBulb(machineid);
	this.sleep(500);
	lampsCount++;}
	catch (  InterruptedException e ) {
			System.err.println("Interrupted!");
		    }
	}}
    }	
    public static void main(String[] args) {
	
	ProducerConsumerTest screw=new ProducerConsumerTest(1);//.start();
	ProducerConsumerTest base=	new ProducerConsumerTest(2);//.start();
	ProducerConsumerTest stand=new ProducerConsumerTest(3);//.start();
	ProducerConsumerTest socket=new ProducerConsumerTest(4);//.start();
	ProducerConsumerTest bulb=new ProducerConsumerTest(5);//.start();
	
	ProducerConsumerTest c1=new ProducerConsumerTest(7);//.start();
	ProducerConsumerTest c2=new ProducerConsumerTest(6);//.start();
	
	screw.start();
	
        base.start();
        stand.start();
        socket.start();
        bulb.start();
	c1.start();
	c2.start();
	
    }
}