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
    Violations getTicketById(Long id);

    /**
     * 根据处罚单id查询附件集合
     * @param id
     * @return
     */
    List<AccessoryUrlModel> getAccessoryListById(Long id);

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
     * 修改违规处罚单附件集合
     * @param accessoryList
     * @return
     */
    Integer updateTicketAccessoryList(AccessoryUrlModel accessoryList);

    /**
     * 查询违规处罚单列表 (带条件分页查询)
     * @param violations
     * @return
     */
    List<Violations> selectTicketList(Violations violations);

    /**
     * 查询违规处罚表的记录数(分页使用)
     * @param violations
     * @return
     */
    Integer selectTicketCount(Violations violations);
}
