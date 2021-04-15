package com.big.song.credit.sup.mapper;

import com.big.song.credit.sup.entity.po.TpelAcctCredSgmt;
import com.big.song.credit.sup.entity.po.TpelAcctCredSgmtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpelAcctCredSgmtMapper {
    int countByExample(TpelAcctCredSgmtExample example);

    int deleteByExample(TpelAcctCredSgmtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TpelAcctCredSgmt record);

    int insertSelective(TpelAcctCredSgmt record);

    List<TpelAcctCredSgmt> selectByExample(TpelAcctCredSgmtExample example);

    TpelAcctCredSgmt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TpelAcctCredSgmt record, @Param("example") TpelAcctCredSgmtExample example);

    int updateByExample(@Param("record") TpelAcctCredSgmt record, @Param("example") TpelAcctCredSgmtExample example);

    int updateByPrimaryKeySelective(TpelAcctCredSgmt record);

    int updateByPrimaryKey(TpelAcctCredSgmt record);
}