package alimentation.cashierApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;

public class CashierAppException extends RuntimeException {
    @NonNull
    private HttpStatus status;

    public CashierAppException(@NonNull HttpStatus status, @NonNull String message) {
        super(message);
        this.status = status;
    }

    @NonNull
    public HttpStatus getStatus() {
        return status;
    }
}