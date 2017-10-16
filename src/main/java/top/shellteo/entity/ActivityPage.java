package top.shellteo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by HP on 2017/10/16.
 */
public class ActivityPage implements Serializable {
    private String uploadPictures;
    private String activityId;
    private String activityName;
    private String startTime;
    private String endTime;
    private String activityPlace;
    private String isFree;

    public String getUploadPictures() {
        return uploadPictures;
    }

    public void setUploadPictures(String uploadPictures) {
        this.uploadPictures = uploadPictures;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActivityPlace() {
        return activityPlace;
    }

    public void setActivityPlace(String activityPlace) {
        this.activityPlace = activityPlace;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }
}
