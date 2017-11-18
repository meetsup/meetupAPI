package top.shellteo.schedule;

import com.aliyun.oss.common.utils.LogUtils;
import org.quartz.Job;
import org.apache.commons.logging.Log;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import top.shellteo.pojo.BScheduleJob;
import top.shellteo.schedule.service.QuartzManagerService;
import top.shellteo.util.SpringUtils;


@Component
public class QuartzExecuteJob implements Job {

	protected final static Log logger = LogUtils.getLog();

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
