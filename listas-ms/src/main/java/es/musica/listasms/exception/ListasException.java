package es.musica.listasms.exception;


public class ListasException extends RuntimeException  {
    
    private static final long serialVersionUID = 1L;
    
    public ListasException(String error) {
        super(error);
    }
    
    public ListasException(String code, String error) {
        super(code + ": " + error);
    }
}
