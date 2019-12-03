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

    @Override
    public Violations getTicketById(Integer id) {

        Violations ticket = violationsDao.getTicketById(id);
        return ticket;
    }

    @Override
    public Integer addTicket(Violations violations) {

        violations.setCreatedBy("岳利涛");
        violations.setCreatedTime(new Date());
        violations.setRemoved(ProviderCentreConsts.REVISION_ZERO);

        return violationsDao.addTicket(violations);
    }

    @Override
    public Integer updateTicket(Violations violations) {
        return null;
    }

    @Override
    public List<Violations> selectTicketList(Violations violations) {
        return null;
    }
}
