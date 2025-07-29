    package com.paymentchain.api.config;

    import com.paymentchain.api.common.ErrorResponse;
    import com.paymentchain.consumer.exception.ExternalServiceException;
    import com.paymentchain.exception.TechnicalException;
    import com.paymentchain.jpa.exception.DatabaseAccessException;
    import com.paymentchain.model.exception.BusinessException;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(BusinessException.class)
        public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("BUSINESS_ERROR", ex.getMessage()));
        }

        @ExceptionHandler(TechnicalException.class)
        public ResponseEntity<ErrorResponse> handleTechnicalException(TechnicalException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("TECHNICAL_ERROR", ex.getMessage()));
        }

        @ExceptionHandler(ExternalServiceException.class)
        public ResponseEntity<ErrorResponse> handleExternalServiceException(ExternalServiceException ex) {
            ErrorResponse error = new ErrorResponse("EXTERNAL_SERVICE_ERROR", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
        }

        @ExceptionHandler(DatabaseAccessException.class)
        public ResponseEntity<ErrorResponse> handleDatabaseException(DatabaseAccessException ex) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(new ErrorResponse("DATABASE_ERROR", ex.getMessage()));
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleUnexpectedException(Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("UNEXPECTED_ERROR", ex.toString()));
        }

    }
