package com.example.geektrust.service;

import com.example.geektrust.constant.PassengerType;
import com.example.geektrust.constant.Station;
import com.example.geektrust.entity.CheckIn;

import java.util.Map;

public interface CheckInService 
{
    //Passenger Checking in
    void checkInPassenger(CheckIn checkIn);

    //returns station type along with the count
    Map<Station, Map<PassengerType, Integer>> getStationTypeCountMap();

    //returns a map with amount paid mapped to station
    Map<String, Integer> getStationAmountMap();

    //returns a map with discount amount paid mapped to station
    Map<String, Integer> getStationDiscountMap();
}
