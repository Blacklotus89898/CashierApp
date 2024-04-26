package alimentation.cashierApp.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import alimentation.cashierApp.dto.ErrorDto;


@ControllerAdvice
public class CahsierAppExceptionHandler {
    @ExceptionHandler(CashierAppException.class)
    public ResponseEntity<ErrorDto> handleEventRegistrationException(CashierAppException e) {
        return new ResponseEntity<ErrorDto>(new ErrorDto(e.getMessage()), e.getStatus());
    }
}