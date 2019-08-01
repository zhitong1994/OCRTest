package com.shtx.servlet;

import static com.shtx.utils.Utils.changeToBase64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shtx.utils.HttpUtils;
import com.shtx.utils.Utils;

@WebServlet(name = "upOcr", value = "/upOcr")
@MultipartConfig
@SuppressWarnings("serial")
public class upOcr extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");
		  
		  String folderPath=getServletContext().getRealPath("/WEB-INF/upload");
	        //判断文件夹是否存在
	        File foder = new File(folderPath);
	        if(!foder.exists()){
	        	foder.mkdirs();
	        }
	        //文件上传组件
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload upload = new ServletFileUpload(factory);
	        upload.setHeaderEncoding("UTF-8");
	        //解析请求
	        List<FileItem> list;
			try {
				list = upload.parseRequest(request);
				for (FileItem item : list){
		        	//上传的文件保存名称
		        	String imgName = item.getName();
		        	imgName = imgName.substring(imgName.lastIndexOf("\\")+1);
		        	//输入输出流
		        	InputStream is = item.getInputStream();
		        	FileOutputStream fos = new FileOutputStream(new File(folderPath + "/" + imgName));
		        	
		        	  int len=0;
		              byte[] buff=new byte[1024*8];
		               
		              while ((len = is.read(buff)) > -1) {
		                  fos.write(buff, 0, len);
		              }
		              
		              //关闭输入输出流
						fos.close();
						is.close();
						response.getWriter().print("upload success!!");
					// 调用阿里云api
						String imgPath = folderPath + "/" + imgName;
						String host = "http://ocrdiy.market.alicloudapi.com";
				        String path = "/api/predict/ocr_sdt";
				        String method = "POST";
				        String appcode = "你自己的appcode";
				        Map<String, String> headers = new HashMap<String, String>();
				        headers.put("Authorization", "APPCODE " + appcode);
				        headers.put("Content-Type", "application/json; charset=UTF-8");
				        Map<String, String> querys = new HashMap<String, String>();
				        
				        String bodys = null;
				        bodys =  "{\"image\":\""+ changeToBase64(imgPath)+"\",\"configure\": \"{\\\"template_id\\\":\\\"你自己的模板id\\\"}\"}";
				     
				        HttpResponse response1 = HttpUtils.doPost(host, path, method, headers, querys, bodys);
			
				        String result = EntityUtils.toString(response1.getEntity());
				           
					       System.out.println(result);
					       
					    //   JSONObject jsonObject = JSONObject.parseObject(result);

					  //     Object js = jsonObject.get("items");
					       
					  //     String m = js.toString();
					  //     System.out.println(m);
					       
				}}catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	

	      
        	
        }     
      


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        
    }

}
