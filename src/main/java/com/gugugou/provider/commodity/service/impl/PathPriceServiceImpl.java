package com.gugugou.provider.commodity.service.impl;

import com.gugugou.provider.commodity.dao.PathPriceDao;
import com.gugugou.provider.commodity.model.PathPriceModel;
import com.gugugou.provider.commodity.service.PathPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author: chengShaoShao
 * @Title: PathPriceServiceImpl
 * @ProjectName: provider
 * @Description:
 * @date 2020/1/8 19:46
 */
@Service
@Transactional
public class PathPriceServiceImpl implements PathPriceService {

    @Resource
    private PathPriceDao pathPriceDao;

    /**
     * 修改路径价格
     * @param pathPriceModel
     * @return
     */
    @Override
    public Integer updatePathPrice(PathPriceModel pathPriceModel) {
        pathPriceModel.setUpdatedTime(new Date());
        return pathPriceDao.updatePathPrice(pathPriceModel);
    }
}
