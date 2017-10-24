package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.pojo.BScheduleJob;
import top.shellteo.pojo.BScheduleJobExample;

public interface BScheduleJobMapper {
    int countByExample(BScheduleJobExample example);

    int deleteByExample(BScheduleJobExample example);

    int deleteByPrimaryKey(String jobid);

    int insert(BScheduleJob record);

    int insertSelective(BScheduleJob record);

    List<BScheduleJob> selectByExample(BScheduleJobExample example);

    BScheduleJob selectByPrimaryKey(String jobid);

    int updateByExampleSelective(@Param("record") BScheduleJob record, @Param("example") BScheduleJobExample example);

    int updateByExample(@Param("record") BScheduleJob record, @Param("example") BScheduleJobExample example);

    int updateByPrimaryKeySelective(BScheduleJob record);

    int updateByPrimaryKey(BScheduleJob record);
}