package com.shtx.utils;

import com.shtx.bean.JsonRootBean;
import com.alibaba.fastjson.JSONPObject;

public class JsonUtil {
	
	public static void ParserJson(String string) {
		
		String json = string;
		//��ȡ�ⲿ������ 
		JsonRootBean jsb = new JsonRootBean();
		JSONPObject obj = new JSONPObject(json);
		
		//��ȡitems������
       
		
	}

}
