import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
* @author HARMANVIR SINGH (40019114)
* @author SARABPREET SINGH REKHI (40154067)
*/

public class A {
	public static int counter = 0;
	static boolean visited[] = null;
	public static void main(String[] args) {
		//Reading input File.
		readInputFile();
	}
	
	/**
	 * This method reads the in.txt file present in the project folder 
	 * and then populates the array which acts as the playground for the game.
	 */
	public static void readInputFile() {
		try {
			System.out.println("Starting the game...");
			File f = new File("in.txt");
			Scanner input = new Scanner(f);
			File fout = new File("out_A.txt");
			PrintWriter output = new PrintWriter(fout);
			System.out.println("reading files....");
			//Reading the number of first line from the file.
			int numberOfArrays = input.nextInt();
			input.nextLine();
			for(int i=0; i<numberOfArrays; i++) {
				if(i>0) {
					System.out.println("Reading array " + i);
				}
				//Reading the second line from the file and splitting and storing in an array.
				String[] inputLine = input.nextLine().split(" ");
				int size = Integer.parseInt(inputLine[0]);
				int start = Integer.parseInt(inputLine[1]);
				int playground[] = new int[size];
				visited = new boolean[playground.length];
				int index=0;
				//Populating the array.
				for(int j=2; j<inputLine.length; j++) {
					playground[index] = Integer.parseInt(inputLine[j]);;
					index++;
				}
				//playground method is called which is a recursive method.
				int decider = playGame(playground, start);
				output.println(decider);
			}
			System.out.println("Output generated on the file...");
			input.close();
			output.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File not found...!!");
			System.exit(0);
		}
	}

	/**
	 * Using tail recursion this method decides whether the player will will or not.
	 * @param playground 	array which acts as the ground. 
	 * @param index			it is basically the pointer to the element in an array.
	 * @return				returns 0 if player reaches the destination.
	 * 						returns -1 if index out of bound or more than 500 repetition. 
	 */
	private static int playGame(int playground[], int index) { 
		if(playground[index] == 0) {
			return 0;
		}
		int move = playground[index];
		visited[index]=true;
	
		//If it is a negative element we take the absolute value.
		if(move<0) {
			move = (-1)*move;
		}
		//We move right only if we are inside the playground i.e. not out of bound.
		if((move + index) < playground.length) {
			//move right
			if(!visited[index + move]) {
				return playGame(playground, index+move);
			}
		}
		
		//We move left if we cannot move to right.
		if((index-move) >=0 ) {
			//move left
			if(!visited[index - move]) {
				return playGame(playground, index - move);
			}
		}
		
		//Index Out Of Bound
		return 1;
	}
}


