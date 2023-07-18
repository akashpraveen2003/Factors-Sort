package factors_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
	 You are given an array A of N elements. Sort the given array in increasing order of number of distinct factors of each element, 
	 i.e., element having the least number of factors should be the first to be displayed and the number having highest number of factors should be the last one. 
	 If 2 elements have same number of factors, then number with less value should come first.
	
	Note: You cannot use any extra space

		Input 1:
		
		A = [6, 8, 9]
		
		Input 2:
		
		A = [2, 4, 7]

		Output 1:
		
		[9, 6, 8]
		
		Output 2:
		
		[2, 7, 4]
		
 */
public class Factors_Sort {
	private static void factors_sort(String[] array) 
	{
		Arrays.sort(array,new Comparator<String>()			// Comparator object
        { 
            public int compare(String o1, String o2) 			
            {
            //	System.out.println(o1+" " +factors(o1)+" "+o2+" "+factors(o2));			Just debugging !!!!
            	if(factors(o1)>factors(o2))					// Check if o1 has more factors
				{
					return 1;
				}
				else if(factors(o1)<factors(o2))			// Check if o1 has less factors
				{
					return -1;
				}
				else										// Both o1 and o2 have equal number of factors
				{
					return o1.compareTo(o2);				// Return lexographically (ascending ) Eg: 2 (1,2) and 3 (1,3)  have 2 factors
				}											// So, we compare them and it returns -1, so dont swap cause it is in ascending, so we return -1
            }

			private int factors(String o1) {				// returns the number of factors
				int number=Integer.parseInt(o1);
			 	int count=0;
				for(int i=1;i*i<=number;i++)
				{
					if(number%i==0)
					{
						if(number/i==i)
						{
							count++;
						}
						else
						{
							count+=2;
						}
					}
				}
				return count;
			}
         });
		System.out.println(Arrays.toString(array));
	}
	public static void main(String[] args) {			// This is gonna be tough...
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		scanner.nextLine();
		String array[]=new String[n];					// implementing in string would be easier
		for(int i=0;i<n;i++)
		{
			array[i]=scanner.nextLine();
		}
		factors_sort(array);
	}
}
