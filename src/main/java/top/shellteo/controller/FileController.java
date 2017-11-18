package top.shellteo.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
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
    public Object uploadImg(@RequestParam(value = "file") MultipartFile file){
        String url = fileService.uploadImg(file);
        return url;
    }
}
