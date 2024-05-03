package com.entity.model;

import com.entity.FuwuxinxiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服务申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuwuxinxiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 服务信息
     */
    private Integer fuwuxinxiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 参加人数
     */
    private Integer fuwuxinxiOrderNumber;


    /**
     * 备注
     */
    private String fuwuxinxiOrderText;


    /**
     * 申请状态
     */
    private Integer fuwuxinxiOrderYesnoTypes;


    /**
     * 申请结果
     */
    private String fuwuxinxiOrderYesnoText;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：服务信息
	 */
    public Integer getFuwuxinxiId() {
        return fuwuxinxiId;
    }


    /**
	 * 设置：服务信息
	 */
    public void setFuwuxinxiId(Integer fuwuxinxiId) {
        this.fuwuxinxiId = fuwuxinxiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：参加人数
	 */
    public Integer getFuwuxinxiOrderNumber() {
        return fuwuxinxiOrderNumber;
    }


    /**
	 * 设置：参加人数
	 */
    public void setFuwuxinxiOrderNumber(Integer fuwuxinxiOrderNumber) {
        this.fuwuxinxiOrderNumber = fuwuxinxiOrderNumber;
    }
    /**
	 * 获取：备注
	 */
    public String getFuwuxinxiOrderText() {
        return fuwuxinxiOrderText;
    }


    /**
	 * 设置：备注
	 */
    public void setFuwuxinxiOrderText(String fuwuxinxiOrderText) {
        this.fuwuxinxiOrderText = fuwuxinxiOrderText;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getFuwuxinxiOrderYesnoTypes() {
        return fuwuxinxiOrderYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setFuwuxinxiOrderYesnoTypes(Integer fuwuxinxiOrderYesnoTypes) {
        this.fuwuxinxiOrderYesnoTypes = fuwuxinxiOrderYesnoTypes;
    }
    /**
	 * 获取：申请结果
	 */
    public String getFuwuxinxiOrderYesnoText() {
        return fuwuxinxiOrderYesnoText;
    }


    /**
	 * 设置：申请结果
	 */
    public void setFuwuxinxiOrderYesnoText(String fuwuxinxiOrderYesnoText) {
        this.fuwuxinxiOrderYesnoText = fuwuxinxiOrderYesnoText;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
