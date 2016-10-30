import java.util.Scanner;

public class Matrix {
	static Scanner in = new Scanner(System.in);
	
	static int[][] matrix1 = new int[3][3];     //Create matrix 1
	static int[][] matrix2 = new int[3][3];		//Create matrix 2
	static int[][] matrix3 = new int[3][3];		//Create matrix 3
	
	//Re-define Runnable::run() Method Of thread class for 1st row Multiplication 
	
	static Thread t1 = new Thread(new Runnable() {
		public void run() {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					matrix3[0][j] += matrix1[0][i]*matrix2[i][j];
				}
			}
		}
	});
	
	//Re-define Runnable::run() Method Of thread class for 2nd row Multiplication 
	
	static Thread t2 = new Thread(new Runnable() {
		public void run() {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					matrix3[1][j] += matrix1[1][i]*matrix2[i][j];
				}
			}
		}
	});
	
	//Re-define Runnable::run() Method Of thread class for 3rd row Multiplication 
	
	static Thread t3 = new Thread(new Runnable() {
		public void run() {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					matrix3[2][j] += matrix1[2][i]*matrix2[i][j];
				}
			}
		}
	});
	
	//A method for starting The Threads 
	
    static void doSomething(){
    	t1.start();    //Start Thread 1
    	t2.start();	   //Start Thread 2
    	t3.start();    //Start Thread 3
    }
    
    //Main Method
    
	public static void main(String[] args) {
		
		//Input matrix 1
		
		System.out.println("Enter matrix 1 : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix1[i][j] = in.nextInt();
			}
			
		}
		
		//Input matrix 2
		
		System.out.println("Enter matrix 2 : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix2[i][j] = in.nextInt();
			}
			
		}
		
		//Call Method doSomething() to start the threads 
		
		Matrix.doSomething();
		
		//Here after finishing individual task The threads are join
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Output The Resultant Matrix
		
		System.out.println("The resultant Matrix is : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix3[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
