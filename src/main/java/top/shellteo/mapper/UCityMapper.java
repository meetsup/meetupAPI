package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.pojo.UCity;
import top.shellteo.pojo.UCityExample;

public interface UCityMapper {
    int countByExample(UCityExample example);

    int deleteByExample(UCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UCity record);

    int insertSelective(UCity record);

    List<UCity> selectByExample(UCityExample example);

    UCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UCity record, @Param("example") UCityExample example);

    int updateByExample(@Param("record") UCity record, @Param("example") UCityExample example);

    int updateByPrimaryKeySelective(UCity record);

    int updateByPrimaryKey(UCity record);
}