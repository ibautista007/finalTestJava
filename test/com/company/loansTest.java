package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class loansTest {

    loans obj1 = new  loans();
    String clientID,clientname, type;
    double amount = 0;
    int y = 0;
    String indice;

    public void init(){
        clientID = "4512451";
    }

    @Test
    void clean_textbox() {
        init();
        assertEquals(true,obj1.clean_textbox());
    }
}