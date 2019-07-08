package com.Handler;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileHandler {
    /*
   1.传统方式文件上传
    */
    @RequestMapping("fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        // 使用fileupload组件进行上传
        // 上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在，不存在则新建文件夹
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        // 解析request对象，获取上传项目并指定存储位置
        DiskFileItemFactory factory = new DiskFileItemFactory();    // 将请求消息实体中的每个项目封装成对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(factory);   // 创建一个上传工具，指定使用缓存区和临时文件位置
        // 解析request
        List<FileItem> items = servletFileUpload.parseRequest(request);
        // 遍历对象
        for (FileItem item:items
        ) {
            //  获取上传文件夹名称
            String fileName = item.getName();
            //  获取一个唯一id值，赋值给文件名，保证文件名的唯一性
            String uuid = UUID.randomUUID().toString().replace("-", "");
            fileName = uuid+"_"+fileName;
            //  保存文件
            item.write(new File(path,fileName));
            //  清除缓存中文件
            item.delete();
        }
        return "success";
    }

    /*
    2.Springmvc方式上传文件
     */
    @RequestMapping("fileUpload2")
    // MultipartFile的参数名称需要和前端提交的name一致
    public String fileUpload2(HttpServletRequest request, MultipartFile upload)
        throws IOException {
        // 确认上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }
        // 原来的解析工作已经由springmvc的配置文件中的文件解析器完成
        // 获取上传名称
        String fileName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid+"_"+fileName;
        upload.transferTo(new File(path,fileName));
        return "success";
    }

    /*
    3.跨服务器上传文件
     */
    // MultipartFile的参数名称需要和前端提交的name一致
    @RequestMapping("fileUpload3")
    public String FileUpload3(MultipartFile upload) throws IOException {
        // 定义上传服务器路径
        String path = "http://localhost:9090/uploads/";

        // 原来的解析工作已经由springmvc的配置文件中的文件解析器完成
        // 获取上传名称
        String fileName = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid+"_"+fileName;

        // 创建客户端对象
        Client client = Client.create();
        // 连接图片上传服务器
        WebResource webResource = client.resource(path + fileName);
        // 上传文件
        webResource.put(upload.getBytes());
        return "success";
    }
}
