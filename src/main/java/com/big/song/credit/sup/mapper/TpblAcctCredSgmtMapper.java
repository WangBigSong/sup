package com.big.song.credit.sup.mapper;

import com.big.song.credit.sup.dao.TpblAcctCredSgmt;
import com.big.song.credit.sup.dao.TpblAcctCredSgmtExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TpblAcctCredSgmtMapper {
    int countByExample(TpblAcctCredSgmtExample example);

    int deleteByExample(TpblAcctCredSgmtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TpblAcctCredSgmt record);

    int insertSelective(TpblAcctCredSgmt record);

    List<TpblAcctCredSgmt> selectByExample(TpblAcctCredSgmtExample example);

    TpblAcctCredSgmt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TpblAcctCredSgmt record, @Param("example") TpblAcctCredSgmtExample example);

    int updateByExample(@Param("record") TpblAcctCredSgmt record, @Param("example") TpblAcctCredSgmtExample example);

    int updateByPrimaryKeySelective(TpblAcctCredSgmt record);

    int updateByPrimaryKey(TpblAcctCredSgmt record);
}