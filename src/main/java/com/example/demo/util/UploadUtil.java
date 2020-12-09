package com.example.demo.util;

import cn.hutool.core.util.StrUtil;
import com.example.demo.entity.ApplicationProperties;
import com.example.demo.entity.FileModel;
import com.example.demo.entity.PmAttachment;
import com.example.demo.entity.ResponseResult;
import com.example.demo.service.IPmAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/upload")
public class UploadUtil {

    @Autowired
    private IPmAttachmentService iPmAttachmentService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Value("${cbs.imagesPath}")
    private String mImagesPath;

    @PostMapping("/uploadMul")
    public ResponseResult upload(HttpServletRequest fileRequest, @RequestParam(required = false) String catalog) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)fileRequest;
        if (multipartRequest.getFileMap().size() == 0) {
            return ResponseResult.success(null);
        } else {
            List<PmAttachment> results = new ArrayList();
            multipartRequest.getFileMap().entrySet().forEach((entry) -> {
                List<MultipartFile> files = multipartRequest.getFiles((String)entry.getKey());
                results.addAll(upload(files, catalog, (String)null));
            });
            return ResponseResult.success(results);
        }
    }

    public List<PmAttachment> upload(List<MultipartFile> files, String catalog, String creator) {
        List<PmAttachment> attachments = new ArrayList();
        upload(files, catalog).forEach((s) -> {
            try {
                PmAttachment attachment = new PmAttachment();
                attachment.setAbsolutePath(s.getAbsolutePath());
                attachment.setCatalogPath(s.getCatalogPath());
                attachment.setFileSize(s.getFileSize());
                attachment.setLogicName(s.getLogicName());
                attachment.setName(s.getName());
                attachment.setPath(s.getPath());
                attachment.setSimpleName(s.getSimpleName());
                attachment.setSuffix(s.getSuffix());
                this.iPmAttachmentService.save(attachment);
                attachments.add(attachment);
            } catch (Exception var6) {
                var6.printStackTrace();
            }

        });
        return attachments;
    }

    public List<FileModel> upload(List<MultipartFile> files, String catalog) {
        if (files != null && files.size() != 0) {
            List<FileModel> datas = new ArrayList();
            files.forEach((f) -> {
                try {
                    FileModel fileModel = this.transfer(f, catalog);
                    if (Optional.ofNullable(fileModel).isPresent()) {
                        datas.add(fileModel);
                    }
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

            });
            return datas;
        } else {
            return new ArrayList();
        }
    }

    private FileModel transfer(MultipartFile file, String catalog) {
        FileModel fileModel = null;
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            if (originalFilename.contains("\\")) {
                originalFilename = originalFilename.substring(originalFilename.lastIndexOf("\\") + 1);
            }

            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String basename = this.applicationProperties.getMasterStore().getPath().trim();
            basename = basename.replace("\\", "/");
            basename = basename.replace("//", "/");
            if (!basename.endsWith("/")) {
                basename = basename + "/";
            }

            String logicName = UUID.randomUUID().toString() + suffix;
            String c = StrUtil.isEmpty(catalog) ? "" : catalog;
            if (StrUtil.isNotEmpty(c)) {
                c = c.replace("\\", "/");
                c = c.replace("//", "/");
                c = c.endsWith("/") ? c : c + "/";
                c = c.startsWith("/") ? c : "/" + c;
            }

            String path = c + "/" + logicName;
            path = path.replace("//", "/");
            String absolutePath = basename + path;
            absolutePath = absolutePath.replace("//", "/");
            File dest = new File(absolutePath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }

            try {
                file.transferTo(dest);
            } catch (IOException | IllegalStateException var14) {
                var14.printStackTrace();
            }

            fileModel = new FileModel();
            fileModel.setSimpleName(originalFilename.replace(suffix, ""));
            fileModel.setName(originalFilename);
            fileModel.setSuffix(suffix.substring(1));
            fileModel.setLogicName(logicName);
            fileModel.setAbsolutePath(absolutePath);
            fileModel.setCatalogPath(absolutePath.replace(logicName, ""));
            fileModel.setPath(path);
            fileModel.setFileSize(file.getSize());
        }

        return fileModel;
    }
}
