package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.entity.BActivityPage;
import top.shellteo.pojo.BActivity;
import top.shellteo.pojo.BActivityExample;

public interface BActivityMapper {
    int countByExample(BActivityExample example);

    int deleteByExample(BActivityExample example);

    int deleteByPrimaryKey(String activityid);

    int insert(BActivity record);

    int insertSelective(BActivity record);

    List<BActivity> selectByExampleWithBLOBs(BActivityExample example);

    List<BActivity> selectByExample(BActivityExample example);

    BActivity selectByPrimaryKey(String activityid);

    int updateByExampleSelective(@Param("record") BActivity record, @Param("example") BActivityExample example);

    int updateByExampleWithBLOBs(@Param("record") BActivity record, @Param("example") BActivityExample example);

    int updateByExample(@Param("record") BActivity record, @Param("example") BActivityExample example);

    int updateByPrimaryKeySelective(BActivity record);

    int updateByPrimaryKeyWithBLOBs(BActivity record);

    int updateByPrimaryKey(BActivity record);

    List<BActivityPage> selectActivitiesByLimit(@Param("m") int begin, @Param("n") int size);

    List<BActivityPage> selectActivitiesSearch(String condicton, int begin, int size);
}