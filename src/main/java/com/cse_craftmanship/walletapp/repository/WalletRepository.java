package com.cse_craftmanship.walletapp.repository;

import com.cse_craftmanship.walletapp.model.CreditCard;
import com.cse_craftmanship.walletapp.model.Wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

  public List<Wallet> findAll();
//  public List<CreditCard> getCardsByWalletId(Long walletId);
  public Wallet getOne(Long walletId);
}