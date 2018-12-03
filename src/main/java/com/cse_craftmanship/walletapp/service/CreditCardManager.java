package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.CreditCard;

import java.util.List;
import java.util.Optional;

public interface CreditCardManager {
    public List<CreditCard> getAllCreditCardsByWalletId(Long walletId);

    public CreditCard saveCreditCard(CreditCard creditCard);

    public void deleteCreditCard(CreditCard creditCard);

    public Optional<CreditCard> findById(Long walletId);

    public boolean isExists(Long creditcardId);
}
