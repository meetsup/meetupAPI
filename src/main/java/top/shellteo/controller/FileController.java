package top.shellteo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.shellteo.service.FileService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 2017/10/28.
 */
@Controller
@RequestMapping(value = "/file",method = RequestMethod.POST)
public class FileController {
    @Autowired
    private FileService fileService;

    @ResponseBody
    @RequestMapping(value = "/upload")
    public String uploadImg(MultipartFile file, HttpServletRequest request){
        String test = file.getName();
        String url = fileService.uploadImg(file,request);
        return url;
    }
}
