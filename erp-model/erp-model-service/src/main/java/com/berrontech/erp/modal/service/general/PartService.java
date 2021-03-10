package com.berrontech.erp.modal.service.general;

import com.berrontech.erp.commons.entity.Part;
import com.berrontech.erp.modal.service.basic.AbstractService;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/13 18:05
 * Class Name: PartService
 * Author: Levent8421
 * Description:
 * 物料相关业务行为定义
 *
 * @author Levent8421
 */
public interface PartService extends AbstractService<Part> {
    /**
     * 搜索物料
     *
     * @param name query
     * @param max  max result
     * @return Parts
     */
    List<Part> search(String name, Integer max);
}
