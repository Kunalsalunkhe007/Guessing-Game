package loginformswingdemo2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.LineBorder;

public class LoginFormSwingDemo2 
{
    ResultSet rs;
    JLabel lblresult;
    Dialog d1;
    JFrame f, f2, f3, f4;
    String name;
    String pass;
    JTextField user1;
    Font fnt = new Font("Calebri",Font.BOLD,15);

    public void Loginform() 
    {
        //**********************SIGN IN FRAME START******************************//
        f = new JFrame("Guess The Number");
        f.setSize(500, 500);
        f.getContentPane().setBackground(new Color(204, 230, 255));
        f.setLayout(null);
        JLabel lbltitle = new JLabel("LOGIN FORM", JLabel.CENTER);
        f.add(lbltitle);
        lbltitle.setBounds(0, 10, 500, 100);
        lbltitle.setFont(new Font("Arial", 1, 30));

        JLabel lblbusername = new JLabel("UserName", JLabel.LEFT);
        f.add(lblbusername);
        lblbusername.setBounds(70, 110, 150, 30);
        lblbusername.setFont(new Font("SERIF", 1, 24));

        JTextField user = new JTextField();
        f.add(user);
        user.setBounds(280, 110, 150, 25);

        JLabel lblpassword = new JLabel("Password", JLabel.LEFT);
        f.add(lblpassword);
        lblpassword.setBounds(70, 150, 150, 30);
        lblpassword.setFont(new Font("SERIF", 1, 24));

        JPasswordField pass = new JPasswordField();
        pass.setEchoChar('#');
        pass.setBounds(280, 150, 150, 25);
        f.add(pass);

        lblresult = new JLabel("", JLabel.CENTER);
        f.add(lblresult);
        lblresult.setBounds(0, 400, 500, 25);
        lblresult.setFont(new Font("SERIF", 1, 18));

        JButton btnsubmit = new JButton("Submit");
        f.add(btnsubmit);

        btnsubmit.setBounds(280, 200, 150, 50);

        btnsubmit.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ae) 
            {
                try 
                {
                    String name = user.getText();
                    char pa[] = pass.getPassword();
                    String pass = String.valueOf(pa);
                    String url = "jdbc:ucanaccess://C:\\Users\\RCPP\\Documents\\UserDatabase1.accdb";
                    Connection cn = DriverManager.getConnection(url);

                    Statement st = cn.createStatement();
                    String str = "select* from Users";
                    ResultSet rs = st.executeQuery(str);

                    while (rs.next()) 
                    {

 /*************/        if (name.equals(rs.getString("username")) && pass.equals(rs.getString("password"))) {
                            lblresult.setText("Login SuccessFully");
                            //Frequency_calculator();
                            if(ae.getSource()==btnsubmit)
                            {
                                f.setVisible(false);
                                f2.setVisible(false);
                                f3.setVisible(false);
                                
                                new GuessNumber().setVisible(true);
                            }

                        } else if (!name.equals(rs.getString("username")) && pass.equals(rs.getString("password"))) {

                            lblresult.setText("username is wrong!");

                        } else if (name.equals(rs.getString("username")) && !pass.equals(rs.getString("password"))) {
                            lblresult.setText("Password is wrong!");

                        } else if (pass.length() <= 0 && name.length() <= 0) {
                            lblresult.setText("Please Enter Username And Password");
                        } else if (!name.equals(rs.getString("username")) & !pass.equals(rs.getString("password"))) {
                            lblresult.setText("username and Password is wrong!");

                        }

                    }

                    st.close();
                    cn.close();

                } catch (Exception e) 
                {
                    System.out.println(e);
                }

            }

        });

        JButton btnclear = new JButton("Clear");
        f.add(btnclear);

        btnclear.setBounds(70, 200, 150, 50);
        btnclear.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                pass.setText("");

                user.setText("");
                lblresult.setText("");
            }

        });

        //
        JButton btnexit = new JButton("Exit");
        f.add(btnexit);

        btnexit.setBounds(70, 280, 150, 50);

        btnexit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                f.dispose();
            }

        });
