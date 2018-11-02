/**
 * Copyright(C) K16SE 2014
 *
 * DiemController.java, Aug 26, 2014 HaVH
 *
 */
package com.managestudent.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFileController
 */
public class UploadFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFileController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(RequestContext request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
        	// Create a factory for disk-based file items
        	FileItemFactory factory = new DiskFileItemFactory();

        	// Create a new file upload handler
        	ServletFileUpload upload = new ServletFileUpload(factory);

            try {
				List<FileItem> items = upload.parseRequest(request);
                for(FileItem item : items) {
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        String root = "C:/Users/thuynt/eclipse-workspace/QuanLySinhVien/WebContent";
                        File path = new File(root + "/images/SinhVienImg");
                        if (!path.exists()) {
							path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);
                        item.write(uploadedFile);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
	}

}
