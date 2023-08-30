import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ScientificCalculator extends JFrame implements ActionListener {
    // GUI Components
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, equalButton, clearButton;
    private JButton sinButton, cosButton, tanButton, logButton;

    // Other Variables
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    ScientificCalculator() {
        // Frame Setup
        setTitle("Scientific Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);

        // Text Field
        textField = new JTextField();
        textField.setBounds(50, 50, 300, 50);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        add(textField);

        // Number Buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 20));
            numberButtons[i].addActionListener(this);
        }

        // Function Buttons
        functionButtons = new JButton[4];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        for (JButton button : functionButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
        }

        // Trigonometric and Log Buttons
        sinButton = new JButton("sin");
        cosButton = new JButton("cos");
        tanButton = new JButton("tan");
        logButton = new JButton("log");
        JButton[] specialButtons = {sinButton, cosButton, tanButton, logButton};
        for (JButton button : specialButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
        }

        // Equal and Clear Buttons
        equalButton = new JButton("=");
        clearButton = new JButton("C");
        JButton[] actionButtons = {equalButton, clearButton};
        for (JButton button : actionButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(this);
        }

        // Button Layout
        int buttonX = 50, buttonY = 150, buttonWidth = 80, buttonHeight = 80;
        int colCount = 0;
        for (int i = 1; i <= 9; i++) {
            numberButtons[i].setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
            add(numberButtons[i]);
            buttonX += buttonWidth + 20;
            colCount++;
            if (colCount == 3) {
                colCount = 0;
                buttonX = 50;
                buttonY += buttonHeight + 20;
            }
        }
        numberButtons[0].setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(numberButtons[0]);

        buttonX += buttonWidth + 20;
        addButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(addButton);
        buttonX += buttonWidth + 20;
        subButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(subButton);
        buttonX += buttonWidth + 20;
        mulButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(mulButton);
        buttonX += buttonWidth + 20;
        divButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(divButton);

        buttonX = 50;
        buttonY += buttonHeight + 20;
        sinButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(sinButton);
        buttonX += buttonWidth + 20;
        cosButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(cosButton);
        buttonX += buttonWidth + 20;
        tanButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(tanButton);
        buttonX += buttonWidth + 20;
        logButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(logButton);

        buttonX = 50;
        buttonY += buttonHeight + 20;
        clearButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(clearButton);
        buttonX += buttonWidth + 20;
        equalButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        add(equalButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
                return;
            }
        }
        if (source == addButton || source == subButton || source == mulButton || source == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = ((JButton) source).getText().charAt(0);
            textField.setText("");
        }
        if (source == sinButton || source == cosButton || source == tanButton || source == logButton) {
            String func = ((JButton) source).getText();
            num1 = Double.parseDouble(textField.getText());
            if (func.equals("sin")) {
                result = Math.sin(num1);
            } else if (func.equals("cos")) {
                result = Math.cos(num1);
            } else if (func.equals("tan")) {
                result = Math.tan(num1);
            } else if (func.equals("log")) {
                result = Math.log(num1);
            }
            textField.setText(String.valueOf(result));
        }
        if (source == equalButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        }
        if (source == clearButton) {
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new ScientificCalculator();
    }
}
