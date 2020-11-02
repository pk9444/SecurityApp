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
    getRole,
    logout;
}
public class AuthorizedActions {
    private static String role;

    private static void assignRole(String temp){
        role=temp;
    }
    private static String getRole(){
        return role;
    }

    boolean doAction(LoginContext loginContext){
        boolean flag=true;
        System.out.println("Select Action ? : (dragoon, drasil, drigger, dranzer, getRole, logout, exit) ");

        String[] roles = {"dragon","tortoise","tiger","phoenix"};


        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String currentUser = loginContext.getSubject().getPrincipals().iterator().next().getName();

        try{
            switch(actions.valueOf(br1.readLine())){

                case dragoon:
                    assignRole(roles[0]);
                    if(currentUser.equals("tyson")){
                        //assignRole(roles[0]);
                      //  System.out.println("Role assigned: " + getRole());
                        PrivilegedAction<Object> p1 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p1);
                        System.out.println("Performed By: " + currentUser);
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case drasil:
                    assignRole(roles[1]);
                    if(currentUser.equals("max")){
                       // System.out.println("Role assigned: " + getRole());
                        PrivilegedAction<Object> p2 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p2);
                        System.out.println("Performed By: " + currentUser);
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case drigger:
                    assignRole(roles[2]);
                    if(currentUser.equals("ray")){
                       // System.out.println("Role assigned: " + getRole());
                        PrivilegedAction<Object> p3 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p3);
                        System.out.println("Performed By: " + currentUser);
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case dranzer:
                    assignRole(roles[3]);
                    if(currentUser.equals("kai")){
                       // System.out.println("Role assigned: " + getRole());
                        PrivilegedAction<Object> p4 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p4);
                        System.out.println(" Performed By: " + currentUser);
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

                case getRole:
                    System.out.println("Role Assigned: " + getRole());
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
