package com.fujl.richenum;

public enum TransCertiType {

    one("营业执照号码",TransCertiTypeEnumInterface.byTransOne()),
    two("组织机构代码",TransCertiTypeEnumInterface.byTransTwo());

    String memo;
    TransCertiTypeEnumInterface enumInterface;

    TransCertiType(String memo, TransCertiTypeEnumInterface inteface) {
        this.memo = memo;
        this.enumInterface = inteface;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public TransCertiTypeEnumInterface getEnumInterface() {
        return enumInterface;
    }

    public void setEnumInterface(TransCertiTypeEnumInterface enumInterface) {
        this.enumInterface = enumInterface;
    }
}
