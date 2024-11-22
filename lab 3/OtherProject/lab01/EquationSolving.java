package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;

public class EquationSolving {

    // Show message
    private static void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }


    public static void solveLinearEquation(double a, double b) {
        if (a == 0) {
            if (b == 0) {
                showMessage("Phuong trinh vo so nghiem", "Ket qua");
            } else {
                showMessage("Phuong trinh vo nghiem", "Ket qua");
            }
        } else {
            double x = -b / a;
            showMessage("Nghiem cua phuong trinh la  = " + x, "Ket qua");
        }
    }

    //ptr bac nhat 2 an
    public static void solveLinearSystem(double a1, double b1, double c1, double a2, double b2, double c2) {
        double delta1 = a1 * b2 - a2 * b1;
        double delta2 = c1 * b2 - c2 * b1;
        double delta3 = a1 * c2 - a2 * c1;

        if (delta1 == 0) {
            if (delta2 == 0 && delta3 == 0) {
                showMessage("phuong trinh vo so nghiem", "Result");
            } else {
                showMessage("The system has no solution.", "Result");
            }
        } else {
            double x = delta2 / delta1;
            double y = delta3 / delta1;
            showMessage("phuong trinh co 1 nghiem:\nx = " + x + "\ny = " + y, "Result");
        }
    }


    // ptr bac 2
    public static void solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            showMessage("day khong phai ptr bac 2.", "Error");
            return;
        }

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            showMessage("phuong trinh co 2 nghiem:\nx1 = " + x1 + "\nx2 = " + x2, "Result");
        } else if (delta == 0) {
            double x = -b / (2 * a);
            showMessage("phuong trinh co 1 nghiem:\nx = " + x, "Result");
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-delta) / (2 * a);
            showMessage("phuong trinh co 2 nghiem phuc:\nx1 = " + realPart + " + " + imaginaryPart + "i\nx2 = " + realPart + " - " + imaginaryPart + "i", "Result");
        }
    }



    // nhap input
    private static double getDoubleInput(String message) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, message, "Input", JOptionPane.INFORMATION_MESSAGE);
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                showMessage("Invalid input. Please enter a valid number.", "Error");
            }
        }
    }

    public static void main(String[] args) {
        String n = JOptionPane.showInputDialog(null,
                "Hay chon loai phuong trinh muon giai:\n1. Bac nhat 1 an\n2. He bac nhat 2 an\n3. Bac hai 1 an",
                "Loai phuong trinh", JOptionPane.INFORMATION_MESSAGE);

        switch (n) {
            case "1": // Linear equation
                double a = getDoubleInput("Hay nhap he so a cua phuong trinh:");
                double b = getDoubleInput("Hay nhap he so b cua phuong trinh:");
                solveLinearEquation(a, b);
                break;

            case "2": // Linear system
                double a1 = getDoubleInput("Hay nhap he so a1 cua phuong trinh:");
                double b1 = getDoubleInput("Hay nhap he so b1 cua phuong trinh:");
                double c1 = getDoubleInput("Hay nhap he so c1 cua phuong trinh:");
                double a2 = getDoubleInput("Hay nhap he so a2 cua phuong trinh:");
                double b2 = getDoubleInput("Hay nhap he so b2 cua phuong trinh:");
                double c2 = getDoubleInput("Hay nhap he so c2 cua phuong trinh:");
                solveLinearSystem(a1, b1, c1, a2, b2, c2);
                break;

            case "3": // Quadratic equation
                double a3 = getDoubleInput("Hay nhap he so a cua phuong trinh:");
                double b3 = getDoubleInput("Hay nhap he so b cua phuong trinh:");
                double c3 = getDoubleInput("Hay nhap he so c cua phuong trinh:");
                solveQuadraticEquation(a3, b3, c3);
                break;

            default:
                showMessage("Invalid selection. Please select a valid equation type.", "Error");
                break;
        }

        System.exit(0);
    }
}