// for color need used get contentpane
// getContentPane().setBackground(Color.yellow);
        JButton btn = new JButton("Forgot");
        f.add(btn);

        btn.setBounds(280, 280, 150, 50);
        
        //**********************SIGN IN FRAME ENDS******************************//

        //**********************FORGOT FRAME START******************************//
        d1 = new Dialog(f, true);

        d1.setLayout(new FlowLayout());
        d1.setBackground(new Color(204, 230, 255));
        JLabel lb = new JLabel("username");
        d1.add(lb);
        JTextField txtxf = new JTextField(20);
        d1.add(txtxf);
        JLabel lb2 = new JLabel("dob    ");
        d1.add(lb2);
        JTextField txtx = new JTextField(20);
        d1.add(txtx);

        Button b1 = new Button("Get Password");
        d1.add(b1);
        d1.setSize(703, 94);
        JLabel lbl3 = new JLabel();
        d1.add(lbl3);
        d1.setLocationRelativeTo(f);
        b1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                try {
                    String name = txtxf.getText();

                    String dob = txtx.getText();
                    String url = "jdbc:ucanaccess://C:\\Users\\RCPP\\Documents\\UserDatabase1.accdb";
                    Connection cn = DriverManager.getConnection(url);

                    Statement st = cn.createStatement();
                    String str = "select* from Users";
                    ResultSet rs = st.executeQuery(str);

                    while (rs.next()) 
                    {

                        if (name.equals(rs.getString("username")) && dob.equals(rs.getString("dob"))) 
                        {
                            JOptionPane.showMessageDialog(d1, "Password:"+rs.getString("Password"));
                            lbl3.setText("" + rs.getString("Password"));

                        } else 
                        {
                            JOptionPane.showMessageDialog(d1, "Unverified");
                            lbl3.setText("unverified");
                        }

                    }
                    st.close();
                    cn.close();

                } catch (Exception e) 
                {
                    System.out.println(e);
                }

            }
        });
        btn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                d1.setVisible(true);
            }
        });

        d1.addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent we) 
            {
                d1.dispose();

            }
        });
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
//**********************FORGOT FRAME ENDS******************************//
    
    //**********************MAIN FRAME START******************************//
    public void LoginFormSwingDemo() 
    {
        f2 = new JFrame("Guess The Number Game");
        f2.setSize(500, 500);
        f2.getContentPane().setBackground(new Color(204, 230, 255));
        f2.setLayout(null);
        
        JLabel lbltitle = new JLabel("LOGIN FORM", JLabel.CENTER);
        f2.add(lbltitle);
        lbltitle.setBounds(-15, 20, 500, 100);
        lbltitle.setFont(new Font("Arial", 1, 30));
        
        JButton btnsingup = new JButton("SignUP");
        btnsingup.setFont(fnt);
        btnsingup.setBorder(new LineBorder(Color.BLACK,2));
        f2.add(btnsingup);
        btnsingup.setBounds(110, 200, 250, 50);
        
        JButton btnsingin = new JButton("SignIN");
        btnsingin.setFont(fnt);
        btnsingin.setBorder(new LineBorder(Color.BLACK,2));
        f2.add(btnsingin);
        btnsingin.setBounds(110, 300, 250, 50);
        
        f2.setLocationRelativeTo(null);
        f2.setVisible(true);

        btnsingin.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                f2.dispose();
                Loginform();
            }
        });

        btnsingup.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                f2.dispose();
                Singup();
            }
        });
    }
    JPasswordField pass1;
    JTextField dobtxt1;
