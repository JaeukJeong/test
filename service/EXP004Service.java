package com.gaubiz.exp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.gaubiz.bezelj.nexa17.util.DataSetUtil;
import com.gaubiz.exp.dao.EXP004DAO;
import com.nexacro.uiadapter17.spring.core.NexacroException;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("exp004Service")
public class EXP004Service extends EgovAbstractServiceImpl {
	
    @Resource(name = "exp004DAO")
    private EXP004DAO exp004DAO;
    
    /**
     * 체험기기 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtList(Map<String, Object> parameter){
        return this.exp004DAO.selectExpEqpmtList(parameter);
    }

    /**
     * 체험좌석 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpSeatList(Map<String, Object> parameter){
        return this.exp004DAO.selectExpSeatList(parameter);
    }
    
    /**
     * 체험좌석관리 변경 저장
     * 
     * @param param   조회조건 데이터
     * @return DataSet 조회 결과 데이터셋
     * 
     * @throws Exception
     */
    public Map<String, Object> saveExpSeatList(List<Map<String, Object>> masterList, String userId) throws Exception {
        int ret            = 0;
        int resCnt         = 0; 

        //저장
        for( Map<String, Object> masterData : masterList ) {
        	ret  = 0;
        	
        	masterData.put("USER_ID", userId);
        	if( DataSetUtil.isInsertedRow(masterData)) {
        		if (checkExistPKHeader(masterData)) {
                	throw new NexacroException("", -100, "COM000015|SEAT,NO"); // '좌석번호' (이)가 중복되었습니다.
                }
        		ret     += exp004DAO.insertExpSeatList(masterData);
        	} else if(DataSetUtil.isUpdatedRow(masterData)) {
        		ret     += exp004DAO.updateExpSeatList(masterData);
        	}
        	resCnt += ret;
        }
        
        HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultCount", resCnt);
        return resultMap;
    }
   
    /**
     * 체험좌석  중복 체크
     * 
     * @param param   조회조건 데이터
     * @return Boolean 종복데이터 존재여부
     * 
     * @throws Exception
     */
    private Boolean checkExistPKHeader(Map<String, Object> data) throws Exception {
    	List<Map<String, Object>> resDupChk = exp004DAO.selectExpSeatKey(data);
    	Map<String, Object> dupChk = resDupChk.get(0);
        if (dupChk.get("CNT").toString().equals("0")) return false;
        
        return true;
    }

}
