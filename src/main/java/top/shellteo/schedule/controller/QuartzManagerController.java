package top.shellteo.schedule.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.shellteo.pojo.BScheduleJob;
import top.shellteo.schedule.service.QuartzManagerService;
import top.shellteo.util.BatisMapper;

@Controller
@RequestMapping(value = "/schedule", method = RequestMethod.GET)
@ResponseBody
public class QuartzManagerController extends BatisMapper {

	@Autowired
	private QuartzManagerService quartzManagerService;

	protected final Logger logger = Logger.getLogger(this.getClass());
	
	/**
	 * 暂停调度任务
	 * @param jobId
	 * @return
	 */
	@RequestMapping(value = "/pause/{jobId}")
	public String pause(@PathVariable String jobId){
		BScheduleJob bScheduleJob = bScheduleJobMapper.selectByPrimaryKey(jobId);
		if(bScheduleJob == null){
			return "不存在JobId为"+jobId+"的调度任务！";
		}else{
			if("A1".equals(bScheduleJob.getJobstatus())){
				return "JobId为"+jobId+"的任务已停用，无需再次停用！";
			}else if("A3".equals(bScheduleJob.getJobstatus())){
				return "JobId为" + jobId + "的任务已删除，不允许停用！";
			}else {
				quartzManagerService.pause(bScheduleJob);
				return "JobId为"+jobId+"的任务停用成功！";
			}
		}
	}
	
	/**
	 * 恢复被暂停的调度任务
	 * @param jobId
	 * @return
	 */
	@RequestMapping(value = "/resume/{jobId}")
	public String resume(@PathVariable String jobId){
		BScheduleJob bScheduleJob = bScheduleJobMapper.selectByPrimaryKey(jobId);
		if(bScheduleJob == null){
			return "不存在JobId为"+jobId+"的调度任务！";
		}else{
			if ("A3".equals(bScheduleJob.getJobstatus())){
				return "调度任务已删除,不允许恢复!";
			}else if ("A2".equals(bScheduleJob.getJobstatus())){
				return "调度任务 "+jobId+" 正在运行中,不需要恢复!";
			} else {
				return "调度任务 "+jobId+" 恢复成功!";
			}
		}
	}
	
	/**
	 * 删除调度任务，删除后数据不做物理删除，但不可恢复
	 * @param jobId
	 * @return
	 */
	@RequestMapping(value = "/delete/{jobId}")
	public String delete(@PathVariable String jobId){
		BScheduleJob bScheduleJob = bScheduleJobMapper.selectByPrimaryKey(jobId);
		if(bScheduleJob == null){
			return "不存在JobId为"+jobId+"的调度任务！";
		}else{
			if ("A3".equals(bScheduleJob.getJobstatus())){
				return "调度任务已删除 "+jobId+" 无需再次删除!";
			}else {
				quartzManagerService.delete(bScheduleJob);
				return "调度任务已删除 "+jobId+" 成功!";
			}
		}
	}
	
	/**
	 * 启动某调度任务
	 * @param jobId
	 * @return
	 */
	@RequestMapping(value = "/start/{jobId}")
	public String start(@PathVariable String jobId){
		BScheduleJob bScheduleJob = bScheduleJobMapper.selectByPrimaryKey(jobId);
		if(bScheduleJob == null){
			return "不存在JobId为"+jobId+"的调度任务！";
		}else{
			quartzManagerService.start(bScheduleJob);
			//quartzManagerService.loadSchedule(bScheduleJob);
			return "调度任务强制执行成功!";
		}
	}
	
}
