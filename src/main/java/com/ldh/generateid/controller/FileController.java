package com.ldh.generateid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class FileController {

    @RequestMapping("/file")
    public void file(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String file = "/Users/ln/Downloads/lazygit_0.zip";
        FileInputStream fis = new FileInputStream(file);

        ServletOutputStream os = response.getOutputStream();
        int len = 0;
        byte bytes[] = new byte[1024];
        while((len = fis.read(bytes)) != -1){
            os.write(bytes);
        }
        fis.close();
    }
}
