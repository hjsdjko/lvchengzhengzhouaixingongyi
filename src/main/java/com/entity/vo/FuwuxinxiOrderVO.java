package com.entity.vo;

import com.entity.FuwuxinxiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 服务申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fuwuxinxi_order")
public class FuwuxinxiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 服务信息
     */

    @TableField(value = "fuwuxinxi_id")
    private Integer fuwuxinxiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 参加人数
     */

    @TableField(value = "fuwuxinxi_order_number")
    private Integer fuwuxinxiOrderNumber;


    /**
     * 备注
     */

    @TableField(value = "fuwuxinxi_order_text")
    private String fuwuxinxiOrderText;


    /**
     * 申请状态
     */

    @TableField(value = "fuwuxinxi_order_yesno_types")
    private Integer fuwuxinxiOrderYesnoTypes;


    /**
     * 申请结果
     */

    @TableField(value = "fuwuxinxi_order_yesno_text")
    private String fuwuxinxiOrderYesnoText;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：服务信息
	 */
    public Integer getFuwuxinxiId() {
        return fuwuxinxiId;
    }


    /**
	 * 获取：服务信息
	 */

    public void setFuwuxinxiId(Integer fuwuxinxiId) {
        this.fuwuxinxiId = fuwuxinxiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：参加人数
	 */
    public Integer getFuwuxinxiOrderNumber() {
        return fuwuxinxiOrderNumber;
    }


    /**
	 * 获取：参加人数
	 */

    public void setFuwuxinxiOrderNumber(Integer fuwuxinxiOrderNumber) {
        this.fuwuxinxiOrderNumber = fuwuxinxiOrderNumber;
    }
    /**
	 * 设置：备注
	 */
    public String getFuwuxinxiOrderText() {
        return fuwuxinxiOrderText;
    }


    /**
	 * 获取：备注
	 */

    public void setFuwuxinxiOrderText(String fuwuxinxiOrderText) {
        this.fuwuxinxiOrderText = fuwuxinxiOrderText;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getFuwuxinxiOrderYesnoTypes() {
        return fuwuxinxiOrderYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setFuwuxinxiOrderYesnoTypes(Integer fuwuxinxiOrderYesnoTypes) {
        this.fuwuxinxiOrderYesnoTypes = fuwuxinxiOrderYesnoTypes;
    }
    /**
	 * 设置：申请结果
	 */
    public String getFuwuxinxiOrderYesnoText() {
        return fuwuxinxiOrderYesnoText;
    }


    /**
	 * 获取：申请结果
	 */

    public void setFuwuxinxiOrderYesnoText(String fuwuxinxiOrderYesnoText) {
        this.fuwuxinxiOrderYesnoText = fuwuxinxiOrderYesnoText;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
