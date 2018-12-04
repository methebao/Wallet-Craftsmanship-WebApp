package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardManagerImpl implements CreditCardManager {
    @Autowired
    CreditCardRepository creditCardRepository;

    public List<CreditCard> getAllCreditCardsByWalletId(Long walletId) {

        return creditCardRepository.findByWalletId(walletId);
    }

    public CreditCard saveCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public void deleteCreditCard(CreditCard creditCard) {
    }

    public Optional<CreditCard> findById(Long creditcardId) {
        return creditCardRepository.findById(creditcardId);
    }

    public boolean isExists(Long creditCardId) {
        return creditCardRepository.existsById(creditCardId);
    }

}
