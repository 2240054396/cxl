package com.zlt.mapper;

import com.zlt.entity.daoEntity.CustomerLog;
import com.zlt.entity.daoEntity.CustomerLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerLogMapper {
    long countByExample(CustomerLogExample example);

    int deleteByExample(CustomerLogExample example);

    int deleteByPrimaryKey(Long clid);

    int insert(CustomerLog record);

    int insertSelective(CustomerLog record);

    List<CustomerLog> selectByExample(CustomerLogExample example);

    CustomerLog selectByPrimaryKey(Long clid);

    int updateByExampleSelective(@Param("record") CustomerLog record, @Param("example") CustomerLogExample example);

    int updateByExample(@Param("record") CustomerLog record, @Param("example") CustomerLogExample example);

    int updateByPrimaryKeySelective(CustomerLog record);

    int updateByPrimaryKey(CustomerLog record);
}