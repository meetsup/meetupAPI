package top.shellteo.schedule.service.impl;

import com.aliyun.oss.common.utils.LogUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import top.shellteo.pojo.BScheduleJob;
import top.shellteo.schedule.service.QuartzManagerService;
import top.shellteo.util.BatisMapper;
import top.shellteo.schedule.QuartzExecuteJob;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

@Service("quartzManagerService")
public class QuartzManagerServiceImpl extends BatisMapper implements QuartzManagerService {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	protected final static Log logger = LogUtils.getLog();
	
	@Override
	/**
	 * 注释:startAt设置的是第一次开始执行的时间 ,而简单触发器设置的是执行次数和之后隔多久执行一次,如withRepeatCount(1).withIntervalInHours(1)
	 */
	public void loadSchedule(BScheduleJob bScheduleJob){
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			String jobId = bScheduleJob.getJobid();
			String jobGroup = bScheduleJob.getJobgroup();
			//创建任务
			JobDetail jobDetail = JobBuilder.newJob(QuartzExecuteJob.class).withIdentity(jobId, jobGroup).build();
			jobDetail.getJobDataMap().put("bScheduleJob", bScheduleJob);
			//表达式调度构建器
			String startTime = bScheduleJob.getCronexpression();
			Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
			java.util.Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			calendar.set(Calendar.DAY_OF_YEAR,calendar.get(Calendar.DAY_OF_YEAR)-1);//天数减1
			//SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withRepeatCount(1).withIntervalInHours(1);//执行一次,每隔1h执行一次
			if (new Date().getTime()<=calendar.getTime().getTime()){	//活动开始前一天提醒,不足24h不提醒
				Calendar calNow = Calendar.getInstance();
				calNow.setTime(new Date());
				int day = calendar.get(Calendar.DAY_OF_YEAR)-calNow.get(Calendar.DAY_OF_YEAR);
				Date date = DateBuilder.futureDate(day, DateBuilder.IntervalUnit.DAY);//设置几天后执行
				//按照新的cronExpression表达式构建一个新的Tigger
				//Date date1 = DateBuilder.futureDate(5, DateBuilder.IntervalUnit.SECOND);//30s后执行
				Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobId, jobGroup).startAt(date).build();
				scheduler.scheduleJob(jobDetail, trigger);
				logger.info("===>定时任务载入成功");
			}

		} catch (SchedulerException e) {
			e.printStackTrace();
		} catch (ParseException e){
			e.printStackTrace();
		}
	}
	
	@Override
	/**
	 * 新增定时任务
	 */
	public void add(BScheduleJob bScheduleJob) {
		try{
			bScheduleJob.setCreatetime(new Date());
			bScheduleJobMapper.insert(bScheduleJob);
			this.loadSchedule(bScheduleJob);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 更新一条定时任务,更新触发器
	 */
	public void update(BScheduleJob bScheduleJob) {

	}
	
	@Override
	/**
	 * 暂停任务
	 */
	public void pause(BScheduleJob bScheduleJob){
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			JobKey jobKey = JobKey.jobKey(bScheduleJob.getJobid(), bScheduleJob.getJobgroup());
			scheduler.pauseJob(jobKey);
			//更新表数据
			bScheduleJob.setJobstatus("A1");
			bScheduleJob.setUpdatetime(new Date());
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
        logger.info("==>定时任务暂停成功");
	}
	
	@Override
	/**
	 * 恢复任务
	 */
	public void resume(BScheduleJob bScheduleJob){
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();  
			JobKey jobKey = JobKey.jobKey(bScheduleJob.getJobid(), bScheduleJob.getJobgroup());
			scheduler.resumeJob(jobKey);
			
			bScheduleJob.setJobstatus("A2");
			bScheduleJob.setUpdatetime(new Date());
			bScheduleJobMapper.updateByPrimaryKeySelective(bScheduleJob);
	        logger.info("==>定时任务恢复成功");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	/**
	 * 删除任务
	 */
	public void delete(BScheduleJob bScheduleJob) {
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();  
			JobKey jobKey = JobKey.jobKey(bScheduleJob.getJobid(), bScheduleJob.getJobgroup());
			scheduler.deleteJob(jobKey);
			
			bScheduleJob.setJobstatus("A3");
			bScheduleJob.setUpdatetime(new Date());
			bScheduleJobMapper.updateByPrimaryKeySelective(bScheduleJob);
			logger.info("==>定时任务注销成功");
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * 发送邮件
	 */
	public void start(BScheduleJob bScheduleJob) {
		String email = bScheduleJob.getEmail();
		if (StringUtils.isNotBlank(email)){
			emailSendService.sendSimpleEmail(bScheduleJob,email,"活动提醒","您参与的活动"+bActivityMapper.selectByPrimaryKey(bScheduleJob.getActivityid()).getActivityname()+"快要开始了,不要忘记啦!");
		}
	}
}
