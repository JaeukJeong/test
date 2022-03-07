package com.gaubiz.exp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.gaubiz.bezelj.nexa17.util.DataSetUtil;
import com.gaubiz.exp.dao.EXP003DAO;
import com.nexacro.uiadapter17.spring.core.NexacroException;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("exp003Service")
public class EXP003Service extends EgovAbstractServiceImpl {
	
    @Resource(name = "exp003DAO")
    private EXP003DAO exp003DAO;
    
    /**
     * 체험모드 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeList(Map<String, Object> parameter){
        return this.exp003DAO.selectExpModeList(parameter);
    }

    /**
     * 체험기기 마스터 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtMasterList(Map<String, Object> parameter){
        return this.exp003DAO.selectExpEqpmtMasterList(parameter);
    }
    
    /**
     * 체험기기 모드 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtDtlMasterList(Map<String, Object> parameter){
        return this.exp003DAO.selectExpEqpmtDtlMasterList(parameter);
    }
    
    /**
     * 체험기기관리 변경 저장
     * 
     * @param param   조회조건 데이터
     * @return DataSet 조회 결과 데이터셋
     * 
     * @throws Exception
     */
    public Map<String, Object> saveExpEqpmtList(List<Map<String, Object>> masterList, List<Map<String, Object>> detailList, String userId) throws Exception {
        int ret            = 0;
        int resCnt         = 0; 

        //체험기기관리 마스터  저장
        for( Map<String, Object> masterData : masterList ) {
        	ret  = 0;
        	
        	masterData.put("USER_ID", userId);
        	if( DataSetUtil.isInsertedRow(masterData) ) {
        		if (checkExistPKHeader(masterData)) {
                	throw new NexacroException("", -100, "COM000015|PRODUCT_CD_01"); // '제품코드' (이)가 중복되었습니다.
                }
        		ret     += exp003DAO.insertExpEqpmtMaster(masterData);
        	} else if ( DataSetUtil.isUpdatedRow(masterData) ) {
    			ret     += exp003DAO.updateExpEqpmtMaster(masterData);
        	}
        	resCnt += ret;
        }
        
        //체험모드  저장
        for( Map<String, Object> detailData : detailList ) {
        	ret  = 0;

        	detailData.put("USER_ID", userId);
            if ( DataSetUtil.isInsertedRow(detailData) ) {
                if (checkExistPKDtl(detailData)) {
                	throw new NexacroException("", -101, "COM000015|EXP,MODE,CD"); //체험모드코드 중복에러입니다.
                }               
                ret     += exp003DAO.insertExpModeMaster(detailData);
            } else if ( DataSetUtil.isUpdatedRow(detailData) ) {
                ret     += exp003DAO.updateExpModeMaster(detailData);
            }

            resCnt += ret;
        }
        
        HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultCount", resCnt);
        return resultMap;
    }
   
    /**
     * 체험기기관리 마스터 중복 체크
     * 
     * @param param   조회조건 데이터
     * @return Boolean 종복데이터 존재여부
     * 
     * @throws Exception
     */
    private Boolean checkExistPKHeader(Map<String, Object> data) throws Exception {
    	List<Map<String, Object>> resDupChk = exp003DAO.selectExpEqpmtMasterKey(data);
    	Map<String, Object> dupChk = resDupChk.get(0);
        if (dupChk.get("CNT").toString().equals("0")) return false;
        
        return true;
    }
    
    /**
     * 체험모드 상세 중복 체크
     * 
     * @param param   조회조건 데이터
     * @return Boolean 종복데이터 존재여부
     * 
     * @throws Exception
     */
    private Boolean checkExistPKDtl(Map<String, Object> data) throws Exception {
    	List<Map<String, Object>> resDupChk = exp003DAO.selectExpModeMasterKey(data);
    	Map<String, Object> dupChk = resDupChk.get(0);
        if (dupChk.get("CNT").toString().equals("0")) return false;
        
        return true;
    }

}
