package com.cse_craftmanship.walletapp.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "billpayment")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class BillPayment implements Serializable {
  private static final long serialVersionUID = -8138063240254512372L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;

  private String name;

  private String comsumerNo;

  private String billNo;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  @CreatedDate
  private Date createdAt;

  private Long initAmount;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "wallet_id", nullable = false)
  @JsonIgnore
  private Wallet wallet;

  // Getter & Setters
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Wallet getWallet() {
    return this.wallet;
  }

  public void setWallet(Wallet wallet) {
    this.wallet = wallet;
  }

  public Long getInitamount() {
    return this.initAmount;
  }

  public void setInitamount(Long initAmount) {
    this.initAmount = initAmount;
  }

  public String getBillno() {
    return this.billNo;
  }

  public void setBillno(String billNo) {
    this.billNo = billNo;
  }

  public String getComsumerno() {
    return this.comsumerNo;
  }

  public void setComsumerno(String comsumerNo) {
    this.comsumerNo = comsumerNo;
  }
}