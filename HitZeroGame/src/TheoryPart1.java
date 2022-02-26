import java.util.Stack;

public class TheoryPart1 {
	
	public static void main(String args[]) {
		int data[] = {22, 9, 61,61, 61, 21, 0, 9, 9, 9, 9, 35, 81,81, 9, 5, 5};
		System.out.println("***********************************************************");
		System.out.println("\t\t\t Without Stack");
		System.out.println("***********************************************************");
		duplicateCounter(data);
		int values[] = new int[data.length];
		int repeats[] = new int[data.length];
		int indexes[] = new int[data.length];
		
	  duplicateStackCounter(data, values, repeats, indexes);
		
		for(int i=0; i<data.length; i++) {
			if(repeats[i] != 0) {
				System.out.println("Value "+values[i] + " is repeated " + repeats[i] 
						+ " times starting at index "+ indexes[i]);
			}
			
		}
	
	}
	
	//Using Stack
	public static void duplicateStackCounter(int givenArray[], int values[], int repeats[], int indexes[] ) {
		int j = 0, counter = 1;
		Stack<Integer> s = new Stack<Integer>();
		for(int i=0; i<givenArray.length; ) {
			values[j] = givenArray[i]; counter = 1;
			if(s.isEmpty()) {			
				s.push(givenArray[i]);
				i++; continue;
			}
			indexes[j] = i-1;
			while( !s.isEmpty() && i<givenArray.length && givenArray[i] == s.peek()) {
				s.push(givenArray[i]);
				counter++;
				i++;
			}
			if( !s.isEmpty() && i<givenArray.length && givenArray[i] != s.peek()) {
				s.pop();
				s.push(givenArray[i]);
				i++;
			}
			if(counter > 1) {
				repeats[j] = counter;
				j++;
			}
		}
	}
	
	//Without using stack and queue. 
	public static void duplicateCounter(int givenArray[]){
	    int counter = 1;
	    int repeatIndex = 1;
	    boolean flag = false;
	    for(int i=0; i<givenArray.length-1; ){
	        counter = 1;
	        repeatIndex = i; 
	        while(givenArray[i] == givenArray[i+1]){
	            counter++;
	            i++;
	            //To make sure that we do not throw an arrayIndexOutOfBound Exception. 
	            if(i >= givenArray.length-1){
	                flag = true;
	                break;
	            }
	        }
	        //Print only those whose values occur more than 1.
	        if(counter > 1){
	            System.out.println("Value " + givenArray[i] 
	            + " is repeated " + counter + " times starting at index " + repeatIndex );
	        }
	        i++;
	        //if i gets larger than length of array loop breaks.
	        if(flag){
	            break;
	        }
	    }
	}
}
