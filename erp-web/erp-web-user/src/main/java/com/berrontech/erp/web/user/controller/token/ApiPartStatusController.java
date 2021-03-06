package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.PartStatus;
import com.berrontech.erp.modal.service.general.PartStatusService;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/12 22:07
 * Class Name: ApiPartStatusController
 * Author: Levent8421
 * Description:
 * 物料状态相关API数据访问控制器
 *
 * @author Levent8421
 */
@RestController
@RequestMapping("/api/token/part-status")
public class ApiPartStatusController extends AbstractController {
    private final PartStatusService partStatusService;

    public ApiPartStatusController(PartStatusService partStatusService) {
        this.partStatusService = partStatusService;
    }

    /**
     * Find All Status
     *
     * @return GR
     */
    @GetMapping("/")
    public GeneralResult<List<PartStatus>> all() {
        val allStatus = partStatusService.all();
        return GeneralResult.ok(allStatus);
    }
}
