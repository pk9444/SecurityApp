import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;


public class Runner {
    public static void main(String[] args) {
        //System.out.println("Calling Main...");
        System.setProperty("java.security.auth.login.config","jaas.config");
        LoginContext loginContext = null;
        AuthorizedActions authorizedAction = new AuthorizedActions();
        int attempt = 0 ;
        while(true){
            for(attempt=0;attempt<3;attempt++){

                try {
                    loginContext = new LoginContext("JAASCall",new CallbackHandlerClass());

                    loginContext.login();
                    //authorizedAction.doAction(loginContext);
                    boolean flag=true;
                    while(flag) flag=authorizedAction.doAction(loginContext);
                } catch (LoginException e) { //| IOException e
                    e.printStackTrace();
                }

            }
            if(attempt==3){
                System.out.println("Allowed attempts over. Restart the app...");
                 System.exit(-1);
            }
        }
    }
}
