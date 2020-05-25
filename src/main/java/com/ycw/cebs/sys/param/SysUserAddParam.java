package com.ycw.cebs.sys.param;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.ycw.common.constants.CommonConstants;

import lombok.Data;

@Data
public class SysUserAddParam implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户编号
	 */
	private String userNum;

	/**
	 * 真实姓名
	 */
	private String realName;

	/**
	 * 昵称
	 */
	@NotBlank(message = "昵称不能为空")
	private String nickName;

	/**
	 * 登录名
	 */
	@NotBlank(message = "请输入登录名")
	private String loginName;

	/**
	 * 头像url
	 */
	private String profilePhotoUrl;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 生日
	 */
	@DateTimeFormat(pattern = CommonConstants.DATE_FORMAT)
	private LocalDate birthday;

	/**
	 * 手机号
	 */
	private String mobilePhone;

	/**
	 * 电子邮箱
	 */
	@Email(message = "请输入正确的邮箱格式")
	private String eMail;

	/**
	 * 身份证号
	 */
	private String idCard;

	/**
	 * QQ
	 */
	private String qq;

	/**
	 * 微信
	 */
	private String wechat;

	/**
	 * 状态：0-失效；1-生效
	 */
	private Integer status;

	/**
	 * 权限Ids,多个以英文逗号隔开
	 */
	private String permIds;

}