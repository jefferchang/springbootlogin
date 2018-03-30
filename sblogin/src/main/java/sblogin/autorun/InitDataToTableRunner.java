package sblogin.autorun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sblogin.servicemg.DataTableService;

/**
 * @author cyb
 * @date: 2018/3/30 14:13
 * Description:
 */

@Component
@Order(1)
public class InitDataToTableRunner implements CommandLineRunner {
    @Autowired
    DataTableService dataTableService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("commandLineRunner is start!");
    }
}
