package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DayAMonth {

    // Array of month names (full and abbreviated forms)
    private static final String[] MONTHS = { 
        "January", "Jan", "February", "Feb", "March", "Mar", 
        "April", "Apr", "May", "June", "Jun", "July", "Jul", 
        "August", "Aug", "September", "Sep", "October", "Oct", 
        "November", "Nov", "December", "Dec" 
    };

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a month: ");
        String monthInput = scan.nextLine().trim();
        int month = getMonthFromInput(monthInput);
        
       
        System.out.print("Enter a year: ");
        int year = scan.nextInt();

        
        if (month == -1 || year < 0) {
            System.out.println("Invalid input.");
        } else {
            int days = getDaysInMonth(month, year);
            System.out.println("Number of days is: " + days);
        }
        
        scan.close();
    }

    //Chuyển input thành valid num
    public static int getMonthFromInput(String input) {
        try {
            int month = Integer.parseInt(input);
            if (month >= 1 && month <= 12) {
                return month;
            }
        } catch (NumberFormatException e) { //ko phải số và sẽ tiếp tục check 
            
        }

        for (int i = 0; i < MONTHS.length; i++) {
            if (MONTHS[i].equalsIgnoreCase(input)) {
                return (i / 2) + 1; 
            }
        }

        return -1;
    }
    
   
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return LeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }

    public static boolean LeapYear(int year) {
    	return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}