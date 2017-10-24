package top.shellteo.schedule.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import top.shellteo.pojo.BScheduleJob;
import top.shellteo.util.BatisMapper;

import java.util.Date;

/**
 * Created by HP on 2017/10/23.
 */
@Component("emailSend")
public class EmailSendServiceImpl extends BatisMapper{
    private Logger logger = Logger.getLogger(this.getClass());

    /**
     *
     * @param bScheduleJob
     * @param recipient 接收人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleEmail(BScheduleJob bScheduleJob, String recipient, String subject, String content){
        try{
            simpleMailMessage.setTo(recipient);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(content);
            mailSender.send(simpleMailMessage);
            bScheduleJob.setTaskstatus("2");//成功
            bScheduleJob.setUpdatetime(new Date());
            bScheduleJobMapper.updateByPrimaryKeySelective(bScheduleJob);
        }catch (Exception e){
            bScheduleJob.setTaskstatus("3");//失败
            bScheduleJob.setUpdatetime(new Date());
            bScheduleJobMapper.updateByPrimaryKeySelective(bScheduleJob);
            e.printStackTrace();
            logger.error("==>发送邮件失败,邮箱:"+recipient);
        }

    }
}
