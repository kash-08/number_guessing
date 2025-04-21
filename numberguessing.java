package number_guessing;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class numberguessing {

    private int generatedNumber;
    private JFrame frame;
    private JTextField guessField;
    private JTextArea messageArea;

    public numberguessing() {
        // Generate number between 1 and 100
        Random random = new Random();
        generatedNumber = random.nextInt(1,100);

        // Create GUI components
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel instructionLabel = new JLabel("Guess a number between 1 and 100:");
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        guessField = new JTextField();
        JButton guessButton = new JButton("Guess");

        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setLineWrap(true);
        messageArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(messageArea);
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        // Add components
        topPanel.add(instructionLabel, BorderLayout.NORTH);
        topPanel.add(guessField, BorderLayout.CENTER);
        topPanel.add(guessButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void handleGuess() {
        try {
            int userInput = Integer.parseInt(guessField.getText());

            if (userInput > generatedNumber) {
                messageArea.append("Too high! Try a lower number.\n");
            } else if (userInput < generatedNumber) {
                messageArea.append("Too low! Try a higher number.\n");
            } else {
                messageArea.append("Congratulations! You guessed it!\n");
                messageArea.append("The correct number was: " + generatedNumber + "\n");
                guessField.setEditable(false);
            }
            guessField.setText(""); 
        } catch (NumberFormatException ex) {
            messageArea.append("Please enter a valid number!\n");
        }
    }

    public static void main(String[] args) {
        new numberguessing();
    }
}
