import java.util.*;

public class ADT {
	static ArrayList<Integer> list=new ArrayList<Integer>();
	static Stack<Integer> S=new Stack<Integer>();
	
	static public boolean Hit(int []A, int start)
	{	
		Boolean flag= false;
		S.push(start);
		list.add(start);
		do {
			System.out.println("Hello"); 
			int x=(int) S.pop();
			if(A[x]==0)
			{
				flag=true;
				break;
			}
			if(x+A[x]<A.length && !list.contains(x+A[x]))
			{

				S.push(x+A[x]);
				list.add(x+A[x]);
			}
			if(x-A[x]>=0 && !list.contains(x-A[x]))
			{
				S.push(x-A[x]);
				list.add(x-A[x]);
			}
			
		}while(!S.isEmpty());
		return flag;
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of elements you want in array:");
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []A=new int[n];
		Boolean flag=null;
		int i=0;
		System.out.println("Enter the elements of array.(Last element should be zero),");
		do {
			A[i]=input.nextInt();
			i++;
		}while(A[i-1]!=0);
		
		System.out.println("Enter starting position");
		int start;
		start=input.nextInt();
		if(start>i-2)
		{
			System.out.println("Invalid start position");
		}
		else
		{
			
			flag=Hit(A,start);
			System.out.println(flag);

		}
		input.close();
		
	}

}
