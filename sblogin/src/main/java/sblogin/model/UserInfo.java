package sblogin.model;

/**
 * @author cyb
 * @date: 2018/3/30 14:37
 * Description:
 */
public class UserInfo {
    private Long id;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserInfo(String userName) {
        this.userName = userName;
    }
}
