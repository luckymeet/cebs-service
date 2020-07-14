package com.ycw.cebs.info.service;

import java.util.List;

import com.ycw.cebs.info.entity.InfoArticle;
import com.ycw.cebs.info.param.InfoArticlePageParam;
import com.ycw.cebs.info.vo.InfoArticleListVO;
import com.ycw.common.base.BaseService;
import com.ycw.common.page.PageParam;

/**
 * 文章Service接口
 *
 * @author yuminjun yuminjun@lexiangbao.com
 * @date 2020/05/19 14:39:58
 * @version v1.00
 *
 * @record
 *
 *         <pre>
 * version  author      date          desc
 * -------------------------------------------------
 * 1.00     yuminjun    2020/05/19    新建
 * -------------------------------------------------
 *         </pre>
 */
public interface InfoArticleService extends BaseService<InfoArticle> {

	/**
	 * 文章列表分页查询
	 *
	 * @author yuminjun
	 * @date 2020/05/19 16:45:07
	 * @param infoArticlePageParam 查询参数
	 * @param pageParam            分页参数（为空时默认查询所有）
	 * @return
	 */
	List<InfoArticleListVO> queryInfoArticlePage(InfoArticlePageParam infoArticlePageParam, PageParam pageParam);

}