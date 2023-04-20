package Web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidGenderConstraint implements ConstraintValidator<ValidGender, String> {

    @Override
    public boolean isValid(String Gender, ConstraintValidatorContext context) {
        String a = "male";
        String b = "female";
        if (Gender.equals(a) || Gender.equals(b)) {
            return true;
        }
        return false;
    }
}
