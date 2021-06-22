package br.com.zupacademy.william.casadocodigo.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

@JsonInclude(Include.NON_NULL)
public class ValidationErrorsOutput {

    private String error;
    private List<ErrorBody> fieldErrors;

    public ValidationErrorsOutput(List<ErrorBody> errors) {
        this.fieldErrors = errors;
    }

    public ValidationErrorsOutput(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public List<ErrorBody> getFieldErrors() {
        return fieldErrors;
    }

    static class ErrorBody {
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
}

//class ErrorBody {
//    private final String campo;
//    private final String mensagem;
//
//    public ErrorBody(String campo, String mensagem) {
//        this.campo = campo;
//        this.mensagem = mensagem;
//    }
//
//    public String getCampo() {
//        return campo;
//    }
//
//    public String getMensagem() {
//        return mensagem;
//    }
//}
