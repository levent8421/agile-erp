package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.Part;
import com.berrontech.erp.commons.exception.BadRequestException;
import com.berrontech.erp.commons.exception.InternalServerErrorException;
import com.berrontech.erp.modal.service.general.PartQuantityService;
import com.berrontech.erp.modal.service.general.PartRelationService;
import com.berrontech.erp.modal.service.general.PartService;
import com.berrontech.erp.modal.service.task.OutboundTask;
import com.berrontech.erp.modal.service.task.PartOutboundException;
import com.berrontech.erp.modal.service.task.dto.PartOutboundRecord;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.util.ParamChecker;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import com.berrontech.erp.web.user.vo.PartOutboundParam;
import com.github.pagehelper.PageInfo;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/13 18:08
 * Class Name: ApiPartController
 * Author: Levent8421
 * Description:
 * Part API物料相关数据访问控制器
 *
 * @author Levent8421
 */
@RestController
@RequestMapping("/api/token/part")
public class ApiPartController extends AbstractController {
    private final PartService partService;
    private final PartQuantityService partQuantityService;
    private final PartRelationService partRelationService;

    public ApiPartController(PartService partService,
                             PartQuantityService partQuantityService,
                             PartRelationService partRelationService) {
        this.partService = partService;
        this.partQuantityService = partQuantityService;
        this.partRelationService = partRelationService;
    }

    /**
     * 全部物料
     *
     * @param page page
     * @param rows rows per page
     * @return GR
     */
    @GetMapping("/_pagination")
    public GeneralResult<PageInfo<Part>> all(Integer page, Integer rows) {
        page = defaultPage(page);
        rows = defaultRows(rows);
        val parts = partService.list(page, rows);
        return GeneralResult.ok(parts);
    }

    /**
     * 虚拟出库
     *
     * @param id    物料ID
     * @param param 参数
     * @return GR
     */
    @PostMapping("/{id}/_virtual-outbound")
    public GeneralResult<List<PartOutboundRecord>> virtualOutbound(@PathVariable("id") Integer id,
                                                                   @RequestBody PartOutboundParam param) {
        ParamChecker.notNull(param, BadRequestException.class, "No params");
        ParamChecker.notNull(param.getCount(), BadRequestException.class, "count is required!");
        ParamChecker.notNull(param.getStorageLocationId(), BadRequestException.class, "StorageLocationId is required!");
        final Part part = partService.require(id);
        final OutboundTask task = new OutboundTask(partQuantityService, partRelationService);
        try {
            task.init(part, param.getStorageLocationId(), param.getCount())
                    .virtualOutbound();
        } catch (PartOutboundException e) {
            throw new InternalServerErrorException("Outbound error:" + e.getMessage(), e);
        }
        final List<PartOutboundRecord> records = task.getRecords();
        return GeneralResult.ok(records);
    }
}
