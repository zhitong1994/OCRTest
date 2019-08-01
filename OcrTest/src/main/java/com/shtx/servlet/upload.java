package com.shtx.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet("/upload")
@WebServlet(name = "upload", value = "/upload")
@MultipartConfig
public class upload extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		//�����ַ�����
        try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
    
        //��Ҫ�����Ŀ���ļ���Ŀ¼��
        String folderPath=getServletContext().getRealPath("/WEB-INF/upload");
        //�ж��ļ����Ƿ����
        File foder = new File(folderPath);
        if(!foder.exists()){
        	foder.mkdirs();
        }
        //�ļ��ϴ����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");
        //��������
        List<FileItem> list;
		try {
			list = upload.parseRequest(request);
			for (FileItem item : list){
	        	//�ϴ����ļ���������
	        	String imgName = item.getName();
	        	imgName = imgName.substring(imgName.lastIndexOf("\\")+1);
	        	//���������
	        	InputStream is = item.getInputStream();
	        	FileOutputStream fos = new FileOutputStream(new File(folderPath + "/" + imgName));
	        	
	        	  int len=0;
	              byte[] buff=new byte[1024*8];
	               
	              while ((len = is.read(buff)) > -1) {
	                  fos.write(buff, 0, len);
	              }
	              
	              //�ر����������
					fos.close();
					is.close();
					response.setCharacterEncoding("utf-8");
		            response.getWriter().print("upload success!!");
		            //System.out.println(upload);
//		            String imgPath = folderPath + "/" + imgName;
//		            System.out.println(imgPath);
		    } 
		}catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
                
        	
        }     
      
     
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


}
