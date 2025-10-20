
public class QuickSortString {
	
	    private static void swap(String[] arr, int i, int j) {
	        String temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }

	 
	    private static int partition(String[] arr, int low, int high) {
	        String pivot = arr[high]; 
	        int i = low - 1;

	        for (int j = low; j < high; j++) {
	            
	            if (arr[j].compareToIgnoreCase(pivot) <= 0) {
	                i++;
	                swap(arr, i, j);
	            }
	        }
	        swap(arr, i + 1, high);
	        return i + 1;
	    }

	  
	    private static void quickSort(String[] arr, int low, int high) {
	        if (low < high) {
	            int pi = partition(arr, low, high);
	            quickSort(arr, low, pi - 1);
	            quickSort(arr, pi + 1, high);
	        }
	    }

	    private static void display(String[] arr) {
	        for (String s : arr) {
	            System.out.print(s + " ");
	        }
	        System.out.println();
	    }


	    public static void main(String[] args) {
	        String[] arr = { "Banana", "apple", "Mango", "cherry", "orange", "grape" };

	        System.out.println("Before sorting:");
	        display(arr);

	        quickSort(arr, 0, arr.length - 1);

	        System.out.println("\nAfter sorting:");
	        display(arr);
	    }
	}


