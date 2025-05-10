import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGuesser extends JFrame{
    private JButton startBtn;
    private JTextField guessInput;
    private JButton resBtn;
    private JLabel guesser;
    private JLabel attempt;
    private JPanel panel;
    private JLabel label;
    private JButton enterBtn;
    private NumberGame game;

    public NumberGuesser(){

        guessInput.setText("Enter your guess!");
        guesser.setText("Guess the Number from 1-100 ");
        guessInput.setForeground(Color.black);
        guessInput.setEnabled(false);


        resBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.resetGame();
                attempt.setText("Attempt: 0");
                guessInput.setText("");
                guessInput.requestFocusInWindow();

            }
        });

        guessInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                guessInput.setText("");
                guessInput.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(guessInput.getText().isEmpty()){
                    guessInput.setText("Enter your guess");
                    guessInput.setForeground(new Color(153,153,153));
                }
            }
        });


        enterBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int guess = Integer.parseInt(guessInput.getText());
                    if(guess < 1 || guess > 100){
                        JOptionPane.showMessageDialog(NumberGuesser.this, "Inputs must be between 1 - 100");
                    } else{
                        String res = game.checkGuess(guess);
                        attempt.setText("Attempt: " + game.getAttempts());
                        JOptionPane.showMessageDialog(NumberGuesser.this, res);
                        if(res.equals("You guessed the number!")){
                            System.out.println("Number of attempts: " + game.getAttempts());
                            game.resetGame();
                            attempt.setText("Attempt: 0");
                        }
                    }
                    guessInput.setText("");
                    guessInput.requestFocusInWindow();
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(NumberGuesser.this,"Invalid input! Please enter again.");
                }
                guessInput.setText("");
                guessInput.requestFocusInWindow();
            }
        });


        game = new NumberGame(0,1,100);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessInput.setText("");
                guessInput.setEnabled(true);
                guesser.setSize(100, 100);
                attempt.setText("Attempt: 0");
                guessInput.requestFocusInWindow();
            }
        });
    }



    public static void main(String[] args) {
        NumberGuesser num = new NumberGuesser();
        num.setTitle("Number Guesser");
        num.setContentPane(num.panel);
        num.setSize(500,500);
        num.setVisible(true);
        num.setResizable(false);
        num.setDefaultCloseOperation(EXIT_ON_CLOSE);
        num.getContentPane().setBackground(new Color(176,196,222));

    }
}