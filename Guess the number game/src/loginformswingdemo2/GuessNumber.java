package loginformswingdemo2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuessNumber extends JFrame
{
    JTextField guess, bestscore, totalguess;
    ButtonListener buttonListener;
    ButtonListener2 buttonListener2;
    ButtonListener3 buttonListener3;
    JLabel inputlabel,guesslabel,trylabel,bestscorelabel,totalguesslabel,imglabel;
    int ran=(int) (Math.random()*100);
    int count=0;
    
    public GuessNumber()
    {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
 
        //*************Guess the Number Label********************//
        guesslabel = new JLabel("Guess the Number ?");
        guesslabel.setForeground(Color.RED);
        guesslabel.setFont(new Font("times new roman",Font.BOLD,24));
        guesslabel.setSize(270,20);
        guesslabel.setLocation(70,70);
        
        //*************Enter the Number Label********************//
        inputlabel = new JLabel("Enter a number between 1-100");
        inputlabel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        inputlabel.setSize(270,20);
        inputlabel.setLocation(70,90);
        
        //*************Try to Guess it Label********************//
        trylabel = new JLabel("Try and guess it !");
        trylabel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        trylabel.setSize(270,20);
        trylabel.setLocation(100,160);
        
        //*************Textfield********************//
        guess = new JTextField(10);
        guess.setSize(50,30);
        guess.setLocation(140,120);
        
        //*************Best Score Textfield********************//
        bestscore = new JTextField(10);
        bestscore.setSize(30,20);
        bestscore.setLocation(10,10);
        
        //*************Best Score Label********************//
        bestscorelabel = new JLabel("Best Score");
        bestscorelabel.setToolTipText("This is a place where you can see your best score :)");
        bestscorelabel.setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        bestscorelabel.setSize(270,20);
        bestscorelabel.setLocation(50,10);
        
        //*************Total Guess TextField********************//
        totalguess = new JTextField(10);
        totalguess.setSize(30,20);
        totalguess.setLocation(10,40);
        
        //*************Number of Guess Label********************//
        totalguesslabel = new JLabel("Number of Guesses");
        totalguesslabel .setFont(new Font("Comic Sans MS",Font.PLAIN,14));
        totalguesslabel.setToolTipText("Here you can see that, How many 'Guesses' you maid");
        totalguesslabel.setSize(270,20);
        totalguesslabel.setLocation(50,40);
 
        //*************Thinking Person Image********************//
        imglabel = new JLabel("");
        imglabel.setIcon(new ImageIcon("C:\\Users\\salun\\OneDrive\\Desktop\\NetBeans Projects\\GuessNumber\\images\\2.png"));
        imglabel.setBounds(280,30,500,350);
 
        //*************Guess Button********************//
        JButton guessbutton =new JButton("Guess");
        guessbutton.setSize(100,30);
        guessbutton.setLocation(110,190);
        guessbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener = new ButtonListener();
        guessbutton.addActionListener(buttonListener);
        
        //*************Give UP Button********************//
        JButton giveupbutton = new JButton("Give up!");
        giveupbutton.setSize(100,30);
        giveupbutton.setLocation(50,240);
        giveupbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener2 = new ButtonListener2();
        giveupbutton.addActionListener(buttonListener2);
        
        //*************Play Again Button********************//
        JButton playagainbutton = new JButton("Play Again!");
        playagainbutton.setSize(100,30);
        playagainbutton.setLocation(170,240);
        playagainbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener3 = new ButtonListener3();
        playagainbutton.addActionListener(buttonListener3);
        
        //*************Exit Button********************//
        ImageIcon exit = new ImageIcon("C:\\Users\\salun\\OneDrive\\Desktop\\NetBeans Projects\\GuessNumber\\images\\exit.png");
        JButton ex = new JButton(exit);
        ex.setBounds(50,300,40,40);
        ex.setBorderPainted(false);
        ex.setToolTipText("Click here for EXIT!");
        ex.setBackground(new Color(204, 230, 255));
        add(ex);
        ex.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                int result = JOptionPane.showConfirmDialog(guess, "Are you sure! You wanna EXIT!","Swing Tester",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                
                if(result == JOptionPane.YES_OPTION)
                {
                    dispose();
                }else if(result == JOptionPane.NO_OPTION)
                {
                    
                }
            }
        });
        
        //*************Contact US Button********************//
        ImageIcon contact = new ImageIcon("C:\\Users\\salun\\OneDrive\\Desktop\\NetBeans Projects\\GuessNumber\\images\\msg.png");
        JButton con = new JButton(contact);
        con.setBounds(120,300,40,40);
        con.setBorderPainted(false);
        con.setToolTipText("Click here for Contact US!");
        con.setBackground(new Color(204, 230, 255));
        add(con);
        con.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                JOptionPane.showMessageDialog(guess, "Contact US: \nMail: cpp.pokepa002@gmail.com");
            }
        });
        
        //*************Terms and Conditions Button********************//
        ImageIcon terms = new ImageIcon("C:\\Users\\salun\\OneDrive\\Desktop\\NetBeans Projects\\GuessNumber\\images\\tc.png");
        JButton tc = new JButton(terms);
        tc.setBounds(190,300,40,40);
        tc.setBorderPainted(false);
        tc.setToolTipText("Click here for read Terms&Conditions!");
        tc.setBackground(new Color(204, 230, 255));
        add(tc);
        
        //*************Add All Elements********************//
        c.add(bestscorelabel);
        c.add(totalguesslabel);
        c.add(trylabel);
        c.add(imglabel);
        c.add(guesslabel);
        c.add(inputlabel);
        c.add(guess);
        c.add(bestscore);
        c.add(totalguess);
        c.add(guessbutton);
        c.add(giveupbutton);
        c.add(playagainbutton);
 
        bestscore.setEditable(false);
        totalguess.setEditable(false);
        
        //*************Frame Property********************//
        setTitle("GUESS THE NUMBER");
        setSize(630,450);
        getContentPane().setBackground(new Color(204, 230, 255));
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //*************Backend Listeners********************//
    private class ButtonListener implements ActionListener
    {
        int bestScore=100;
        public void actionPerformed(ActionEvent e)
    {
        int a = Integer.parseInt(guess.getText());
        count=count+1;
        if(a<ran)
        {
            trylabel.setText(a+" is low, try again!!");
        }
        else if(a>ran)
        {
            trylabel.setText(a+" is high, try again!!");
        }
        else
        {
            trylabel.setText("Your guess is correct, You win!!");
        if(count<bestScore)
        {
            bestScore=count;
            bestscore.setText(bestScore+"");
        }
        else 
        {
            bestscore.setText("" + bestScore);
        }
            guess.setEditable(false);
        }
            guess.requestFocus();
            guess.selectAll();
            totalguess.setText(count+"");
    }
}
        private class ButtonListener2 implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
        {
            totalguess.setText("");
            trylabel.setText("The correct answer is "+ran+"!!");
            guess.setText("");
            guess.setEditable(false);
        }
    }
        private class ButtonListener3 implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                ran = (int) (Math.random()*100);
                guess.setText("");
                totalguess.setText("");
                trylabel.setText("Try and guess it !");
                totalguess.setText("");
                count=0;
                guess.setEditable(true);
                guess.requestFocus();
            }
        }
        
       
        //*************Main Function********************//
        public static void main(String[] args)
        {
            new GuessNumber();
        }
}


