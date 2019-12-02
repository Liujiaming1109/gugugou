package com.gugugou.provider.violations.service;

import com.gugugou.provider.violations.model.Violations;

import java.util.List;

public interface ViolationsService {
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
     * @param violations
     * @return
     */
    List<Violations> selectTicketList(Violations violations);
}
