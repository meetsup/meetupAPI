package top.shellteo.impl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.shellteo.entity.FilePage;
import top.shellteo.entity.Response;
import top.shellteo.service.FileService;
import top.shellteo.util.OSSClientUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HP on 2017/10/28.
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
    @Autowired
    private OSSClientUtil ossClientUtil;
    @Override
    public String uploadImg(MultipartFile file) {
        try {
            String fileUrl = "";
            if (file != null && file.getSize()>0){  //如果文件存在
                String fileName = ossClientUtil.uploadImg2Oss(file);    //返回文件名称
                fileUrl = ossClientUtil.getUrl(fileName);        //返回文件地址
            }
            return JSONObject.fromObject(new Response("0","","",new FilePage(fileUrl))).toString();
        } catch (Exception e) {
            return JSONObject.fromObject(new Response("1","",e.getMessage(),null)).toString();
        }
    }
}
