package top.shellteo.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 2017/10/28.
 */
public interface FileService {
    String uploadImg(MultipartFile file);
}
