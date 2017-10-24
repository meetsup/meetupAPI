package top.shellteo.schedule.service;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import top.shellteo.pojo.BScheduleJob;
import top.shellteo.util.SpringUtils;


@Component
public class QuartzExecuteJob implements Job {
	
	protected final Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
        try{
            BScheduleJob scheduleJob = (BScheduleJob) context.getJobDetail().getJobDataMap().get("bScheduleJob");
			System.out.println("ok");
			QuartzManagerService quartzManagerService = (QuartzManagerService) SpringUtils.getBean("quartzManagerService");
        	quartzManagerService.start(scheduleJob);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
