package com.berrontech.erp.web.user.vo;

import com.berrontech.erp.model.repository.dto.QuantityBatchUpdateItem;
import lombok.Data;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/12/22 14:21
 * Class Name: QuantityBatchOutboundParam
 * Author: Levent8421
 * Description:
 * 库存批量扣除参数
 *
 * @author Levent8421
 */
@Data
public class QuantityBatchOutboundParam {
    private Integer storageLocationId;
    private List<QuantityBatchUpdateItem> items;
}
