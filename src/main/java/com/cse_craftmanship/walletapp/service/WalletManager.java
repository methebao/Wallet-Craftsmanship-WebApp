package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.Wallet;

import java.util.List;

public interface WalletManager {

  public List<Wallet> getAll();
  public Wallet saveWallet(Wallet newWallet);
  public void deleteWallet(Wallet wallet);
  public Wallet findById(Long walletId);

}
