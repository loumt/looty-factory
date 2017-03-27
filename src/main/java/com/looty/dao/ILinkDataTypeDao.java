package com.looty.dao;

import com.looty.crawler.LinkTypeData;

import java.util.Date;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/27/027
 */
public interface ILinkDataTypeDao {

    long saveResouData(LinkTypeData linkTypeData);


    Long count(String begin, String end);
}
