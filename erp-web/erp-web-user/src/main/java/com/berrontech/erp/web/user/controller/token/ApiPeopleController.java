package com.berrontech.erp.web.user.controller.token;

import com.berrontech.erp.commons.entity.People;
import com.berrontech.erp.modal.service.general.PeopleService;
import com.berrontech.erp.web.commons.controller.AbstractController;
import com.berrontech.erp.web.commons.vo.GeneralResult;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create By Levent8421
 * Create Time: 2020/2/14 18:27
 * Class Name: ApiPeopleController
 * Author: Levent8421
 * Description:
 * 联系人相关API数据访问控制器
 *
 * @author Levent8421
 */
@RestController
@RequestMapping("/api/token/people")
public class ApiPeopleController extends AbstractController {
    private final PeopleService peopleService;

    public ApiPeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    /**
     * 全部联系人
     *
     * @return GR
     */
    @GetMapping("/")
    public GeneralResult<List<People>> all() {
        val all = peopleService.all();
        return GeneralResult.ok(all);
    }
}
