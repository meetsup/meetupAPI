package top.shellteo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BActivityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andActivityidIsNull() {
            addCriterion("ActivityId is null");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNotNull() {
            addCriterion("ActivityId is not null");
            return (Criteria) this;
        }

        public Criteria andActivityidEqualTo(Long value) {
            addCriterion("ActivityId =", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotEqualTo(Long value) {
            addCriterion("ActivityId <>", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThan(Long value) {
            addCriterion("ActivityId >", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThanOrEqualTo(Long value) {
            addCriterion("ActivityId >=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThan(Long value) {
            addCriterion("ActivityId <", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThanOrEqualTo(Long value) {
            addCriterion("ActivityId <=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidIn(List<Long> values) {
            addCriterion("ActivityId in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotIn(List<Long> values) {
            addCriterion("ActivityId not in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidBetween(Long value1, Long value2) {
            addCriterion("ActivityId between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotBetween(Long value1, Long value2) {
            addCriterion("ActivityId not between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivitynameIsNull() {
            addCriterion("ActivityName is null");
            return (Criteria) this;
        }

        public Criteria andActivitynameIsNotNull() {
            addCriterion("ActivityName is not null");
            return (Criteria) this;
        }

        public Criteria andActivitynameEqualTo(String value) {
            addCriterion("ActivityName =", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotEqualTo(String value) {
            addCriterion("ActivityName <>", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThan(String value) {
            addCriterion("ActivityName >", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityName >=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThan(String value) {
            addCriterion("ActivityName <", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLessThanOrEqualTo(String value) {
            addCriterion("ActivityName <=", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameLike(String value) {
            addCriterion("ActivityName like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotLike(String value) {
            addCriterion("ActivityName not like", value, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameIn(List<String> values) {
            addCriterion("ActivityName in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotIn(List<String> values) {
            addCriterion("ActivityName not in", values, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameBetween(String value1, String value2) {
            addCriterion("ActivityName between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivitynameNotBetween(String value1, String value2) {
            addCriterion("ActivityName not between", value1, value2, "activityname");
            return (Criteria) this;
        }

        public Criteria andActivityplaceIsNull() {
            addCriterion("ActivityPlace is null");
            return (Criteria) this;
        }

        public Criteria andActivityplaceIsNotNull() {
            addCriterion("ActivityPlace is not null");
            return (Criteria) this;
        }

        public Criteria andActivityplaceEqualTo(String value) {
            addCriterion("ActivityPlace =", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceNotEqualTo(String value) {
            addCriterion("ActivityPlace <>", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceGreaterThan(String value) {
            addCriterion("ActivityPlace >", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityPlace >=", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceLessThan(String value) {
            addCriterion("ActivityPlace <", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceLessThanOrEqualTo(String value) {
            addCriterion("ActivityPlace <=", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceLike(String value) {
            addCriterion("ActivityPlace like", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceNotLike(String value) {
            addCriterion("ActivityPlace not like", value, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceIn(List<String> values) {
            addCriterion("ActivityPlace in", values, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceNotIn(List<String> values) {
            addCriterion("ActivityPlace not in", values, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceBetween(String value1, String value2) {
            addCriterion("ActivityPlace between", value1, value2, "activityplace");
            return (Criteria) this;
        }

        public Criteria andActivityplaceNotBetween(String value1, String value2) {
            addCriterion("ActivityPlace not between", value1, value2, "activityplace");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesIsNull() {
            addCriterion("UploadPictures is null");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesIsNotNull() {
            addCriterion("UploadPictures is not null");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesEqualTo(String value) {
            addCriterion("UploadPictures =", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesNotEqualTo(String value) {
            addCriterion("UploadPictures <>", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesGreaterThan(String value) {
            addCriterion("UploadPictures >", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesGreaterThanOrEqualTo(String value) {
            addCriterion("UploadPictures >=", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesLessThan(String value) {
            addCriterion("UploadPictures <", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesLessThanOrEqualTo(String value) {
            addCriterion("UploadPictures <=", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesLike(String value) {
            addCriterion("UploadPictures like", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesNotLike(String value) {
            addCriterion("UploadPictures not like", value, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesIn(List<String> values) {
            addCriterion("UploadPictures in", values, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesNotIn(List<String> values) {
            addCriterion("UploadPictures not in", values, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesBetween(String value1, String value2) {
            addCriterion("UploadPictures between", value1, value2, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andUploadpicturesNotBetween(String value1, String value2) {
            addCriterion("UploadPictures not between", value1, value2, "uploadpictures");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("StartTime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("StartTime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("StartTime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("StartTime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("StartTime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("StartTime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("StartTime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("StartTime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("StartTime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("StartTime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("StartTime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("StartTime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("EndTime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("EndTime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("EndTime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("EndTime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("EndTime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EndTime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("EndTime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("EndTime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("EndTime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("EndTime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("EndTime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("EndTime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("Creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("Creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("Creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("Creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("Creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("Creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("Creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("Creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("Creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("Creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("Creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("Creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("Creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("Creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andFabulousIsNull() {
            addCriterion("Fabulous is null");
            return (Criteria) this;
        }

        public Criteria andFabulousIsNotNull() {
            addCriterion("Fabulous is not null");
            return (Criteria) this;
        }

        public Criteria andFabulousEqualTo(Long value) {
            addCriterion("Fabulous =", value, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousNotEqualTo(Long value) {
            addCriterion("Fabulous <>", value, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousGreaterThan(Long value) {
            addCriterion("Fabulous >", value, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousGreaterThanOrEqualTo(Long value) {
            addCriterion("Fabulous >=", value, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousLessThan(Long value) {
            addCriterion("Fabulous <", value, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousLessThanOrEqualTo(Long value) {
            addCriterion("Fabulous <=", value, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousIn(List<Long> values) {
            addCriterion("Fabulous in", values, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousNotIn(List<Long> values) {
            addCriterion("Fabulous not in", values, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousBetween(Long value1, Long value2) {
            addCriterion("Fabulous between", value1, value2, "fabulous");
            return (Criteria) this;
        }

        public Criteria andFabulousNotBetween(Long value1, Long value2) {
            addCriterion("Fabulous not between", value1, value2, "fabulous");
            return (Criteria) this;
        }

        public Criteria andBrowsecountIsNull() {
            addCriterion("BrowseCount is null");
            return (Criteria) this;
        }

        public Criteria andBrowsecountIsNotNull() {
            addCriterion("BrowseCount is not null");
            return (Criteria) this;
        }

        public Criteria andBrowsecountEqualTo(Long value) {
            addCriterion("BrowseCount =", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountNotEqualTo(Long value) {
            addCriterion("BrowseCount <>", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountGreaterThan(Long value) {
            addCriterion("BrowseCount >", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountGreaterThanOrEqualTo(Long value) {
            addCriterion("BrowseCount >=", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountLessThan(Long value) {
            addCriterion("BrowseCount <", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountLessThanOrEqualTo(Long value) {
            addCriterion("BrowseCount <=", value, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountIn(List<Long> values) {
            addCriterion("BrowseCount in", values, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountNotIn(List<Long> values) {
            addCriterion("BrowseCount not in", values, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountBetween(Long value1, Long value2) {
            addCriterion("BrowseCount between", value1, value2, "browsecount");
            return (Criteria) this;
        }

        public Criteria andBrowsecountNotBetween(Long value1, Long value2) {
            addCriterion("BrowseCount not between", value1, value2, "browsecount");
            return (Criteria) this;
        }

        public Criteria andIsfreeIsNull() {
            addCriterion("IsFree is null");
            return (Criteria) this;
        }

        public Criteria andIsfreeIsNotNull() {
            addCriterion("IsFree is not null");
            return (Criteria) this;
        }

        public Criteria andIsfreeEqualTo(String value) {
            addCriterion("IsFree =", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotEqualTo(String value) {
            addCriterion("IsFree <>", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThan(String value) {
            addCriterion("IsFree >", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeGreaterThanOrEqualTo(String value) {
            addCriterion("IsFree >=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThan(String value) {
            addCriterion("IsFree <", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLessThanOrEqualTo(String value) {
            addCriterion("IsFree <=", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeLike(String value) {
            addCriterion("IsFree like", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotLike(String value) {
            addCriterion("IsFree not like", value, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeIn(List<String> values) {
            addCriterion("IsFree in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotIn(List<String> values) {
            addCriterion("IsFree not in", values, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeBetween(String value1, String value2) {
            addCriterion("IsFree between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsfreeNotBetween(String value1, String value2) {
            addCriterion("IsFree not between", value1, value2, "isfree");
            return (Criteria) this;
        }

        public Criteria andIsprivateIsNull() {
            addCriterion("IsPrivate is null");
            return (Criteria) this;
        }

        public Criteria andIsprivateIsNotNull() {
            addCriterion("IsPrivate is not null");
            return (Criteria) this;
        }

        public Criteria andIsprivateEqualTo(String value) {
            addCriterion("IsPrivate =", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateNotEqualTo(String value) {
            addCriterion("IsPrivate <>", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateGreaterThan(String value) {
            addCriterion("IsPrivate >", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateGreaterThanOrEqualTo(String value) {
            addCriterion("IsPrivate >=", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateLessThan(String value) {
            addCriterion("IsPrivate <", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateLessThanOrEqualTo(String value) {
            addCriterion("IsPrivate <=", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateLike(String value) {
            addCriterion("IsPrivate like", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateNotLike(String value) {
            addCriterion("IsPrivate not like", value, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateIn(List<String> values) {
            addCriterion("IsPrivate in", values, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateNotIn(List<String> values) {
            addCriterion("IsPrivate not in", values, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateBetween(String value1, String value2) {
            addCriterion("IsPrivate between", value1, value2, "isprivate");
            return (Criteria) this;
        }

        public Criteria andIsprivateNotBetween(String value1, String value2) {
            addCriterion("IsPrivate not between", value1, value2, "isprivate");
            return (Criteria) this;
        }

        public Criteria andActivitytagIsNull() {
            addCriterion("ActivityTag is null");
            return (Criteria) this;
        }

        public Criteria andActivitytagIsNotNull() {
            addCriterion("ActivityTag is not null");
            return (Criteria) this;
        }

        public Criteria andActivitytagEqualTo(String value) {
            addCriterion("ActivityTag =", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagNotEqualTo(String value) {
            addCriterion("ActivityTag <>", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagGreaterThan(String value) {
            addCriterion("ActivityTag >", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityTag >=", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagLessThan(String value) {
            addCriterion("ActivityTag <", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagLessThanOrEqualTo(String value) {
            addCriterion("ActivityTag <=", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagLike(String value) {
            addCriterion("ActivityTag like", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagNotLike(String value) {
            addCriterion("ActivityTag not like", value, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagIn(List<String> values) {
            addCriterion("ActivityTag in", values, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagNotIn(List<String> values) {
            addCriterion("ActivityTag not in", values, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagBetween(String value1, String value2) {
            addCriterion("ActivityTag between", value1, value2, "activitytag");
            return (Criteria) this;
        }

        public Criteria andActivitytagNotBetween(String value1, String value2) {
            addCriterion("ActivityTag not between", value1, value2, "activitytag");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("Type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("Type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("Type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("Type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("Type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("Type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("Type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("Type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("Type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("Type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("Type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("Type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("Type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("Type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("CreateTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("CreateTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("CreateTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("CreateTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("CreateTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("CreateTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("CreateTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("CreateTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("CreateTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("CreateTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("CreateTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UpdateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UpdateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UpdateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UpdateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UpdateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UpdateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UpdateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UpdateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UpdateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UpdateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UpdateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UpdateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}