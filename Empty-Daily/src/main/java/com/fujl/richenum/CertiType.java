package com.fujl.richenum;

import java.util.HashMap;
import java.util.Map;

public class CertiType {

    //私有静态对象,加载不做初始化
    private static CertiType m_instance = null;
    public Map<String,String> certiMap = new HashMap<>();

    //构造方法,给map设置初始值
    private CertiType(){
        setTypeForCerti();
    }

    //静态方法创建实体类
    synchronized public static CertiType getInstance(){
        if (m_instance == null){
            m_instance = new CertiType();
        }
        return m_instance;
    }

    //设置初始值
    private void setTypeForCerti() {
        certiMap.put("1","one");//1营业执照号码
        certiMap.put("2","two");//2组织机构代码
    }
}
