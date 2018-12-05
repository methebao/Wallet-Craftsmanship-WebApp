package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.BillPayment;
import com.cse_craftmanship.walletapp.repository.BillPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillPaymentManagerImpl implements BillPaymentManager {
  @Autowired
  BillPaymentRepository billPaymentRepository;

  public List<BillPayment> getAll() {
    return billPaymentRepository.findAll();
  }

  public List<BillPayment> getAllBillPaymentsByWalletId(Long walletId) {

    return billPaymentRepository.findByWalletId(walletId);
  }

  public BillPayment saveBillPayment(BillPayment billPayment) {
    return billPaymentRepository.save(billPayment);
  }

  public void deleteBillPayment(BillPayment billPayment) {
    billPaymentRepository.delete(billPayment);

  }

  public Optional<BillPayment> findById(Long billPaymentId) {
    return billPaymentRepository.findById(billPaymentId);
  }

  public boolean isExists(Long billPaymentId) {
    return billPaymentRepository.existsById(billPaymentId);
  }

}
