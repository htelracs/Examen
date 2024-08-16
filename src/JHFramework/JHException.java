package JHFramework;


public class JHException extends Exception {
    public JHException(Exception e, String clase, String metodo) {
        System.out.println("[ERROR APP --> LOG] " + clase +"."+ metodo +" : "+ e );
    }

    
    public String getMessage(){
        return "UPs..! existe un error..";
    }    
}

