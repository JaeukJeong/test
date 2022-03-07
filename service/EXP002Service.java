package com.gaubiz.exp.service;

import com.gaubiz.bezelj.nexa17.util.DataSetUtil;
import com.gaubiz.exp.dao.EXP002DAO;
import com.nexacro.uiadapter17.spring.core.NexacroException;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service("exp002Service")
public class EXP002Service extends EgovAbstractServiceImpl {
	
    @Resource(name = "exp002DAO")
    private EXP002DAO exp002DAO;

    /**
     * 체험모드관리 마스터 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeMasterList(Map<String, Object> parameter){
        return this.exp002DAO.selectExpModeMasterList(parameter);
    }
    
    /**
     * 체험모드코드 채번
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeSeqMasterList(Map<String, Object> parameter){
        return this.exp002DAO.selectExpModeSeqMasterList(parameter);
    }
    
    /**
     * 체험모드관리  상세 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeDtlMasterList(Map<String, Object> parameter){
        return this.exp002DAO.selectExpModeDtlMasterList(parameter);
    }
    
    /**
     * 체험모드관리 변경 저장
     * 
     * @param param   조회조건 데이터
     * @return DataSet 조회 결과 데이터셋
     * 
     * @throws Exception
     */
    public Map<String, Object> saveExpModeCodeList(List<Map<String, Object>> masterList, List<Map<String, Object>> detailList, String userId) throws Exception {
        int ret            = 0;
        int resCnt         = 0; 

        //체험모드관리 마스터  저장
        for( Map<String, Object> masterData : masterList ) {
        	ret  = 0;
        	
        	masterData.put("USER_ID", userId);
        	if( DataSetUtil.isInsertedRow(masterData) ) {
        		if (checkExistPKHeader(masterData)) {
                	throw new NexacroException("", -100, "COM000015|EXP,MODE,CD"); // '체험모드코드' (이)가 중복되었습니다.
                }
        		ret     += exp002DAO.insertExpModeMaster(masterData);
        	} else if ( DataSetUtil.isUpdatedRow(masterData) ) {
    			ret     += exp002DAO.updateExpModeMaster(masterData);
        	}
        	resCnt += ret;
        }
        
        //체험모드관리 상세  저장
        for( Map<String, Object> detailData : detailList ) {
        	ret  = 0;

        	detailData.put("USER_ID", userId);
            if ( DataSetUtil.isInsertedRow(detailData) ) {
                if (checkExistPKDtl(detailData)) {
                	throw new NexacroException("", -101, "COM000015|DTL,MODE,CD"); //체험상세모드코드 중복에러입니다.
                }               
                ret     += exp002DAO.insertExpModeDtlMaster(detailData);
            } else if ( DataSetUtil.isUpdatedRow(detailData) ) {
                ret     += exp002DAO.updateExpModeDtlMaster(detailData);
            } else if ( DataSetUtil.isDeletedRow(detailData)) {
            	ret     += exp002DAO.deleteExpModeDtlMaster(detailData);
            }

            resCnt += ret;
        }
        
        HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultCount", resCnt);
        return resultMap;
    }
    
    /**
     * 체험모드관리 상세여부 수정
     * 
     * @param param   조회조건 데이터
     * @return DataSet 조회 결과 데이터셋
     * 
     * @throws Exception
     */
    public Map<String, Object> updateDtlModeYn(List<Map<String, Object>> masterList, String userId) throws Exception {
        int ret            = 0;
        int resCnt         = 0; 
        
      //체험모드관리 상세여부 수정
        for( Map<String, Object> masterData : masterList ) {
        	ret  = 0;
        	
        	masterData.put("USER_ID", userId);
        	if( DataSetUtil.isInsertedRow(masterData) || DataSetUtil.isUpdatedRow(masterData)) {
        		ret    += exp002DAO.updateDtlModeYn(masterData);
        	}
        	resCnt += ret;
        }
        
        HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultCount", resCnt);
        return resultMap;
    }
    
    
    /**
     * 체험모드관리 마스터 중복 체크
     * 
     * @param param   조회조건 데이터
     * @return Boolean 종복데이터 존재여부
     * 
     * @throws Exception
     */
    private Boolean checkExistPKHeader(Map<String, Object> data) throws Exception {
    	List<Map<String, Object>> resDupChk = exp002DAO.selectExpModeMasterKey(data);
    	Map<String, Object> dupChk = resDupChk.get(0);
        if (dupChk.get("CNT").toString().equals("0")) return false;
        
        return true;
    }
    
    /**
     * 체험모드관리 상세 중복 체크
     * 
     * @param param   조회조건 데이터
     * @return Boolean 종복데이터 존재여부
     * 
     * @throws Exception
     */
    private Boolean checkExistPKDtl(Map<String, Object> data) throws Exception {
    	List<Map<String, Object>> resDupChk = exp002DAO.selectExpModeDtlMasterKey(data);
    	Map<String, Object> dupChk = resDupChk.get(0);
        if (dupChk.get("CNT").toString().equals("0")) return false;
        
        return true;
    }

}
