package xxp.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import xxp.config.AppConfig;

@RestController
@RequestMapping(value="file")
@CrossOrigin(allowCredentials = "true")
public class FileUpload {

    @Autowired
    private AppConfig config;

//  @ApiOperation("上传图片，多文件")
    @PostMapping("/upload")
    @ResponseBody
    public List<String> upload(HttpServletRequest request1, MultipartHttpServletRequest request) throws IOException {
        String ctxPath = request1.getSession().getServletContext()
                .getRealPath("/");
//        System.out.println(ctxPath);
        List<String> result = new ArrayList<>();
        List<MultipartFile> files = request.getFiles("file");
        if (files.size() > 0) {
            for (MultipartFile multipartFile : files) {
//                System.out.println(multipartFile);
                result.add(handleFileUpload(multipartFile,request));
            }
        }
        return result;
    }


    /** 
     * @ 单一文件上传
     * @param file
     * @param request
     * @return
     */
    @RequestMapping("/upload2")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (!file.isEmpty()) {
            String saveFileName = getFileName(file);
            System.out.println(file.getName());
            File saveFile = new File(config.getUploadFolder() + saveFileName);
            System.out.println(saveFile.getAbsolutePath());
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return config.getPreviewPath() + saveFile.getName();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败,";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败,";
            }
        } else {
            return "上传失败，因为文件为空.";
        }
    }

    private String getFileName(MultipartFile file) {
        String name = file.getOriginalFilename();
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append(date.getTime());
        sb.append(name.substring(name.indexOf(".")));
        return sb.toString();
    }
    
    
    @RequestMapping("/download")
    public void downloadFile(@RequestParam String filePath, final HttpServletResponse response, final HttpServletRequest request){
        try {            
         
                File file = new File(filePath);
                // 取得文件名。
                String fileName = file.getName();
                // 以流的形式下载文件。
                InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                // 清空response
                response.reset();
                String uncod= URLDecoder.decode(fileName,"UTF-8");
                    fileName = new String(uncod.getBytes("UTF-8"), "iso-8859-1");
                response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(fileName)));
                // 设置response的Header
                response.addHeader("Content-Length", "" + file.length());
                OutputStream toClient = new BufferedOutputStream(
                        response.getOutputStream());
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
          
            // path是指欲下载的文件的路径。
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		

    }

}
