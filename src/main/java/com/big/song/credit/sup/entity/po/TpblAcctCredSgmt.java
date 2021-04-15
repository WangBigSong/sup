package com.big.song.credit.sup.entity.po;

import java.math.BigDecimal;
import java.util.Date;

public class TpblAcctCredSgmt {
    private Long id;

    private String creditNo;

    private String custId;

    private String stat;

    private String noRpt;

    private Date getTime;

    private String operator;

    private String deptCode;

    private Date changeDate;

    private String corpCode;

    private Date infoUpDate;

    private String transactionId;

    private BigDecimal relaId;

    private String acctNo;

    private Long busiHash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat == null ? null : stat.trim();
    }

    public String getNoRpt() {
        return noRpt;
    }

    public void setNoRpt(String noRpt) {
        this.noRpt = noRpt == null ? null : noRpt.trim();
    }

    public Date getGetTime() {
        return getTime;
    }

    public void setGetTime(Date getTime) {
        this.getTime = getTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public String getCorpCode() {
        return corpCode;
    }

    public void setCorpCode(String corpCode) {
        this.corpCode = corpCode == null ? null : corpCode.trim();
    }

    public Date getInfoUpDate() {
        return infoUpDate;
    }

    public void setInfoUpDate(Date infoUpDate) {
        this.infoUpDate = infoUpDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public BigDecimal getRelaId() {
        return relaId;
    }

    public void setRelaId(BigDecimal relaId) {
        this.relaId = relaId;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo == null ? null : acctNo.trim();
    }

    public Long getBusiHash() {
        return busiHash;
    }

    public void setBusiHash(Long busiHash) {
        this.busiHash = busiHash;
    }
}