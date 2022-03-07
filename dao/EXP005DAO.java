package com.gaubiz.exp.dao;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("exp005DAO")
public class EXP005DAO extends EgovAbstractMapper {

    /**
     * 체험기기모드 조회(콤보)
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtMode(Map<String, Object> parameter){
        return this.selectList("EXP005Mapper.selectExpEqpmtMode", parameter);
    }
    
    /**
     * 체험모드 조회(버튼)
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeDtl(Map<String, Object> parameter){
        return this.selectList("EXP005Mapper.selectExpModeDtl", parameter);
    }
    
    /**
     * 체험현황 수정
     * @param parameter
     * @return int 변경 건수
     */  
    public int updateExpCurStat(Map<String, Object> parameter) {
        return this.update("EXP005Mapper.updateExpCurStat", parameter);
    }
    
    /**
     * 체험현황 삭제
     * @param parameter
     * @return int 변경 건수
     */  
    public int deleteExpCurStat(Map<String, Object> parameter) {
        return this.update("EXP005Mapper.deleteExpCurStat", parameter);
    }
    
}
