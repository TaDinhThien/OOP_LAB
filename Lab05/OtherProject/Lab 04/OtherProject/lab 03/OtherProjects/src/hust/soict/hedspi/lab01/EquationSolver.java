package hust.soict.hedspi.lab01;
import java.util.Scanner;

public class EquationSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose equation type:");
        System.out.println("1 - First degree equation (ax + b = 0)");
        System.out.println("2 - System of two first degree equations");
        System.out.println("3 - Second degree equation (ax^2 + bx + c = 0)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveFirstDegree(scanner);
                break;
            case 2:
                solveSystem(scanner);
                break;
            case 3:
                solveQuadratic(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }

 
    static void solveFirstDegree(Scanner scanner) {
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("Solution: x = " + x);
        }
    }

 
    static void solveSystem(Scanner scanner) {
        System.out.println("Enter coefficients for equation 1 (a11, a12, b1):");
        double a11 = scanner.nextDouble();
        double a12 = scanner.nextDouble();
        double b1 = scanner.nextDouble();

        System.out.println("Enter coefficients for equation 2 (a21, a22, b2):");
        double a21 = scanner.nextDouble();
        double a22 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("Solution: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("Infinite solutions.");
            } else {
                System.out.println("No solution.");
            }
        }
    }

    
    static void solveQuadratic(Scanner scanner) {
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            // If a = 0, it becomes a linear equation
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Infinite solutions.");
                } else {
                    System.out.println("No solution.");
                }
            } else {
                double x = -c / b;
                System.out.println("Linear solution: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Two real roots: x1 = " + x1 + ", x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Double root: x = " + x);
            } else {
                System.out.println("No real roots.");
            }
        }
    }
}
