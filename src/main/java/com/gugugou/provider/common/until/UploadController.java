package com.gugugou.provider.common.until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

/**
 * @author: chengShaoShao
 * @Title: UploadController
 * @ProjectName: provider
 * @Description:
 * @date 2019/12/16 10:35
 */
@RestController
public class UploadController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/upload")
    public JsonResultVo upload(@RequestParam("file") MultipartFile file) {
        JsonResultVo jsonResultVo = new JsonResultVo();
        if (file.isEmpty()) {
            jsonResultVo.setCount(1);
            jsonResultVo.setData("上传失败，请选择文件");
            return jsonResultVo;
        }
        String fileName = file.getOriginalFilename();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        String filePath = "upload/image/pic/" + year + "/" + month + "/" + date;
        File file1 = new File(filePath);
        // 判断文件是否存在，如果不存在，则创建此文件夹
        if (!file1.exists()) {
            file1.mkdir();
        }
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            logger.info("上传成功");
            jsonResultVo.setCount(0);
            jsonResultVo.setData("上传成功");
            return jsonResultVo;
        } catch (IOException e) {
            logger.error(e.toString(), e);
        }
        jsonResultVo.setCount(1);
        jsonResultVo.setData("上传失败！");
        return jsonResultVo;
    }


    @PostMapping("/multiUpload")
    public JsonResultVo multiUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String filePath = "E:/image/pic/";
        JsonResultVo jsonResultVo = new JsonResultVo();
        for (int i = 0; i < files.size(); i++) {
            MultipartFile file = files.get(i);
            if (file.isEmpty()) {
                jsonResultVo.setCount(1);
                jsonResultVo.setData("上传第" + (i++) + "个文件失败");
                return jsonResultVo;
            }
            String fileName = file.getOriginalFilename();

            File dest = new File(filePath + fileName);
            try {
                file.transferTo(dest);
                jsonResultVo.setCount(0);
                jsonResultVo.setData("上传成功");
                logger.info("第" + (i + 1) + "个文件上传成功");
            } catch (IOException e) {
                jsonResultVo.setCount(1);
                jsonResultVo.setData("上传第" + (i++) + "个文件失败");
                logger.error(e.toString(), e);
                return jsonResultVo;
            }
        }
        return jsonResultVo;
    }
}
