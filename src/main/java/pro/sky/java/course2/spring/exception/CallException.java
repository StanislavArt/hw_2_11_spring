package pro.sky.java.course2.spring.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CallException {

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleException(ProductNotFoundException e) {
        String result = e.getMessage() + "<br><br>Содержимое ResponseStatus: " + e.getClass().getAnnotation(ResponseStatus.class).value();
        return result;
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public String handleException(ProductAlreadyExistsException e) {
        String result = e.getMessage() + "<br><br>Содержимое ResponseStatus: " + e.getClass().getAnnotation(ResponseStatus.class).value();
        return result;
    }

    @ExceptionHandler(NumberFormatException.class)
    public String handleException(NumberFormatException e) {
        return e.getMessage();
    }

}
