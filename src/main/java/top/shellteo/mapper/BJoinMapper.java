package top.shellteo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.shellteo.pojo.BJoin;
import top.shellteo.pojo.BJoinExample;

public interface BJoinMapper {
    int countByExample(BJoinExample example);

    int deleteByExample(BJoinExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BJoin record);

    int insertSelective(BJoin record);

    List<BJoin> selectByExample(BJoinExample example);

    BJoin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BJoin record, @Param("example") BJoinExample example);

    int updateByExample(@Param("record") BJoin record, @Param("example") BJoinExample example);

    int updateByPrimaryKeySelective(BJoin record);

    int updateByPrimaryKey(BJoin record);
}