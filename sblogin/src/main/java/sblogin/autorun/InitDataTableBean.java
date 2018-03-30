package sblogin.autorun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import sblogin.servicemg.DataTableService;

/**
 * @author cyb
 * @date: 2018/3/30 13:39
 * Description:
 */

@Configuration
public class InitDataTableBean {

    @Bean
    public DataTableService initTableDataTableServiceBean() {
        DataTableService dataTableService = new DataTableService();
        return dataTableService;
    }
}
