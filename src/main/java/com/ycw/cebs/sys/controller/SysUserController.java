package com.ycw.cebs.sys.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esotericsoftware.minlog.Log;
import com.github.pagehelper.PageInfo;
import com.ycw.cebs.sys.api.ISysUserApi;
import com.ycw.cebs.sys.vo.SysUserDetailVO;
import com.ycw.cebs.sys.vo.SysUserListVO;
import com.ycw.cebs.sys.vo.param.SysUserAddParamVO;
import com.ycw.cebs.sys.vo.param.SysUserEditParamVO;
import com.ycw.cebs.sys.vo.param.SysUserListParamVO;
import com.ycw.common.base.BaseController;
import com.ycw.common.exception.SysException;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;

/**
 * 用户管理Controller
 * @author yuminjun
 * @date 2020/04/22 14:13:24
 * @version 1.00
 *
 * @record
 * <pre>
 * version  author      date          desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/04/22    新建
 * -------------------------------------------------
 * </pre>
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

	@Autowired
	private ISysUserApi sysUserApi;

	/**
	 * 用户列表分页查询
	 * @author yuminjun
	 * @date 2020/04/22 14:13:35
	 * @param vo 查询参数
	 * @param pageParams 分页参数
	 * @return
	 * @throws SysException
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:user:list")
	public ResponseVO<PageInfo<SysUserListVO>> queryUserPage(SysUserListParamVO vo, PageParams pageParams) throws SysException {
		return sysUserApi.queryUserPage(vo, pageParams);
	}

	/**
	 * 用户详情
	 * @author yuminjun
	 * @date 2020/04/22 14:13:50
	 * @param id
	 * @return
	 * @throws SysException
	 */
	@GetMapping
	public ResponseVO<SysUserDetailVO> getUser(Long id) throws SysException {
		return sysUserApi.getUser(id);
	}

	/**
	 * 用户新增
	 * @author yuminjun
	 * @date 2020/04/22 14:24:46
	 * @param vo
	 * @return
	 * @throws SysException
	 */
	@PostMapping
	public ResponseVO<Long> saveUser(@Validated SysUserAddParamVO vo) throws SysException {
		return sysUserApi.saveUser(vo);
	}

	/**
	 * 用户修改
	 * @author yuminjun
	 * @date 2020/04/22 14:24:57
	 * @param vo
	 * @return
	 * @throws SysException
	 */
	@PutMapping
	public ResponseVO<Long> updateUser(@Validated SysUserEditParamVO vo) throws SysException {
		System.out.println("===============" + vo);
		return sysUserApi.updateUser(vo);
	}

	/**
	 * 用户删除
	 * @author yuminjun
	 * @date 2020/04/22 14:14:40
	 * @param id 用户id
	 * @return
	 * @throws SysException
	 */
	@DeleteMapping
	public ResponseVO<String> deleteUser(Long id) throws SysException {
		return sysUserApi.deleteUser(id);
	}

}