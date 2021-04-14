package com.big.song.credit.sup.constant;

public class CreditCode {

    public final static String COMPANY_LOAN = "LOAN";     // 借贷
    public final static String COMPANY_BASE = "BASE";     // 基本信息
    public final static String COMPANY_CREDIT = "CREDIT"; // 授信
    public final static String COMPANY_DIZIYA = "DIZIYA"; // 抵质押

    public final static String TXT_HEAD="A050";
    public final static String END="00010";

    public final static Integer COMPANY_LOAN_CODE = 410;
    public final static Integer COMPANY_BASE_CODE = 310;
    public final static Integer COMPANY_CREDIT_CODE = 420;
    public final static Integer COMPANY_DIZIYA_CODE = 510;

    public final static String PERSON_BASE = "PERSONBASE";     // 个人基本信息
    public final static String PERSON_LOAN = "PERSONLOAN";     // 个人借贷
    public final static String PERSON_CREDIT = "PERSONCREDIT"; // 个人授信



    public final static Integer PERSON_BASE_CODE = 110;
    public final static Integer PERSON_LOAN_CODE = 210;
    public final static Integer PERSON_CREDIT_CODE = 220;

    public final static String FILE_TXT = ".txt";
    public final static String FILE_SQL = ".sql";
    public final static String NEW_FILE_NAME = "newTxt";
    public final static String NEW_FILE_DELETE = "deleteFile";
    public final static String NEW_FILE_NO_CREDIT = "noCredit";
    public final static String NEW_FILE_NO_ACCT_BS_INF= "noAcctBsInf";
    // 个人借贷删除code 与 报文
    public static final Integer PERSON_DELETE_LOAN = 214;
    public final static String DEL_MODEL_PERSON_LOAN="<Document><InAcctEntDel><InfRecType>214</InfRecType><DelRecCode>#{acctCode}</DelRecCode></InAcctEntDel></Document>\n";

    // 个人基本信息删除code 与 报文
    public static Integer PERSON_DELETE_BASE = 114;
    public final static String DEL_MODEL_PERSON_BASE="<Document><InBsInfDlt><InfRecType>114</InfRecType><Name>#{personName}</Name><IDType>10</IDType><IDNum>#{IdNUM}</IDNum><InfSurcCode>#{ORGCODE}</InfSurcCode></InBsInfDlt></Document>\n";

    // 个人授信删除code 与 报文
    public static Integer PERSON_DELETE_CREDIT = 224;
    public final static String DEL_MODEL_PERSON_CREDIT="<Document><InCtrctEntDel><InfRecType>224</InfRecType><DelRecCode>#{contractCode}</DelRecCode></InCtrctEntDel></Document>\n";

    // 企业借贷删除code 与 报文
    public static Integer COMPANY_DELETE_LOAN = 414;
    public final static String DEL_MODEL_COMPANY_LOAN="<Document><EnAcctInfEntDel><InfRecType>414</InfRecType><DelRecCode>#{enAcctCode}</DelRecCode></EnAcctInfEntDel></Document>\n";

    // 企业基本信息删除code 与 报文
    public static Integer COMPANY_DELETE_BASE = 314;
    public final static String DEL_MODEL_COMPANY_BASE="<Document><EnBsInfDlt><InfRecType>314</InfRecType><EntName>#{entName}</EntName><EntCertType>10</EntCertType><EntCertNum>#{entCertNum}</EntCertNum><InfSurcCode>#{ORGCODE}</InfSurcCode></EnBsInfDlt></Document>\n";

    // 企业授信删除code 与 报文
    public static Integer COMPANY_DELETE_CREDIT = 424;
    public final static String DEL_MODEL_COMPANY_CREDIT="<Document><EnCtrctInfEntDel><InfRecType>424</InfRecType><DelRecCode>#{entContractCode}</DelRecCode></EnCtrctInfEntDel></Document>\n";

