import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Map;

public class LoginModuleClass implements LoginModule {

    private Subject subject = null;
    private CallbackHandler callbackHandler = null;
    private PrincipalClass principal = null;

    private static final String[][] group3 = {{"tyson","pass@12"},{"max","pass@34"},{"ray","pass@56"},{"kai","pass@78"}};

    protected static String role;
    protected static String[] roles = {"dragon","tortoise","tiger","phoenix"};

    protected static void setRole(String temp){
        role=temp;
    }
    protected  static String getRole(){
        return role;
    }
    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> map, Map<String, ?> map1) {
        this.subject=subject;
        this.callbackHandler=callbackHandler;
        System.out.println("Initializing JAAS...");
    }


    @Override
    public boolean login() throws LoginException {
        //System.out.println("Calling login...");
        boolean flag = false;
       Callback[] callbacks = new Callback[2]; //stored all the active callbacks - logged in actions in an array
       //size = 2 to store the authentication credentials - login and password
        callbacks[0] = new NameCallback("Username:");
        callbacks[1] = new PasswordCallback("Password:",false);

        try {
            callbackHandler.handle(callbacks);
            String username = ((NameCallback)callbacks[0]).getName();
            String password = new String(((PasswordCallback)callbacks[1]).getPassword());

            int count = 0;

            while(count<group3.length){
                if(group3[count][0].equals(username) && group3[count][1].equals(password)) {
                    principal = new PrincipalClass(username);
                    System.out.println("Authentication Granted...");
                    flag = true;
                    //break;
                }
                count++;
            }
            //count++;
            if(!flag){
                System.err.println("Authentication Denied ...");
            } //throw new LoginException("Authentication Denied ..");
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }
        return flag;
    }

/**
 * Invoke commit() whenever authenctication succeeds
 * */
    @Override
    public boolean commit() throws LoginException {
       // System.out.println("Calling commit...");
        if(subject !=null && !subject.getPrincipals().contains(principal)) {
            subject.getPrincipals().add(principal);
            return true;
        }
        return false;
    }

    @Override
    public boolean abort() throws LoginException {
        //System.out.println("Calling abort...");
        if(subject !=null && principal!=null && subject.getPrincipals().contains(principal)){
            subject.getPrincipals().remove(principal);
        }
        subject=null;
        principal=null;
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        //System.out.println("Calling logout...");
        subject.getPrincipals().remove(principal);
        subject = null;
        return true;
    }

    protected static void assignRoles(String str){
        switch (str) {
            case "tyson":
                setRole(roles[0]);
                break;
            case "max":
                setRole(roles[1]);
                break;
            case "ray":
                setRole(roles[2]);
                break;
            case "kai":
                setRole(roles[3]);
                break;
        }
    }
}
