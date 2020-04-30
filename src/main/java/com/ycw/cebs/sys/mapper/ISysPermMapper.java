package com.ycw.cebs.sys.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ycw.cebs.sys.entity.SysPermEntity;
import com.ycw.common.base.BaseCrudMapper;

/**
 * 系统权限Mapper接口
 * @author yuminjun yuminjun@lexiangbao.com
 * @date 2020/04/22 09:30:50
 * @version v1.00

 * @record
 * <pre>
 * version  author      date          desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/04/22    新建
 * -------------------------------------------------
 * </pre>
 */
@Mapper
public interface ISysPermMapper extends BaseCrudMapper<SysPermEntity> {

}
