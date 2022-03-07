package com.gaubiz.exp.dao;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("exp003DAO")
public class EXP003DAO extends EgovAbstractMapper {
	
	/**
     * 체험모드 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeList(Map<String, Object> parameter){
        return this.selectList("EXP003Mapper.selectExpModeList", parameter);
    }

    /**
     * 체험기기 마스터 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtMasterList(Map<String, Object> parameter){
        return this.selectList("EXP003Mapper.selectExpEqpmtMasterList", parameter);
    }
    
    /**
     * 체험기기 모드 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtDtlMasterList(Map<String, Object> parameter){
        return this.selectList("EXP003Mapper.selectExpEqpmtDtlMasterList", parameter);
    }
    
    /**
	 * 체험기기 마스터 추가
	 * @param parameter
	 * @return
	 */
    public int insertExpEqpmtMaster(Map<String, Object> parameter) {
        return this.insert("EXP003Mapper.insertExpEqpmtMaster", parameter);
    }
    
    /**
     * 체험기기 마스터 수정
     * @param parameter
     * @return int 변경 건수
     */  
    public int updateExpEqpmtMaster(Map<String, Object> parameter) {
        return this.update("EXP003Mapper.updateExpEqpmtMaster", parameter);
    }
    
    /**
     * 체험모드  추가
     * @param parameter
     * @return int 변경 건수
     */
    public int insertExpModeMaster(Map<String, Object> parameter) {
        return this.update("EXP003Mapper.insertExpModeMaster", parameter);
    }
    
    /**
     * 체험모드 수정
     * @param parameter
     * @return int 변경 건수
     */  
    public int updateExpModeMaster(Map<String, Object> parameter) {
        return this.update("EXP003Mapper.updateExpModeMaster", parameter);
    }
    
    /**
     * 체험기기 마스터  중복 체크
     * @param parameter
     * @return DataSet 조회 결과 데이터셋
     */
    public List<Map<String, Object>> selectExpEqpmtMasterKey(Map<String, Object> parameter) {
        return this.selectList("EXP003Mapper.selectExpEqpmtMasterKey", parameter);
    }
    
    /**
     * 체험모드 상세 중복 체크
     * @param parameter
     * @return DataSet 조회 결과 데이터셋
     */
    public List<Map<String, Object>> selectExpModeMasterKey(Map<String, Object> parameter) {
        return this.selectList("EXP003Mapper.selectExpModeMasterKey", parameter);
    }
    
}
