package com.entity.view;

import com.entity.ZixunEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 资讯信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zixun")
public class ZixunView extends ZixunEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 资讯类型的值
		*/
		private String zixunValue;



	public ZixunView() {

	}

	public ZixunView(ZixunEntity zixunEntity) {
		try {
			BeanUtils.copyProperties(this, zixunEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 资讯类型的值
			*/
			public String getZixunValue() {
				return zixunValue;
			}
			/**
			* 设置： 资讯类型的值
			*/
			public void setZixunValue(String zixunValue) {
				this.zixunValue = zixunValue;
			}











}
