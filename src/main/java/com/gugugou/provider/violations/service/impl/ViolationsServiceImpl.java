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
    public Violations getTicketById(Integer id) {
        ViolationsResponseDTO violationsResponseDTO = new ViolationsResponseDTO();
        Violations violations = violationsDao.getTicketById(id);
        if (violations != null){
            //获取附件列表
            List<AccessoryUrlModel> accessoryList = violationsDao.getAccessoryListById(violations.getId());
            if (accessoryList !=null && accessoryList.size() > 0){
                violations.setAccessoryList(accessoryList);
            }
        }
        return violations;
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
        Integer integer = violationsDao.addTicket(violations);
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
                accessoryUrlModel.setCreatedBy(violations.getCreatedBy());
                accessoryUrlModel.setRemoved(ProviderCentreConsts.REMOVED_ZERO);
                accessoryUrlModel.setAccessorySource(ProviderCentreConsts.ACCESSORY_RESOURCE_TWO);
//            accessoryUrlModel.setAccessoryAddress(ProviderCentreConsts.BRAND_ADDRESS_ZERO);
            }
        }
        violationsDao.addAccessoryUrlModelList(accessoryList);
        return integer;
    }

    /**
     * 更新处罚单
     * @param violations
     * @return
     */
    @Override
    public Integer updateTicket(Violations violations) {
        violations.setUpdatedTime(new Date());
        violations.setUpdatedBy("张无忌");
        //更新主表
        Integer id = violationsDao.updateTicket(violations);
        List<AccessoryUrlModel> accessoryList = violations.getAccessoryList();
        if (!accessoryList.isEmpty()&&accessoryList.size()>0){
            for (AccessoryUrlModel accessoryUrlModel : accessoryList) {
                accessoryUrlModel.setUpdatedBy(violations.getUpdatedBy());
                accessoryUrlModel.setUpdatedTime(violations.getUpdatedTime());
//                System.out.println(accessoryUrlModel);
                violationsDao.updateTicketAccessoryList(accessoryUrlModel);
            }
        }
        return id;
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
            for (Violations violations1 : violationsList) {
                violations1.setPageIndex(violations.getPageIndex());
                violations1.setPageSize(violations.getPageSize());
            }
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
