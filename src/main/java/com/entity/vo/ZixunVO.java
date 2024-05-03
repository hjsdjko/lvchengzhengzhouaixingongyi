package com.entity.vo;

import com.entity.ZixunEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 资讯信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zixun")
public class ZixunVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 资讯标题
     */

    @TableField(value = "zixun_name")
    private String zixunName;


    /**
     * 资讯类型
     */

    @TableField(value = "zixun_types")
    private Integer zixunTypes;


    /**
     * 资讯图片
     */

    @TableField(value = "zixun_photo")
    private String zixunPhoto;


    /**
     * 相关文件
     */

    @TableField(value = "zixun_file")
    private String zixunFile;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 资讯详情
     */

    @TableField(value = "zixun_content")
    private String zixunContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：资讯标题
	 */
    public String getZixunName() {
        return zixunName;
    }


    /**
	 * 获取：资讯标题
	 */

    public void setZixunName(String zixunName) {
        this.zixunName = zixunName;
    }
    /**
	 * 设置：资讯类型
	 */
    public Integer getZixunTypes() {
        return zixunTypes;
    }


    /**
	 * 获取：资讯类型
	 */

    public void setZixunTypes(Integer zixunTypes) {
        this.zixunTypes = zixunTypes;
    }
    /**
	 * 设置：资讯图片
	 */
    public String getZixunPhoto() {
        return zixunPhoto;
    }


    /**
	 * 获取：资讯图片
	 */

    public void setZixunPhoto(String zixunPhoto) {
        this.zixunPhoto = zixunPhoto;
    }
    /**
	 * 设置：相关文件
	 */
    public String getZixunFile() {
        return zixunFile;
    }


    /**
	 * 获取：相关文件
	 */

    public void setZixunFile(String zixunFile) {
        this.zixunFile = zixunFile;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：资讯详情
	 */
    public String getZixunContent() {
        return zixunContent;
    }


    /**
	 * 获取：资讯详情
	 */

    public void setZixunContent(String zixunContent) {
        this.zixunContent = zixunContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
