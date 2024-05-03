package com.entity.model;

import com.entity.FuwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服务信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuwuxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String fuwuxinxiName;


    /**
     * 服务类型
     */
    private Integer fuwuxinxiTypes;


    /**
     * 服务图片
     */
    private String fuwuxinxiPhoto;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fuwuxinxiTime;


    /**
     * 服务地址
     */
    private String fuwuxinxiAddress;


    /**
     * 服务详情
     */
    private String fuwuxinxiContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：标题
	 */
    public String getFuwuxinxiName() {
        return fuwuxinxiName;
    }


    /**
	 * 设置：标题
	 */
    public void setFuwuxinxiName(String fuwuxinxiName) {
        this.fuwuxinxiName = fuwuxinxiName;
    }
    /**
	 * 获取：服务类型
	 */
    public Integer getFuwuxinxiTypes() {
        return fuwuxinxiTypes;
    }


    /**
	 * 设置：服务类型
	 */
    public void setFuwuxinxiTypes(Integer fuwuxinxiTypes) {
        this.fuwuxinxiTypes = fuwuxinxiTypes;
    }
    /**
	 * 获取：服务图片
	 */
    public String getFuwuxinxiPhoto() {
        return fuwuxinxiPhoto;
    }


    /**
	 * 设置：服务图片
	 */
    public void setFuwuxinxiPhoto(String fuwuxinxiPhoto) {
        this.fuwuxinxiPhoto = fuwuxinxiPhoto;
    }
    /**
	 * 获取：开始时间
	 */
    public Date getFuwuxinxiTime() {
        return fuwuxinxiTime;
    }


    /**
	 * 设置：开始时间
	 */
    public void setFuwuxinxiTime(Date fuwuxinxiTime) {
        this.fuwuxinxiTime = fuwuxinxiTime;
    }
    /**
	 * 获取：服务地址
	 */
    public String getFuwuxinxiAddress() {
        return fuwuxinxiAddress;
    }


    /**
	 * 设置：服务地址
	 */
    public void setFuwuxinxiAddress(String fuwuxinxiAddress) {
        this.fuwuxinxiAddress = fuwuxinxiAddress;
    }
    /**
	 * 获取：服务详情
	 */
    public String getFuwuxinxiContent() {
        return fuwuxinxiContent;
    }


    /**
	 * 设置：服务详情
	 */
    public void setFuwuxinxiContent(String fuwuxinxiContent) {
        this.fuwuxinxiContent = fuwuxinxiContent;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
