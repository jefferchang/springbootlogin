package sblogin.controllermg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import sblogin.model.Protocol;

/**
 * @author cyb
 * @date: 2018/3/30 11:06
 * Description:
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler
    public Protocol error(Exception e) {
        logger.error(e.getMessage(), e);
        Protocol result = new Protocol(-1, "", null);
        result.setMsg(e.getMessage());
        return result;
    }
}
