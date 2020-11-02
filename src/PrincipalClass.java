import javax.security.auth.Subject;
import java.io.Serializable;
import java.security.Principal;

public class PrincipalClass implements Principal, Serializable {
    private static final Long serialVersionUID = 1L;
    private String username = null;

    public PrincipalClass(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
       // System.out.println("Calling getName...");
        return username;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

//    @Override
//    public boolean equals(Object obj) {
//        boolean flag=false;
//        if(obj instanceof Principal)
//            flag=username.equals(((Principal)obj).getName());
//        return flag;
//    }
}
