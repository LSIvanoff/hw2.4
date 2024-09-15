import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        try {
            inputUserData("kikomoorra", "UtF8gEN", "UtF8gEN");
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void inputUserData(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String regexLogin = "^[a-z0-9_]{0,20}$";
        Pattern patternLogin = Pattern.compile(regexLogin);
        Matcher matcherLogin = patternLogin.matcher(login);

        String regexPassword = "^[a-z0-9_]{0,20}$";
        Pattern patternPassword = Pattern.compile(regexPassword);
        Matcher matcherPassword = patternPassword.matcher(password);

        if (!matcherLogin.matches()) {
            throw new WrongLoginException();
        }
        if (!matcherPassword.matches()) {
            throw new WrongPasswordException();
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}