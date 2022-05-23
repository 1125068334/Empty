package com.fujl;

import com.alibaba.fastjson.JSONObject;
import jodd.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.util.StopWatch;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class Empty {

    private static String sql = "select AGY_CODE,ACA_CODE,ACB_CODE,PERD, VOU_TYPE_CODE, VOU_NO, VOU_ID, VOU_DATE, DR_CR, CUR_CODE,DR_AMT, CR_AMT, STAD_AMT, CUR_AMT as CURR_AMT, QTY,  ACO_CODE, ACO_NAME, ACO_FULLNAME,  CURDR_AMT AS CURRDR_AMT, CURCR_AMT AS CURRCR_AMT, QTYDR_AMT, QTYCR_AMT, FX_RATE AS EX_RATE, PRICE_AMT, DETAIL_SUMMARY, VOU_SUMMARY, VOU_DETAIL_DESC, VOU_DETAIL_ASS_DESC,DETAIL_SEQ,DETAIL_ID, BILL_NO, BILL_DATE, EXPIRY_DATE, BUSS_DATE   from (SELECT H.AGY_CODE,H.ACB_CODE,H.ERR_FLAG,H.FISCAL,H.VOU_KIND,H.VOU_TYPE_CODE, H.VOU_NO,H.VOU_ID, H.PERD,H.VOU_DATE, H.VOU_STATUS,D.DETAIL_SEQ, D.DETAIL_ID, A.AUX_SEQ, A.BILL_NO, A.BILL_DATE, A.EXPIRY_DATE, A.BUSS_DATE, D.ACO_CODE, case when GA.MAD_NAME is null  then '' else GA.MAD_NAME end  ACO_NAME, case when GA.MAD_FNAME is null  then '' else GA.MAD_FNAME end  ACO_FULLNAME, case when A.DR_CR is null  then D.DR_CR else A.DR_CR end  DR_CR, case when A.STAD_AMT is null  then D.STAD_AMT else A.STAD_AMT end  STAD_AMT, A.CUR_AMT, case when A.QTY is null  then 0 else A.QTY end  QTY, case when  case when A.DR_CR is null  then D.DR_CR else A.DR_CR end =-1 then 0 else  case when A.STAD_AMT is null  then D.STAD_AMT else A.STAD_AMT end  end as DR_AMT, case when  case when A.DR_CR is null  then D.DR_CR else A.DR_CR end =-1 then  case when A.STAD_AMT is null  then D.STAD_AMT else A.STAD_AMT end  else 0 end as CR_AMT, case when  case when A.DR_CR is null  then D.DR_CR else A.DR_CR end =-1 then 0 else A.CUR_AMT end as CURDR_AMT, case when  case when A.DR_CR is null  then D.DR_CR else A.DR_CR end =-1 then A.CUR_AMT else 0 end as CURCR_AMT, case when  case when A.DR_CR is null  then D.DR_CR else A.DR_CR end =-1 then 0 else A.QTY end as QTYDR_AMT, case when  case when A.DR_CR is null  then D.DR_CR else A.DR_CR end =-1 then A.QTY else 0 end as QTYCR_AMT,  A.PRICE_AMT, A.FX_RATE,GA.ACA_CODE,A.EXPFUNC_CODE,A.GOVEXPECO_CODE,A.EXPECO_CODE,A.DEPPRO_CODE,A.PROJECT_CODE,A.PROTYPE_CODE,A.CHARGEITEM_CODE,A.FUNDTYPE_CODE,A.BUDSOURCE_CODE,A.FUNDSOURCE_CODE,A.PAYTYPE_CODE,A.EXPTYPE_CODE,A.SETMODE_CODE,A.CURRENT_CODE,A.DEPARTMENT_CODE,A.EMPLOYEE_CODE,A.FATYPE_CODE,A.ACITEM01_CODE,A.ACITEM02_CODE,A.ACITEM03_CODE,A.ACITEM04_CODE,A.ACITEM05_CODE,A.ACITEM06_CODE,A.ACITEM07_CODE,A.ACITEM08_CODE,A.ACITEM09_CODE,A.ACITEM10_CODE,A.ACITEM11_CODE,A.ACITEM12_CODE,A.ACITEM13_CODE,A.ACITEM14_CODE,A.ACITEM15_CODE,A.ACITEM16_CODE,A.ACITEM17_CODE,A.ACITEM18_CODE,A.ACITEM19_CODE,A.ACITEM20_CODE,A.ACITEM21_CODE,A.ACITEM22_CODE,A.ACITEM23_CODE,A.ACITEM24_CODE,A.ACITEM25_CODE,A.ACITEM26_CODE,A.ACITEM27_CODE,A.ACITEM28_CODE,A.ACITEM29_CODE,A.ACITEM30_CODE,A.ACITEM31_CODE,A.ACITEM32_CODE, case when A.CUR_CODE is null  then 'RMB' else A.CUR_CODE end  CUR_CODE, CASE WHEN (D.DETAIL_SUMMARY='' or D.DETAIL_SUMMARY is null ) THEN (CASE WHEN (H.VOU_SUMMARY='' or H.VOU_SUMMARY is null) THEN '' ELSE H.VOU_SUMMARY END) ELSE D.DETAIL_SUMMARY END  as DETAIL_SUMMARY, H.VOU_SUMMARY as VOU_SUMMARY,  case when (D.DETAIL_SUMMARY='' or D.DETAIL_SUMMARY is null ) then H.VOU_SUMMARY else D.DETAIL_SUMMARY end as VOU_DETAIL_DESC, A.REMARK as VOU_DETAIL_ASS_DESC,  D.MOF_DIV_CODE as MOF_DIV_CODE  FROM GAL_VOU_DETAIL D left join GAL_VOUCHER H  on H.FISCAL=D.FISCAL AND H.AGY_CODE=D.AGY_CODE AND H.ACB_CODE=D.ACB_CODE AND H.VOU_ID=D.VOU_ID  left join GAL_VOU_AUX A on D.FISCAL=A.FISCAL AND D.AGY_CODE=A.AGY_CODE AND D.ACB_CODE=A.ACB_CODE AND D.VOU_ID=A.VOU_ID AND D.DETAIL_ID=A.DETAIL_ID left join MAD_ACO GA on D.FISCAL=GA.FISCAL AND D.AGY_CODE=GA.AGY_CODE  and D.ACB_CODE=GA.ACB_CODE AND D.ACO_CODE=GA.MAD_CODE  and D.MOF_DIV_CODE=GA.MOF_DIV_CODE  WHERE D.FISCAL=2021 AND D.AGY_CODE='1001' AND D.MOF_DIV_CODE='87' AND D.ACB_CODE='0001'AND D.PERD<=12 AND H.ERR_FLAG <> '1')B where  B.FISCAL='2021' AND B.AGY_CODE='1001' AND B.ACB_CODE='0001' AND B.MOF_DIV_CODE='87'  AND (  ( B.ACO_CODE = '50010110' OR B.ACO_CODE = '500107' OR B.ACO_CODE = '500106' OR B.ACO_CODE = '500105' OR B.ACO_CODE = '500104' OR B.ACO_CODE = '500109' OR B.ACO_CODE = '500108' OR B.ACO_CODE = '50010105' OR B.ACO_CODE = '50010103' OR B.ACO_CODE = '5001010101' OR B.ACO_CODE = '50010109' OR B.ACO_CODE = '50010107' OR B.ACO_CODE = '5001010205' OR B.ACO_CODE = '5001010403' OR B.ACO_CODE = '5001010601' OR B.ACO_CODE = '5001010206' OR B.ACO_CODE = '5001010404' OR B.ACO_CODE = '5001010602' OR B.ACO_CODE = '5001010405' OR B.ACO_CODE = '5001010801' OR B.ACO_CODE = '5001010802' OR B.ACO_CODE = '5001010102' OR B.ACO_CODE = '5001010201' OR B.ACO_CODE = '5001010202' OR B.ACO_CODE = '5001010203' OR B.ACO_CODE = '5001010401' OR B.ACO_CODE = '5001010204' OR B.ACO_CODE = '5001010402' OR B.ACO_CODE = '500103' OR B.ACO_CODE = '500102' )  ) AND B.VOU_DATE >='2021-01-01'  AND B.VOU_DATE <='2021-12-15'  AND B.VOU_STATUS IN('P','F','A','D') AND B.ACA_CODE = 'fac'  AND B.VOU_KIND <>'B' order by B. PERD, B. VOU_DATE, B. VOU_TYPE_CODE, B. VOU_NO, B. DETAIL_SEQ  , B.ACO_CODE;\n";

    public static void main(String[] args) {
        String str = "{errorMsg=数据不存在！}";
        System.out.println(str.contains("{errorMsg=数据不存在！}"));;

        String a = new String("124");
        String b = new String("125");
        a = b = "2";
        System.out.println(a);
        System.out.println(b);
//        System.out.println(a == b);
//        System.out.println(a.equals(b));
//        String aI = a.intern();
//        String bI = b.intern();
//        System.out.println(aI == bI);
//        System.out.printf("a : %s, b: %s, aI: %s, bI: %s", a, b, aI, bI);
//
//        System.out.println(a.repeat(1));

//        String[] arr ={"123","123","234"};
//        String maxCountWord = getMaxCountWord(arr);
//        System.out.println(maxCountWord);
//        timeCompare();
//        intCompare();
//        toUpperMapKey();
//        testFastJson();
//        testFastJson();

//        String s = DigestUtils.md5Hex("123456");
//        System.out.println(s);
//
//        String pass = PBEEncrypt.encript("123456");
//        System.out.println(pass);
//        pass = PBEEncrypt.decript(pass);
//        System.out.println(pass);

//        String townhRY77t = DigestUtils.md5Hex("TownhRY77t");
//        System.out.println(townhRY77t);
//
//        String replace = UUID.randomUUID().toString().replace("-", "");
//        System.out.println(replace.length());

//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> alist = Arrays.asList(6, 5, 4, 3, 2, 1);
//        for (Integer integer : list) {
//            Integer integer1 = alist.get(list.indexOf(integer));
//            System.out.println(integer1);
//        }


//        List<Integer> result = new ArrayList<>();
//        int i = 10 / 3;
//        int k = 10 % 3;
//        for (int j = 0; j < i; j++) {
//            result.addAll(list);
//        }
//        result.addAll(list.subList(0, k));
//
//        System.out.println(i + "-----" + k);
    }

    private static void test(){
        String a = "1234";
        if (a.length() > 3) {
            a = a.substring(a.length() - 3);
        }
        System.out.println(a);
    }

    private static void timeCompare() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制

            long newTime1 = simpleDateFormat.parse("2022-03-08 18:56:54").getTime();

            long newTime2 = simpleDateFormat.parse("2022-03-09 23:56:54").getTime();

            Long result = newTime1 - newTime2; //获取两时间相差的毫秒数

            long nd = 1000 * 24 * 60 * 60;

            long nh = 1000 * 60 * 60;

            long nm = 1000 * 60;

            long hour = result % nd / nh; //获取相差的小时数

            System.err.println(hour);
        } catch (ParseException e) {

        }
    }

    private static void intCompare() {
        Integer a = 9999;
        System.out.println(a.compareTo(99999));
        System.out.println(a.compareTo(9999));
        System.out.println(a.compareTo(9998));
    }

    // 加密
    public static class PBEEncrypt {
        public final static String PREFIX_ = "^a1@#?";
        private static final String PASSWD = "kdsjfpq4ioemvlj";
        private static final String SALT = "qazwsx12";
        private static final String ALGORITHM = "PBEWITHMD5andDES";
        private static int ITERAT_COUNT = 32;

        private static Key PBE_KEY;

        static {
            try {
                PBEKeySpec spec = new PBEKeySpec(PASSWD.toCharArray());
                SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
                PBE_KEY = factory.generateSecret(spec);
            } catch (Exception ex) {
                log.error("error:", ex);
            }
        }

        // 加密
        public static String encript(String text) {
            try {
                PBEParameterSpec params = new PBEParameterSpec(SALT.getBytes("utf-8"), ITERAT_COUNT);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.ENCRYPT_MODE, PBE_KEY, params);
                byte[] bytes = cipher.doFinal(text.getBytes("utf-8"));
                return Base64.getEncoder().encodeToString(bytes);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        // 解密
        public static String decript(String text) {
            try {
                PBEParameterSpec params = new PBEParameterSpec(SALT.getBytes("utf-8"), ITERAT_COUNT);
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                cipher.init(Cipher.DECRYPT_MODE, PBE_KEY, params);
                return new String(cipher.doFinal(Base64.getDecoder().decode(text.getBytes("utf-8"))), "utf-8");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        // 判断是否已经加密
        public static boolean hasEncryt(String t) {
            if (t == null || t.length() == 0) {
                return false;
            } else {
                try {
                    return decript(t).startsWith(PREFIX_);
                } catch (Exception e) {
                    return false;
                }
            }
        }
    }

    private static void testFormat(){
        log.info(String.format("年度%d 单位%s  查询到%d 条待上传数据", 2021, "nihao", 12));

    }

    private static void testLoop(){
        int i = 0;
        for (;;){
            i++;
            if (i == 7) {
                break;
            }
        }
        System.out.println("" + i);
    }

    private static void testFastJson(){
        String data = txt2String(new File("C:\\Users\\jianglong\\Desktop\\a.txt"));
        data = data.replace("use","other");
        data = data.replaceAll("\\\\", "\\\\\\\\");
        JSONObject jsonObject = JSONObject.parseObject(data);
        System.out.println(jsonObject.toJSONString());
    }

    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
        String result = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result = result + "\n" +s;
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private static void toUpperMapKey(){
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put("a"+i,i);
        }
        Map<String, Object> temp = new HashMap<>(map.size());
        StopWatch watch = new StopWatch();
        watch.start("111111");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            temp.put(entry.getKey().toUpperCase(Locale.ROOT),entry.getValue());
        }
        watch.stop();
        System.err.println(watch.prettyPrint());
        StopWatch watch1 = new StopWatch();
        watch1.start("222222");
        Map<String, Object> m = new HashMap<>(map.size());
        for (String next : map.keySet()) {
            m.put(next.toUpperCase(Locale.ROOT), map.get(next));
        }
        map.clear();
        watch1.stop();
        System.err.println(watch1.prettyPrint());
    }

    private String toUpperSql(String sql){
        StringBuilder sb = new StringBuilder();
        sql.replace("FROM","from");
        String[] froms = sql.split("from");
        System.out.println(froms.length);
        if (froms.length > 1) {
            String arr = froms[0];
            arr = arr.replace("select", "");
            String[] column = arr.split(",");
            for (String s : column) {
                if (s.contains("as")) {
                    String[] as = s.split("as");
                    sb.append(as[0]).append(" as ").append("\"").append(as[1].toUpperCase(Locale.ROOT)).append("\"");
                } else if (s.contains("AS")) {
                    String[] as = s.split("AS");
                    sb.append(as[0]).append(" as ").append("\"").append(as[1].toUpperCase(Locale.ROOT)).append("\"");
                }else{
                    s = s.trim();
                    sb.append(s).append(" as ").append("\"").append(s.toUpperCase(Locale.ROOT)).append("\"");
                }
                sb.append(",");
            }
            froms[0] = sb.substring(0, sb.length() - 1);
        }
        sql = "select " + froms[0] + "from" + froms[1];
        System.out.println(sql);
        return sql;
    }

    /**
     * map集合元素key转换大写
     */
    public static List<Map<String, Object>> toUpperMapKey(List<Map<String, Object>> list) {
        if (isContainLowerKey(list)) {
            List<Map<String, Object>> result = new ArrayList<>();
            for (Map<String, Object> map : list) {
                Map<String, Object> resultMap = new HashMap<>();
                for (String key : map.keySet()) {
                    resultMap.put(key.toUpperCase(), map.get(key));
                }
                result.add(resultMap);
            }
            list = result;
        }
        return list;
    }

    /**
     * 判断集合元素map中是否含有小写key
     */
    private static boolean isContainLowerKey(List<Map<String, Object>> list) {
        for (Map<String, Object> map : list) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                entry.getKey();

            }
            for (String key : map.keySet()) {
                char[] chars = key.toCharArray();
                for (char ch : chars) {
                    if (ch >= 'a' && ch <= 'z') {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static String getMaxCountWord(String[] s) {
        int len = s.length;
        if(len == 0){
            return null;
        }
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            String str = s[i];
            if(map.keySet().contains(str)){
                map.put(str,map.get(str)+1);
            }else{
                map.put(str,1);
            }
        }
        Integer max = getMaxValue(map);
        if(null == max){
            return null;
        }
        for(Map.Entry<String,Integer>  entry : map.entrySet()){
            if(entry.getValue() == max){
                return entry.getKey();
            }
        }
        return null;
    }
    /**
     * 获取map中最大的value值
     */
    private static Integer getMaxValue(Map<String,Integer> map){
        Collection<Integer> values = map.values();
        if(values.size() <= 0){
            return null;
        }
        Object[] array = values.toArray();
        int max = Integer.parseInt(array[0].toString());
        for(int i = 1;i < array.length;i++){
            int a = Integer.parseInt(array[i].toString());
            if (a > max) {
                max = a;
            }
        }
        return max;
    }


    @Test
    public void test1(){

        String mofDivCode = "330302";
        Integer fiscal = null;
        String depproCode = "330302220130205002003";
        System.out.println(isDeppro(mofDivCode,fiscal,depproCode));



    }

    private boolean isDeppro(String mofDivCode, Integer fiscal, String depproCode) {
        if (StringUtil.isEmpty(depproCode) || depproCode.length() != 21) {
            return Boolean.FALSE;
        }
        String preMofDiv = depproCode.substring(0, 6);
        String subFiscal = depproCode.substring(6, 8);
        if (!Objects.equals(mofDivCode, preMofDiv) || null == fiscal|| !Objects.equals(fiscal.toString().substring(2, 4), subFiscal)) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }



}
