import java.util.Scanner;

// Compound Value by Payton Kerby (https://github.com/PMK744).
// 
// This program will calculate the account value after a given number of months.
// The user will be prompted to enter the monthly saving amount, annual interest rate, and the number of months.

public class CompoundValue {
    public static void main(String[] args) {
      // Create a Scanner
      Scanner input = new Scanner(System.in);

      // Prepare the account value
      double accountValue = 0;

      // Request the user to enter the monthly saving amount
      System.out.print("Enter the monthly saving amount: ");
      double monthlySavingAmount = input.nextDouble();

      // Request the user to enter the annual interest rate
      System.out.print("Enter the annual interest rate (decimal): ");
      double monthlyInterestRate = input.nextDouble() / 12;

      // Request the user to enter the number of months
      System.out.print("Enter the number of months: ");
      int months = input.nextInt();


      // Loop through the months to calculate the account value
      for (int i = 0; i < months; i++) {
        // Calculate the account value
        accountValue = (monthlySavingAmount + accountValue) * (1 + monthlyInterestRate);
      }

      // Append nd, rd, or th to the month number
      String monthSuffix = "th";
      if (months % 10 == 1) {
        monthSuffix = "st";
      } else if (months % 10 == 2) {
        monthSuffix = "nd";
      } else if (months % 10 == 3) {
        monthSuffix = "rd";
      }

      // Display the account value
      System.out.println("After the " + months + monthSuffix + " month, the account value is " + accountValue);

      // Garbage collection...
      input.close();
    }
}
