public class Person {

    public boolean checkUser(String username) {
        return username.matches("^[a-zA-Z0-9]{8,}$");
    }

    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = !password.equals(password.toLowerCase());
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*");

        return hasUpperCase && hasNumber && hasSpecialChar;
    }
}