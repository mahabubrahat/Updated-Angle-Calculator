import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;

public class AngleCal {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AngleCal window = new AngleCal();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public AngleCal() {
        initialize();
    }

    // UPDATED parseInput method - supports +, -, *, /
    private double parseInput(String input) throws NumberFormatException {
        input = input.trim();

        if (input.contains("+")) {
            String[] parts = input.split("\\+");
            if(parts.length != 2) throw new NumberFormatException("Invalid format");
            return Double.parseDouble(parts[0].trim()) + Double.parseDouble(parts[1].trim());
        } 
        else if (input.contains("-")) {
            String[] parts = input.split("-");
            if(parts.length != 2) throw new NumberFormatException("Invalid format");
            return Double.parseDouble(parts[0].trim()) - Double.parseDouble(parts[1].trim());
        } 
        else if (input.contains("*")) {
            String[] parts = input.split("\\*");
            if(parts.length != 2) throw new NumberFormatException("Invalid format");
            return Double.parseDouble(parts[0].trim()) * Double.parseDouble(parts[1].trim());
        } 
        else if (input.contains("/")) {
            String[] parts = input.split("/");
            if(parts.length != 2) throw new NumberFormatException("Invalid format");
            double numerator = Double.parseDouble(parts[0].trim());
            double denominator = Double.parseDouble(parts[1].trim());
            if (denominator == 0) throw new NumberFormatException("Division by zero");
            return numerator / denominator;
        } 
        else {
            return Double.parseDouble(input);
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
        frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 12));
        frame.setBounds(100, 100, 329, 378);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblAngleCalculator = new JLabel("Angle Calculator");
        lblAngleCalculator.setFont(new Font("Calibri Light", Font.BOLD, 17));
        lblAngleCalculator.setBounds(89, 11, 197, 23);
        frame.getContentPane().add(lblAngleCalculator);

        textField = new JTextField();
        textField.setForeground(SystemColor.textHighlightText);
        textField.setBackground(SystemColor.textInactiveText);
        textField.setBounds(10, 45, 293, 32);
        textField.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblFrom = new JLabel("From");
        lblFrom.setFont(new Font("Arial", Font.BOLD, 15));
        lblFrom.setBounds(10, 98, 46, 14);
        frame.getContentPane().add(lblFrom);

        textField_2 = new JTextField();
        textField_2.setBackground(SystemColor.inactiveCaption);
        textField_2.setFont(new Font("Arial", Font.BOLD, 15));
        textField_2.setBounds(50, 93, 99, 24);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblTo = new JLabel("To");
        lblTo.setFont(new Font("Arial", Font.BOLD, 15));
        lblTo.setBounds(10, 179, 46, 14);
        frame.getContentPane().add(lblTo);

        textField_3 = new JTextField();
        textField_3.setBackground(SystemColor.inactiveCaption);
        textField_3.setFont(new Font("Arial", Font.BOLD, 15));
        textField_3.setBounds(35, 174, 115, 24);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setForeground(SystemColor.textHighlightText);
        textField_1.setBackground(SystemColor.textInactiveText);
        textField_1.setBounds(10, 123, 293, 32);
        textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton = new JButton("Degree to Radian");
        btnNewButton.setBackground(new Color(255, 165, 0));
        btnNewButton.setBounds(10, 204, 139, 32);
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton.addActionListener(e -> {
            try {
                double d = parseInput(textField.getText());
                double result = (d * Math.PI) / 180;
                textField_1.setText(String.format("%.5f", result));
                textField_2.setText("Degrees");
                textField_3.setText("Radians");
            } catch (NumberFormatException ex) {
                textField_1.setText("Invalid input");
            }
        });
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Degree to Gradian");
        btnNewButton_1.setBackground(new Color(255, 165, 0));
        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_1.setBounds(159, 204, 147, 32);
        btnNewButton_1.addActionListener(e -> {
            try {
                double d = parseInput(textField.getText());
                double result = d * 1.111111;
                textField_1.setText(String.format("%.5f", result));
                textField_2.setText("Degrees");
                textField_3.setText("Gradians");
            } catch (NumberFormatException ex) {
                textField_1.setText("Invalid input");
            }
        });
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Radian to Degree");
        btnNewButton_2.setBackground(new Color(255, 165, 0));
        btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 12));
        btnNewButton_2.setBounds(10, 247, 139, 32);
        btnNewButton_2.addActionListener(e -> {
            try {
                double d = parseInput(textField.getText());
                double result = (d * 180) / Math.PI;
                textField_1.setText(String.format("%.5f", result));
                textField_2.setText("Radians");
                textField_3.setText("Degrees");
            } catch (NumberFormatException ex) {
                textField_1.setText("Invalid input");
            }
        });
        frame.getContentPane().add(btnNewButton_2);

        JButton btnRadianToGradian = new JButton("Radian to Gradian");
        btnRadianToGradian.setBackground(new Color(255, 165, 0));
        btnRadianToGradian.setFont(new Font("Arial", Font.BOLD, 12));
        btnRadianToGradian.setBounds(156, 247, 147, 32);
        btnRadianToGradian.addActionListener(e -> {
            try {
                double d = parseInput(textField.getText());
                double result = d * 63.661977;
                textField_1.setText(String.format("%.5f", result));
                textField_2.setText("Radians");
                textField_3.setText("Gradians");
            } catch (NumberFormatException ex) {
                textField_1.setText("Invalid input");
            }
        });
        frame.getContentPane().add(btnRadianToGradian);

        JButton btnGradianToDegree = new JButton("Gradian to Degree");
        btnGradianToDegree.setBackground(new Color(255, 165, 0));
        btnGradianToDegree.setFont(new Font("Arial", Font.BOLD, 12));
        btnGradianToDegree.setBounds(10, 290, 139, 38);
        btnGradianToDegree.addActionListener(e -> {
            try {
                double d = parseInput(textField.getText());
                double result = d / 1.111111;
                textField_1.setText(String.format("%.5f", result));
                textField_2.setText("Gradians");
                textField_3.setText("Degrees");
            } catch (NumberFormatException ex) {
                textField_1.setText("Invalid input");
            }
        });
        frame.getContentPane().add(btnGradianToDegree);

        JButton btnGradianToRadian = new JButton("Gradian to Radian");
        btnGradianToRadian.setBackground(new Color(255, 165, 0));
        btnGradianToRadian.setFont(new Font("Arial", Font.BOLD, 12));
        btnGradianToRadian.setBounds(156, 290, 147, 38);
        btnGradianToRadian.addActionListener(e -> {
            try {
                double d = parseInput(textField.getText());
                double result = d / 63.661977;
                textField_1.setText(String.format("%.5f", result));
                textField_2.setText("Gradians");
                textField_3.setText("Radians");
            } catch (NumberFormatException ex) {
                textField_1.setText("Invalid input");
            }
        });
        frame.getContentPane().add(btnGradianToRadian);

        JButton btnNewButton_3 = new JButton("CE");
        btnNewButton_3.setBackground(new Color(255, 165, 0));
        btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 16));
        btnNewButton_3.setBounds(159, 165, 144, 28);
        btnNewButton_3.addActionListener(e -> {
            textField.setText("");
            textField_1.setText("");
            textField_2.setText("");
            textField_3.setText("");
        });
        frame.getContentPane().add(btnNewButton_3);
    }
}
