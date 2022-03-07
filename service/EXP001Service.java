package com.gaubiz.exp.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.gaubiz.exp.dao.EXP001DAO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("exp001Service")
public class EXP001Service extends EgovAbstractServiceImpl {
	
    @Resource(name = "exp001DAO")
    private EXP001DAO exp001DAO;

    /**
     * 체험현황 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpCurStatList(Map<String, Object> parameter){
        return this.exp001DAO.selectExpCurStatList(parameter);
    }
    
    /**
     * 체험기기조건 조회
     *
     * @param parameter
     * @return
     */
    public List<Map<String, Object>> selectExpEqpmt(Map<String, Object> parameter){
        return this.exp001DAO.selectExpEqpmt(parameter);
    }

}
