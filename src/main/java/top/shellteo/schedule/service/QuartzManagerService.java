package top.shellteo.schedule.service;

import top.shellteo.pojo.BScheduleJob;

public interface QuartzManagerService {

	void loadSchedule(BScheduleJob BScheduleJob);
	
	void add(BScheduleJob BScheduleJob);
	
	void update(BScheduleJob BScheduleJob);
	
	void pause(BScheduleJob BScheduleJob);
	
	void resume(BScheduleJob BScheduleJob);
	
	void delete(BScheduleJob BScheduleJob);
	
	void start(BScheduleJob BScheduleJob);
	
	//public String running(JobInstance jobInstance);
	
	//public void stop(JobInstance jobInstance);
	
	//void monitorStart();
	
	//List<BScheduleJob> queryBScheduleJob();
	
}
