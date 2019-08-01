package com.shtx.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

@SuppressWarnings("restriction")
public class Utils {
	
    public static void output(String content) {
        System.out.println(content);
        File file = new File("E:\\result.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void prase(String string){
        JSONObject jsonObject=JSONObject.parseObject(string);
        JSONArray jsonArray=jsonObject.getJSONArray("ret");
        for (int i=0;i<jsonArray.size();i++){
            JSONObject newjsonObject=(JSONObject) jsonArray.get(i);
            output(newjsonObject.getString("rect"));
        }
    }
    

    public static String changeToBase64(String fileName) throws Exception{
        File file = new File(fileName);
        FileInputStream inputFile = new FileInputStream(file);
        byte[] buffer = new byte[(int)file.length()];
        inputFile.read(buffer);
        inputFile.close();
        @SuppressWarnings("restriction")
		String base64Code=new BASE64Encoder().encode(buffer);
        return base64Code;
    }
    
    
}
