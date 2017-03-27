package com.looty.service;

import com.looty.crawler.LinkTypeData;

import java.util.Date;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/27/027
 */
public interface ILinkDataTypeService {

    long save(LinkTypeData linkTypeData);

    void saveList(List<LinkTypeData> datas);

    Long getCountByDate(Date now);
}
