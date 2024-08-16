
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class StartGame extends JFrame implements ActionListener {
    JLabel header,inp,display,remainingAttemptsLabel;
    JTextField input;
    JButton check,restart;

    int remainingAttempts = 3;
    int randomNumber = generateRandomNumber();


    public StartGame(){
        System.out.println("Random number is: "+randomNumber);

        header = new JLabel("                              Guess the Number from 1 to 100!!");
        header.setBounds(0,20,500,30);
        header.setOpaque(true);
        header.setBackground(Color.CYAN);

        inp = new JLabel(" Enter a number: ");
        inp.setBounds(60,60,120,30);
        inp.setOpaque(true);
        inp.setBackground(Color.PINK);

        remainingAttemptsLabel = new JLabel(" "+ remainingAttempts + " Attempts left");
        remainingAttemptsLabel.setBounds(60,90,300,40);
        remainingAttemptsLabel.setOpaque(true);
        remainingAttemptsLabel.setBackground(Color.LIGHT_GRAY);

        input = new JTextField();
        input.setBounds(190,60,90,30);

        check = new JButton("Check");
        check.setBounds(110,140,100,30);
        check.setBackground(Color.GREEN);
        check.addActionListener(this);

        restart = new JButton("Restart");
        restart.setBounds(220,140,100,30);
        restart.setBackground(Color.ORANGE);
        restart.addActionListener(this);

        display = new JLabel();
        display.setBounds(80,180,200,30);

        add(header);
        add(inp);
        add(display);
        add(remainingAttemptsLabel);
        add(input);
        add(check);
        add(restart);

        setTitle("Guess the Number");
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(400,350);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static int generateRandomNumber(){
        int num;
        Random random = new Random();
        num = random.nextInt(101);
        return num;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == check){
            display.setOpaque(true);
            display.setBackground(Color.YELLOW);
            if(remainingAttempts>0) {
                int userInput = Integer.parseInt(input.getText());
                if (userInput == randomNumber) {
                    display.setText("Congrats, You Won!!");
                    return;
                }
                else if (userInput < randomNumber) {
                    display.setText("Your guess is lesser!!");
                }
                else {
                    display.setText("Your guess is greater!!");
                }
                remainingAttempts--;
                remainingAttemptsLabel.setText(" " + remainingAttempts + " Attempts left");
            }
            if(remainingAttempts==0){
                remainingAttemptsLabel.setText(" You lost the game, the correct number is: "+randomNumber);

            }
        }
        if(e.getSource() == restart){
            input.setText("");
            display.setOpaque(false);
            display.setText("");
            remainingAttempts = 3;
            remainingAttemptsLabel.setText(remainingAttempts + " Attempts left");
            randomNumber = generateRandomNumber();
            System.out.println("Game Restarted.... the newly generated random number is : "+randomNumber);
        }
    }
}
