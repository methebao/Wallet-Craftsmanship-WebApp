package com.cse_craftmanship.walletapp.repository;

import com.cse_craftmanship.walletapp.model.BillPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {

  public List<BillPayment> findByWalletId(Long walletId);

}
