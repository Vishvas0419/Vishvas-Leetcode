class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;

        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specialChars = "!@#$%^&*()-+";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            // Check for adjacent duplicates
            if (i > 0 && ch == password.charAt(i - 1)) {
                return false;
            }

            if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.indexOf(ch) != -1) hasSpecial = true;
        }

        return hasLower && hasUpper && hasDigit && hasSpecial;
    }
}
