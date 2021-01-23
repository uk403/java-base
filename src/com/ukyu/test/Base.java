package com.ukyu.test;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import com.sun.org.apache.bcel.internal.classfile.Code;
import sun.security.pkcs11.wrapper.CK_SSL3_KEY_MAT_OUT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ukyu
 * @date 2020/11/13
 **/
public class Base{

    public static void main(String[] args) {
        System.out.println(CodeType.P);
    }
}

enum CodeType {
    //订单编号
    /**
     * 开户
     */
    KH("KH", false),
    /**
     * 认购
     */
    RG("RG", false),
    /**
     * 收购
     */
    SG("SG", false),
    /**
     * 赎回
     */
    SH("SH", false),
    /**
     * 份额转让
     */
    ZR("ZR", false),
    /**
     * 分红
     */
    FH("FH", false),
    /**
     * 冻结
     */
    DJ("DJ", false),
    /**
     * 解冻
     */
    JD("JD", false),
    // 资产账号
    /**
     * 销售机构编号
     */
    SO("SO", true),
    /**
     * 销售渠道编号
     */
    SC("SC", true),
    // 客户编号
    /**
     * 个人
     */
    P("P",true),
    /**
     * 机构
     */
    O("O", true)
    ;

    private boolean noHms;

    public boolean getNoHms(){
        return noHms;
    }

    CodeType(String key, boolean noHms) {

        this.noHms = noHms;
    }
}
