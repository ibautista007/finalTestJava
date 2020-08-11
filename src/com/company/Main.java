package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
	// write your code here
        loans obj1 = new  loans();

        obj1.sss();
        obj1.load_Info();
        obj1.setVisible(true);

    }



}
