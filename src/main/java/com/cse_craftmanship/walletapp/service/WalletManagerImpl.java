package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.model.Wallet;
import com.cse_craftmanship.walletapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public Optional<Wallet> findById(Long walletId) {
    return walletRepository.findById(walletId);
  }

  public boolean isExists(Long walletId) {
    return walletRepository.existsById(walletId);
  }

  public Wallet addMoneyToWallet(Wallet walletToAdd, Long initAmount) {
    walletToAdd.setBalance(walletToAdd.getBalance() + initAmount);
    return saveWallet(walletToAdd);
  }

  public Wallet chargeBill(Wallet walletToCharge, Long initAmount) {
    walletToCharge.setBalance(walletToCharge.getBalance() - initAmount);
    return saveWallet(walletToCharge);
  }
}
