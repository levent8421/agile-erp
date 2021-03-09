package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.context.OrderState;
import com.berrontech.erp.commons.entity.MarketOrder;
import com.berrontech.erp.commons.exception.BadRequestException;
import com.berrontech.erp.modal.service.general.MarketOrderService;
import com.berrontech.erp.web.commons.controller.AbstractApiController;
import com.berrontech.erp.web.commons.security.TokenDataHolder;
import com.berrontech.erp.web.commons.util.ParamChecker;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import com.berrontech.erp.web.commons.vo.PaginationParam;
import com.berrontech.erp.web.user.security.UserToken;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

/**
 * Create By Levent8421
 * Create Time: 2021/3/9 13:29
 * Class Name: ApiMarketOrderController
 * Author: Levent8421
 * Description:
 * 市场订单相关数据访问控制器
 *
 * @author Levent8421
 */
@RestController
@RequestMapping("/api/token/market-order")
public class ApiMarketOrderController extends AbstractApiController {
    private final MarketOrderService marketOrderService;
    private final TokenDataHolder tokenDataHolder;

    public ApiMarketOrderController(MarketOrderService marketOrderService, TokenDataHolder tokenDataHolder) {
        this.marketOrderService = marketOrderService;
        this.tokenDataHolder = tokenDataHolder;
    }

    /**
     * 分页查询数据
     *
     * @param param 分页参数(default 1 page 20 rows)
     * @return GR
     */
    @GetMapping("/")
    public GeneralResult<PageInfo<MarketOrder>> list(PaginationParam param) {
        final PageInfo<MarketOrder> orderPageInfo = marketOrderService.listWithAll(param.getPage(), param.getRows());
        return GeneralResult.ok(orderPageInfo);
    }

    /**
     * 创建市场订单
     *
     * @param param 参数
     * @return GR
     */
    @PutMapping("/")
    public GeneralResult<MarketOrder> create(@RequestBody MarketOrder param) {
        final MarketOrder order = new MarketOrder();
        checkCreateParam(param, order);
        final Integer uid = UserToken.obtainUserIdFromHolder(tokenDataHolder);
        order.setCreatorId(uid);
        order.setState(OrderState.CREATED.code);
        final MarketOrder createRes = marketOrderService.create(order);
        return GeneralResult.ok(createRes);
    }

    private void checkCreateParam(MarketOrder param, MarketOrder order) {
        ParamChecker.notNull(param, BadRequestException.class, "no params!");
        ParamChecker.notNull(param.getExceedDate(), BadRequestException.class, "exceedDate is required!");
        order.setExceedDate(param.getExceedDate());
        order.setCustomerName(param.getCustomerName());
        order.setDeliveryAddress(param.getDeliveryAddress());
        order.setRemark(param.getRemark());
    }

    /**
     * Find order by id
     *
     * @param id id
     * @return GR
     */
    @GetMapping("/{id}")
    public GeneralResult<MarketOrder> findById(@PathVariable("id") Integer id) {
        final MarketOrder order = marketOrderService.requireWithAll(id);
        return GeneralResult.ok(order);
    }
}
