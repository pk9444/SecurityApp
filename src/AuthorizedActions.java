import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedAction;

enum actions{
    dragoon,
    drasil,
    drigger,
    dranzer,
    exit,
    switchUser,
    logout;
}
public class AuthorizedActions {

    boolean doAction(LoginContext loginContext){
        boolean flag=true;
        System.out.println("Select Action ? : (dragoon, drasil, drigger, dranzer, logout, exit) ");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String currentUser = loginContext.getSubject().getPrincipals().iterator().next().getName();

        try{
            switch(actions.valueOf(br1.readLine())){

                case dragoon:
                    if(currentUser.equals("tyson")){
                        PrivilegedAction<Object> p1 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p1);
                        System.out.println("Performed By:"+currentUser);
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case drasil:
                    if(currentUser.equals("max")){
                        PrivilegedAction<Object> p2 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p2);
                        System.out.println("Performed By:"+currentUser);
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case drigger:
                    if(currentUser.equals("ray")){
                        PrivilegedAction<Object> p3 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p3);
                        System.out.println("Performed By:"+currentUser);
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case dranzer:
                    if(currentUser.equals("kai")){
                        PrivilegedAction<Object> p4 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p4);
                        System.out.println("By:"+currentUser);
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case logout:
//                    try {
//                        loginContext.logout();
//                        System.out.println(currentUser + " Logged out");
//                        flag=false;
//
//                        //System.exit(-2);
//
//                    } catch (LoginException e) {
//                        e.printStackTrace();
//                    }
                    loginContext.logout();
                    flag=false;
                    break;

                case exit:
                    System.out.println("Exiting Application ...");
                    System.exit(-2);

                default:
                    System.out.println("Enter a valid action...");
                    break;
            }
        }catch (IllegalArgumentException | IOException | LoginException e){
            System.err.println("Invalid Action! Enter a valid action: ");;
        }

        return flag;
    }

    //########################################################################################

}
