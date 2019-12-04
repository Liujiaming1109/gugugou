package com.gugugou.provider.violations.service.impl;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.violations.dao.ViolationsDao;
import com.gugugou.provider.violations.dto.ViolationsResponseDTO;
import com.gugugou.provider.violations.model.Violations;
import com.gugugou.provider.violations.service.ViolationsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public ViolationsResponseDTO getTicketById(Integer id) {
        ViolationsResponseDTO violationsResponseDTO = new ViolationsResponseDTO();
        Violations violations = violationsDao.getTicketById(id);
        if (violations != null){
            violationsResponseDTO.setViolations(violations);
            //获取附件列表
            List<AccessoryUrlModel> accessoryList = violationsDao.getAccessoryListById(violations.getId());
            if (accessoryList !=null && accessoryList.size() > 0){
                violationsResponseDTO.setAccessoryList(accessoryList);
            }
        }
        return violationsResponseDTO;
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

    /**
     * 分页查询违规处罚列表
     * @param violations
     * @return
     */
    @Override
    public ResponseDTO selectTicketList(Violations violations) {
        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
            Integer pageIndex = (violations.getPageIndex()-ProviderCentreConsts.INTEGER_ONE) * violations.getPageSize();
        violations.setPageIndex(pageIndex);
        List<Violations> violationsList = violationsDao.selectTicketList(violations);
        if (!violationsList.isEmpty()){
            responseDTO.setData(violationsList);
        }else{
            //返回一个空数组
            responseDTO.setData(new ArrayList<>());
        }
        //获取违规处罚表的记录数
        Integer count = violationsDao.selectTicketCount(violations);
        if (count != null && count > ProviderCentreConsts.INTEGER_ZERO){
            responseDTO.setCount(count);
        }
        return responseDTO;
    }
}
