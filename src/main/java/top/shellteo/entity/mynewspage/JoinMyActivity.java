package top.shellteo.entity.mynewspage;

/**
 * Created by HP on 2017/10/21.
 */
public class JoinMyActivity {
    //消息部分信息
    private Integer id;
    private String tasktype;
    private String createtime;

    //参加者部分信息
    private String nickname;
    private String gender;
    private String telphone;
    private String email;

    //活动创建者信息
    private String nicknameCreate;//活动创建者昵称

    //活动部分信息
    private String activityid;
    private String activityname;
    private String activityplace;
    private String starttime;
    private String endtime;
    private String isfree;
    private String isprivate;
    private String detail;

    public String getActivityid() {
        return activityid;
    }

    public void setActivityid(String activityid) {
        this.activityid = activityid;
    }

    public String getNicknameCreate() {
        return nicknameCreate;
    }

    public void setNicknameCreate(String nicknameCreate) {
        this.nicknameCreate = nicknameCreate;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
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
