package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.pojo.MCity;
import top.shellteo.pojo.MCityExample;

public interface MCityMapper {
    int countByExample(MCityExample example);

    int deleteByExample(MCityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MCity record);

    int insertSelective(MCity record);

    List<MCity> selectByExample(MCityExample example);

    MCity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MCity record, @Param("example") MCityExample example);

    int updateByExample(@Param("record") MCity record, @Param("example") MCityExample example);

    int updateByPrimaryKeySelective(MCity record);

    int updateByPrimaryKey(MCity record);
}