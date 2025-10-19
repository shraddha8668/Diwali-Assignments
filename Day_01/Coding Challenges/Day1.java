//1. You are given an array of strings. Your task is to determine the length of the 
//longest string in the array. 
public class Day1 {

	public static void main(String[] args) {
		String [] arr = {"ram", "shyam", "mahesh", "sita","priyank"};
		lengthLongestString(arr);


	}
	
	public static void lengthLongestString(String[] arr)
	{
		int max=0;
		for(String name :arr) {
			if(name.length()>max) {
				max=name.length();
			}
		}
		System.out.println("Length of longest string is "+max);
	}

}
