
public class TheoryPart2 {
	public static void main(String args[]) {
		int data[] = {123,73,39,12,14,9,113,93,203,22,25,10};
		pairModulo(data, 3);
	}
	
	//
	public static void pairModulo(int data[], int remainder) {
		for(int i=0; i<data.length-1; i++) {
			for(int j=i+1; j<data.length; j++) {
				if(data[i] % data[j] == remainder) {
					System.out.println("Indices " + i + " & "+ j 
							+ " with values " + data[i] + " & " + data[j]);
				}
			}
		}
	}
}
