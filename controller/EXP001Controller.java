package com.gaubiz.exp.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.gaubiz.bezelj.nexa17.util.NexacroResultUtil;
import com.gaubiz.exp.service.EXP001Service;
import com.nexacro.uiadapter17.spring.core.NexacroException;
import com.nexacro.uiadapter17.spring.core.annotation.ParamDataSet;
import com.nexacro.uiadapter17.spring.core.data.NexacroResult;

@Controller
@RequestMapping(value = "/exp/exp001")
public class EXP001Controller {

    @Resource(name = "exp001Service")
    private EXP001Service exp001Service;
    
    /**
     * 체험현황 조회
     *
     * @param parameter
     * @return
     * @throws Exception
     */
     @RequestMapping(value = "selectExpCurStatList.bzl")
     public NexacroResult selectExpCurStatList(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

         NexacroResult nexacroResult = null;

         try{
            List<Map<String, Object>> resultList = this.exp001Service.selectExpCurStatList(parameter);
            nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_expCurStat", resultList);

         } catch (Exception ex){
             throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
         }

         return nexacroResult;
     }
     
     /**
      * 체험기기조건 조회
      *
      * @param parameter
      * @return
      * @throws Exception
      */
      @RequestMapping(value = "selectExpEqpmt.bzl")
      public NexacroResult selectExpEqpmt(@ParamDataSet(name = "ds_search", required = true)Map<String, Object> parameter) throws Exception {

          NexacroResult nexacroResult = null;

          try{
             List<Map<String, Object>> resultList = this.exp001Service.selectExpEqpmt(parameter);
             nexacroResult = NexacroResultUtil.toNexacroResult("000", "SUCCESS", "ds_expEqmt", resultList);

          } catch (Exception ex){
              throw new NexacroException(ex.getLocalizedMessage(), -900, "COM000013");
          }

          return nexacroResult;
      }
     
}