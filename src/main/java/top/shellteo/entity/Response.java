package top.shellteo.entity;

import java.io.Serializable;

/**
 * Created by HP on 2017/10/13.
 */
public class Response implements Serializable {
    private String status;//    0/成功  1/失败
    private String errorCode;//     错误代码
    private String errMsg;//       错误信息
    private String jsonData;

    public Response(String status, String errorCode, String errMsg, String jsonData) {
        this.status = status;
        this.errorCode = errorCode;
        this.errMsg = errMsg;
        this.jsonData = jsonData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
