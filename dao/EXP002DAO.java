package com.gaubiz.exp.dao;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository("exp002DAO")
public class EXP002DAO extends EgovAbstractMapper {

    /**
     * 체험모드관리 마스터 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeMasterList(Map<String, Object> parameter){
        return this.selectList("EXP002Mapper.selectExpModeMasterList", parameter);
    }
    
    /**
     * 체험모드코드 채번
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeSeqMasterList(Map<String, Object> parameter){
        return this.selectList("EXP002Mapper.selectExpModeSeqMasterList", parameter);
    }
    
    /**
     * 체험모드관리  상세 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeDtlMasterList(Map<String, Object> parameter){
        return this.selectList("EXP002Mapper.selectExpModeDtlMasterList", parameter);
    }
    
    /**
	 * 체험모드관리 마스터 추가
	 * @param parameter
	 * @return
	 */
    public int insertExpModeMaster(Map<String, Object> parameter) {
        return this.insert("EXP002Mapper.insertExpModeMaster", parameter);
    }
    
    /**
     * 체험모드관리 마스터 수정
     * @param parameter
     * @return int 변경 건수
     */  
    public int updateExpModeMaster(Map<String, Object> parameter) {
        return this.update("EXP002Mapper.updateExpModeMaster", parameter);
    }
    
    /**
     * 체험모드관리 상세 추가
     * @param parameter
     * @return int 변경 건수
     */
    public int insertExpModeDtlMaster(Map<String, Object> parameter) {
        return this.update("EXP002Mapper.insertExpModeDtlMaster", parameter);
    }
    
    /**
     * 체험모드관리 상세 수정
     * @param parameter
     * @return int 변경 건수
     */  
    public int updateExpModeDtlMaster(Map<String, Object> parameter) {
        return this.update("EXP002Mapper.updateExpModeDtlMaster", parameter);
    }
    
    /**
     * 체험모드관리 상세 삭제
     * @param parameter
     * @return int 변경 건수
     */  
    public int deleteExpModeDtlMaster(Map<String, Object> parameter) {
        return this.update("EXP002Mapper.deleteExpModeDtlMaster", parameter);
    }
    
    /**
     * 체험모드관리 상세여부 수정
     * @param parameter
     * @return int 변경 건수
     */  
    public int updateDtlModeYn(Map<String, Object> parameter) {
        return this.update("EXP002Mapper.updateDtlModeYn", parameter);
    }
    
    /**
     * 체험모드관리 마스터  중복 체크
     * @param parameter
     * @return DataSet 조회 결과 데이터셋
     */
    public List<Map<String, Object>> selectExpModeMasterKey(Map<String, Object> parameter) {
        return this.selectList("EXP002Mapper.selectExpModeMasterKey", parameter);
    }
    
    /**
     * 체험모드관리 상세 중복 체크
     * @param parameter
     * @return DataSet 조회 결과 데이터셋
     */
    public List<Map<String, Object>> selectExpModeDtlMasterKey(Map<String, Object> parameter) {
        return this.selectList("EXP002Mapper.selectExpModeDtlMasterKey", parameter);
    }
    
}
