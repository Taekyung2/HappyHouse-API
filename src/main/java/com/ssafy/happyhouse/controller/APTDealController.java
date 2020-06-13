package com.ssafy.happyhouse.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/api/APTDeal")
public class APTDealController {

	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);

	@GetMapping("/{dongcode}")
	public   Map<String, Object>  getActualDealPrice(@PathVariable("dongcode")String dongcode) throws Exception {
		System.out.println("dongcode="+dongcode);
		   Map<String, Object> resultMap = new HashMap<>();		   
		   try {
		  StringBuilder urlBuilder = new StringBuilder("http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=h1kJ5ttM3gl1tvQVRXWMOhLCjN5NFL5o92pSdzj3beq038TkfNaZcoAF0YrthGLa9fYWr17b3lVicIavN4b6KQ%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("LAWD_CD","UTF-8") + "=" +URLEncoder.encode(dongcode, "UTF-8")); /*각 지역별 코드*/
	        urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD","UTF-8") + "=" + URLEncoder.encode("201910", "UTF-8")); /*월 단위 신고자료*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("30", "UTF-8")); /*데이터 출력수*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
//	        System.out.println(sb.toString());
            org.json.JSONObject xmlJSONObj = XML.toJSONObject(sb.toString());
            String xmlJSONObjString = xmlJSONObj.toString();
            System.out.println("### xmlJSONObjString=>"+xmlJSONObjString);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<>();
            map = objectMapper.readValue(xmlJSONObjString, new TypeReference<Map<String, Object>>(){});
            Map<String, Object> dataResponse = (Map<String, Object>) map.get("response");
            Map<String, Object> body = (Map<String, Object>) dataResponse.get("body");
            Map<String, Object> items = null;
            List<Map<String, Object>> itemList = null;
            items = (Map<String, Object>) body.get("items");
            itemList = (List<Map<String, Object>>) items.get("item");
//            System.out.println("### map="+map);
//            System.out.println("### dataResponse="+dataResponse);
//            System.out.println("### body="+body);
//            System.out.println("### items="+items);
//            System.out.println("### itemList="+itemList);
            resultMap.put("Result", "0000");
//            resultMap.put("numOfRows", body.get("numOfRows"));
//            resultMap.put("pageNo", body.get("pageNo"));
//            resultMap.put("totalCount", body.get("totalCount"));
            resultMap.put("data", itemList);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.clear();
            resultMap.put("Result", "0001");
        }
        return resultMap;
	}

}
