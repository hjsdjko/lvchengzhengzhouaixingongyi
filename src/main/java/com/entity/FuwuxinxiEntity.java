package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 服务信息
 *
 * @author 
 * @email
 */
@TableName("fuwuxinxi")
public class FuwuxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuwuxinxiEntity() {

	}

	public FuwuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 标题
     */
    @TableField(value = "fuwuxinxi_name")

    private String fuwuxinxiName;


    /**
     * 服务类型
     */
    @TableField(value = "fuwuxinxi_types")

    private Integer fuwuxinxiTypes;


    /**
     * 服务图片
     */
    @TableField(value = "fuwuxinxi_photo")

    private String fuwuxinxiPhoto;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fuwuxinxi_time")

    private Date fuwuxinxiTime;


    /**
     * 服务地址
     */
    @TableField(value = "fuwuxinxi_address")

    private String fuwuxinxiAddress;


    /**
     * 服务详情
     */
    @TableField(value = "fuwuxinxi_content")

    private String fuwuxinxiContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：标题
	 */
    public String getFuwuxinxiName() {
        return fuwuxinxiName;
    }
    /**
	 * 获取：标题
	 */

    public void setFuwuxinxiName(String fuwuxinxiName) {
        this.fuwuxinxiName = fuwuxinxiName;
    }
    /**
	 * 设置：服务类型
	 */
    public Integer getFuwuxinxiTypes() {
        return fuwuxinxiTypes;
    }
    /**
	 * 获取：服务类型
	 */

    public void setFuwuxinxiTypes(Integer fuwuxinxiTypes) {
        this.fuwuxinxiTypes = fuwuxinxiTypes;
    }
    /**
	 * 设置：服务图片
	 */
    public String getFuwuxinxiPhoto() {
        return fuwuxinxiPhoto;
    }
    /**
	 * 获取：服务图片
	 */

    public void setFuwuxinxiPhoto(String fuwuxinxiPhoto) {
        this.fuwuxinxiPhoto = fuwuxinxiPhoto;
    }
    /**
	 * 设置：开始时间
	 */
    public Date getFuwuxinxiTime() {
        return fuwuxinxiTime;
    }
    /**
	 * 获取：开始时间
	 */

    public void setFuwuxinxiTime(Date fuwuxinxiTime) {
        this.fuwuxinxiTime = fuwuxinxiTime;
    }
    /**
	 * 设置：服务地址
	 */
    public String getFuwuxinxiAddress() {
        return fuwuxinxiAddress;
    }
    /**
	 * 获取：服务地址
	 */

    public void setFuwuxinxiAddress(String fuwuxinxiAddress) {
        this.fuwuxinxiAddress = fuwuxinxiAddress;
    }
    /**
	 * 设置：服务详情
	 */
    public String getFuwuxinxiContent() {
        return fuwuxinxiContent;
    }
    /**
	 * 获取：服务详情
	 */

    public void setFuwuxinxiContent(String fuwuxinxiContent) {
        this.fuwuxinxiContent = fuwuxinxiContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fuwuxinxi{" +
            "id=" + id +
            ", fuwuxinxiName=" + fuwuxinxiName +
            ", fuwuxinxiTypes=" + fuwuxinxiTypes +
            ", fuwuxinxiPhoto=" + fuwuxinxiPhoto +
            ", fuwuxinxiTime=" + fuwuxinxiTime +
            ", fuwuxinxiAddress=" + fuwuxinxiAddress +
            ", fuwuxinxiContent=" + fuwuxinxiContent +
            ", createTime=" + createTime +
        "}";
    }
}
