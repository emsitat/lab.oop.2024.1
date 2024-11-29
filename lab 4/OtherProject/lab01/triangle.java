package hust.soict.dsai.lab01;
import java.util.Scanner;

public class triangle {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the height of the triangle: ");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++){
            System.out.println(" ".repeat(2*n - i) + "*".repeat(2*i + 1));
        }
    }
}
