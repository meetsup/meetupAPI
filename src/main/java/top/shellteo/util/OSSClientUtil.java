package top.shellteo.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.LogUtils;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import top.shellteo.exception.BusinessException;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.Random;

/**
 * Created by HP on 2017/10/28.
 */
@Component("oSSClientUtil")
public class OSSClientUtil {
    private final static Log log = LogUtils.getLog();
    // endpoint以杭州为例，其它region请按实际情况填写
    private String endpoint = "oss-cn-hangzhou.aliyuncs.com";
    // accessKey
    private String accessKeyId = "LTAIZolpNW0wfr3c";
    private String accessKeySecret = "QiG8RBDaCEXDvyo0LcCfZAWn6DbVnO";
    //空间
    private String bucketName = "meetsup";
    //文件存储目录
    private String filedir = "activityPic/";

    private OSSClient ossClient;

    public OSSClientUtil() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 初始化
     */
    public void init() {
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }

    /**
     * 销毁
     */
    public void destory() {
        ossClient.shutdown();
    }

    /**
     * 上传图片
     *
     * @param url
     */
    public void uploadImg2Oss(String url) {
        File fileOnServer = new File(url);
        FileInputStream in;
        try {
            in = new FileInputStream(fileOnServer);
            String[] split = url.split("/");
            this.uploadFile2OSS(in, split[split.length - 1]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            log.error("图片上传失败",e);
        }
    }

    public String uploadImg2Oss(MultipartFile file) {
        if (file.getSize() > 1024 * 1024 * 10) {
            log.error("上传文件大小不能超过10M");
        }
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            InputStream inputStream = file.getInputStream();
            this.uploadFile2OSS(inputStream, name);
            return filedir+name;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败",e);
            throw new BusinessException(e);
        }
    }

    /**
     * 获得图片路径
     *
     * @param fileUrl
     * @return
     */
    public String getImgUrl(String fileUrl) {
        if (!StringUtils.isEmpty(fileUrl)) {
            String[] split = fileUrl.split("/");
            return this.getUrl(this.filedir + split[split.length - 1]);
        }
        return null;
    }

    /**
     * 上传到OSS服务器  如果同名文件会覆盖服务器上的
     *
     * @param instream 文件流
     * @param fileName 文件名称 包括后缀名
     * @return 出错返回"" ,唯一MD5数字签名
     */
    public String uploadFile2OSS(InputStream instream, String fileName) {
        //这里可以对文件格式进行控制
        String text = fileName.substring(fileName.lastIndexOf(".")+1);
        if (!text.equalsIgnoreCase("jpg") && !text.equalsIgnoreCase("jpeg") && !text.equalsIgnoreCase("png")
                && !text.equalsIgnoreCase("gif") && !text.equalsIgnoreCase("bmp")){
            throw new BusinessException("上传的格式不符合要求,目前只准许上传的格式包括:jpg/jpeg/png/gif/bmp");
        }
        String ret = "";
        try {
            //创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(instream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf(".")+1)));
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            //上传文件
            PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
            ret = putResult.getETag();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件上传oss服务器失败", e);
        } finally {
            try {
                if (instream != null) {
                    instream.close();
                }
            } catch (IOException e) {
                log.error("文件上传oss服务器流关闭失败", e);
                e.printStackTrace();
            }
        }
        return ret;
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase("bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase("gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase("jpeg") ||
                FilenameExtension.equalsIgnoreCase("jpg") ||
                FilenameExtension.equalsIgnoreCase("png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase("html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase("txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase("vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase("pptx") ||
                FilenameExtension.equalsIgnoreCase("ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase("docx") ||
                FilenameExtension.equalsIgnoreCase("doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase("xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

    /**
     * 获得url链接
     *
     * @param key
     * @return
     */
    public String getUrl(String key) {
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);//单位ms ,设置10年后过期
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        } else {
            log.error("文件上传生成地址失败");
            throw new BusinessException("生成地址失败");
        }
    }
}
