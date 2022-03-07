package com.gaubiz.exp.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gaubiz.bezelj.nexa17.util.NexacroResultUtil;
import com.gaubiz.exp.service.EXP005Service;
import com.nexacro.uiadapter17.spring.core.NexacroException;
import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

@Controller
@RequestMapping(value = "/exp/exp005")
public class EXP005Controller {

    @Resource(name = "exp005Service")
    private EXP005Service exp005Service;
    
    /**
     * 체험기기모드 조회(콤보)
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpEqpmtMode.bzl")
     public NexacroResult selectExpEqpmtMode(@ParamDataSet(name = "ds_searchDtl", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp005Service.selectExpEqpmtMode(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_expEqmtMode", resultList);

         } catch (Exception ex){
             throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

         return nexacroResult;
     }   
     
    /**
     * 체험모드 조회(버튼) 
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpModeDtl.bzl")
     public NexacroResult selectExpModeDtl(@ParamDataSet(name = "ds_searchDtl", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp005Service.selectExpModeDtl(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_expModeDtl", resultList);

         } catch (Exception ex){
            throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

          return nexacroResult;
     }     
      
     /**
      * 체험현황 변경 저장 (수정,삭제)
      * @param masterList
      * @param userId
      * @return
      * @throws Exception
      */
      @RequestMapping(value = "/saveExpCurStat.bzl", method = {RequestMethod.POST})
     public NexacroResult saveExpCurStat(@ParamDataSet(name = "ds_expCurStatDtl", required = true) List<Map<String, Object>> masterList,
    			                         @ParamVariable(name = "USER_ID") String userId) throws Exception {
    	NexacroResult nexacroResult = new NexacroResult();
    		
    	try {
    		Map<String, Object> resultMap = this.exp005Service.saveExpCurStat(masterList, userId);
    		nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_result", resultMap);
    			
    	} catch (NexacroException nxEx) {
    		throw nxEx;
    			
    	} catch (Exception ex) {
    		throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
    	}
    		
    	return nexacroResult;
    }
}