package com.big.song.credit.sup.mapper;

import com.big.song.credit.sup.entity.po.TpelAcctBsInfSgmt;
import com.big.song.credit.sup.entity.po.TpelAcctBsInfSgmtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpelAcctBsInfSgmtMapper {
    int countByExample(TpelAcctBsInfSgmtExample example);

    int deleteByExample(TpelAcctBsInfSgmtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TpelAcctBsInfSgmt record);

    int insertSelective(TpelAcctBsInfSgmt record);

    List<TpelAcctBsInfSgmt> selectByExample(TpelAcctBsInfSgmtExample example);

    TpelAcctBsInfSgmt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TpelAcctBsInfSgmt record, @Param("example") TpelAcctBsInfSgmtExample example);

    int updateByExample(@Param("record") TpelAcctBsInfSgmt record, @Param("example") TpelAcctBsInfSgmtExample example);

    int updateByPrimaryKeySelective(TpelAcctBsInfSgmt record);

    int updateByPrimaryKey(TpelAcctBsInfSgmt record);
}