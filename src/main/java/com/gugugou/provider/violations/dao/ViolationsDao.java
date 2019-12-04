package com.gugugou.provider.violations.dao;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.violations.model.Violations;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ViolationsDao {
    /**
     * 查询单条处罚单
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
     * 新增违规处罚附件集合
     * @param accessoryList
     * @return
     */
    Integer addAccessoryUrlModelList(List<AccessoryUrlModel> accessoryList);

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
