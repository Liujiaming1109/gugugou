package com.gugugou.provider.provider.dao;

import com.gugugou.provider.aptitude.model.AccessoryUrlModel;
import com.gugugou.provider.provider.model.Aptitude;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AptitudeDao {
    /**添加供应商的资质信息*/
    Integer addProviderAptitude(Aptitude aptitude);
    /**添加供应商的附件路径*/
    Integer addProviderAptitudeUrl(List<AccessoryUrlModel> accessoryUrlModels);
    /**修改供应商的资质信息*/
    Integer updateProviderAptitude(Aptitude aptitude);
   /**修改供应商的附件*/
    /*Integer updateProviderAptitudeUrl(AccessoryUrlModel accessoryUrlModels);*/
    /**查看供应商资质*/
    Aptitude selectAptitude(Long id);
   /**查看供应商资质的附件*/
   List<AccessoryUrlModel> selectAccessoryUrlModelList(AccessoryUrlModel accessoryUrlModel);

}

