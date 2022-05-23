package com.fujl.pass;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.Key;
import java.util.*;

public class EncryptConfig {

//    public static void encryptPassword(String mybatisConfig) throws IOException {
//        String configPath;
//        if (mybatisConfig.startsWith(ResourceUtils.CLASSPATH_URL_PREFIX)) {
//            //  如果是classpath:/      地址路径
//            String path = mybatisConfig.substring(ResourceUtils.CLASSPATH_URL_PREFIX.length());
//            Resource resource = new ClassPathResource(path);
//            String absolutePath = resource.getFile().getAbsolutePath();
//            configPath = absolutePath.replace("mybatis.xml", "application-db.yaml");
//        } else {
//            //  如果是${user.dir} 地址路径
//            configPath = Paths.get(System.getProperty("user.dir"), "config", "application-db.yaml").toString();
//        }
//        File yamlFile = new File(configPath);
//        LinkedHashMap ymlMap = YmlUtils.getFromYml(yamlFile);
//        if (!ymlMap.isEmpty()) {
//            encryptPassword(ymlMap);
//        }
//        YmlUtils.updateYml(yamlFile, ymlMap);
//    }
public static void main(String[] args) {
    Map<String, Object> map = new HashMap<>();
    map.put("password","kjhs_boss_b");
    encryptPassword(map);
    System.out.printf(String.format("password is %s", map.get("password")));
}


    private static void encryptPassword(Map map) {
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            if (!ObjectUtils.isEmpty(key)) {
                if (Objects.equals(key, "password") && !(value instanceof Map)) {
                    if (!ObjectUtils.isEmpty(value) && !PBEEncrypt.hasEncryt(String.valueOf(value))) {
                        map.put("password", PBEEncrypt.encript(PBEEncrypt.PREFIX_ + value));
                    }
                } else if (value instanceof Map) {
                    encryptPassword((Map) value);
                }
            }
        }
    }


    @Slf4j
    public static class PBEEncrypt {
        public final static String PREFIX_ = "^a1@#?";
        private static final String PASSWD = "kdsjfpq4ioemvlj";
        private static final String SALT = "qazwsx12";
        private static final String ALGORITHM = "PBEWITHMD5andDES";
        private static int ITERAT_COUNT = 10;

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
        public static String decript(String text) throws Exception {
            PBEParameterSpec params = new PBEParameterSpec(SALT.getBytes("utf-8"), ITERAT_COUNT);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, PBE_KEY, params);
            return new String(cipher.doFinal(Base64.getDecoder().decode(text.getBytes("utf-8"))), "utf-8");
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
}
