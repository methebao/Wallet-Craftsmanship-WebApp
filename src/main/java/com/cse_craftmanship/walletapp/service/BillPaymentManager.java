package com.cse_craftmanship.walletapp.service;

import com.cse_craftmanship.walletapp.model.BillPayment;

import java.util.List;
import java.util.Optional;

public interface BillPaymentManager {

    public List<BillPayment> getAll();

    public List<BillPayment> getAllBillPaymentsByWalletId(Long walletId);

    public BillPayment saveBillPayment(BillPayment billPayment);

    public void deleteBillPayment(BillPayment billPayment);

    public Optional<BillPayment> findById(Long billPaymentId);

    public boolean isExists(Long billPaymentId);
}
