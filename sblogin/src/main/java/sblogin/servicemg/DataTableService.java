package sblogin.servicemg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import sblogin.mapper.UserInfoMapper;

/**
 * @author cyb
 * @date: 2018/3/30 13:46
 * Description:
 */

public class DataTableService {

    @Autowired
    UserInfoMapper userMapper;

    public List<String> list() {
        return userMapper.list();
    }


}
