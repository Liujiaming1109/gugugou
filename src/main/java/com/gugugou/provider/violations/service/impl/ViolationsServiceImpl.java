package com.gugugou.provider.violations.service.impl;

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

        return violationsDao.addTicket(violations);
    }

    /**
     * 更新处罚单
     * @param violations
     * @return
     */
    @Override
    public Integer updateTicket(Violations violations) {

        violations.setUpdatedBy("李白");
        violations.setUpdatedTime(new Date());
        return violationsDao.updateTicket(violations);
    }

    @Override
    public List<Violations> selectTicketList(Violations violations) {
        return null;
    }
}
