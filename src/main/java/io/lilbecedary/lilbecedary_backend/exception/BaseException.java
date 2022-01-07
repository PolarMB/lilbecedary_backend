package io.lilbecedary.lilbecedary_backend.exception;

import java.util.Date;

public class BaseException {
    private Date timestamp;
    private String mensaje;

    public BaseException(Date timestamp, String mensaje, String detalles){
        this.timestamp = timestamp;
        this.mensaje = mensaje;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMensaje() {
        return mensaje;
    }

}
