import javax.security.auth.callback.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CallbackHandlerClass implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        System.out.println("Calling Handle...");

        NameCallback nameCallback = (NameCallback) callbacks[0];
        System.out.println(nameCallback.getPrompt());
        nameCallback.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());

        PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];
        System.out.println(passwordCallback.getPrompt());
        passwordCallback.setPassword(new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray());
    }
}
