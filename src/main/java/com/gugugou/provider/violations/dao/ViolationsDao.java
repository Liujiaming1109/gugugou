package com.gugugou.provider.violations.dao;

import com.gugugou.provider.violations.model.Violations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViolationsDao {
    /**
     * 根据供应商id查询处罚单
     * @param id
     * @return
     */
    Violations getTicketById(Integer id);

    /**
     * 新增违规处罚单
     * @param violations
     * @return
     */
    Integer addTicket(Violations violations);

    /**
     * 修改违规处罚单
     * @param violations
     * @return
     */
    Integer updateTicket(Violations violations);

    /**
     * 查询违规处罚单列表
     * @return
     */
    List<Violations> selectTicketList();
}
