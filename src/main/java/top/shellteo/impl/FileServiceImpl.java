package top.shellteo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.shellteo.service.FileService;
import top.shellteo.util.OSSClientUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 2017/10/28.
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Autowired
    private OSSClientUtil ossClientUtil;
    @Override
    public String uploadImg(MultipartFile file) {
        String fileUrl = "";
        if (file != null && file.getSize()>0){  //如果文件存在
            String fileName = ossClientUtil.uploadImg2Oss(file);    //返回文件名称
            fileUrl = ossClientUtil.getUrl(fileName);        //返回文件地址
        }
        return fileUrl;
    }
}
