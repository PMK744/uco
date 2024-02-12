import java.util.Scanner;

// Taxable Income Calculator by Payton Kerby (https://github.com/PMK744).

// This program calculates the tax for a given taxable income and filing status.

// The tax rates are as follows:
// 10% Single ( $0 - $8,350 ) Married Filing Jointly ( $0 - $16,700 ) Married Filing Separately ( $0 - $8,350 ) Head of Household ( $0 - $11,950 )
// 15% Single ( $8,351 - $33,950 ) Married Filing Jointly ( $16,701 - $67,900 ) Married Filing Separately ( $8,351 - $33,950 ) Head of Household ( $11,951 - $45,500 )
// 25% Single ( $33,951 - $82,250 ) Married Filing Jointly ( $67,901 - $137,050 ) Married Filing Separately ( $33,951 - $68,525 ) Head of Household ( $45,501 - $117,450 )
// 28% Single ( $82,251 - $171,550 ) Married Filing Jointly ( $137,051 - $208,850 ) Married Filing Separately ( $68,526 - $104,425 ) Head of Household ( $117,451 - $190,200 )
// 33% Single ( $171,551 - $372,950 ) Married Filing Jointly ( $208,851 - $372,950 ) Married Filing Separately ( $104,426 - $186,475 ) Head of Household ( $190,201 - $372,950 )
// 35% Single ( $372,951+ ) Married Filing Jointly ( $372,951+ ) Married Filing Separately ( $186,476+ ) Head of Household ( $372,951+ )

public class TaxableIncome {
   @SuppressWarnings("resource")
   public static void main(String[] args) throws Exception {
      // Construct a Scanner object
      Scanner scanner = new Scanner(System.in);

      // Log the user to enter the filing status
      System.out.print("Enter your filing status (0-single filer, 1-married jointly, 2-married separately, 3-head of household): ");

      // Read the user input
      int status = scanner.nextInt();

      // Check if the status is valid
      if (status < 0 || status > 3) {
        throw new Exception("Invalid status: " + status + ". Please enter a valid status.");
      }

      // Log the user to enter the taxable income
      // And read the user input
      System.out.print("Enter the taxable income: $");
      double income = scanner.nextDouble();

      // Calculate the tax
      switch (status) {
        default:
          System.out.println("Error: Invalid status");
          break;

        case 0: {
          double tax = 0;
          if (income <= 8350) {
            tax = income * 0.10;
          } else if (income <= 33950) {
            tax = 8350 * 0.10 + (income - 8350) * 0.15;
          } else if (income <= 82250) {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
          } else if (income <= 171550) {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
          } else if (income <= 372950) {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
          } else {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
          }
          System.out.println("Tax is " + (int)(tax * 100) / 100.0);
          break;
        }

        case 1: {
          double tax = 0;
          if (income <= 16700) {
            tax = income * 0.10;
          } else if (income <= 67900) {
            tax = 16700 * 0.10 + (income - 16700) * 0.15;
          } else if (income <= 137050) {
            tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (income - 67900) * 0.25;
          } else if (income <= 208850) {
            tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (income - 137050) * 0.28;
          } else if (income <= 372950) {
            tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (income - 208850) * 0.33;
          } else {
            tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + (137050 - 67900) * 0.25 + (208850 - 137050) * 0.28 + (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
          }
          System.out.println("Tax is " + (int)(tax * 100) / 100.0);
          break;
        }

        case 2: {
          double tax = 0;
          if (income <= 8350) {
            tax = income * 0.10;
          } else if (income <= 33950) {
            tax = 8350 * 0.10 + (income - 8350) * 0.15;
          } else if (income <= 68525) {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
          } else if (income <= 104425) {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (income - 68525) * 0.28;
          } else if (income <= 186475) {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (income - 104425) * 0.33;
          } else {
            tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + (186475 - 104425) * 0.33 + (income - 186475) * 0.35;
          }
          System.out.println("Tax is " + (int)(tax * 100) / 100.0);
          break;
        }

        case 3: {
          double tax = 0;
          if (income <= 11950) {
            tax = income * 0.10;
          } else if (income <= 45500) {
            tax = 11950 * 0.10 + (income - 11950) * 0.15;
          } else if (income <= 117450) {
            tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (income - 45500) * 0.25;
          } else if (income <= 190200) {
            tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (income - 117450) * 0.28;
          } else if (income <= 372950) {
            tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (income - 190200) * 0.33;
          } else {
            tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + (372950 - 190200) * 0.33 + (income - 372950) * 0.35;
          }
          System.out.println("Tax is " + (int)(tax * 100) / 100.0);
          break;
        }
      }

      // Garbage collection...
      scanner.close();
   }
}
