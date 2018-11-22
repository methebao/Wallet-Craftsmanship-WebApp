package com.cse_craftmanship.walletapp.repository;

import com.cse_craftmanship.walletapp.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

  public List<CreditCard> findAll();
  //  public List<CreditCard> getCardsByWalletId(Long walletId);

}