//**********************MAIN FRAME ENDS*****************************//
    
    //**********************SIGN UP FRAME START******************************//
    public void Singup() 
    {

        f3 = new JFrame();
        f3.setSize(500, 500);
        f3.setLayout(null);
        f3.getContentPane().setBackground(new Color(204, 230, 255));
        f3.setLocationRelativeTo(null);
        JLabel lbltitle = new JLabel("REGISTRATION FORM", JLabel.CENTER);
        f3.add(lbltitle);
        lbltitle.setBounds(0, 20, 500, 50);
        lbltitle.setFont(new Font("Arial", 1, 30));

        JLabel lblbusername = new JLabel("UserName", JLabel.LEFT);
        f3.add(lblbusername);
        lblbusername.setBounds(70, 100, 150, 30);
        lblbusername.setFont(new Font("SERIF", 1, 24));

        user1 = new JTextField();
        f3.add(user1);
        user1.setBounds(280, 100, 150, 25);

        JLabel lblpassword = new JLabel("Password", JLabel.LEFT);
        f3.add(lblpassword);
        lblpassword.setBounds(70, 150, 150, 30);
        lblpassword.setFont(new Font("SERIF", 1, 24));

        pass1 = new JPasswordField();
        pass1.setEchoChar('#');
        pass1.setBounds(280, 150, 150, 25);
        f3.add(pass1);
        
        JLabel lbldob = new JLabel("DOB Year", JLabel.LEFT);
        f3.add(lbldob);
        lbldob.setBounds(70, 200, 150, 30);
        lbldob.setFont(new Font("SERIF", 1, 24));
        
        dobtxt1 = new JTextField();
        f3.add(dobtxt1);
        dobtxt1.setBounds(280, 200, 150, 25);
        
        JButton submitbtn = new JButton("Submit");
        f3.add(submitbtn);
        submitbtn.setBounds(170, 300, 150, 50);
        submitbtn.setFont(new Font("SERIF", 1, 24));
        f3.setVisible(true);

        submitbtn.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                f3.dispose();
                LoginFormSwingDemo();
                try {
                    char pa[] = pass1.getPassword();
                    String user = user1.getText();
                    String pass = String.valueOf(pa);
                    String dob = dobtxt1.getText();
                    String url = "jdbc:ucanaccess://C:\\Users\\RCPP\\Documents\\UserDatabase1.accdb";
                    String query = "INSERT INTO Users (username,password,dob)VALUES( ? ,? ,?)";
                    Connection cn = DriverManager.getConnection(url);
                    PreparedStatement st2 = cn.prepareStatement(query);
                    ResultSet rs;
                    Statement st = cn.createStatement();
                    st2.setString(1, user);
                    st2.setString(2, pass);
                    st2.setString(3, dob);

                    st2.execute();

                    System.out.println("" + user);

                    System.out.println("" + pass);

                    System.out.println("" + dob);

                    st.close();

                    cn.close();
                } catch (Exception e) 
                {
                    System.out.println(e);

                }
            }
        });
    }
    //**********************SIGN UP FRAME ENDS******************************//
    
//    public void Frequency_calculator() 
//    {
//        f4 = new JFrame();
//        f4.setSize(500, 700);
//        f4.setLayout(null);
//        f4.setLocationRelativeTo(null);
//        JLabel lbltitle = new JLabel("REGISTRATION FORM", JLabel.CENTER);
//        f4.add(lbltitle);
//        lbltitle.setBounds(0, 20, 500, 100);
//        lbltitle.setFont(new Font("Arial", 1, 30));
//        String str = "picture perfect";
//        f4.setVisible(true);
//        int[] freq = new int[str.length()];
//        int i, j;
//
//        //Converts given string into character array    
//        char string[] = str.toCharArray();
//
//        for (i = 0; i < str.length(); i++) {
//            freq[i] = 1;
//            for (j = i + 1; j < str.length(); j++) {
//                if (string[i] == string[j]) {
//                    freq[i]++;
//
//                    //Set string[j] to 0 to avoid printing visited character    
//                    string[j] = '0';
//                }
//            }
//        }
//
//        //Displays the each character and their corresponding frequency    
//        System.out.println("Characters and their corresponding frequencies");
//        for (i = 0; i < freq.length; i++) {
//            if (string[i] != ' ' && string[i] != '0') {
//                System.out.println(string[i] + "-" + freq[i]);
//            }
//        }
//
//    }

    public static void main(String[] args) 
    {
        LoginFormSwingDemo2 a = new LoginFormSwingDemo2();
        a.LoginFormSwingDemo();
    }

}
