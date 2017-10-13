package top.shellteo.util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

/**
 * @Author:lias
 * @Description: http接口调用工具类
 * @Date: created in 15:20 2017/6/28
 */
public class HttpClient {
    private static Logger logger = Logger.getLogger(HttpClient.class);

    public static String executeByPOST(String url, String json) throws Exception {
        logger.info("开始通讯:"+url+" jsondata:"+json+" type:post");
        //DefaultHttpClient httpClient = new DefaultHttpClient();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        String responseStr = "";//返回数据
        CloseableHttpResponse response = null;
        try {
            httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
            httpPost.setEntity(new StringEntity(json, "UTF-8"));
            response = httpClient.execute(httpPost);
            int code = -1;
            if (response!=null){
                code = response.getStatusLine().getStatusCode();
                if (response.getEntity()!=null){
                    responseStr = EntityUtils.toString(response.getEntity(), "UTF-8");
                }
            }
            if (code == 200){//通讯成功
                logger.info("==>"+url+" 通讯成功!");
            }else { //2xx 开头的状态码均表示成功 4xx/请求错误 5xx/服务器错误
                logger.error("==>通讯异常,请检查:"+url);
            }
        }
        catch (Exception e) {
            logger.error(url+":"+e);
            e.printStackTrace();
        }finally {
            response.close();
        }
        logger.info("通讯结束:"+url+" response:"+responseStr);
        return responseStr;
    }

    public static String executeByGet(String url) throws Exception {
        logger.info("开始通讯:"+url+" type:get");
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        String responseStr = "";
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(httpGet);
            //获取状态码
            int code = -1;
            if (response!=null){
                code = response.getStatusLine().getStatusCode();
                if (response.getEntity()!=null){
                    responseStr = EntityUtils.toString(response.getEntity() , "UTF-8");
                }
            }
            if (code == 200){//通讯成功
                logger.info("==>"+url+" 通讯成功!");
            }else { //2xx 开头的状态码均表示成功 4xx/请求错误 5xx/服务器错误
                logger.error("==>通讯异常,请检查:"+url);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(url+":"+e.getMessage());
        }finally {
            response.close();
        }
        logger.info("通讯结束:"+url+" response:"+responseStr);
        return responseStr;
    }
}
