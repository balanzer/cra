package com.ihg.it.pfm.services.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = LoggerFactory.getLogger(ServiceException.class);

    /**
     * @param message
     */
    public ServiceException(final String message) {
        super(message);
        LOG.error("Service Exception : {} ", message);
    }

    /**
     * @param message
     * @param cause
     */
    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
        LOG.error("Service Exception : {} cause {} ", message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public ServiceException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOG.error("Service Exception : {} cause {} ", message, cause);
    }

    /**
     * @param cause
     */
    public ServiceException(final Throwable cause) {
        super(cause);
        LOG.error("Service Exception : {} ", cause.getMessage());
    }

}