package com.mumat.service.Core;

import com.mumat.model.core.Email;

public interface MailService { 
	public boolean sendEmail(Email email);
}
