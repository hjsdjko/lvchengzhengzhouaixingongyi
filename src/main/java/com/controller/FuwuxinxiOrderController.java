
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 服务申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fuwuxinxiOrder")
public class FuwuxinxiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(FuwuxinxiOrderController.class);

    @Autowired
    private FuwuxinxiOrderService fuwuxinxiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FuwuxinxiService fuwuxinxiService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fuwuxinxiOrderService.queryPage(params);

        //字典表数据转换
        List<FuwuxinxiOrderView> list =(List<FuwuxinxiOrderView>)page.getList();
        for(FuwuxinxiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FuwuxinxiOrderEntity fuwuxinxiOrder = fuwuxinxiOrderService.selectById(id);
        if(fuwuxinxiOrder !=null){
            //entity转view
            FuwuxinxiOrderView view = new FuwuxinxiOrderView();
            BeanUtils.copyProperties( fuwuxinxiOrder , view );//把实体数据重构到view中

                //级联表
                FuwuxinxiEntity fuwuxinxi = fuwuxinxiService.selectById(fuwuxinxiOrder.getFuwuxinxiId());
                if(fuwuxinxi != null){
                    BeanUtils.copyProperties( fuwuxinxi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFuwuxinxiId(fuwuxinxi.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(fuwuxinxiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FuwuxinxiOrderEntity fuwuxinxiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fuwuxinxiOrder:{}",this.getClass().getName(),fuwuxinxiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            fuwuxinxiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        fuwuxinxiOrder.setCreateTime(new Date());
        fuwuxinxiOrderService.insert(fuwuxinxiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FuwuxinxiOrderEntity fuwuxinxiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fuwuxinxiOrder:{}",this.getClass().getName(),fuwuxinxiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            fuwuxinxiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FuwuxinxiOrderEntity> queryWrapper = new EntityWrapper<FuwuxinxiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FuwuxinxiOrderEntity fuwuxinxiOrderEntity = fuwuxinxiOrderService.selectOne(queryWrapper);
        if(fuwuxinxiOrderEntity==null){
            fuwuxinxiOrderService.updateById(fuwuxinxiOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody FuwuxinxiOrderEntity fuwuxinxiOrder, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,fuwuxinxiOrder:{}",this.getClass().getName(),fuwuxinxiOrder.toString());

//        if(fuwuxinxiOrder.getFuwuxinxiOrderYesnoTypes() == 2){//通过
//            fuwuxinxiOrder.setFuwuxinxiOrderTypes();
//        }else if(fuwuxinxiOrder.getFuwuxinxiOrderYesnoTypes() == 3){//拒绝
//            fuwuxinxiOrder.setFuwuxinxiOrderTypes();
//        }
        fuwuxinxiOrderService.updateById(fuwuxinxiOrder);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fuwuxinxiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FuwuxinxiOrderEntity> fuwuxinxiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FuwuxinxiOrderEntity fuwuxinxiOrderEntity = new FuwuxinxiOrderEntity();
//                            fuwuxinxiOrderEntity.setFuwuxinxiId(Integer.valueOf(data.get(0)));   //服务信息 要改的
//                            fuwuxinxiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            fuwuxinxiOrderEntity.setFuwuxinxiOrderNumber(Integer.valueOf(data.get(0)));   //参加人数 要改的
//                            fuwuxinxiOrderEntity.setFuwuxinxiOrderText(data.get(0));                    //备注 要改的
//                            fuwuxinxiOrderEntity.setFuwuxinxiOrderYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            fuwuxinxiOrderEntity.setFuwuxinxiOrderYesnoText(data.get(0));                    //申请结果 要改的
//                            fuwuxinxiOrderEntity.setCreateTime(date);//时间
                            fuwuxinxiOrderList.add(fuwuxinxiOrderEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        fuwuxinxiOrderService.insertBatch(fuwuxinxiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = fuwuxinxiOrderService.queryPage(params);

        //字典表数据转换
        List<FuwuxinxiOrderView> list =(List<FuwuxinxiOrderView>)page.getList();
        for(FuwuxinxiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FuwuxinxiOrderEntity fuwuxinxiOrder = fuwuxinxiOrderService.selectById(id);
            if(fuwuxinxiOrder !=null){


                //entity转view
                FuwuxinxiOrderView view = new FuwuxinxiOrderView();
                BeanUtils.copyProperties( fuwuxinxiOrder , view );//把实体数据重构到view中

                //级联表
                    FuwuxinxiEntity fuwuxinxi = fuwuxinxiService.selectById(fuwuxinxiOrder.getFuwuxinxiId());
                if(fuwuxinxi != null){
                    BeanUtils.copyProperties( fuwuxinxi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFuwuxinxiId(fuwuxinxi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(fuwuxinxiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody FuwuxinxiOrderEntity fuwuxinxiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,fuwuxinxiOrder:{}",this.getClass().getName(),fuwuxinxiOrder.toString());
            FuwuxinxiEntity fuwuxinxiEntity = fuwuxinxiService.selectById(fuwuxinxiOrder.getFuwuxinxiId());
            if(fuwuxinxiEntity == null){
                return R.error(511,"查不到该服务信息");
            }
            // Double fuwuxinxiNewMoney = fuwuxinxiEntity.getFuwuxinxiNewMoney();

            if(false){
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            fuwuxinxiOrder.setYonghuId(userId); //设置订单支付人id
            fuwuxinxiOrder.setCreateTime(new Date());
                fuwuxinxiOrderService.insert(fuwuxinxiOrder);//新增订单
            return R.ok();
    }



}
