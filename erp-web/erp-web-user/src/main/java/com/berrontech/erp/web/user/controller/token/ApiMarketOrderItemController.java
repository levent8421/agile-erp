package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.MarketOrder;
import com.berrontech.erp.commons.entity.MarketOrderItem;
import com.berrontech.erp.commons.exception.BadRequestException;
import com.berrontech.erp.modal.service.general.MarketOrderItemService;
import com.berrontech.erp.modal.service.general.MarketOrderService;
import com.berrontech.erp.web.commons.controller.AbstractApiController;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.berrontech.erp.web.commons.util.ParamChecker.notNull;

/**
 * Create By Levent8421
 * Create Time: 2021/3/10 15:00
 * Class Name: ApiMarketOrderItemController
 * Author: Levent8421
 * Description:
 * 市场订单项 数据访问控制器
 *
 * @author Levent8421
 */
@RestController
@RequestMapping("/api/token/market-order-item")
public class ApiMarketOrderItemController extends AbstractApiController {
    private final MarketOrderItemService marketOrderItemService;
    private final MarketOrderService marketOrderService;

    public ApiMarketOrderItemController(MarketOrderItemService marketOrderItemService,
                                        MarketOrderService marketOrderService) {
        this.marketOrderItemService = marketOrderItemService;
        this.marketOrderService = marketOrderService;
    }

    /**
     * Find mark order items by order id
     *
     * @param orderId order id
     * @return GR
     */
    @GetMapping("/_by-order")
    public GeneralResult<List<MarketOrderItem>> findByOrder(@RequestParam("orderId") Integer orderId) {
        final List<MarketOrderItem> items = marketOrderItemService.findByOrderFetchAll(orderId);
        return GeneralResult.ok(items);
    }

    /**
     * 创建订单项
     *
     * @param param 请求参数
     * @return GR
     */
    @PutMapping("/")
    public GeneralResult<MarketOrderItem> createItem4Order(@RequestBody MarketOrderItem param) {
        final MarketOrderItem item = new MarketOrderItem();
        checkCreateParam(param, item);
        final MarketOrder order = marketOrderService.require(item.getMarketOrderId());
        marketOrderItemService.create(item);
        item.setMarketOrder(order);
        return GeneralResult.ok(item);
    }

    private void checkCreateParam(MarketOrderItem param, MarketOrderItem item) {
        final Class<BadRequestException> e = BadRequestException.class;
        notNull(param, e, "No params!");
        notNull(param.getMarketOrderId(), e, "marketOrderId is required!");
        notNull(param.getPartId(), e, "partId is required!");
        notNull(param.getPcs(), e, "pcs is required!");

        item.setMarketOrderId(param.getMarketOrderId());
        item.setPartId(param.getPartId());
        item.setPcs(param.getPcs());
        item.setRemark(param.getRemark());
    }
}
