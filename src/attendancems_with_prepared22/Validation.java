package attendancems_with_prepared22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Validation {
    public static String validateData(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }
    
    public static Icon validate(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return new ImageIcon(Validation.class.getResource("/attendancems_with_prepared22/Project_Images/validation-smiley.jpg"));
        } else {
            return new ImageIcon(Validation.class.getResource("/attendancems_with_prepared22/Project_Images/validation-sad.jpg"));
        }
    }
}
