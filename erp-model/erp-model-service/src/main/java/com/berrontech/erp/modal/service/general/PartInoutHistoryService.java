package com.berrontech.erp.modal.service.general;

import com.berrontech.erp.commons.entity.PartInoutHistory;
import com.berrontech.erp.modal.service.basic.AbstractService;

import java.util.Date;
import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/7/16 13:40
 * Class Name: PartInoutHistoryService
 * Author: Levent8421
 * Description:
 * 物料出入库历史相关业务行为i定义
 *
 * @author Levent8421
 */
public interface PartInoutHistoryService extends AbstractService<PartInoutHistory> {
    /**
     * Find history list by date range
     *
     * @param start date start
     * @param end   date end
     * @return history list
     */
    List<PartInoutHistory> findByDateRangeFetchAll(Date start, Date end);
}
