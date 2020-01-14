package com.gugugou.provider.provider.controller;

import com.gugugou.provider.common.until.SendEmail;
import com.gugugou.provider.provider.model.*;
import com.gugugou.provider.provider.service.InformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
 * 新增供应商
 * */

@RequestMapping("provider")
@RestController
public class InformationController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private InformationService informationService;
    @Resource
    private SendEmail sendEmail;

    /**
     * 新增供应商----添加供应商的基本信息
     */
    @PostMapping("base/addbase")
    public Long addInformation(@RequestBody Information information) {
        return informationService.addInformation(information);
    }

    /**
     * 新增供应商----查看供应商的基本信息
     */
    @GetMapping("base/findById")
    public Information findInformation(@RequestParam Long id) {
        Information information = informationService.findInformationById(id);
        return information;
    }

    /**新增供应商----修改供应商的基本信息*/
    @PostMapping("base/updatebase")
    public int updateInformation(@RequestBody Information information){
           return informationService.updateInformation(information);
    }

    /**供应商管理----修改供应商的经营状态和原因*/
    @PostMapping("base/updateManageStutas")
    public int updateInformationStatus(@RequestBody Information information){
            return informationService.updateInformationStatus(information);
    }

    /**供应商管理----查看详情*
     * id是供应商Id
     */
    @GetMapping("selectDetalById")
    public Map selectDetalById(@RequestParam Long id){
        logger.info("selectDetalById入参:{}",id);
        return informationService.selectDetalById(id);
    }

    /**供应商管理----设置平台负责人*/
    @PostMapping("updateContactName")
    public int updateContactName(@RequestBody InformationContact informationContact){

       return informationService.updateContactName(informationContact);
    }

    /**供应商管理----查看供应商列表带条件*/
    @PostMapping("findAllProviders")
    public Map findAllProviders(@RequestBody QueryField queryField){
        return  informationService.findAllProviders(queryField);
    }

    /**供应商管理----编辑供应商*/
    @PostMapping("queryAllProviders")
    public List<Information> queryAllProviders(){
        return  informationService.queryAllProviders();
    }

    /**新增供应商----合同到期发送邮件*/
    @GetMapping("sendEmails")
    public void sendEmail(@RequestParam String email) {
        sendEmail.sendMail(email,"你好,合同即将到期,请及时续约","合同即将到期");
    }

}