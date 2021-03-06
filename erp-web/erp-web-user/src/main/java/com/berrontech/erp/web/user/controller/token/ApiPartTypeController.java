package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.PartType;
import com.berrontech.erp.modal.service.general.PartTypeService;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/12 0:25
 * Class Name: ApiPartTypeController
 * Author: Levent8421
 * Description:
 * API 库存分类相关数据访问控制器
 *
 * @author Levent8421
 */
@RestController
@RequestMapping("/api/token/part-type")
public class ApiPartTypeController extends AbstractController {
    private final PartTypeService partTypeService;

    public ApiPartTypeController(PartTypeService partTypeService) {
        this.partTypeService = partTypeService;
    }

    /**
     * 获取全部分类
     *
     * @return GR
     */
    @GetMapping("/")
    public GeneralResult<List<PartType>> all() {
        val all = partTypeService.all();
        return GeneralResult.ok(all);
    }
}
