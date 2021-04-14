package com.big.song.credit.sup.util;

import org.dom4j.*;
import java.util.Iterator;
import java.util.List;

public class ChangeTXTValue {

    public static String changeValue(String xmlCont,Integer creditCode,String unionCode,String nodeTag,String xmlTag,String newValue){
        Document doc = null; // 将字符串转为XML
        try {
            doc = DocumentHelper.parseText(xmlCont);
            Element rootElt = doc.getRootElement(); // 获取根节点
            String xmlUnionCode=null;
            switch (creditCode){
                case 114: //个人基本信息
                    Element inBasInf = rootElt.element("InBasInf");
                    xmlUnionCode= inBasInf.element("BsSgmt").element("IDNum").getText();
                    break;
                case 214://个人借贷
                    Element acctInf = rootElt.element("InAcctInf");
                    xmlUnionCode = acctInf.element("AcctBsSgmt").element("AcctCode").getText();
                    break;
                case 224://个人授信
                    Element inCtrctInf = rootElt.element("InCtrctInf");
                    xmlUnionCode = inCtrctInf.element("CtrctBsSgmt").element("ContractCode").getText();
                    break;
                case 314: //企业基本信息
                    Element enBasInf = rootElt.element("EnBasInf");
                    xmlUnionCode= enBasInf.element("BsSgmt").element("EntCertNum").getText();
                    break;
                case 414: //企业借贷
                    Element enAcctInf = rootElt.element("EnAcctInf");
                    xmlUnionCode = enAcctInf.element("AcctBsSgmt").element("AcctCode").getText();
                    break;
                case 424: //企业授信e
                    Element enCtrctInf = rootElt.element("EnCtrctInf");
                    xmlUnionCode = enCtrctInf.element("CtrctBsSgmt").element("ContractCode").getText();
                    break;
                case 514: //抵质押
                    Element motgaCltalCtrctInf = rootElt.element("MotgaCltalCtrctInf");
                    xmlUnionCode = motgaCltalCtrctInf.element("MotgaCltalCtrctBsSgmt").element("CcCode").getText();
                    if(xmlUnionCode.equals(unionCode)){
                        List elements=   motgaCltalCtrctInf.elements(nodeTag);
                        for (Iterator it = elements.iterator(); it.hasNext();) {

                      }
                    }
                    break;
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }
        System.out.println(doc);

return  null;


    }


//    public static void main(String[] args) {
//        String inPath="C:\\Users\\thinkpad\\Desktop\\永辉小贷\\报文加载与反馈（清库后）\\测试用\\抵质押\\newFile";
//        // 读取所有的txt报文
//        List<String> fileList= TxtFileUtil.getFileList(inPath);
//        String demo="<Document><MotgaCltalCtrctInf><MotgaCltalCtrctBsSgmt><InfRecType>510</InfRecType><CcCode>X5001010000249HETO202006231104160050</CcCode><RptDate>2020-10-20</RptDate><RptDateCode>10</RptDateCode><InfoIDType>2</InfoIDType><Name>北京鹏程万达科技发展集团有限公司</Name><CertType>10</CertType><CertNum>1101020001022401</CertNum><MngmtOrgCode>X5001010000249</MngmtOrgCode></MotgaCltalCtrctBsSgmt><MotgaCltalBsInfSgmt><GuarType>2</GuarType><CcAmt>10000000</CcAmt><Cy>CNY</Cy><CcValDate>2020-06-16</CcValDate><CcExpDate>2021-06-03</CcExpDate><MaxGuar>1</MaxGuar><CcStatus>1</CcStatus></MotgaCltalBsInfSgmt><CltalInfSgmt><ImpNm>1</ImpNm><ImpInf><ImpType>24</ImpType><ImpVal>10000000</ImpVal><ImpCy>CNY</ImpCy><Ippc>2</Ippc><PawnName>北京鹏程万达科技发展集团有限公司</PawnName><PawnCertType>10</PawnCertType><PawnCertNum>1101020001022401</PawnCertNum></ImpInf></CltalInfSgmt></MotgaCltalCtrctInf></Document>";
//        changeValue(demo,514,"X5001010000249HETO202006231104160050","MotgaCltalBsInfSgmt","CcAmt","wwww");
//    }

}
