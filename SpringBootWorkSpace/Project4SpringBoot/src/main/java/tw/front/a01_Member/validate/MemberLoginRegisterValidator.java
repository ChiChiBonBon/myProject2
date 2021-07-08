package tw.front.a01_Member.validate;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import tw.front.a01_Member.model.MemberBean;

@Component
public class MemberLoginRegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return MemberBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		MemberBean bean = (MemberBean) target;
		ValidationUtils.rejectIfEmpty(errors, "account", "member.account.notempty", "請輸入帳號 default");
		ValidationUtils.rejectIfEmpty(errors, "password", "member.password.notempty", "請輸入密碼 default");
		ValidationUtils.rejectIfEmpty(errors, "name", "member.name.notempty", "請輸入姓名 default");
		ValidationUtils.rejectIfEmpty(errors, "gender", "member.gender.notempty", "請選擇性別 default");
		ValidationUtils.rejectIfEmpty(errors, "e_mail", "member.e_mail.notempty", "請輸入電子信箱 default");
	}

}
