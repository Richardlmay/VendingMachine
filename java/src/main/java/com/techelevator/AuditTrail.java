package com.techelevator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AuditTrail {

    java.time.LocalDateTime theDateTime = java.time.LocalDateTime.of(2020, 11, 19, 3, 21, 10);



        PrintWriter dataOutput;

    {
        try {
            dataOutput = new PrintWriter("log.txt");
        } catch (FileNotFoundException e) {
            dataOutput.println("hello");
        }
    }

}


