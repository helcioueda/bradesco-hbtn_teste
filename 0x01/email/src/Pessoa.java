public class Pessoa {

    public static boolean emailValid(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        boolean hasAtSymbol = email.contains("@");
        boolean isUnder50Chars = email.length() <= 50;

        return hasAtSymbol && isUnder50Chars;
    }
}