package org.sofka.demo.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintViolationException;

@Component
class GlobalExceptionHandler implements  ErrorWebExceptionHandler  {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        ServerHttpResponse httpResponse = exchange.getResponse();
        setResponseStatus(httpResponse, ex);
        return httpResponse.writeWith(Mono.fromSupplier(() -> {
            DataBufferFactory bufferFactory = httpResponse.bufferFactory();
            try {
                String errMsgToSend = (httpResponse.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) ? "" : setErrorMessage(ex);
                return bufferFactory.wrap(new ObjectMapper().writeValueAsBytes(errMsgToSend));
            } catch (JsonProcessingException e) {
                return bufferFactory.wrap(new byte[0]);
            }
        }));
    }

    private String setErrorMessage(Throwable ex){
        if (ex instanceof DuplicateKeyException){
            return "Can't create. It already exists";
        }else{
            return ex.getMessage();
        }
    }

    private void setResponseStatus(ServerHttpResponse httpResponse, Throwable ex) {
        //exceptions thrown by validator or in the use case
        if (ex instanceof IllegalArgumentException || ex instanceof DuplicateKeyException || ex instanceof ConstraintViolationException
        ) {
            httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        } else {
            httpResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}



