package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class loginPage extends JFrame implements ActionListener{

    JTextField inputUsername;
    //JTextField inputPassword;
    JPasswordField inputPassword;
    JButton btnSubmit;
    JButton btnRegister;
    //JFrame this;


    public loginPage(){ //creiamo il costruttore
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(600,500);
        this.setTitle("Login");
        ImageIcon icon = new ImageIcon("C:/Users/bouzi/OneDrive/Desktop/Programs/WebSite/Image/iconaLogin3.png");
        this.setIconImage(icon.getImage());

        JLabel scrittaLogin = new JLabel();
        scrittaLogin.setText("Login");
        scrittaLogin.setFont(new Font("Arial", Font.BOLD, 40));
        scrittaLogin.setForeground(new Color(46, 46, 46));
        scrittaLogin.setHorizontalTextPosition(JLabel.CENTER);
        scrittaLogin.setBounds(230, 65, 300, 100);

        //AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);

        JLabel scrittaUsername = new JLabel();
        scrittaUsername.setText("Username:");
        scrittaUsername.setFont(new Font("Arial", Font.PLAIN, 20));
        scrittaUsername.setForeground(Color.black);
        scrittaUsername.setBounds(110, 180, 100, 30);

        inputUsername = new JTextField();
        //inputUsername.setText("Username");
        inputUsername.setPreferredSize(new Dimension(250, 30));
        inputUsername.setFont(new Font("Arial", Font.PLAIN, 15));
        inputUsername.setBounds(220, 180, 250, 30);
        //inputEmail.setBorder(brdr);

        JLabel scrittaPassword = new JLabel();
        scrittaPassword.setText("Password: ");
        scrittaPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        scrittaPassword.setForeground(Color.black);
        scrittaPassword.setBounds(110, 250, 250, 30);

        inputPassword = new JPasswordField();
        //inputPassword.setText("Password");
        inputPassword.setPreferredSize(new Dimension(250, 30));
        inputPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        inputPassword.setBounds(220, 250, 250, 30);


        btnRegister = new JButton();
        btnRegister.setText("Register");
        btnRegister.setFocusable(false);
        btnRegister.setFont(new Font("Arial", Font.PLAIN, 15));
        btnRegister.setBounds(160,330,120,40);
        btnRegister.addActionListener(this);
        //btnRegister.setBackground(new Color(164, 171, 166));
        //btnRegister.setBorder(BorderFactory.createLineBorder(Color.black));

        btnSubmit = new JButton();
        btnSubmit.setText("Submit");
        btnSubmit.setFocusable(false);
        btnSubmit.setFont(new Font("Arial", Font.PLAIN, 15));
        btnSubmit.setBounds(310, 330, 120, 40);
        btnSubmit.addActionListener(this);
        //btnSubmit.setBackground(new Color(164, 171, 166));
        //btnSubmit.setBorder(BorderFactory.createLineBorder(Color.black));

        this.add(scrittaLogin); //we add the label in our frames
        this.add(inputUsername);
        this.add(scrittaUsername);
        this.add(scrittaPassword);
        this.add(inputPassword);
        this.add(btnRegister);
        this.add(btnSubmit);
        //this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSubmit) {
            String username = inputUsername.getText();
            String password = inputPassword.getText();

            System.out.println("Username: "+username);
            System.out.println("Password: "+password);

            if(username.equals("") || password.equals("")) {
                //System.out.println("Input username empty");
                JOptionPane.showMessageDialog(null, "Inserire dati nell'input", "Input vuoto", JOptionPane.WARNING_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(null, "Il login e' avvenuto con successo", "Successo login", JOptionPane.PLAIN_MESSAGE);
                try {
                    FileWriter scriviDati = new FileWriter("C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Progetti\\src\\prog\\dataBase.txt");
                    scriviDati.write("Username: "+username+"\nPassword: "+password);
                    scriviDati.close();
                } catch(IOException a) {
                    a.printStackTrace();
                }
                System.exit(0);
            }
        }

		/*
		if(e.getSource() == btnRegister) {
			this.dispose();
			registrationForm regisForm = new registrationForm();
		}
		*/

    }

}
