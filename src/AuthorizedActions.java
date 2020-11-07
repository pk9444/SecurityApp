import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedAction;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
//    private static String role;
//    private static String[] roles = {"dragon","tortoise","tiger","phoenix"};
//
//    private static void setRole(String temp){
//        role=temp;
//    }
//    private static String getRole(){
//        return role;
//    }

//    private static void assignRoles(String str){
//        switch (str) {
//            case "tyson":
//                setRole(roles[0]);
//                break;
//            case "max":
//                setRole(roles[1]);
//                break;
//            case "ray":
//                setRole(roles[2]);
//                break;
//            case "kai":
//                setRole(roles[3]);
//                break;
//        }
//    }

    boolean doAction(LoginContext loginContext){
        boolean flag=true;
        System.out.println("Select Action ? : (dragoon, drasil, drigger, dranzer, getRole, logout, exit) ");


        Map<String,String> rMap = new TreeMap<>();

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        String currentUser = loginContext.getSubject().getPrincipals().iterator().next().getName();


//        switch (currentUser) {
//            case "tyson":
//                assignRole(roles[0]);
//                break;
//            case "max":
//                assignRole(roles[1]);
//                break;
//            case "ray":
//                assignRole(roles[2]);
//                break;
//            case "kai":
//                assignRole(roles[3]);
//                break;
//        }

        LoginModuleClass.assignRoles(currentUser); //assigning through function call

        try{
            switch(actions.valueOf(br1.readLine())){

                case dragoon:

                    rMap.put(currentUser,LoginModuleClass.getRole());
                    if(LoginModuleClass.getRole().equals(LoginModuleClass.roles[0])){

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

                    rMap.put(currentUser,LoginModuleClass.getRole());
                    if(LoginModuleClass.getRole().equals(LoginModuleClass.roles[1])){

                        PrivilegedAction<Object> p2 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p2);
                        System.out.println("Performed By: " + currentUser + " "+ rMap.get(currentUser));
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case drigger:

                    rMap.put(currentUser,LoginModuleClass.getRole());
                    if(LoginModuleClass.getRole().equals(LoginModuleClass.roles[2])){

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

                    rMap.put(currentUser,LoginModuleClass.getRole());
                    if(LoginModuleClass.getRole().equals(LoginModuleClass.roles[3])){

                        PrivilegedAction<Object> p4 = ()->{
                            System.out.println("Action Authorized!");
                            return null;
                        };
                        Subject.doAs(loginContext.getSubject(),p4);
                        System.out.println(" Performed By: " + currentUser );
                    }
                    else {
                        System.err.println("You are not authorized to perform this action. Try something else ...");
                    }

                    break;

                case logout:

                    loginContext.logout();
                    flag=false;
                    break;

                case getRole:
                    System.out.println("Role Assigned: " + LoginModuleClass.getRole());
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
