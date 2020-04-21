package com.ycw.cebs.user.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.ycw.cebs.user.api.ISysUserApi;
import com.ycw.cebs.user.entity.SysUserEntity;
import com.ycw.cebs.user.service.ISysUserService;
import com.ycw.cebs.user.vo.SysUserDetailVO;
import com.ycw.cebs.user.vo.SysUserListVO;
import com.ycw.cebs.user.vo.param.SysUserListParamVO;
import com.ycw.cebs.user.vo.param.SysUserParamVO;
import com.ycw.common.exception.SysException;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseCode;
import com.ycw.common.response.ResponseVO;
import com.ycw.common.utils.BeanHandleUtils;

/**
 * @类名称 SysUserServiceImpl
 * @类描述 【系统用户表】Service接口实现类
 * @作者 yuminjun
 * @创建时间 2019年12月27日
 * @版本 v1.00
 * @修改记录
 *
 *       <pre>
 * 版本     		修改人 	修改时间    	 	修改内容	描述
 * ----------------------------------------------
 * 1.00 	yuminjun     	2019年12月27日 	新建
 * ----------------------------------------------
 *       </pre>
 */
@Service("sysUserApi")
public class SysUserApiImpl implements ISysUserApi {

	@Autowired
	private ISysUserService sysUserService;

	/**
	 * 用户列表分页查询
	 * @author yuminjun
	 * @date 2020/04/21 14:52:30
	 * @param vo 查询参数
	 * @param pageParams 分页参数（为空时默认查询所有）
	 * @return
	 */
	@Override
	public ResponseVO<PageInfo<SysUserListVO>> querySysUserPage(SysUserListParamVO vo, PageParams pageParams) throws SysException {
		List<SysUserListVO> page = sysUserService.querySysUserList(vo, pageParams);
		return ResponseVO.success(new PageInfo<>(page));
	}

	/**
	 * 根据id查询系统用户数据
	 * @author yuminjun
	 * @date 2020/04/21 16:55:11
	 * @param id
	 * @return
	 * @throws SysException
	 */
	@Override
	public ResponseVO<SysUserDetailVO> getSysUser(Long id) throws SysException {
		if (id == null) {
			throw new SysException(ResponseCode.ERR_418.getCode(), "id不能为空");
		}
		SysUserEntity sysUser = sysUserService.getById(id);
		SysUserDetailVO vo = BeanHandleUtils.beanCopy(sysUser, SysUserDetailVO.class);
		return ResponseVO.success(vo);
	}

	/**
	 * 保存系统用户数据
	 * @author yuminjun
	 * @date 2020/04/21 16:55:37
	 * @param vo
	 * @return
	 */
	@Override
	public ResponseVO<Long> saveSysUser(SysUserParamVO vo) {
		SysUserEntity sysUser = BeanHandleUtils.beanCopy(vo, SysUserEntity.class);
		sysUserService.save(sysUser);
		return ResponseVO.success(sysUser.getId(), "新增成功");
	}

	/**
	 * 修改系统用户数据
	 * @author yuminjun
	 * @date 2020/04/21 16:55:59
	 * @param vo
	 * @return
	 */
	@Override
	public ResponseVO<Long> updateSysUser(SysUserParamVO vo) {
		SysUserEntity sysUser = BeanHandleUtils.beanCopy(vo, SysUserEntity.class);
		sysUserService.updateById(sysUser);
		return ResponseVO.success(sysUser.getId(), "修改成功");
	}

	/**
	 * 删除系统用户数据
	 * @author yuminjun
	 * @date 2020/04/21 16:56:15
	 * @param id
	 * @return
	 * @throws SysException
	 */
	@Override
	public ResponseVO<String> deleteSysUser(Long id) throws SysException {
		if (id == null) {
			throw new SysException(ResponseCode.ERR_418.getCode(), "id不能为空");
		}
		sysUserService.removeById(id);
		return ResponseVO.success(null, "删除成功");
	}

}
