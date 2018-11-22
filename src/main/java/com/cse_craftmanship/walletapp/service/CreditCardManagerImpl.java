package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardManagerImpl implements CreditCardManager{
    @Autowired
    CreditCardRepository creditCardRepository;

    public List<CreditCard> getAllCreditCards() {
       return creditCardRepository.findAll();
    }

    public CreditCard createCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public void deleteCreditCard(CreditCard creditCard) {
        creditCardRepository.delete(creditCard);
    }

    public CreditCard  findById(Long creditId){
        return creditCardRepository.getOne(creditId);
    }
}
