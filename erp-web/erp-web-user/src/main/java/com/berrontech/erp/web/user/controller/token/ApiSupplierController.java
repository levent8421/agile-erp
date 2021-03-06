package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.Supplier;
import com.berrontech.erp.modal.service.general.SupplierService;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/14 17:00
 * Class Name: ApiSupplierController
 * Author: Levent8421
 * Description:
 * 供应商相关API数据访问控制器
 *
 * @author Levent8421
 */
@RestController
@RequestMapping("/api/token/supplier")
public class ApiSupplierController extends AbstractController {
    private final SupplierService supplierService;

    public ApiSupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * 获取所有供应商
     *
     * @return GR
     */
    @GetMapping("/")
    public GeneralResult<List<Supplier>> all() {
        val all = supplierService.all();
        return GeneralResult.ok(all);
    }
}
