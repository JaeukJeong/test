package com.gaubiz.exp.dao;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("exp001DAO")
public class EXP001DAO extends EgovAbstractMapper {

    /**
     * 체험현황 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpCurStatList(Map<String, Object> parameter){
        return this.selectList("EXP001Mapper.selectExpCurStatList", parameter);
    }
    
    /**
     * 체험기기조건 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmt(Map<String, Object> parameter){
        return this.selectList("EXP001Mapper.selectExpEqpmt", parameter);
    }
    
}
