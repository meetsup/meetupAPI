package top.shellteo.entity.mynewspage;

/**
 * Created by HP on 2017/10/21.
 */
public class JoinActivityNews {
    //消息部分信息
    private Integer id;
    private String tasktype;
    private String createtime;

    //参加者信息
    private String openid;
    private String nickname;

    //活动创建者信息
    private String createphone;//活动创建者的联系方式
    private String createmail;//活动创建者的邮箱

    //活动部分信息
    private String activityid;
    private String activityplace;
    private String starttime;
    private String endtime;
    private String activityname;
    private String isfree;
    private String isprivate;
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreatephone() {
        return createphone;
    }

    public void setCreatephone(String createphone) {
        this.createphone = createphone;
    }

    public String getCreatemail() {
        return createmail;
    }

    public void setCreatemail(String createmail) {
        this.createmail = createmail;
    }

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getActivityplace() {
        return activityplace;
    }

    public void setActivityplace(String activityplace) {
        this.activityplace = activityplace;
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

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public String getIsfree() {
        return isfree;
    }

    public void setIsfree(String isfree) {
        this.isfree = isfree;
    }

    public String getIsprivate() {
        return isprivate;
    }

    public void setIsprivate(String isprivate) {
        this.isprivate = isprivate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
