package top.shellteo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import top.shellteo.mapper.*;
import top.shellteo.schedule.service.QuartzManagerService;
import top.shellteo.schedule.service.impl.EmailSendServiceImpl;

import javax.annotation.Resource;

/**
 * Created by HP on 2017/10/21.
 */
@SuppressWarnings("SpringJavaAutowiringInspection")
public abstract class BatisMapper {
    @Autowired
    public UCityMapper uCityMapper;
    @Autowired
    public BActivityMapper bActivityMapper;
    @Autowired
    public BJoinMapper bJoinMapper;
    @Autowired
    public BTaskMapper bTaskMapper;
    @Autowired
    public UTypeMapper uTypeMapper;
    @Autowired
    public UUserMapper uUserMapper;
    @Autowired
    public BScheduleJobMapper bScheduleJobMapper;
    @Autowired
    public QuartzManagerService quartzManagerService;
    @Resource(name = "mailSender")
    public MailSender mailSender;
    @Resource(name = "simpleMailMessage")
    public SimpleMailMessage simpleMailMessage;
    @Resource(name = "emailSend")
    public EmailSendServiceImpl emailSendService;
}
