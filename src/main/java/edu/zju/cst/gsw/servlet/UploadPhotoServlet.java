package edu.zju.cst.gsw.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UploadPhotoServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = null;
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 设置上传文件的大小限制为1M
            factory.setSizeThreshold(1024 * 1024);

            List<FileItem> items = null;
            try {
                items = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            for (FileItem item : items) {
                if (!item.isFormField()) {

                    // 根据时间戳创建头像文件
                    filename = System.currentTimeMillis() + ".jpg";

                    //通过getRealPath获取上传文件夹，如果项目在e:/project/j2ee/web,那么就会自动获取到 e:/project/j2ee/web/uploaded
                    String photoFolder = req.getServletContext().getRealPath("uploaded");
                    System.out.println(photoFolder);

                    File f = new File(photoFolder, filename);
                    f.getParentFile().mkdirs();

                    // 通过item.getInputStream()获取浏览器上传的文件的输入流
                    InputStream is = item.getInputStream();

                    // 复制文件
                    FileOutputStream fos = new FileOutputStream(f);
                    byte[] b = new byte[1024 * 1024];
                    int length = 0;
                    while (-1 != (length = is.read(b))) {
                        fos.write(b, 0, length);
                    }
                    fos.close();

                } else {
                    System.out.println(item.getFieldName());
                    String value = item.getString();
                    value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
                    System.out.println(value);
                }
            }

            String html = "<img width='200' height='150' src='uploaded/%s' />";
            resp.setContentType("text/html");
            PrintWriter pw = resp.getWriter();

            pw.format(html, filename);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
