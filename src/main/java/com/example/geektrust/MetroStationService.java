package com.example.geektrust;

import com.example.geektrust.constant.Common;
import com.example.geektrust.entity.CheckIn;
import com.example.geektrust.service.CheckInService;
import com.example.geektrust.service.MetroCardService;
import com.example.geektrust.service.PrintSummaryService;
import com.example.geektrust.service.impl.CheckInServiceImpl;
import com.example.geektrust.service.impl.MetroCardServiceImpl;
import com.example.geektrust.service.impl.PrintSummaryServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class MetroStationService 
{
    MetroCardService metroCardService = new MetroCardServiceImpl();
    CheckInService checkInService = new CheckInServiceImpl(metroCardService);
    PrintSummaryService printSummaryService = new PrintSummaryServiceImpl(checkInService);

    public void start(String[] args) throws IOException
    {
        try 
        {
            //Input file need to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis);
            // while loop returns true if there is another line to read
            while (sc.hasNextLine()) 
            {
                String[] input = sc.nextLine().split(Common.SPACE, Common.TWO);
                switch (input[0]) 
                {
                    case "BALANCE":
                        String[] cardDetails = input[1].split(Common.SPACE, Common.TWO);
                        //cardDetails[0]-card number 
                        //cardDetails[1]-card balance
                        metroCardService.addCard(cardDetails[0], Integer.parseInt(cardDetails[1]));
                        break;
                        
                    case "CHECK_IN":
                        String[] checkInDetails = input[1].split(Common.SPACE, Common.THREE);
                        //checkInDetails[0]-Card Number
                        //checkInDetails[1]-Passenger Type
                        //checkInDetails[2]-From Station
                        checkInService.checkInPassenger(new CheckIn(checkInDetails[0], checkInDetails[1], checkInDetails[2]));
                        break;
                        
                    case "PRINT_SUMMARY":
                        printSummaryService.printSummary();
                        break;
                        
                    default:
                        break;
                }

            }
            sc.close(); // closes the scanner
        } 
        catch (IOException e) 
        {
            throw new IOException("Error while reading input");
        }
    }
}
