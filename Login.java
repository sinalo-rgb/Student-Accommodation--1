
/**
 * @author Sinalo
 */

package za.ac.cput.student_platform;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
         
         public static void main(String[] a) {
                  Login login = new Login();
                  login.setTitle("LOGIN FORM:");
                  login.setBounds(10, 10, 370, 600);
                  login.getContentPane().setBackground(Color.white);
                  login.setVisible(true);
                  login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  login.setResizable(false);
         }
         
         Container container = getContentPane();
         JLabel label1 = new JLabel("USERNAME:");
         JLabel label2 = new JLabel("PASSWORD:");
         JTextField text1 = new JTextField();
         JPasswordField text2 = new JPasswordField();
         JButton reset = new JButton("RESET");
         JButton login = new JButton("LOGIN");
         JButton exit = new JButton("EXIT");
         JCheckBox box = new JCheckBox("Show Password");
         
         Login () {
                  setLayoutManager();
                  setLocationAndSize();
                  setComponentsToContainer();
                  addActionEvent();
         }
         
         public void setLayoutManager() {
                  container.setLayout(null);
         }
         
         public void setLocationAndSize() {
                  label1.setBounds(50, 150, 100, 30);
                  label2.setBounds(50, 200, 100, 30);
                  text1.setBounds(150, 150, 150, 30);
                  text2.setBounds(150, 220, 150, 30);
                  box.setBounds(150, 250, 150, 30);
                  reset.setBounds(10, 300, 100, 30);
                  login.setBounds(125, 300, 100, 30);
                  exit.setBounds(240, 300, 100, 30);
         }
         
         public void setComponentsToContainer() {
                  container.add(label1);
                  container.add(label2);
                  container.add(text1);
                  container.add(text2);
                  container.add(box);
                  container.add(reset);
                  container.add(login);
                  container.add(exit);
         }
         
         public void addActionEvent() {
                  reset.addActionListener(this);
                  login.addActionListener(this);
                  exit.addActionListener(this);
                  box.addActionListener(this);
         }
         
         @Override
         public void actionPerformed(ActionEvent action) {
                  
                  if (action.getSource() == box) {
                           if(box.isSelected()) {
                                    text2.setEchoChar((char)0);
                           }
                           else {
                                    text2.setEchoChar('*');
                           }
                  }
                  
                  if (action.getSource() == reset) {
                           text1.setText(" ");
                           text2.setText(" ");
                  }
                  
                  if (action.getSource() == login) {
                           String username;
                           String password;
                           username = text1.getText();
                           password = text2.getText();
                           
                           if (username.equalsIgnoreCase("sinalo") && password.equalsIgnoreCase("12345")) {
                                    JOptionPane.showMessageDialog(this, "You Have Successfully Logged In!");
                                    this.dispose();
                                    Student student = new Student();
                                    student.frame.setVisible(true);
                           }
                           else {
                                    JOptionPane.showMessageDialog(this, "Your Username/Password Is Incorrect, Please Try Again!");
                           }
                  }
                  
                  if (action.getSource() == exit) {
                           System.exit(1);
                  }
         }
}