package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.model.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletManager {

  public List<Wallet> getAll();
  public Wallet saveWallet(Wallet newWallet);
  public void deleteWallet(Wallet wallet);
  public Optional<Wallet> findById(Long walletId);
  public boolean isExists(Long walletid);

}
