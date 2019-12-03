package com.gugugou.provider.provider.dao;

import com.gugugou.provider.provider.model.Information;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InformationDao {

    int addInformation(Information information);

    int addInformations(Information information);
}
