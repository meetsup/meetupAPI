package top.shellteo.util;

import org.springframework.beans.factory.annotation.Autowired;
import top.shellteo.mapper.*;

/**
 * Created by HP on 2017/10/21.
 */
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
}
