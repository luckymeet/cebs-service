package com.ycw.cebs.info.api;

import java.time.LocalDateTime;

import com.github.pagehelper.PageInfo;
import com.ycw.cebs.info.param.InfoArticleAddParam;
import com.ycw.cebs.info.param.InfoArticleEditParam;
import com.ycw.cebs.info.param.InfoArticlePageParam;
import com.ycw.cebs.info.vo.InfoArticleListVO;
import com.ycw.common.page.PageParams;
import com.ycw.common.response.ResponseVO;

/**
 * 文章Api接口
 * @author yuminjun
 * @date 2020/05/19 14:39:58
 * @version v1.00

 * @record
 * <pre>
 * version  author      date          desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/05/19    新建
 * -------------------------------------------------
 * </pre>
 */
public interface IInfoArticleApi {

	/**
	 * 文章列表分页查询
	 * @author yuminjun
	 * @date 2020/05/19 16:45:07
	 * @param infoArticlePageParamVO 查询参数
	 * @param pageParams 分页参数（为空时默认查询所有）
	 * @return
	 */
	ResponseVO<PageInfo<InfoArticleListVO>> queryInfoArticlePage(InfoArticlePageParam infoArticlePageParamVO, PageParams pageParams);

	/**
	 * 文章新增
	 * @author yuminjun
	 * @date 2020/05/25 11:01:04
	 * @param infoArticleAddParam
	 * @return
	 */
	ResponseVO<Long> saveInfoArticle(InfoArticleAddParam infoArticleAddParam);

	/**
	 * 文章修改
	 * @author yuminjun
	 * @date 2020/05/25 11:01:04
	 * @param infoArticleEditParam
	 * @return
	 */
	ResponseVO<String> updateInfoArticle(InfoArticleEditParam infoArticleEidtParam);

	/**
	 * 文章删除
	 * @author yuminjun
	 * @date 2020/05/25 14:39:24
	 * @param id
	 * @return
	 */
	ResponseVO<String> deleteInfoArticle(Long id);

	/**
	 * 发布
	 * @author yuminjun
	 * @date 2020/05/25 15:26:16
	 * @param id 文章id
	 * @param publishTime 发布时间
	 * @return
	 */
	ResponseVO<String> publish(Long id, LocalDateTime publishTime);

	/**
	 * 取消发布
	 * @author yuminjun
	 * @date 2020/05/25 15:21:05
	 * @param id
	 * @return
	 */
	ResponseVO<String> cancelPublish(Long id);

}
