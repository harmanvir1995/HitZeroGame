import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
* @author HARMANVIR SINGH (40019114)
* @author SARABPREET SINGH REKHI (40154067)
*/

public class B {
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
			File fout = new File("out_B.txt");
			PrintWriter output = new PrintWriter(fout);
			//Reading the number of first line from the file.
			int numberOfArrays = input.nextInt();
			input.nextLine();
			for(int i=0; i<numberOfArrays; i++) {
				//Reading the second line from the file and splitting and storing in an array.
				String[] inputLine = input.nextLine().split(" ");
				int size = Integer.parseInt(inputLine[0]);
				int start = Integer.parseInt(inputLine[1]);
				int playground[] = new int[size];
				int index=0;
				//Populating the array.
				for(int j=2; j<inputLine.length; j++) {
					playground[index] = Integer.parseInt(inputLine[j]);;
					index++;
				}
				//playground method is called which is a recursive method.
				int decider = playGame(playground, start);
			//	boolean decider = Hit(playground, start);
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
	 * 
	 * @param playground
	 * @param start
	 * @return
	 */
	private static int playGame(int[] playground, int start) {
		Stack <Integer> s = new Stack<Integer>();
		s.push(start);
		boolean visited[] = new boolean[playground.length];
			while(!s.empty()) {
				int index = s.pop();
				//When the index is visited turn it true.
				visited[index] = true;
				int move = playground[index];
				//Exits if the hit zero.
				if(move == 0) {
					return 0;
				}
				//Move right
				if( (index + move) < playground.length ) {
					//we push only if the index is not visited.
					if(!visited[index + move]) {
						s.push(index + move);
					}
				}
				//Move left 
				else if( (index-move) >= 0  ) {
					//we push only if the index is not visited.
					if(!visited[index - move]) {
						s.push(index - move);
					}
				}
			}
		return 1;
	}
}
