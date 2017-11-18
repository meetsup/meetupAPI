package top.shellteo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import top.shellteo.mapper.BScheduleJobMapper;
import top.shellteo.pojo.BScheduleJob;
import top.shellteo.pojo.BScheduleJobExample;
import top.shellteo.schedule.service.QuartzManagerService;

import java.util.List;

/**
 * Created by HP on 2017/10/23.
 * spring在将所有的bean初始化后会执行重写方法
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public class QuartzInit implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private BScheduleJobMapper bScheduleJobMapper;
    @Autowired
    private QuartzManagerService quartzManagerService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null){
            BScheduleJobExample example = new BScheduleJobExample();
            BScheduleJobExample.Criteria criteria = example.createCriteria();
            //已经删除或者邮件发送成功的数据不再加载执行
            criteria.andJobstatusNotEqualTo("A3");
            criteria.andTaskstatusNotEqualTo("2");
            List<BScheduleJob> bScheduleJobList = bScheduleJobMapper.selectByExample(example);
            for (BScheduleJob bScheduleJob : bScheduleJobList){
                quartzManagerService.loadSchedule(bScheduleJob);
            }
        }

    }
}
