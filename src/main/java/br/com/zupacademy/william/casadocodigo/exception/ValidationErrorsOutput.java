package br.com.zupacademy.william.casadocodigo.exception;

import java.util.List;

public class ValidationErrorsOutput {

    private final List<ErrorBody> fieldErrors;

    public ValidationErrorsOutput(List<ErrorBody> errors) {
        this.fieldErrors = errors;
    }

    public List<ErrorBody> getFieldErrors() {
        return fieldErrors;
    }
}

class ErrorBody {
    private final String campo;
    private final String mensagem;

    public ErrorBody(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
