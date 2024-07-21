import java.util.regex.Pattern;

public class SecurityUtils {

    private static final Pattern PATTERN = Pattern.compile("[A-Z0-9_]");
    private static final String PATTERN2 = "hvbftsjvlysbxcnvkbjfm,1234567890_";
    public static void check(String login, String password, String confirmPassword) throws WrongLoginException {
        if (login.length() > 20 && PATTERN.matcher(login).matches()) {
            throw new WrongLoginException("Неправильный логин!");
        }
        if (password.length() > 20 || !password.equals(confirmPassword) || checkPassword2(password)) {
            throw new WrongPasswordException("Неправильный пароль!");
        }
    }
    private boolean checkPassword(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (!PATTERN2.contains(String.valueOf(password.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkPassword2(String password) {
        for (int i = 0; i < password.length(); i++) {
            var c = Character.toLowerCase(password.charAt(i));
            if ((c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '_') {
                return false;
            }
        }
        return true;
    }
}


