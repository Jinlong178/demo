package com.example.demo.util;

import com.example.demo.entity.PmAttachment;
import com.example.demo.entity.ResponseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadUtil {

    public ResponseResult upload(HttpServletRequest fileRequest, @RequestParam(required = false) String catalog) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)fileRequest;
        if (multipartRequest.getFileMap().size() == 0) {
        } else {
            List<PmAttachment> results = new ArrayList();
            multipartRequest.getFileMap().entrySet().forEach((entry) -> {
                List<MultipartFile> files = multipartRequest.getFiles((String)entry.getKey());

            });
        }
        return ResponseResult.success(true);
    }
}
