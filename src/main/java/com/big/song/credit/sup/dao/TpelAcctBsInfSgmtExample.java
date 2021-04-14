package com.big.song.credit.sup.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TpelAcctBsInfSgmtExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TpelAcctBsInfSgmtExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBusiLinesIsNull() {
            addCriterion("busi_lines is null");
            return (Criteria) this;
        }

        public Criteria andBusiLinesIsNotNull() {
            addCriterion("busi_lines is not null");
            return (Criteria) this;
        }

        public Criteria andBusiLinesEqualTo(String value) {
            addCriterion("busi_lines =", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesNotEqualTo(String value) {
            addCriterion("busi_lines <>", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesGreaterThan(String value) {
            addCriterion("busi_lines >", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesGreaterThanOrEqualTo(String value) {
            addCriterion("busi_lines >=", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesLessThan(String value) {
            addCriterion("busi_lines <", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesLessThanOrEqualTo(String value) {
            addCriterion("busi_lines <=", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesLike(String value) {
            addCriterion("busi_lines like", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesNotLike(String value) {
            addCriterion("busi_lines not like", value, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesIn(List<String> values) {
            addCriterion("busi_lines in", values, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesNotIn(List<String> values) {
            addCriterion("busi_lines not in", values, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesBetween(String value1, String value2) {
            addCriterion("busi_lines between", value1, value2, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiLinesNotBetween(String value1, String value2) {
            addCriterion("busi_lines not between", value1, value2, "busiLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesIsNull() {
            addCriterion("busi_dtl_lines is null");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesIsNotNull() {
            addCriterion("busi_dtl_lines is not null");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesEqualTo(String value) {
            addCriterion("busi_dtl_lines =", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesNotEqualTo(String value) {
            addCriterion("busi_dtl_lines <>", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesGreaterThan(String value) {
            addCriterion("busi_dtl_lines >", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesGreaterThanOrEqualTo(String value) {
            addCriterion("busi_dtl_lines >=", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesLessThan(String value) {
            addCriterion("busi_dtl_lines <", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesLessThanOrEqualTo(String value) {
            addCriterion("busi_dtl_lines <=", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesLike(String value) {
            addCriterion("busi_dtl_lines like", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesNotLike(String value) {
            addCriterion("busi_dtl_lines not like", value, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesIn(List<String> values) {
            addCriterion("busi_dtl_lines in", values, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesNotIn(List<String> values) {
            addCriterion("busi_dtl_lines not in", values, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesBetween(String value1, String value2) {
            addCriterion("busi_dtl_lines between", value1, value2, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andBusiDtlLinesNotBetween(String value1, String value2) {
            addCriterion("busi_dtl_lines not between", value1, value2, "busiDtlLines");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNull() {
            addCriterion("open_date is null");
            return (Criteria) this;
        }

        public Criteria andOpenDateIsNotNull() {
            addCriterion("open_date is not null");
            return (Criteria) this;
        }

        public Criteria andOpenDateEqualTo(Date value) {
            addCriterion("open_date =", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotEqualTo(Date value) {
            addCriterion("open_date <>", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThan(Date value) {
            addCriterion("open_date >", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateGreaterThanOrEqualTo(Date value) {
            addCriterion("open_date >=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThan(Date value) {
            addCriterion("open_date <", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateLessThanOrEqualTo(Date value) {
            addCriterion("open_date <=", value, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateIn(List<Date> values) {
            addCriterion("open_date in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotIn(List<Date> values) {
            addCriterion("open_date not in", values, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateBetween(Date value1, Date value2) {
            addCriterion("open_date between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andOpenDateNotBetween(Date value1, Date value2) {
            addCriterion("open_date not between", value1, value2, "openDate");
            return (Criteria) this;
        }

        public Criteria andCyIsNull() {
            addCriterion("cy is null");
            return (Criteria) this;
        }

        public Criteria andCyIsNotNull() {
            addCriterion("cy is not null");
            return (Criteria) this;
        }

        public Criteria andCyEqualTo(String value) {
            addCriterion("cy =", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyNotEqualTo(String value) {
            addCriterion("cy <>", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyGreaterThan(String value) {
            addCriterion("cy >", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyGreaterThanOrEqualTo(String value) {
            addCriterion("cy >=", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyLessThan(String value) {
            addCriterion("cy <", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyLessThanOrEqualTo(String value) {
            addCriterion("cy <=", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyLike(String value) {
            addCriterion("cy like", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyNotLike(String value) {
            addCriterion("cy not like", value, "cy");
            return (Criteria) this;
        }

        public Criteria andCyIn(List<String> values) {
            addCriterion("cy in", values, "cy");
            return (Criteria) this;
        }

        public Criteria andCyNotIn(List<String> values) {
            addCriterion("cy not in", values, "cy");
            return (Criteria) this;
        }

        public Criteria andCyBetween(String value1, String value2) {
            addCriterion("cy between", value1, value2, "cy");
            return (Criteria) this;
        }

        public Criteria andCyNotBetween(String value1, String value2) {
            addCriterion("cy not between", value1, value2, "cy");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineIsNull() {
            addCriterion("acct_cred_line is null");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineIsNotNull() {
            addCriterion("acct_cred_line is not null");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineEqualTo(Long value) {
            addCriterion("acct_cred_line =", value, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineNotEqualTo(Long value) {
            addCriterion("acct_cred_line <>", value, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineGreaterThan(Long value) {
            addCriterion("acct_cred_line >", value, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineGreaterThanOrEqualTo(Long value) {
            addCriterion("acct_cred_line >=", value, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineLessThan(Long value) {
            addCriterion("acct_cred_line <", value, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineLessThanOrEqualTo(Long value) {
            addCriterion("acct_cred_line <=", value, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineIn(List<Long> values) {
            addCriterion("acct_cred_line in", values, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineNotIn(List<Long> values) {
            addCriterion("acct_cred_line not in", values, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineBetween(Long value1, Long value2) {
            addCriterion("acct_cred_line between", value1, value2, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andAcctCredLineNotBetween(Long value1, Long value2) {
            addCriterion("acct_cred_line not between", value1, value2, "acctCredLine");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNull() {
            addCriterion("loan_amt is null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIsNotNull() {
            addCriterion("loan_amt is not null");
            return (Criteria) this;
        }

        public Criteria andLoanAmtEqualTo(Long value) {
            addCriterion("loan_amt =", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotEqualTo(Long value) {
            addCriterion("loan_amt <>", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThan(Long value) {
            addCriterion("loan_amt >", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("loan_amt >=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThan(Long value) {
            addCriterion("loan_amt <", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtLessThanOrEqualTo(Long value) {
            addCriterion("loan_amt <=", value, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtIn(List<Long> values) {
            addCriterion("loan_amt in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotIn(List<Long> values) {
            addCriterion("loan_amt not in", values, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtBetween(Long value1, Long value2) {
            addCriterion("loan_amt between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andLoanAmtNotBetween(Long value1, Long value2) {
            addCriterion("loan_amt not between", value1, value2, "loanAmt");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNull() {
            addCriterion("due_date is null");
            return (Criteria) this;
        }

        public Criteria andDueDateIsNotNull() {
            addCriterion("due_date is not null");
            return (Criteria) this;
        }

        public Criteria andDueDateEqualTo(Date value) {
            addCriterion("due_date =", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotEqualTo(Date value) {
            addCriterion("due_date <>", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThan(Date value) {
            addCriterion("due_date >", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateGreaterThanOrEqualTo(Date value) {
            addCriterion("due_date >=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThan(Date value) {
            addCriterion("due_date <", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateLessThanOrEqualTo(Date value) {
            addCriterion("due_date <=", value, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateIn(List<Date> values) {
            addCriterion("due_date in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotIn(List<Date> values) {
            addCriterion("due_date not in", values, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateBetween(Date value1, Date value2) {
            addCriterion("due_date between", value1, value2, "dueDate");
            return (Criteria) this;
        }

        public Criteria andDueDateNotBetween(Date value1, Date value2) {
            addCriterion("due_date not between", value1, value2, "dueDate");
            return (Criteria) this;
        }

        public Criteria andRepayModeIsNull() {
            addCriterion("repay_mode is null");
            return (Criteria) this;
        }

        public Criteria andRepayModeIsNotNull() {
            addCriterion("repay_mode is not null");
            return (Criteria) this;
        }

        public Criteria andRepayModeEqualTo(String value) {
            addCriterion("repay_mode =", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeNotEqualTo(String value) {
            addCriterion("repay_mode <>", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeGreaterThan(String value) {
            addCriterion("repay_mode >", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeGreaterThanOrEqualTo(String value) {
            addCriterion("repay_mode >=", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeLessThan(String value) {
            addCriterion("repay_mode <", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeLessThanOrEqualTo(String value) {
            addCriterion("repay_mode <=", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeLike(String value) {
            addCriterion("repay_mode like", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeNotLike(String value) {
            addCriterion("repay_mode not like", value, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeIn(List<String> values) {
            addCriterion("repay_mode in", values, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeNotIn(List<String> values) {
            addCriterion("repay_mode not in", values, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeBetween(String value1, String value2) {
            addCriterion("repay_mode between", value1, value2, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayModeNotBetween(String value1, String value2) {
            addCriterion("repay_mode not between", value1, value2, "repayMode");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyIsNull() {
            addCriterion("repay_freqcy is null");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyIsNotNull() {
            addCriterion("repay_freqcy is not null");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyEqualTo(String value) {
            addCriterion("repay_freqcy =", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyNotEqualTo(String value) {
            addCriterion("repay_freqcy <>", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyGreaterThan(String value) {
            addCriterion("repay_freqcy >", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyGreaterThanOrEqualTo(String value) {
            addCriterion("repay_freqcy >=", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyLessThan(String value) {
            addCriterion("repay_freqcy <", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyLessThanOrEqualTo(String value) {
            addCriterion("repay_freqcy <=", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyLike(String value) {
            addCriterion("repay_freqcy like", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyNotLike(String value) {
            addCriterion("repay_freqcy not like", value, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyIn(List<String> values) {
            addCriterion("repay_freqcy in", values, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyNotIn(List<String> values) {
            addCriterion("repay_freqcy not in", values, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyBetween(String value1, String value2) {
            addCriterion("repay_freqcy between", value1, value2, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayFreqcyNotBetween(String value1, String value2) {
            addCriterion("repay_freqcy not between", value1, value2, "repayFreqcy");
            return (Criteria) this;
        }

        public Criteria andRepayPrdIsNull() {
            addCriterion("repay_prd is null");
            return (Criteria) this;
        }

        public Criteria andRepayPrdIsNotNull() {
            addCriterion("repay_prd is not null");
            return (Criteria) this;
        }

        public Criteria andRepayPrdEqualTo(Short value) {
            addCriterion("repay_prd =", value, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdNotEqualTo(Short value) {
            addCriterion("repay_prd <>", value, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdGreaterThan(Short value) {
            addCriterion("repay_prd >", value, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdGreaterThanOrEqualTo(Short value) {
            addCriterion("repay_prd >=", value, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdLessThan(Short value) {
            addCriterion("repay_prd <", value, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdLessThanOrEqualTo(Short value) {
            addCriterion("repay_prd <=", value, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdIn(List<Short> values) {
            addCriterion("repay_prd in", values, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdNotIn(List<Short> values) {
            addCriterion("repay_prd not in", values, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdBetween(Short value1, Short value2) {
            addCriterion("repay_prd between", value1, value2, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andRepayPrdNotBetween(Short value1, Short value2) {
            addCriterion("repay_prd not between", value1, value2, "repayPrd");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistIsNull() {
            addCriterion("apply_busi_dist is null");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistIsNotNull() {
            addCriterion("apply_busi_dist is not null");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistEqualTo(String value) {
            addCriterion("apply_busi_dist =", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistNotEqualTo(String value) {
            addCriterion("apply_busi_dist <>", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistGreaterThan(String value) {
            addCriterion("apply_busi_dist >", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistGreaterThanOrEqualTo(String value) {
            addCriterion("apply_busi_dist >=", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistLessThan(String value) {
            addCriterion("apply_busi_dist <", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistLessThanOrEqualTo(String value) {
            addCriterion("apply_busi_dist <=", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistLike(String value) {
            addCriterion("apply_busi_dist like", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistNotLike(String value) {
            addCriterion("apply_busi_dist not like", value, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistIn(List<String> values) {
            addCriterion("apply_busi_dist in", values, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistNotIn(List<String> values) {
            addCriterion("apply_busi_dist not in", values, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistBetween(String value1, String value2) {
            addCriterion("apply_busi_dist between", value1, value2, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andApplyBusiDistNotBetween(String value1, String value2) {
            addCriterion("apply_busi_dist not between", value1, value2, "applyBusiDist");
            return (Criteria) this;
        }

        public Criteria andGuarModeIsNull() {
            addCriterion("guar_mode is null");
            return (Criteria) this;
        }

        public Criteria andGuarModeIsNotNull() {
            addCriterion("guar_mode is not null");
            return (Criteria) this;
        }

        public Criteria andGuarModeEqualTo(String value) {
            addCriterion("guar_mode =", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeNotEqualTo(String value) {
            addCriterion("guar_mode <>", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeGreaterThan(String value) {
            addCriterion("guar_mode >", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeGreaterThanOrEqualTo(String value) {
            addCriterion("guar_mode >=", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeLessThan(String value) {
            addCriterion("guar_mode <", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeLessThanOrEqualTo(String value) {
            addCriterion("guar_mode <=", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeLike(String value) {
            addCriterion("guar_mode like", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeNotLike(String value) {
            addCriterion("guar_mode not like", value, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeIn(List<String> values) {
            addCriterion("guar_mode in", values, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeNotIn(List<String> values) {
            addCriterion("guar_mode not in", values, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeBetween(String value1, String value2) {
            addCriterion("guar_mode between", value1, value2, "guarMode");
            return (Criteria) this;
        }

        public Criteria andGuarModeNotBetween(String value1, String value2) {
            addCriterion("guar_mode not between", value1, value2, "guarMode");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayIsNull() {
            addCriterion("oth_repy_guar_way is null");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayIsNotNull() {
            addCriterion("oth_repy_guar_way is not null");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayEqualTo(String value) {
            addCriterion("oth_repy_guar_way =", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayNotEqualTo(String value) {
            addCriterion("oth_repy_guar_way <>", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayGreaterThan(String value) {
            addCriterion("oth_repy_guar_way >", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayGreaterThanOrEqualTo(String value) {
            addCriterion("oth_repy_guar_way >=", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayLessThan(String value) {
            addCriterion("oth_repy_guar_way <", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayLessThanOrEqualTo(String value) {
            addCriterion("oth_repy_guar_way <=", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayLike(String value) {
            addCriterion("oth_repy_guar_way like", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayNotLike(String value) {
            addCriterion("oth_repy_guar_way not like", value, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayIn(List<String> values) {
            addCriterion("oth_repy_guar_way in", values, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayNotIn(List<String> values) {
            addCriterion("oth_repy_guar_way not in", values, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayBetween(String value1, String value2) {
            addCriterion("oth_repy_guar_way between", value1, value2, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andOthRepyGuarWayNotBetween(String value1, String value2) {
            addCriterion("oth_repy_guar_way not between", value1, value2, "othRepyGuarWay");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagIsNull() {
            addCriterion("asset_trand_flag is null");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagIsNotNull() {
            addCriterion("asset_trand_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagEqualTo(String value) {
            addCriterion("asset_trand_flag =", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagNotEqualTo(String value) {
            addCriterion("asset_trand_flag <>", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagGreaterThan(String value) {
            addCriterion("asset_trand_flag >", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagGreaterThanOrEqualTo(String value) {
            addCriterion("asset_trand_flag >=", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagLessThan(String value) {
            addCriterion("asset_trand_flag <", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagLessThanOrEqualTo(String value) {
            addCriterion("asset_trand_flag <=", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagLike(String value) {
            addCriterion("asset_trand_flag like", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagNotLike(String value) {
            addCriterion("asset_trand_flag not like", value, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagIn(List<String> values) {
            addCriterion("asset_trand_flag in", values, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagNotIn(List<String> values) {
            addCriterion("asset_trand_flag not in", values, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagBetween(String value1, String value2) {
            addCriterion("asset_trand_flag between", value1, value2, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andAssetTrandFlagNotBetween(String value1, String value2) {
            addCriterion("asset_trand_flag not between", value1, value2, "assetTrandFlag");
            return (Criteria) this;
        }

        public Criteria andFundSouIsNull() {
            addCriterion("fund_sou is null");
            return (Criteria) this;
        }

        public Criteria andFundSouIsNotNull() {
            addCriterion("fund_sou is not null");
            return (Criteria) this;
        }

        public Criteria andFundSouEqualTo(String value) {
            addCriterion("fund_sou =", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouNotEqualTo(String value) {
            addCriterion("fund_sou <>", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouGreaterThan(String value) {
            addCriterion("fund_sou >", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouGreaterThanOrEqualTo(String value) {
            addCriterion("fund_sou >=", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouLessThan(String value) {
            addCriterion("fund_sou <", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouLessThanOrEqualTo(String value) {
            addCriterion("fund_sou <=", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouLike(String value) {
            addCriterion("fund_sou like", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouNotLike(String value) {
            addCriterion("fund_sou not like", value, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouIn(List<String> values) {
            addCriterion("fund_sou in", values, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouNotIn(List<String> values) {
            addCriterion("fund_sou not in", values, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouBetween(String value1, String value2) {
            addCriterion("fund_sou between", value1, value2, "fundSou");
            return (Criteria) this;
        }

        public Criteria andFundSouNotBetween(String value1, String value2) {
            addCriterion("fund_sou not between", value1, value2, "fundSou");
            return (Criteria) this;
        }

        public Criteria andLoanFormIsNull() {
            addCriterion("loan_form is null");
            return (Criteria) this;
        }

        public Criteria andLoanFormIsNotNull() {
            addCriterion("loan_form is not null");
            return (Criteria) this;
        }

        public Criteria andLoanFormEqualTo(String value) {
            addCriterion("loan_form =", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormNotEqualTo(String value) {
            addCriterion("loan_form <>", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormGreaterThan(String value) {
            addCriterion("loan_form >", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormGreaterThanOrEqualTo(String value) {
            addCriterion("loan_form >=", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormLessThan(String value) {
            addCriterion("loan_form <", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormLessThanOrEqualTo(String value) {
            addCriterion("loan_form <=", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormLike(String value) {
            addCriterion("loan_form like", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormNotLike(String value) {
            addCriterion("loan_form not like", value, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormIn(List<String> values) {
            addCriterion("loan_form in", values, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormNotIn(List<String> values) {
            addCriterion("loan_form not in", values, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormBetween(String value1, String value2) {
            addCriterion("loan_form between", value1, value2, "loanForm");
            return (Criteria) this;
        }

        public Criteria andLoanFormNotBetween(String value1, String value2) {
            addCriterion("loan_form not between", value1, value2, "loanForm");
            return (Criteria) this;
        }

        public Criteria andCreditIdIsNull() {
            addCriterion("credit_id is null");
            return (Criteria) this;
        }

        public Criteria andCreditIdIsNotNull() {
            addCriterion("credit_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreditIdEqualTo(String value) {
            addCriterion("credit_id =", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotEqualTo(String value) {
            addCriterion("credit_id <>", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdGreaterThan(String value) {
            addCriterion("credit_id >", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdGreaterThanOrEqualTo(String value) {
            addCriterion("credit_id >=", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdLessThan(String value) {
            addCriterion("credit_id <", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdLessThanOrEqualTo(String value) {
            addCriterion("credit_id <=", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdLike(String value) {
            addCriterion("credit_id like", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotLike(String value) {
            addCriterion("credit_id not like", value, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdIn(List<String> values) {
            addCriterion("credit_id in", values, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotIn(List<String> values) {
            addCriterion("credit_id not in", values, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdBetween(String value1, String value2) {
            addCriterion("credit_id between", value1, value2, "creditId");
            return (Criteria) this;
        }

        public Criteria andCreditIdNotBetween(String value1, String value2) {
            addCriterion("credit_id not between", value1, value2, "creditId");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNull() {
            addCriterion("cust_id is null");
            return (Criteria) this;
        }

        public Criteria andCustIdIsNotNull() {
            addCriterion("cust_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustIdEqualTo(String value) {
            addCriterion("cust_id =", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotEqualTo(String value) {
            addCriterion("cust_id <>", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThan(String value) {
            addCriterion("cust_id >", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdGreaterThanOrEqualTo(String value) {
            addCriterion("cust_id >=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThan(String value) {
            addCriterion("cust_id <", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLessThanOrEqualTo(String value) {
            addCriterion("cust_id <=", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdLike(String value) {
            addCriterion("cust_id like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotLike(String value) {
            addCriterion("cust_id not like", value, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdIn(List<String> values) {
            addCriterion("cust_id in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotIn(List<String> values) {
            addCriterion("cust_id not in", values, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdBetween(String value1, String value2) {
            addCriterion("cust_id between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andCustIdNotBetween(String value1, String value2) {
            addCriterion("cust_id not between", value1, value2, "custId");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeIsNull() {
            addCriterion("loan_con_code is null");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeIsNotNull() {
            addCriterion("loan_con_code is not null");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeEqualTo(String value) {
            addCriterion("loan_con_code =", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeNotEqualTo(String value) {
            addCriterion("loan_con_code <>", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeGreaterThan(String value) {
            addCriterion("loan_con_code >", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_con_code >=", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeLessThan(String value) {
            addCriterion("loan_con_code <", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeLessThanOrEqualTo(String value) {
            addCriterion("loan_con_code <=", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeLike(String value) {
            addCriterion("loan_con_code like", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeNotLike(String value) {
            addCriterion("loan_con_code not like", value, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeIn(List<String> values) {
            addCriterion("loan_con_code in", values, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeNotIn(List<String> values) {
            addCriterion("loan_con_code not in", values, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeBetween(String value1, String value2) {
            addCriterion("loan_con_code between", value1, value2, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andLoanConCodeNotBetween(String value1, String value2) {
            addCriterion("loan_con_code not between", value1, value2, "loanConCode");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagIsNull() {
            addCriterion("first_hou_loan_flag is null");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagIsNotNull() {
            addCriterion("first_hou_loan_flag is not null");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagEqualTo(String value) {
            addCriterion("first_hou_loan_flag =", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagNotEqualTo(String value) {
            addCriterion("first_hou_loan_flag <>", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagGreaterThan(String value) {
            addCriterion("first_hou_loan_flag >", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagGreaterThanOrEqualTo(String value) {
            addCriterion("first_hou_loan_flag >=", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagLessThan(String value) {
            addCriterion("first_hou_loan_flag <", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagLessThanOrEqualTo(String value) {
            addCriterion("first_hou_loan_flag <=", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagLike(String value) {
            addCriterion("first_hou_loan_flag like", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagNotLike(String value) {
            addCriterion("first_hou_loan_flag not like", value, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagIn(List<String> values) {
            addCriterion("first_hou_loan_flag in", values, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagNotIn(List<String> values) {
            addCriterion("first_hou_loan_flag not in", values, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagBetween(String value1, String value2) {
            addCriterion("first_hou_loan_flag between", value1, value2, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andFirstHouLoanFlagNotBetween(String value1, String value2) {
            addCriterion("first_hou_loan_flag not between", value1, value2, "firstHouLoanFlag");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNull() {
            addCriterion("dept_code is null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIsNotNull() {
            addCriterion("dept_code is not null");
            return (Criteria) this;
        }

        public Criteria andDeptCodeEqualTo(String value) {
            addCriterion("dept_code =", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotEqualTo(String value) {
            addCriterion("dept_code <>", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThan(String value) {
            addCriterion("dept_code >", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dept_code >=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThan(String value) {
            addCriterion("dept_code <", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLessThanOrEqualTo(String value) {
            addCriterion("dept_code <=", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeLike(String value) {
            addCriterion("dept_code like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotLike(String value) {
            addCriterion("dept_code not like", value, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeIn(List<String> values) {
            addCriterion("dept_code in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotIn(List<String> values) {
            addCriterion("dept_code not in", values, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeBetween(String value1, String value2) {
            addCriterion("dept_code between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andDeptCodeNotBetween(String value1, String value2) {
            addCriterion("dept_code not between", value1, value2, "deptCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIsNull() {
            addCriterion("corp_code is null");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIsNotNull() {
            addCriterion("corp_code is not null");
            return (Criteria) this;
        }

        public Criteria andCorpCodeEqualTo(String value) {
            addCriterion("corp_code =", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotEqualTo(String value) {
            addCriterion("corp_code <>", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeGreaterThan(String value) {
            addCriterion("corp_code >", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeGreaterThanOrEqualTo(String value) {
            addCriterion("corp_code >=", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLessThan(String value) {
            addCriterion("corp_code <", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLessThanOrEqualTo(String value) {
            addCriterion("corp_code <=", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeLike(String value) {
            addCriterion("corp_code like", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotLike(String value) {
            addCriterion("corp_code not like", value, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeIn(List<String> values) {
            addCriterion("corp_code in", values, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotIn(List<String> values) {
            addCriterion("corp_code not in", values, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeBetween(String value1, String value2) {
            addCriterion("corp_code between", value1, value2, "corpCode");
            return (Criteria) this;
        }

        public Criteria andCorpCodeNotBetween(String value1, String value2) {
            addCriterion("corp_code not between", value1, value2, "corpCode");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateIsNull() {
            addCriterion("info_up_date is null");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateIsNotNull() {
            addCriterion("info_up_date is not null");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateEqualTo(Date value) {
            addCriterion("info_up_date =", value, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateNotEqualTo(Date value) {
            addCriterion("info_up_date <>", value, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateGreaterThan(Date value) {
            addCriterion("info_up_date >", value, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateGreaterThanOrEqualTo(Date value) {
            addCriterion("info_up_date >=", value, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateLessThan(Date value) {
            addCriterion("info_up_date <", value, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateLessThanOrEqualTo(Date value) {
            addCriterion("info_up_date <=", value, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateIn(List<Date> values) {
            addCriterion("info_up_date in", values, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateNotIn(List<Date> values) {
            addCriterion("info_up_date not in", values, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateBetween(Date value1, Date value2) {
            addCriterion("info_up_date between", value1, value2, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andInfoUpDateNotBetween(Date value1, Date value2) {
            addCriterion("info_up_date not between", value1, value2, "infoUpDate");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNull() {
            addCriterion("transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIsNotNull() {
            addCriterion("transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionIdEqualTo(String value) {
            addCriterion("transaction_id =", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotEqualTo(String value) {
            addCriterion("transaction_id <>", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThan(String value) {
            addCriterion("transaction_id >", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_id >=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThan(String value) {
            addCriterion("transaction_id <", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLessThanOrEqualTo(String value) {
            addCriterion("transaction_id <=", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdLike(String value) {
            addCriterion("transaction_id like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotLike(String value) {
            addCriterion("transaction_id not like", value, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdIn(List<String> values) {
            addCriterion("transaction_id in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotIn(List<String> values) {
            addCriterion("transaction_id not in", values, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdBetween(String value1, String value2) {
            addCriterion("transaction_id between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andTransactionIdNotBetween(String value1, String value2) {
            addCriterion("transaction_id not between", value1, value2, "transactionId");
            return (Criteria) this;
        }

        public Criteria andAcctNoIsNull() {
            addCriterion("acct_no is null");
            return (Criteria) this;
        }

        public Criteria andAcctNoIsNotNull() {
            addCriterion("acct_no is not null");
            return (Criteria) this;
        }

        public Criteria andAcctNoEqualTo(String value) {
            addCriterion("acct_no =", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotEqualTo(String value) {
            addCriterion("acct_no <>", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoGreaterThan(String value) {
            addCriterion("acct_no >", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoGreaterThanOrEqualTo(String value) {
            addCriterion("acct_no >=", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoLessThan(String value) {
            addCriterion("acct_no <", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoLessThanOrEqualTo(String value) {
            addCriterion("acct_no <=", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoLike(String value) {
            addCriterion("acct_no like", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotLike(String value) {
            addCriterion("acct_no not like", value, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoIn(List<String> values) {
            addCriterion("acct_no in", values, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotIn(List<String> values) {
            addCriterion("acct_no not in", values, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoBetween(String value1, String value2) {
            addCriterion("acct_no between", value1, value2, "acctNo");
            return (Criteria) this;
        }

        public Criteria andAcctNoNotBetween(String value1, String value2) {
            addCriterion("acct_no not between", value1, value2, "acctNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}