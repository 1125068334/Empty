package com.fujl.arithmetic;


/**
 * 进制转换 TODO fujl 202206031018
 */
public class HexTrans {

    public static void main(String[] args) {
//        System.out.println(tenToOther(2,19));

        System.out.println(resize(92));
    }

    /**
     * @param tar
     * @param oriValue
     * @return
     */
    public static int tenToOther(int tar, int oriValue) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(oriValue % tar);
            oriValue /= tar;
        }while (oriValue != 0);
        if (sb.toString() != "") {
            return Integer.valueOf(sb.toString());
        }
        return 0;
    }


    public static int otherToTen(int tar, int oriValue) {




        return 0;
    }

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static int resize(int cap){
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
