package com.example.javaknowledge2.demos.oss;

;
import com.example.javaknowledge2.demos.oss.service.impl.MinIOServiceImpl;
import com.example.javaknowledge2.demos.oss.storage.OssConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@RestController
public class OssController {

    @RequestMapping("/html1")
    public String html() {
        return "index.html";
    }

    @RequestMapping("/uploadFile")
    public static String uploadFile(String path) {
        File file = new File(path);
        FileInputStream inputStream = null;
        try {
            String fileName = file.getName();
            String objectKey = "ceshi/"+fileName;
            inputStream = new FileInputStream(file);
            MinIOServiceImpl minIOService = new MinIOServiceImpl();
            minIOService.putObject(OssConfiguration.bucket, objectKey, inputStream);
            return "redirect:/html/"+objectKey;
        } catch (Exception e) {
            e.printStackTrace();
            return "error11233";
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
