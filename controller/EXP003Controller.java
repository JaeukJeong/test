package com.gaubiz.exp.controller;

import com.gaubiz.bezelj.nexa17.util.NexacroResultUtil;
import com.gaubiz.exp.service.EXP003Service;
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
@RequestMapping(value = "/exp/exp003")
public class EXP003Controller {

    @Resource(name = "exp003Service")
    private EXP003Service exp003Service;
    
    /**
     * 체험모드 조회
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpModeList.bzl")
     public NexacroResult selectExpModeList(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp003Service.selectExpModeList(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_expMode", resultList);

         } catch (Exception ex){
             throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

         return nexacroResult;
     }
    
    /**
     * 체험기기 마스터 조회
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpEqpmtMasterList.bzl")
     public NexacroResult selectExpEqpmtMasterList(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp003Service.selectExpEqpmtMasterList(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_master", resultList);

         } catch (Exception ex){
             throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

         return nexacroResult;
     }
         
      /**
       * 체험기기 모드 조회
       *
       * @param parameter
       * @return
       * @throws Exception
       */
       @RequestMapping(value = "selectExpEqpmtDtlMasterList.bzl")
       public NexacroResult selectExpModeDtlMasterList(@ParamDataSet(name = "ds_searchDtl", required = true)Map<String, Object> parameter) throws Exception {

           NexacroResult nexacroResult = null;

           try{
              List<Map<String, Object>> resultList = this.exp003Service.selectExpEqpmtDtlMasterList(parameter);
              nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_detail", resultList);

           } catch (Exception ex){
               throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
           }

           return nexacroResult;
       }
       
     /**
   	  * 체험기기관리 변경 저장 (입력,수정)
   	  * @param masterList
   	  * @param detailList
   	  * @param userId
   	  * @return
   	  * @throws Exception
   	  */
   	@RequestMapping(value = "/saveExpEqpmtList.bzl", method = {RequestMethod.POST})
   	public NexacroResult saveExpModeCodeList(
   		    @ParamDataSet(name = "ds_master", required = true) List<Map<String, Object>> masterList,
   			@ParamDataSet(name = "ds_detail", required = true) List<Map<String, Object>> detailList,
   			@ParamVariable(name = "USER_ID") String userId) throws Exception {
   		NexacroResult nexacroResult = new NexacroResult();
   		
   		try {
   			Map<String, Object> resultMap = this.exp003Service.saveExpEqpmtList(masterList, detailList, userId);
   			nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_result", resultMap);
   			
   		} catch (NexacroException nxEx) {
   			throw nxEx;
   			
   		} catch (Exception ex) {
   			throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
   		}
   		
   		return nexacroResult;
   	}
    
}