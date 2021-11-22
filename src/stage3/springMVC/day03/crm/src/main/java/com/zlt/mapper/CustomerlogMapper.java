package com.zlt.mapper;

import com.zlt.entity.Customerlog;
import com.zlt.entity.CustomerlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerlogMapper {
    long countByExample(CustomerlogExample example);

    int deleteByExample(CustomerlogExample example);

    int deleteByPrimaryKey(Long clid);

    int insert(Customerlog record);

    int insertSelective(Customerlog record);

    List<Customerlog> selectByExample(CustomerlogExample example);

    Customerlog selectByPrimaryKey(Long clid);

    int updateByExampleSelective(@Param("record") Customerlog record, @Param("example") CustomerlogExample example);

    int updateByExample(@Param("record") Customerlog record, @Param("example") CustomerlogExample example);

    int updateByPrimaryKeySelective(Customerlog record);

    int updateByPrimaryKey(Customerlog record);
}