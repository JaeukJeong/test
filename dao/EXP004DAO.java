package com.gaubiz.exp.dao;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("exp004DAO")
public class EXP004DAO extends EgovAbstractMapper {
	
	/**
     * 체험기기 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtList(Map<String, Object> parameter){
        return this.selectList("EXP004Mapper.selectExpEqpmtList", parameter);
    }

    /**
     * 체험좌석 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpSeatList(Map<String, Object> parameter){
        return this.selectList("EXP004Mapper.selectExpSeatList", parameter);
    }
    
    /**
	 * 체험좌석 추가
	 * @param parameter
	 * @return
	 */
    public int insertExpSeatList(Map<String, Object> parameter) {
        return this.insert("EXP004Mapper.insertExpSeatList", parameter);
    }
    
    /**
     * 체험좌석 수정
     * @param parameter
     * @return int 변경 건수
     */  
    public int updateExpSeatList(Map<String, Object> parameter) {
        return this.update("EXP004Mapper.updateExpSeatList", parameter);
    }
    
    /**
     * 체험좌석  중복 체크
     * @param parameter
     * @return DataSet 조회 결과 데이터셋
     */
    public List<Map<String, Object>> selectExpSeatKey(Map<String, Object> parameter) {
        return this.selectList("EXP004Mapper.selectExpSeatKey", parameter);
    }
    
}
