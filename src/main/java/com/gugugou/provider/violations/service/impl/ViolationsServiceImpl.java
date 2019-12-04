package com.gugugou.provider.violations.service.impl;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.violations.dao.ViolationsDao;
import com.gugugou.provider.violations.model.Violations;
import com.gugugou.provider.violations.service.ViolationsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ViolationsServiceImpl implements ViolationsService {

    @Resource
    public ViolationsDao violationsDao;

    /**
     * 查询单条处罚单
     * @param id
     * @return
     */
    @Override
    public Violations getTicketById(Integer id) {

        Violations ticket = violationsDao.getTicketById(id);
        return ticket;
    }

    /**
     * 新增处罚单
     * @param violations
     * @return
     */
    @Override
    public Integer addTicket(Violations violations) {
        /**
         * 供应商id和供应商名称从前台获取
         */

        violations.setCreatedBy("岳利涛");
        violations.setCreatedTime(new Date());
        violations.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
        //新增处罚单后返回主键id
        violationsDao.addTicket(violations);
        //获取主表的主键id
        Integer id = violations.getId();
        //获取violations中的附件集合
        List<AccessoryUrlModel> accessoryList = violations.getAccessoryList();
        System.out.println(accessoryList);
        //判断
        if (!accessoryList.isEmpty()){
            for (AccessoryUrlModel accessoryUrlModel : accessoryList) {
                accessoryUrlModel.setViolationsIdFk(id);
                accessoryUrlModel.setCreatedTime(new Date());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_TWO);
//            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
            }
        }
        return violationsDao.addAccessoryUrlModelList(accessoryList) > 0 ? 1:0;
    }

    /**
     * 更新处罚单
     * @param violations
     * @return
     */
    @Override
    public Integer updateTicket(Violations violations) {
        //这里不清楚附件会不会修改，修改的话，是覆盖还是删除原来的再新增！！！！
        violations.setUpdatedBy("李白");
        violations.setUpdatedTime(new Date());
        List<AccessoryUrlModel> accessoryList = violations.getAccessoryList();
        for (AccessoryUrlModel accessoryUrlModel : accessoryList) {
            accessoryUrlModel.setUpdatedBy(violations.getUpdatedBy());
            accessoryUrlModel.setUpdatedTime(violations.getUpdatedTime());
        }
        return violationsDao.updateTicket(violations);
    }

    @Override
    public List<Violations> selectTicketList(Violations violations) {
        return null;
    }
}