    //抵质押
    public static Integer COMPANY_DELETE_DIZIYA = 514;
    public final static String DEL_MODEL_DIZITA="<Document><MoCEntDel><InfRecType>514</InfRecType><DelRecCode>#{ccCode}</DelRecCode></MoCEntDel></Document>\n";



    public final static  String CREDIT_NODE="<AcctCredSgmt><Mcc>#{mcc}</Mcc></AcctCredSgmt>";

    public final static  String ACCT_BS_INF_SGMT_NODE="<AcctBsInfSgmt><BusiLines>#{BusiLines}</BusiLines><BusiDtlLines>#{BusiDtlLines}</BusiDtlLines><OpenDate>#{OpenDate}</OpenDate><Cy>#{Cy}</Cy><LoanAmt>#{LoanAmt}</LoanAmt><Flag>#{Flag}</Flag><DueDate>#{DueDate}</DueDate><RepayMode>#{RepayMode}</RepayMode><RepayFreqcy>#{RepayFreqcy}</RepayFreqcy><RepayPrd>#{RepayPrd}</RepayPrd><ApplyBusiDist>#{ApplyBusiDist}</ApplyBusiDist><GuarMode>#{GuarMode}</GuarMode><OthRepyGuarWay>#{OthRepyGuarWay}</OthRepyGuarWay><AssetTrandFlag>#{AssetTrandFlag}</AssetTrandFlag><FundSou>#{FundSou}</FundSou><LoanForm>#{LoanForm}</LoanForm></AcctBsInfSgmt>";

    // 个人
    public final static String[] PERSON_BASE_TB = new String[]{ "tpbb_bs_sgmt" ,
                                                                "tpbb_edu_inf_sgmt" ,
                                                                "tpbb_fcs_inf_sgmt" ,
                                                                "tpbb_id_sgmt" ,
                                                                "tpbb_mlg_inf_sgmt" ,
                                                                "tpbb_octpn_inf_sgmt" ,
                                                                "tpbb_rednc_inf_sgmt" ,
                                                                "tpbb_sps_inf_sgmt"};

    public final static String[] PERSON_BASE_TH = new String[]{ "tphb_bs_sgmt" ,
                                                                "tphb_edu_inf_sgmt" ,
                                                                "tphb_fcs_inf_sgmt" ,
                                                                "tphb_id_sgmt" ,
                                                                "tphb_mlg_inf_sgmt" ,
                                                                "tphb_octpn_inf_sgmt" ,
                                                                "tphb_rednc_inf_sgmt" ,
                                                                "tphb_sps_inf_sgmt"};
    // 借贷
    public final static String[] PERSON_LOAN_TH = new String[]{ "tpHl_acct_bs_sgmt" ,
                                                                "tpHl_acct_bs_inf_sgmt" ,
                                                                "tpHl_acct_cred_sgmt" ,
                                                                "tpHl_acct_dbtinf_sgmt" ,
                                                                "tpHl_acct_dspn_sgmt" ,
                                                                "tpHl_acct_mthly_sgmt"};

    public final static String[] PERSON_LOAN_TB = new String[]{ "tpBl_acct_bs_sgmt" ,
                                                                "tpBl_acct_bs_inf_sgmt" ,
                                                                "tpBl_acct_cred_sgmt" ,
                                                                "tpBl_acct_dbtinf_sgmt" ,
                                                                "tpBl_acct_dspn_sgmt" ,
                                                                "tpBl_acct_mthly_sgmt"};
   // 授信
    public final static String[] PERSON_CTRCT_TH = new String[]{ "tphc_ctrct_bs_sgmt" ,
                                                                 "tphc_ctrct_cert_rel_sgmt" ,
                                                                 "tphc_credit_lim_sgmt" };

    public final static String[] PERSON_CTRCT_TB = new String[]{ "tpbc_ctrct_bs_sgmt" ,
                                                                 "tpbc_ctrct_cert_rel_sgmt" ,
                                                                 "tpbc_credit_lim_sgmt" };


}
