import java.util.Scanner;

// PrintCalender by Payton Kerby (https://github.com/PMK744).
// 
// This program prints a calender for a given month and year.
// The program prompts the user to enter the year and month, and then prints the calender for the given month and year.

public class PrintCalender {
    /**
     * Scanner object to read input from the user.
    */
    public static final Scanner input = new Scanner(System.in);

    /**
     * Main method to take input from the user and print the calender.
     * @param args
     */
    public static void main(String[] args) throws Exception {
        // Prompt the user to enter the year, and read the input from the user.
        System.out.print("Enter full year (e.g., 2001): ");
        int year = PrintCalender.input.nextInt();

        // Prompt the user to enter the month, and read the input from the user.
        // We will used a signed int8 instead of a signed int32 to save memory.
        System.out.print("Enter month as a number between 1 and 12: ");
        byte month = PrintCalender.input.nextByte();

        // Get the month title.
        String monthTitle = PrintCalender.getMonthTitle(year, month);

        // Get the start day of the week for the first day of the month.
        int startDay = PrintCalender.getStartDay(year, month);

        // Get the number of days in the month.
        int numberOfDaysInMonth = PrintCalender.getNumberOfDaysInMonth(year, month);

        // Print the calendar.
        PrintCalender.printMonth(year, month, monthTitle, startDay, numberOfDaysInMonth);
    }

    /**
     * Print the calendar for the given month.
     * @param year Year
     * @param month Month
     * @param monthTitle Month title
     * @param startDay Start day of the week for the first day of the month
     * @param numberOfDaysInMonth Number of days in the month
     */
    public static void printMonth(int year, byte month, String monthTitle, int startDay, int numberOfDaysInMonth) {
        // Print the month title.
        System.out.println("\n" + monthTitle);

        // Print the days of the week.
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Print the leading spaces before the first day of the month.
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        // Print the days of the month.
        for (int i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%3d ", i);

            // Move to the next line if the day is the last day of the week.
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        // Move to the next line after printing the calendar.
        System.out.println();
    }

    /**
     * Get the month title.
     * @param year Year
     * @param month Month
     * @return Month title
     */
    public static String getMonthTitle(int year, byte month) {
        // Create a string builder to store the month title.
        StringBuilder monthTitle = new StringBuilder();

        // Append the month name to the month title.
        switch (month) {
            case 1:
                monthTitle.append("January");
                break;
            case 2:
                monthTitle.append("February");
                break;
            case 3:
                monthTitle.append("March");
                break;
            case 4:
                monthTitle.append("April");
                break;
            case 5:
                monthTitle.append("May");
                break;
            case 6:
                monthTitle.append("June");
                break;
            case 7:
                monthTitle.append("July");
                break;
            case 8:
                monthTitle.append("August");
                break;
            case 9:
                monthTitle.append("September");
                break;
            case 10:
                monthTitle.append("October");
                break;
            case 11:
                monthTitle.append("November");
                break;
            case 12:
                monthTitle.append("December");
                break;
            default:
                throw new IllegalArgumentException("Invalid month. Month should be between 1 and 12.");
        }

        // Append the year to the month title.
        monthTitle.append(" ").append(year);

        // Return the month title.
        return monthTitle.toString();
    }

    /**
     * Get the start day of the week for the first day of the month.
     * @param year Year
     * @param month Month
     * @return Start day of the week for the first day of the month
     */
    public static int getStartDay(int year, int month) {
		final int START_DAY_FOR_JAN_1_1800 = 3;

	    // Get total number of days from 1/1/1800 to month/1/year
	    int totalNumberOfDays = getTotalNumberOfDays(year, month);

	    // Return the start day for month/1/year
	    return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /**
     * Get the total number of days since January 1, 1800
     * @param year Year
     * @param month Month
     * @return Total number of days
     */
    public static int getTotalNumberOfDays(int year, int month) {
    	int total = 0;

    	// Get the total days from 1800 to 1/1/year
    	for (int i = 1800; i < year; i++)

        // Use ternary operator to add days in year i
        total = isLeapYear(i)
            ? total + 366
            : total + 365;
    
    	// Add days from Jan to the month prior to the calendar month
    	for (int i = 1; i < month; i++)
    	total = total + getNumberOfDaysInMonth(year, i);

    	return total;
    }
	
    /**
     * Get the number of days in a month
     * @param year Year
     * @param month Month
     * @return Number of days in a month
    */
    public static int getNumberOfDaysInMonth(int year, int month) {
        
	    if (month == 1 || month == 3 || month == 5 || month == 7 ||
	    month == 8 || month == 10 || month == 12)
	    return 31;
        
	    if (month == 4 || month == 6 || month == 9 || month == 11)
	    return 30;
        
	    if (month == 2) return isLeapYear(year) ? 29 : 28;

	    return 0; // If month is incorrect
    }
 
    /**
     * Determine if it is a leap year
    */
    public static boolean isLeapYear(int year) {
 	    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
