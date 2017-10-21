package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.pojo.BTask;
import top.shellteo.pojo.BTaskExample;

public interface BTaskMapper {
    int countByExample(BTaskExample example);

    int deleteByExample(BTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BTask record);

    int insertSelective(BTask record);

    List<BTask> selectByExample(BTaskExample example);

    BTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BTask record, @Param("example") BTaskExample example);

    int updateByExample(@Param("record") BTask record, @Param("example") BTaskExample example);

    int updateByPrimaryKeySelective(BTask record);

    int updateByPrimaryKey(BTask record);
}