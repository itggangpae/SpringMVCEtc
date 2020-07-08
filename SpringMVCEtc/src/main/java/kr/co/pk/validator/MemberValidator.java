package kr.co.pk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.pk.domain.Member;

public class MemberValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*
		Member memberInfo = (Member) target;
		if (memberInfo.getEmail() == null || memberInfo.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		}
		if (memberInfo.getPw() == null || memberInfo.getPw().trim().isEmpty()) {
			errors.rejectValue("pw", "required");
		}
		*/
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pw", "required");

	}
}
