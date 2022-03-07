package com.gaubiz.exp.controller;

import com.gaubiz.bezelj.nexa17.util.NexacroResultUtil;
import com.gaubiz.exp.service.EXP004Service;
import com.nexacro.uiadapter17.spring.core.NexacroException;
import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.annotation.ParamVariable;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.*;

@Controller
@RequestMapping(value = "/exp/exp004")
public class EXP004Controller {

    @Resource(name = "exp004Service")
    private EXP004Service exp004Service;
    
    /**
     * 체험기기 조회
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpEqpmtList.bzl")
     public NexacroResult selectExpEqpmtList(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp004Service.selectExpEqpmtList(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_expEqpmt", resultList);

         } catch (Exception ex){
             throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

         return nexacroResult;
     }
    
    /**
     * 체험좌석 조회
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpSeatList.bzl")
     public NexacroResult selectExpSeatList(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp004Service.selectExpSeatList(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_expSeat", resultList);

         } catch (Exception ex){
             throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

         return nexacroResult;
     }
         
     /**
   	  * 체험좌석관리 변경 저장 (입력,수정)
   	  * @param masterList
   	  * @param userId
   	  * @return
   	  * @throws Exception
   	  */
   	@RequestMapping(value = "/saveExpSeatList.bzl", method = {RequestMethod.POST})
   	public NexacroResult saveExpSeatList(
   		    @ParamDataSet(name = "ds_expSeat", required = true) List<Map<String, Object>> masterList,
   			@ParamVariable(name = "USER_ID") String userId) throws Exception {
   		NexacroResult nexacroResult = new NexacroResult();
   		
   		try {
   			Map<String, Object> resultMap = this.exp004Service.saveExpSeatList(masterList, userId);
   			nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_result", resultMap);
   			
   		} catch (NexacroException nxEx) {
   			throw nxEx;
   			
   		} catch (Exception ex) {
   			throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
   		}
   		
   		return nexacroResult;
   	}
    
}