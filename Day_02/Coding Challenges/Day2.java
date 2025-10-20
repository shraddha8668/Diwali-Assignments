import java.util.Scanner;

public class Day2 {
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter an integer: ");
	        int n = sc.nextInt();

	        int reversed = reverseNumber(n);
	        System.out.println("Reversed number: " + reversed);
	    }

	    public static int reverseNumber(int n) {
	        int rev = 0;

	        while (n != 0) {
	            int rem = n % 10;
	            rev = rev * 10 + rem;
	            n /= 10;
	        }

	        return rev;
	    }
	}

	