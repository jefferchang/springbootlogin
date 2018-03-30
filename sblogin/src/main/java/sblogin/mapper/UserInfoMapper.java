package sblogin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author cyb
 * @date: 2018/3/30 14:31
 * Description:
 */
@Mapper
public interface UserInfoMapper {
    List<String> list();
}
