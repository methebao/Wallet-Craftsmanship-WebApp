package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.CreditCard;

import java.util.List;

public interface CreditCardManager {
    public List<CreditCard> getAllCreditCards();
    public CreditCard createCreditCard(CreditCard creditCard);
    public void deleteCreditCard(CreditCard creditCard);
    public CreditCard findById(Long creditId);
}
