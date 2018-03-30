package sblogin.controllermg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sblogin.model.Protocol;
import sblogin.servicemg.DataTableService;

/**
 * @author cyb
 * @date: 2018/3/30 11:10
 * Description:
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    DataTableService dataTableService;

    @GetMapping("/list")
    public Protocol list() {
        return new Protocol<List>(0, "", dataTableService.list());
    }

}
