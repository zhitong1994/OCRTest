package com.shtx.utils;

import com.shtx.bean.JsonRootBean;
import com.alibaba.fastjson.JSONPObject;

public class JsonUtil {
	
	public static void ParserJson(String string) {
		
		String json = string;
		//获取外部的数据 
		JsonRootBean jsb = new JsonRootBean();
		JSONPObject obj = new JSONPObject(json);
		
		//获取items的数据
       
		
	}

}
