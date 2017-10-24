package top.shellteo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BScheduleJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BScheduleJobExample() {
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

        public Criteria andJobidIsNull() {
            addCriterion("JobID is null");
            return (Criteria) this;
        }

        public Criteria andJobidIsNotNull() {
            addCriterion("JobID is not null");
            return (Criteria) this;
        }

        public Criteria andJobidEqualTo(String value) {
            addCriterion("JobID =", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotEqualTo(String value) {
            addCriterion("JobID <>", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThan(String value) {
            addCriterion("JobID >", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidGreaterThanOrEqualTo(String value) {
            addCriterion("JobID >=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThan(String value) {
            addCriterion("JobID <", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLessThanOrEqualTo(String value) {
            addCriterion("JobID <=", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidLike(String value) {
            addCriterion("JobID like", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotLike(String value) {
            addCriterion("JobID not like", value, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidIn(List<String> values) {
            addCriterion("JobID in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotIn(List<String> values) {
            addCriterion("JobID not in", values, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidBetween(String value1, String value2) {
            addCriterion("JobID between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobidNotBetween(String value1, String value2) {
            addCriterion("JobID not between", value1, value2, "jobid");
            return (Criteria) this;
        }

        public Criteria andJobgroupIsNull() {
            addCriterion("JobGroup is null");
            return (Criteria) this;
        }

        public Criteria andJobgroupIsNotNull() {
            addCriterion("JobGroup is not null");
            return (Criteria) this;
        }

        public Criteria andJobgroupEqualTo(String value) {
            addCriterion("JobGroup =", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotEqualTo(String value) {
            addCriterion("JobGroup <>", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupGreaterThan(String value) {
            addCriterion("JobGroup >", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupGreaterThanOrEqualTo(String value) {
            addCriterion("JobGroup >=", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupLessThan(String value) {
            addCriterion("JobGroup <", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupLessThanOrEqualTo(String value) {
            addCriterion("JobGroup <=", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupLike(String value) {
            addCriterion("JobGroup like", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotLike(String value) {
            addCriterion("JobGroup not like", value, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupIn(List<String> values) {
            addCriterion("JobGroup in", values, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotIn(List<String> values) {
            addCriterion("JobGroup not in", values, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupBetween(String value1, String value2) {
            addCriterion("JobGroup between", value1, value2, "jobgroup");
            return (Criteria) this;
        }

        public Criteria andJobgroupNotBetween(String value1, String value2) {
            addCriterion("JobGroup not between", value1, value2, "jobgroup");
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

        public Criteria andCronexpressionIsNull() {
            addCriterion("CronExpression is null");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIsNotNull() {
            addCriterion("CronExpression is not null");
            return (Criteria) this;
        }

        public Criteria andCronexpressionEqualTo(String value) {
            addCriterion("CronExpression =", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotEqualTo(String value) {
            addCriterion("CronExpression <>", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionGreaterThan(String value) {
            addCriterion("CronExpression >", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionGreaterThanOrEqualTo(String value) {
            addCriterion("CronExpression >=", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLessThan(String value) {
            addCriterion("CronExpression <", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLessThanOrEqualTo(String value) {
            addCriterion("CronExpression <=", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionLike(String value) {
            addCriterion("CronExpression like", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotLike(String value) {
            addCriterion("CronExpression not like", value, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionIn(List<String> values) {
            addCriterion("CronExpression in", values, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotIn(List<String> values) {
            addCriterion("CronExpression not in", values, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionBetween(String value1, String value2) {
            addCriterion("CronExpression between", value1, value2, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andCronexpressionNotBetween(String value1, String value2) {
            addCriterion("CronExpression not between", value1, value2, "cronexpression");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("OpenId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("OpenId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("OpenId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("OpenId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("OpenId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("OpenId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("OpenId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("OpenId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("OpenId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("OpenId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("OpenId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("OpenId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("OpenId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("OpenId not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNull() {
            addCriterion("ActivityId is null");
            return (Criteria) this;
        }

        public Criteria andActivityidIsNotNull() {
            addCriterion("ActivityId is not null");
            return (Criteria) this;
        }

        public Criteria andActivityidEqualTo(String value) {
            addCriterion("ActivityId =", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotEqualTo(String value) {
            addCriterion("ActivityId <>", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThan(String value) {
            addCriterion("ActivityId >", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityId >=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThan(String value) {
            addCriterion("ActivityId <", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLessThanOrEqualTo(String value) {
            addCriterion("ActivityId <=", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidLike(String value) {
            addCriterion("ActivityId like", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotLike(String value) {
            addCriterion("ActivityId not like", value, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidIn(List<String> values) {
            addCriterion("ActivityId in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotIn(List<String> values) {
            addCriterion("ActivityId not in", values, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidBetween(String value1, String value2) {
            addCriterion("ActivityId between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andActivityidNotBetween(String value1, String value2) {
            addCriterion("ActivityId not between", value1, value2, "activityid");
            return (Criteria) this;
        }

        public Criteria andJobstatusIsNull() {
            addCriterion("JobStatus is null");
            return (Criteria) this;
        }

        public Criteria andJobstatusIsNotNull() {
            addCriterion("JobStatus is not null");
            return (Criteria) this;
        }

        public Criteria andJobstatusEqualTo(String value) {
            addCriterion("JobStatus =", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotEqualTo(String value) {
            addCriterion("JobStatus <>", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusGreaterThan(String value) {
            addCriterion("JobStatus >", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusGreaterThanOrEqualTo(String value) {
            addCriterion("JobStatus >=", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusLessThan(String value) {
            addCriterion("JobStatus <", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusLessThanOrEqualTo(String value) {
            addCriterion("JobStatus <=", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusLike(String value) {
            addCriterion("JobStatus like", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotLike(String value) {
            addCriterion("JobStatus not like", value, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusIn(List<String> values) {
            addCriterion("JobStatus in", values, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotIn(List<String> values) {
            addCriterion("JobStatus not in", values, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusBetween(String value1, String value2) {
            addCriterion("JobStatus between", value1, value2, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andJobstatusNotBetween(String value1, String value2) {
            addCriterion("JobStatus not between", value1, value2, "jobstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIsNull() {
            addCriterion("TaskStatus is null");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIsNotNull() {
            addCriterion("TaskStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTaskstatusEqualTo(String value) {
            addCriterion("TaskStatus =", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotEqualTo(String value) {
            addCriterion("TaskStatus <>", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusGreaterThan(String value) {
            addCriterion("TaskStatus >", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusGreaterThanOrEqualTo(String value) {
            addCriterion("TaskStatus >=", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLessThan(String value) {
            addCriterion("TaskStatus <", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLessThanOrEqualTo(String value) {
            addCriterion("TaskStatus <=", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLike(String value) {
            addCriterion("TaskStatus like", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotLike(String value) {
            addCriterion("TaskStatus not like", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIn(List<String> values) {
            addCriterion("TaskStatus in", values, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotIn(List<String> values) {
            addCriterion("TaskStatus not in", values, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusBetween(String value1, String value2) {
            addCriterion("TaskStatus between", value1, value2, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotBetween(String value1, String value2) {
            addCriterion("TaskStatus not between", value1, value2, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("Detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("Detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("Detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("Detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("Detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("Detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("Detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("Detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("Detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("Detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("Detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("Detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("Detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("Detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("Telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("Telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("Telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("Telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("Telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("Telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("Telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("Telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("Telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("Telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("Telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("Telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("Telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("Telephone not between", value1, value2, "telephone");
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