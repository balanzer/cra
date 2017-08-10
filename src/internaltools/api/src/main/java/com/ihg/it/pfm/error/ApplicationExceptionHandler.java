package com.ihg.it.pfm.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author varathm
 *
 */
@ControllerAdvice
@RestController
public class ApplicationExceptionHandler {

    class Error {

        private String message;

        Error(String errMessage) {
            this.message = errMessage;
        }

        /**
         * @return the message
         */
        public String getMessage() {
            return this.message;
        }

        /**
         * @param message
         *            the message to set
         */
        public void setMessage(String message) {
            this.message = message;
        }
    }

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = BaseException.class)
    public String handleBaseException(BaseException e) {
        LOG.error("handleBaseException - message : {} ", e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Error> handleException(Exception e) {
        LOG.error("handleException - message : {} ", e.getMessage());
        return new ResponseEntity<>(new Error(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}