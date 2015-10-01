public class Hanoi 
{

	static String mainArray[][] = new String [8][3];

	static boolean UsedOrUnused[][] = new boolean[8][3];


	public void initialise()
	{

		for(int i=0;i<6;i++)
		{

			for(int j=1;j<3;j++)
			{

				mainArray[i][j]="0";

				UsedOrUnused[i][j]=false;

			}			

		}	

		for(int i=0;i<3;i++)
		{
			mainArray[6][i]="-";
			mainArray[7][i]=Integer.toString(i);
			UsedOrUnused[6][i]=false;
			UsedOrUnused[7][i]=false;
		}

		for(int i=0;i<6;i++)
		{
			mainArray[i][0]=Integer.toString(i+1);
			UsedOrUnused[i][0]=true;
		}
         

	}   

  
	public static void makeMove(String pos1,String pos2,int n1){

    	int p1 = Integer.parseInt(pos1);

	int p2 = Integer.parseInt(pos2);

	String n  = Integer.toString(n1);





  	for(int i=0;i<6;i++)
	{

   

  		if (mainArray[i][p1].equals(n))
		{

     

 			 for(int j=5;j>=0;j--)
			 {


				  if(UsedOrUnused[j][p2]==false)
					{

   

					  mainArray[i][p1]="0";

 					 UsedOrUnused[i][p1]=false;

 					 mainArray[j][p2]=n;

 					 UsedOrUnused[j][p2]=true;

 					 DefaultMainArray(mainArray);

 					 break;

   

  					}	

   

  			}	

  		}

  	}



	}



public static void DefaultMainArray(String h[][]){

for(int i=0;i<8;i++){

for(int j=0;j<3;j++){

System.out.print(mainArray[i][j]);

}

System.out.println();

}

System.out.println();

}


public static void main(String[] args) {

String poleStart="0";
String poleOver="1";
String poleEnd="2"; 

Hanoi h =new Hanoi();

h.initialise();


  move(6,poleStart,poleOver,poleEnd);

}


public static void move(int  n, String poleStart, String poleOver, String poleEnd){


//	System.out.println("n--->"+n+"->PS-->"+poleStart+"--poleOver-->"+poleOver+"-->poleEnd-->"+poleEnd);

if(n==1){

System.out.println("move disk 1 from "+poleStart+" to "+poleEnd);

makeMove(poleStart,poleEnd,n);

}

else{



move(n-1,poleStart,poleEnd,poleOver);


System.out.println("move disk "+n+" from "+poleStart+" to "+poleEnd);

makeMove(poleStart,poleEnd,n);


move(n-1,poleOver,poleStart,poleEnd);

//	makeMove(poleOver,poleEnd,n);

}
}



}
