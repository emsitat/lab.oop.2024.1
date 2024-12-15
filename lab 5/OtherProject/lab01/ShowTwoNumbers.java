package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
	public static void main(String[] args){
		String strNum1, strNum2;
		String strNotification = "You've just entered: ";
		
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first number: ","Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(strNum1);
		strNotification += strNum1 + " and ";
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second number: ","Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
        double b = Double.parseDouble(strNum2);
		strNotification += strNum2;

		JOptionPane.showMessageDialog(null,strNotification,
				"Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        double tong = a+b;
        strNotification = "Tong:" + tong;
        JOptionPane.showMessageDialog(null,strNotification,
				"Show result", JOptionPane.INFORMATION_MESSAGE);
        double hieu = a-b;
        strNotification = "Hieu:"   + hieu;
        JOptionPane.showMessageDialog(null,strNotification,
				"Show result", JOptionPane.INFORMATION_MESSAGE);
        double tich = a*b;
        strNotification = "Tich:" + tich;
        JOptionPane.showMessageDialog(null,strNotification,
				"Show result", JOptionPane.INFORMATION_MESSAGE);
        if (b==0){
            strNotification = "cannot devided by 0";}
        else{
            double thuong = a/b;
            strNotification = "Thuong: " + thuong;}
            JOptionPane.showMessageDialog(null,strNotification,
            "Show result", JOptionPane.INFORMATION_MESSAGE);

		System.exit(0);
	}
}