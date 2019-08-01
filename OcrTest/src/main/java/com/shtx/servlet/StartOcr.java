package com.shtx.servlet;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.shtx.utils.HttpUtils;

import java.util.*;

import static com.shtx.utils.Utils.*;

public class StartOcr {

    public static void main(String[] args)  {
        String host = "http://ocrdiy.market.alicloudapi.com";
        String path = "/api/predict/ocr_sdt";
        String method = "POST";
        String appcode = "你自己的";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();

//        String imgPath = "E:\\ocr.jpg";
//        try {
//			String imgUrl =  changeToBase64(imgPath);
//			System.out.println(imgUrl);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
        String bodys = null;
        try {
//            bodys =  "\"\"image\": imgUrl,\"configure\": \"{\"template_id\":\"你自己的模板id\"}\"\"";
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            prase(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
      
      System.out.println(bodys);
    }
    
    
    
}
