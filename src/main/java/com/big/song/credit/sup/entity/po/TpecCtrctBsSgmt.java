package com.big.song.credit.sup.entity.po;

import java.util.Date;

public class TpecCtrctBsSgmt {
    private Long id;

    private String creditNo;

    private String name;

    private String idType;

    private String idNum;

    private String mngmtOrgCode;

    private String custId;

    private String deptCode;

    private String corpCode;

    private Date infoUpDate;

    private String transactionId;

    private String operator;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    public String getMngmtOrgCode() {
        return mngmtOrgCode;
    }

    public void setMngmtOrgCode(String mngmtOrgCode) {
        this.mngmtOrgCode = mngmtOrgCode == null ? null : mngmtOrgCode.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }
}