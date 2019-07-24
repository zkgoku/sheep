package com.shaunk.mapper;

import com.shaunk.entity.Notice;
import com.shaunk.vo.NoticeVO;
import com.shaunk.vo.QueryNoticeVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Project sheep
 * @Package com.shaunk.mapper
 * @Name NoticeMapper
 * @Version 1.0
 * @Data: 2019/7/5 11:38 AM
 * @Author: shaunk
 * @Description: TODO
 */
public interface NoticeMapper extends Mapper<Notice> {

    List<NoticeVO> listNotice(QueryNoticeVO queryNoticeVO);
}
