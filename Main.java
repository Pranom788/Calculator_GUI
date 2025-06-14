import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            Operation op = new Operation();
            int choice;
            // helps create a menu and perform operations based on user input
            do 
            { 
                displayMenu();
                choice = sc.nextInt();
                if (choice == 6) 
                {
                    System.out.println("Exiting...");
                    break;
                }
                System.out.print("Enter first number: ");
                int a = sc.nextInt();
                System.out.print("Enter second number: ");
                int b = sc.nextInt();
                try 
                {
                    performOperation(op, choice, a, b);
                } 
                catch (IllegalArgumentException e) 
                {
                    System.out.println("Error: " + e.getMessage());
                }
            } while (choice != 6);
            sc.close();
        }
    }
        public static void displayMenu() 
        {
            System.out.println("\nSelect an operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
        }
        public static void performOperation(Operation op, int choice, int a,int b)
        {
            switch (choice)
            {
                case 1 :
                    System.out.println("Result:" + op.add(a, b));
                    break;
                case 2 :
                    System.out.println("Result: " + op.subtract(a, b));
                    break;
                case 3 :
                    System.out.println("Result: " + op.multiply(a, b));
                    break;
                case 4 :
                    if (b == 0) {
                        throw new IllegalArgumentException("Cannot divide by zero.");
                    }
                    System.out.println("Result: " + op.divide(a, b));
                    break;
            }
        }
    }