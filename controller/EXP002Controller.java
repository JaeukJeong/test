package com.gaubiz.exp.controller;

import com.gaubiz.bezelj.nexa17.util.NexacroResultUtil;
import com.gaubiz.exp.service.EXP002Service;
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
@RequestMapping(value = "/exp/exp002")
public class EXP002Controller {

    @Resource(name = "exp002Service")
    private EXP002Service exp002Service;
    
    /**
     * 체험모드관리 마스터 조회
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpModeMasterList.bzl")
     public NexacroResult selectExpModeMasterList(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp002Service.selectExpModeMasterList(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_master", resultList);

         } catch (Exception ex){
             throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

         return nexacroResult;
     }
     
     /**
      * 체험모드코드 채번
      *
      * @param parameter
      * @return
      * @throws Exception
      */
      @RequestMapping(value = "selectExpModeSeqMasterList.bzl")
      public NexacroResult selectExpModeSeqMasterList(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

          NexacroResult nexacroResult = null;

          try{
             List<Map<String, Object>> resultList = this.exp002Service.selectExpModeSeqMasterList(parameter);
             nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_seq", resultList);

          } catch (Exception ex){
              throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
          }

          return nexacroResult;
      }
      
      /**
       * 체험모드관리  상세 조회
       *
       * @param parameter
       * @return
       * @throws Exception
       */
       @RequestMapping(value = "selectExpModeDtlMasterList.bzl")
       public NexacroResult selectExpModeDtlMasterList(@ParamDataSet(name = "ds_searchDtl", required = true)Map<String, Object> parameter) throws Exception {

           NexacroResult nexacroResult = null;

           try{
              List<Map<String, Object>> resultList = this.exp002Service.selectExpModeDtlMasterList(parameter);
              nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_detail", resultList);

           } catch (Exception ex){
               throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
           }

           return nexacroResult;
       }
       
     /**
   	  * 체험모드관리 변경 저장 (입력,수정)
   	  * @param masterList
   	  * @param detailList
   	  * @param userId
   	  * @return
   	  * @throws Exception
   	  */
   	@RequestMapping(value = "/saveExpModeCodeList.bzl", method = {RequestMethod.POST})
   	public NexacroResult saveExpModeCodeList(
   		    @ParamDataSet(name = "ds_master", required = true) List<Map<String, Object>> masterList,
   			@ParamDataSet(name = "ds_detail", required = true) List<Map<String, Object>> detailList,
   			@ParamVariable(name = "USER_ID") String userId) throws Exception {
   		NexacroResult nexacroResult = new NexacroResult();
   		
   		try {
   			Map<String, Object> resultMap = this.exp002Service.saveExpModeCodeList(masterList, detailList, userId);
   			nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_result", resultMap);
   			
   		} catch (NexacroException nxEx) {
   			throw nxEx;
   			
   		} catch (Exception ex) {
   			throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
   		}
   		
   		return nexacroResult;
   	}
   	
   	/**
  	  * 체험모드관리 상세여부 수정
  	  * @param masterList
  	  * @param detailList
  	  * @param userId
  	  * @return
  	  * @throws Exception
  	  */
  	@RequestMapping(value = "/updateDtlModeYn.bzl", method = {RequestMethod.POST})
  	public NexacroResult updateDtlModeYn(
  		    @ParamDataSet(name = "ds_master", required = true) List<Map<String, Object>> masterList,
  			@ParamVariable(name = "USER_ID") String userId) throws Exception {
  		NexacroResult nexacroResult = new NexacroResult();

  		try {
  			Map<String, Object> resultMap = this.exp002Service.updateDtlModeYn(masterList, userId);
  			nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_result", resultMap);
  			
  		} catch (NexacroException nxEx) {
  			throw nxEx;
  			
  		} catch (Exception ex) {
  			throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
  		}
  		
  		return nexacroResult;
  	}
      
}