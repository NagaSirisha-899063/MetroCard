package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.entity.MetroCard;

public interface MetroCardService 
{
    /* Adds new metro card from the input provided, and maintains a map of card_id and balance mapped to that card
      cardId - card number
      balance - balance amount in card */
    void addCard(String cardId, int balance);

    
    //Returns list of all metro cards
    List<MetroCard> getCards();

    
    /* Performs a transaction on metro card from input
        cardId - card number
        amount - transaction amount
        returns int - amount left to pay */
    int transactCard(String cardId, int amount);
}
