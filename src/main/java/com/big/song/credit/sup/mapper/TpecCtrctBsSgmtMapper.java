package com.big.song.credit.sup.mapper;

import com.big.song.credit.sup.dao.TpecCtrctBsSgmt;
import com.big.song.credit.sup.dao.TpecCtrctBsSgmtExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TpecCtrctBsSgmtMapper {
    int countByExample(TpecCtrctBsSgmtExample example);

    int deleteByExample(TpecCtrctBsSgmtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TpecCtrctBsSgmt record);

    int insertSelective(TpecCtrctBsSgmt record);

    List<TpecCtrctBsSgmt> selectByExample(TpecCtrctBsSgmtExample example);

    TpecCtrctBsSgmt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TpecCtrctBsSgmt record, @Param("example") TpecCtrctBsSgmtExample example);

    int updateByExample(@Param("record") TpecCtrctBsSgmt record, @Param("example") TpecCtrctBsSgmtExample example);

    int updateByPrimaryKeySelective(TpecCtrctBsSgmt record);

    int updateByPrimaryKey(TpecCtrctBsSgmt record);
}