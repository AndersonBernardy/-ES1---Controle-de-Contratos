package pessoa;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.validaException;

public class Email implements Serializable {

	private static final long serialVersionUID = -1318478443831527898L;
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws validaException {
		if(isEmail(email)) {
		this.email = email;
		}else {
			throw new validaException("EMAIL INVALIDO");
		}
	}	

	@Override
	public String toString() {
		return email;
	}
	
	public static boolean isEmail(String email)
    {
		boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
