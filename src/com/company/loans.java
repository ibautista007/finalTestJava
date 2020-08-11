/*
 * Created by JFormDesigner on Tue Aug 11 12:29:25 PDT 2020
 */

package com.company;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.util.Vector;

/**
 * @author Isaias
 */
public class loans extends JFrame {

    //Global varibles
    PreparedStatement query;
    Connection con1;
    String clientID,clientname, type;
    double amount = 0;
    int y = 0;
    String indice;


    public loans() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
        // TODO add your code here

        if(validation() == true){
            LoanP values = new LoanP(clientID,clientname,amount,y,type);
                Class.forName("com.mysql.jdbc.Driver");

                //local connection with WAMP
                con1= DriverManager.getConnection("jdbc:mysql://localhost:3308/loan","root","");
                //connection to Submit
                //con1= DriverManager.getConnection("jdbc:mysql://localhost/loan","root","");


                if(e.getSource()==button1) {
                    query = con1.prepareStatement("SELECT * FROM loantable where clientno = ? ");
                    query.setString(1,values.getClientNo());
                    ResultSet rs = query.executeQuery();
                    if(rs.isBeforeFirst()){          //res.isBeforeFirst() is true if the cursor

                        JOptionPane.showMessageDialog(null,"The customer ID already existed");
                        clean_textbox();
                        return;
                    }

                    query = con1.prepareStatement("INSERT INTO loantable (clientno, clientname, loanamount, years, loantype) VALUES (?,?,?,?,?);");

                    //set parameters
                    query.setString(1, values.getClientNo());
                    query.setString(2, values.getClientName());
                    query.setDouble(3, values.getLoanA());
                    query.setInt(4, values.getYears());
                    query.setString(5, values.getTypeLoan());

                    query.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Record added");
                    clean_textbox();
                    load_Info();
                }

            }



    }

    private void table1MouseClicked(MouseEvent e) {
        // TODO add your code here
        DefaultTableModel df = (DefaultTableModel)table1.getModel();

        int index1 = table1.getSelectedRow();

        textField1.setText(df.getValueAt(index1,0).toString());
        textField2.setText(df.getValueAt(index1,1).toString());
        textField3.setText(df.getValueAt(index1,2).toString());
        textField4.setText(df.getValueAt(index1,3).toString());
        String value = df.getValueAt(index1,4).toString();
        value = value.trim();

        if(value.equals("Business")){
            comboBox1.setSelectedIndex(0);
        }
        else{
            comboBox1.setSelectedIndex(1);
        }



        indice=textField1.getText();
    }

    private void button2ActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
        // TODO add your code here
        if(validation() == true){
            LoanP values = new LoanP(clientID,clientname,amount,y,type);
            Class.forName("com.mysql.jdbc.Driver");

            //local connection with WAMP
            con1= DriverManager.getConnection("jdbc:mysql://localhost:3308/loan","root","");
            //connection to Submit
            //con1= DriverManager.getConnection("jdbc:mysql://localhost/loan","root","");


            query = con1.prepareStatement("UPDATE loantable set clientno=?, clientname=?, loanamount=?, years=?,loantype=? where clientno = ? ");


            //set parameters
            query.setString(1, values.getClientNo());
            query.setString(2, values.getClientName());
            query.setDouble(3, values.getLoanA());
            query.setInt(4, values.getYears());
            query.setString(5, values.getTypeLoan());
            query.setString(6, indice);

            query.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record Edited");
            clean_textbox();
            load_Info();

        }

    }

    private void button3ActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException {
        // TODO add your code here
        if(validation() == true) {
            Class.forName("com.mysql.jdbc.Driver");

            //local connection with WAMP
            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3308/loan", "root", "");
            //connection to Submit
            //con1= DriverManager.getConnection("jdbc:mysql://localhost/loan","root","");



            int result = JOptionPane.showConfirmDialog(null,"Do you really want to delete this record??", "Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){

                query = con1.prepareStatement("DELETE FROM loantable where clientno = ?");

                query.setString(1,indice);
                query.execute();

                JOptionPane.showMessageDialog(null, "Record deleted");
            }else{
                JOptionPane.showMessageDialog(null, "Record didn't delete");
            }
            clean_textbox();
            load_Info();

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Isaias
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        comboBox1 = new JComboBox<>();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label6 = new JLabel();
        textField6 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Enter the client number:");
        contentPane.add(label1, "cell 0 0 3 1");
        contentPane.add(textField1, "cell 3 0 17 1");

        //---- label2 ----
        label2.setText("Enter the client name:");
        contentPane.add(label2, "cell 0 1 3 1");
        contentPane.add(textField2, "cell 3 1 17 1");

        //---- label3 ----
        label3.setText("Enter  the customer loan amount: ");
        contentPane.add(label3, "cell 0 2 3 1");
        contentPane.add(textField3, "cell 3 2 17 1");

        //---- label4 ----
        label4.setText("Enter the number of years to pay: ");
        contentPane.add(label4, "cell 0 3 3 1");
        contentPane.add(textField4, "cell 3 3 17 1");

        //---- label5 ----
        label5.setText("Enter the loan type:");
        contentPane.add(label5, "cell 0 4 3 1");

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "Business",
            "Personal"
        }));
        contentPane.add(comboBox1, "cell 3 4 17 1");

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    table1MouseClicked(e);
                }
            });
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 0 5 3 1");

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2, "cell 3 5 17 1");

        //---- button1 ----
        button1.setText("Add");
        button1.addActionListener(e -> {
            try {
                button1ActionPerformed(e);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(button1, "cell 0 7");

        //---- button2 ----
        button2.setText("Edit");
        button2.addActionListener(e -> {
            try {
                button2ActionPerformed(e);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(button2, "cell 1 7");

        //---- button3 ----
        button3.setText("Delete");
        button3.addActionListener(e -> {
            try {
                button3ActionPerformed(e);
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        contentPane.add(button3, "cell 2 7");

        //---- label6 ----
        label6.setText("Monthly Payment");
        contentPane.add(label6, "cell 3 7");

        //---- textField6 ----
        textField6.setEnabled(false);
        contentPane.add(textField6, "cell 13 7 7 1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Isaias
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JComboBox<String> comboBox1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label6;
    private JTextField textField6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    //new methods
    public boolean validation(){
        try{
            clientID = textField1.getText();
            clientname = textField2.getText();
            amount = Double.parseDouble(textField3.getText());
            type = comboBox1.getSelectedItem().toString();
            y = Integer.parseInt(textField4.getText());
            if(y<1){
                JOptionPane.showMessageDialog(null,"The value of the years must be greater than or equal to 1");
            }
            return  true;
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Please enter appropriate values for each field ");
            return false;
        }


    }


    public boolean clean_textbox(){
        try{
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");

            clientID = ""; clientname = ""; type="";
            amount = 0;
            y = 0;
            indice = "";
            return true;
        }
        catch (Exception x){
            return false;
        }


    }



    public void load_Info() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        con1= DriverManager.getConnection("jdbc:mysql://localhost:3308/loan","root","");

        query = con1.prepareStatement("select * from loantable");

        ResultSet rs = query.executeQuery();

        int c;
        ResultSetMetaData res = rs.getMetaData();

        c = res.getColumnCount();

        DefaultTableModel df = (DefaultTableModel) table1.getModel();

        df.setRowCount(0);

        while(rs.next()){

            Vector v2 = new Vector();

            for(int a =1;a<=c;a++){
                v2.add(rs.getString("clientno"));
                v2.add(rs.getString("clientname"));
                v2.add(rs.getString("loanamount"));
                v2.add(rs.getString("years"));
                v2.add(rs.getString("loantype"));
            }
            df.addRow(v2);
        }


        int v=1;
    }


    public void sss(){

        String[] cols = {"Number", "Name","Amount", "Years", "Type of Loan"};
        String[][] data = {{"d1", "d1.1"},{"d2", "d2.1"},{"d3", "d3.1"},{"d4", "d4.1"},{"d5", "d5.1"}};
        DefaultTableModel model = new DefaultTableModel(data, cols);
        table1.setModel(model);

        //  add(table1);

    }



}
