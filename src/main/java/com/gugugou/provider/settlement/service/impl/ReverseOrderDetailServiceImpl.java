package com.gugugou.provider.settlement.service.impl;

import com.gugugou.provider.common.ProviderCentreConsts;
import com.gugugou.provider.common.ResponseDTO;
import com.gugugou.provider.settlement.dao.ReverseOrderDetailDao;
import com.gugugou.provider.settlement.model.ReverseOrderDetail;
import com.gugugou.provider.settlement.service.ReverseOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: yuelitao
 * @date 2020/1/17 11:59
 */
@Service
public class ReverseOrderDetailServiceImpl implements ReverseOrderDetailService {

    @Resource
    private ReverseOrderDetailDao reverseOrderDetailDao;

    @Override
    public Integer addReverseOrderDetail(List<ReverseOrderDetail> reverseOrderDetails) {

        return reverseOrderDetailDao.addReverseOrderDetail(reverseOrderDetails);
    }

    @Override
    public ResponseDTO selectReverseOrderDetailList(ReverseOrderDetail reverseOrderDetail) {
        ResponseDTO responseDTO = new ResponseDTO();
        //获取pageIndex
        Integer pageIndex = (reverseOrderDetail.getPageIndex()- ProviderCentreConsts.INTEGER_ONE) * reverseOrderDetail.getPageSize();
        reverseOrderDetail.setPageIndex(pageIndex);
        //获取逆向单集合数据
        List<ReverseOrderDetail> reverseOrderDetails = reverseOrderDetailDao.selectReverseOrderDetailList(reverseOrderDetail);
        if (!reverseOrderDetails.isEmpty()){
            responseDTO.setData(reverseOrderDetails);
        }else{
            responseDTO.setData(new ArrayList<>());
        }
        //获取逆向单集合数据的记录数
        Integer count = reverseOrderDetailDao.selectReverseOrderDetailCount(reverseOrderDetail);
        if (count != null && count > 0){
            responseDTO.setCount(count);
        }
        return responseDTO;
    }
}
