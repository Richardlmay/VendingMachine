package com.techelevator;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class FundsTest extends TestCase {



    @Test
    public void testChangeGiven() {

        Funds funds = new Funds();

        String expectedResult = "Quarters- 4\nDimes- 0\nNickels- 0\nPenny- 0";
//        String expectedResult = "4 ";
        String actualResult = funds.changeGiven(1);

        assertEquals(expectedResult,actualResult);

    }


}