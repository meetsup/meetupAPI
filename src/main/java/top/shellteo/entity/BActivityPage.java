package top.shellteo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HP on 2017/10/16.
 */
public class BActivityPage implements Serializable {
    private String activityid;

    private String activityname;

    private String activityplace;

    private String uploadpictures;

    private String starttime;

    private String endtime;

    private String phone;

    private String creator;

    private String fabulous;

    private String browsecount;

    private String isfree;

    private String isprivate;

    private String activitytag;

    private String type;

    private String detail;

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public String getActivityplace() {
        return activityplace;
    }

    public void setActivityplace(String activityplace) {
        this.activityplace = activityplace == null ? null : activityplace.trim();
    }

    public String getUploadpictures() {
        return uploadpictures;
    }

    public void setUploadpictures(String uploadpictures) {
        this.uploadpictures = uploadpictures == null ? null : uploadpictures.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public String getFabulous() {
        return fabulous;
    }

    public void setFabulous(String fabulous) {
        this.fabulous = fabulous;
    }

    public String getBrowsecount() {
        return browsecount;
    }

    public void setBrowsecount(String browsecount) {
        this.browsecount = browsecount;
    }

    public String getIsfree() {
        return isfree;
    }

    public void setIsfree(String isfree) {
        this.isfree = isfree == null ? null : isfree.trim();
    }

    public String getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(String isprivate) {
        this.isprivate = isprivate == null ? null : isprivate.trim();
    }

    public String getActivitytag() {
        return activitytag;
    }

    public void setActivitytag(String activitytag) {
        this.activitytag = activitytag == null ? null : activitytag.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}
