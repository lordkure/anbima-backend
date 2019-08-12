package br.com.clebersantos.anbima.exception;

import org.springframework.web.client.RestClientException;

/**
 * Create by Cleber Santos on 08/08/2019
 */
public class SelicException extends RestClientException {
    public SelicException(String msg) {
        super(msg);
    }

    public SelicException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
