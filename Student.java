
/**
 * @author Sinalo Ngolozana (217211151)
 */

package za.ac.cput.student_platform;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Student implements ActionListener {
         
         public static void main(String[] args) {
                  Student student = new Student();
         }
    
         JFrame frame;
         String[] gender = new String[] {"Male", "Female"};
         JLabel label1 = new JLabel("NAME: ");
         JLabel label2 = new JLabel("SURNAME: ");
         JLabel label3 = new JLabel("GENDER: ");
         JLabel label4 = new JLabel("CITY/TOWN: ");
         JLabel label5 = new JLabel("CELL NO.: ");
         JLabel label6 = new JLabel("STUDENT EMAIL: ");
         JLabel label7 = new JLabel("PASSWORD.: ");
         JTextField text1 = new JTextField();
         JTextField text2 = new JTextField();         
         JComboBox<String> box = new JComboBox<>(gender);
         JTextField text3 = new JTextField();
         JTextField text4 = new JTextField();
         JTextField text5 = new JTextField();
         JTextField text6 = new JTextField();
         JButton button1 = new JButton("RESET");
         JButton button2 = new JButton("SAVE");
         JButton button3 = new JButton("EXIT");
         
         Student () {
                  createWindow();
                  setLocationAndSize();
                  addComponentsToFrame();
                  actionEvent();
         }
         
         public void createWindow() {
                  frame = new JFrame();
                  frame.setTitle("STUDENT FORM:");
                  frame.setBounds(40, 40, 380, 600);
                  frame.getContentPane().setBackground(Color.white);
                  frame.getContentPane().setLayout(null);
                  frame.setVisible(true);
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  frame.setResizable(false);
         }
         
         public void setLocationAndSize() {
                  label1.setBounds(20, 20, 40, 70);
                  label2.setBounds(20, 70, 80, 70);
                  label3.setBounds(20, 120, 100, 70);
                  label4.setBounds(20, 170, 100, 70);
                  label5.setBounds(20, 220, 140, 70);
                  label6.setBounds(20, 270, 100, 70);
                  label7.setBounds(20, 320, 100, 70);
                  text1.setBounds(180, 43, 165, 23);
                  text2.setBounds(180, 93, 165, 23);
                  box.setBounds(180, 143, 165, 23);
                  text3.setBounds(180, 193, 165, 23);
                  text4.setBounds(180, 243, 165, 23);
                  text5.setBounds(180, 293, 165, 23);
                  text6.setBounds(180, 343, 165, 23);
                  button1.setBounds(10, 400, 100, 35);
                  button2.setBounds(130, 400, 100, 35);
                  button3.setBounds(250, 400, 100, 35);
         }
         
         public void addComponentsToFrame() {
                  frame.add(label1);
                  frame.add(label2);
                  frame.add(label3);
                  frame.add(label4);
                  frame.add(label5);
                  frame.add(label6);
                  frame.add(label7);
                  frame.add(text1);
                  frame.add(text2);
                  frame.add(box, BorderLayout.CENTER);
                  frame.add(text3);
                  frame.add(text4);
                  frame.add(text5);
                  frame.add(text6);
                  frame.add(button1);
                  frame.add(button2);
                  frame.add(button3);
         }
         
         public void actionEvent() {
                  button1.addActionListener(this);
                  button2.addActionListener(this);
                  button3.addActionListener(this);
         }
         
         @Override
         public void actionPerformed(ActionEvent action) {
                
                  if(action.getSource() == button2) {
                           try {
                                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:1527/Student","root","root");
                                    PreparedStatement statement = connection.prepareStatement("instert into student values(?,?,?,?,?,?,?)");
                                    statement.setString(1, text1.getText());
                                    statement.setString(2, text2.getText());
                                    statement.setString(3, box.getSelectedItem().toString());
                                    statement.setString(4, text3.getText());
                                    statement.setString(5, text4.getText());
                                    statement.setString(6, text5.getText());
                                    statement.setString(7, text6.getText());
                                    
                                    if (text6.getText().equalsIgnoreCase("12345")) {
                                             statement.executeUpdate();
                                             JOptionPane.showMessageDialog(null, "Data Successfully Registered!");
                                    }
                                    else {
                                             JOptionPane.showMessageDialog(null, "Password Invalid!");
                                    }
                           }
                           
                           catch(SQLException e1) {
                                    e1.printStackTrace();
                           }
                  }
                  
                  if (action.getSource() == button1) {
                           text1.setText(" ");
                           text2.setText(" ");
                           box.setSelectedItem(" ");
                           text3.setText(" ");
                           text4.setText(" ");
                           text5.setText(" ");
                           text6.setText(" ");
                  }
                  
                  if (action.getSource() == button3) {
                           System.exit(1);
                  }
         }
}