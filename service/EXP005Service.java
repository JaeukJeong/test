package com.gaubiz.exp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gaubiz.bezelj.nexa17.util.DataSetUtil;
import com.gaubiz.exp.dao.EXP005DAO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("exp005Service")
public class EXP005Service extends EgovAbstractServiceImpl {
	
    @Resource(name = "exp005DAO")
    private EXP005DAO exp005DAO;

    /**
     * 체험기기모드 조회(콤보)
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmtMode(Map<String, Object> parameter){
        return this.exp005DAO.selectExpEqpmtMode(parameter);
    }
    
    /**
     * 체험모드 조회(버튼)
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpModeDtl(Map<String, Object> parameter){
        return this.exp005DAO.selectExpModeDtl(parameter);
    }
    
    /**
     * 체험현황 수정 및 삭제
     * 
     * @param param   조회조건 데이터
     * @return DataSet 조회 결과 데이터셋
     * 
     * @throws Exception
     */
    public Map<String, Object> saveExpCurStat(List<Map<String, Object>> masterList, String userId) throws Exception {
        int ret            = 0;
        int resCnt         = 0; 

        for( Map<String, Object> masterData : masterList ) {
        	ret  = 0;
        	
        	masterData.put("USER_ID", userId);
        	if( DataSetUtil.isUpdatedRow(masterData)) {
        		ret     += exp005DAO.updateExpCurStat(masterData);
        	} else if(DataSetUtil.isDeletedRow(masterData)) {
        		ret     += exp005DAO.deleteExpCurStat(masterData);
        	}
        	resCnt += ret;
        }
        
        HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("resultCount", resCnt);
        return resultMap;
    }

}