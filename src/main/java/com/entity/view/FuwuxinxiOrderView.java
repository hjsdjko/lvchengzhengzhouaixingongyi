package com.entity.view;

import com.entity.FuwuxinxiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 服务申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fuwuxinxi_order")
public class FuwuxinxiOrderView extends FuwuxinxiOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请状态的值
		*/
		private String fuwuxinxiOrderYesnoValue;



		//级联表 fuwuxinxi
			/**
			* 标题
			*/
			private String fuwuxinxiName;
			/**
			* 服务类型
			*/
			private Integer fuwuxinxiTypes;
				/**
				* 服务类型的值
				*/
				private String fuwuxinxiValue;
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 身份
			*/
			private Integer yonghuTypes;
				/**
				* 身份的值
				*/
				private String yonghuValue;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FuwuxinxiOrderView() {

	}

	public FuwuxinxiOrderView(FuwuxinxiOrderEntity fuwuxinxiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, fuwuxinxiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 申请状态的值
			*/
			public String getFuwuxinxiOrderYesnoValue() {
				return fuwuxinxiOrderYesnoValue;
			}
			/**
			* 设置： 申请状态的值
			*/
			public void setFuwuxinxiOrderYesnoValue(String fuwuxinxiOrderYesnoValue) {
				this.fuwuxinxiOrderYesnoValue = fuwuxinxiOrderYesnoValue;
			}










				//级联表的get和set fuwuxinxi

					/**
					* 获取： 标题
					*/
					public String getFuwuxinxiName() {
						return fuwuxinxiName;
					}
					/**
					* 设置： 标题
					*/
					public void setFuwuxinxiName(String fuwuxinxiName) {
						this.fuwuxinxiName = fuwuxinxiName;
					}

					/**
					* 获取： 服务类型
					*/
					public Integer getFuwuxinxiTypes() {
						return fuwuxinxiTypes;
					}
					/**
					* 设置： 服务类型
					*/
					public void setFuwuxinxiTypes(Integer fuwuxinxiTypes) {
						this.fuwuxinxiTypes = fuwuxinxiTypes;
					}


						/**
						* 获取： 服务类型的值
						*/
						public String getFuwuxinxiValue() {
							return fuwuxinxiValue;
						}
						/**
						* 设置： 服务类型的值
						*/
						public void setFuwuxinxiValue(String fuwuxinxiValue) {
							this.fuwuxinxiValue = fuwuxinxiValue;
						}

					/**
					* 获取： 服务图片
					*/
					public String getFuwuxinxiPhoto() {
						return fuwuxinxiPhoto;
					}
					/**
					* 设置： 服务图片
					*/
					public void setFuwuxinxiPhoto(String fuwuxinxiPhoto) {
						this.fuwuxinxiPhoto = fuwuxinxiPhoto;
					}

					/**
					* 获取： 开始时间
					*/
					public Date getFuwuxinxiTime() {
						return fuwuxinxiTime;
					}
					/**
					* 设置： 开始时间
					*/
					public void setFuwuxinxiTime(Date fuwuxinxiTime) {
						this.fuwuxinxiTime = fuwuxinxiTime;
					}

					/**
					* 获取： 服务地址
					*/
					public String getFuwuxinxiAddress() {
						return fuwuxinxiAddress;
					}
					/**
					* 设置： 服务地址
					*/
					public void setFuwuxinxiAddress(String fuwuxinxiAddress) {
						this.fuwuxinxiAddress = fuwuxinxiAddress;
					}

					/**
					* 获取： 服务详情
					*/
					public String getFuwuxinxiContent() {
						return fuwuxinxiContent;
					}
					/**
					* 设置： 服务详情
					*/
					public void setFuwuxinxiContent(String fuwuxinxiContent) {
						this.fuwuxinxiContent = fuwuxinxiContent;
					}













				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 身份
					*/
					public Integer getYonghuTypes() {
						return yonghuTypes;
					}
					/**
					* 设置： 身份
					*/
					public void setYonghuTypes(Integer yonghuTypes) {
						this.yonghuTypes = yonghuTypes;
					}


						/**
						* 获取： 身份的值
						*/
						public String getYonghuValue() {
							return yonghuValue;
						}
						/**
						* 设置： 身份的值
						*/
						public void setYonghuValue(String yonghuValue) {
							this.yonghuValue = yonghuValue;
						}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}






}
