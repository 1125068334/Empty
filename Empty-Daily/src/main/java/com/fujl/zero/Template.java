package com.fujl.zero;//package com.fujl.zero;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Template {
//
//    private static final String url = "https://api.map.baidu.com/geoconv/v1/";// ?coords=114.21892734521,29.575429778924&from=1&to=5&ak=你的密钥 //GET请求
//
//    private static final String ak = "CKP6qhbsvZvHMjY1SsfGj9GaFI2VQaZK";
//
//    public static void main(String[] args) {
//
//        Map<String,Object> map = new HashMap<>();
//        map.put("coords","116.41338370,29.575429778924");
//        map.put("ak",ak);
//        map.put("from",1);
//        map.put("to",5);
//        ResponseEntity responseEntity = dealRequest(url+ "?coords=114.21892734521,29.5754297789244&from=1&to=5&ak=CKP6qhbsvZvHMjY1SsfGj9GaFI2VQaZK", map);
//        System.out.println(responseEntity);
//
//
//    }
//
//
//    private static ResponseEntity dealRequest(String url, Map<String,Object> map){
//        RestTemplate template = new RestTemplate();
//        ResponseEntity<String> entity = template.getForEntity(url, String.class);
//
//        ResponseEntity<String> ipAddr = template.getForEntity("https://api.map.baidu.com/location/ip?ak=CKP6qhbsvZvHMjY1SsfGj9GaFI2VQaZK&ip=221.217.50.33&coor=bd09ll", String.class);
//
//
//        System.out.println(entity.getBody());
//
//        return entity;
//    }
//}
