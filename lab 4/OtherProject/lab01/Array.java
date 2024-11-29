package hust.soict.dsai.lab01;
import java.util.Scanner;
public class Array {
	 public static void main(String[] args){
	        Scanner scan = new Scanner(System.in);

	        System.out.print("Enter the size of the array: ");
	        int n = scan.nextInt();
	        int[] array = new int[n];

	        //Buble sort 
	        for (int i = 0; i < n; i++) {
	            array[i] = scan.nextInt();
	        }

	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (array[j] > array[j + 1]) {
	                    // Hoán đổi
	                    int temp = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = temp;
	                }
	            }
	        }

	        // Chuyển  mảng thành chuỗi
	        StringBuilder result = new StringBuilder("[");
	        for (int i = 0; i < n; i++) {
	            result.append(array[i]);
	            if (i < n - 1) {
	                result.append(", ");
	            }
	        }
	        result.append("]");

	        // tính sum và trung bình 
	        int sum = 0;
	        for (int num : array) {
	            sum += num;
	        }
	        double average = (double) sum / n;

	        System.out.println("Array in sorted order is: " + result);
	        System.out.println("Sum of all element: " +  sum);
	        System.out.println("The average number is " + average);

	        scan.close();
	 }
}
