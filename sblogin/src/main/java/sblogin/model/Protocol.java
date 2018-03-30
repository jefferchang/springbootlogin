package sblogin.model;

/**
 * @author cyb
 * @date: 2018/3/30 11:08
 * Description:
 */
public class Protocol<T> {
    private int status;
    private String msg;
    private T result;

    public Protocol(int status, String msg, T result) {
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
