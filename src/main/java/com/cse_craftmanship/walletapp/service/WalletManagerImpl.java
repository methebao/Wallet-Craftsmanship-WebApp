package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.model.Wallet;
import com.cse_craftmanship.walletapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletManagerImpl implements WalletManager {

  @Autowired
  WalletRepository walletRepository;

  public List<Wallet> getAll() {

    return walletRepository.findAll();
  }
  public Wallet saveWallet(Wallet newWallet) {
    return walletRepository.save(newWallet);
  }
  public void deleteWallet(Wallet wallet) {
     walletRepository.delete(wallet);
  }
  public Wallet findById(Long walletId) {
    return walletRepository.getOne(walletId);
  }
  public List<CreditCard> getCardsByWalletId(Long walletId){
    Wallet wallet = walletRepository.getOne(walletId);
    return wallet.getCards();
  }

}
