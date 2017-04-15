package com.mumat.configuration;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.mumat.utils.Constant;

public class MYSuccessHandler implements AuthenticationSuccessHandler {
 
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override 
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String pageName = request.getParameter("pageName");
		String searchKeyWord = request.getParameter("searchKeyWord");
		/*Set some session variables*/
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
        session.setAttribute("uname", authUser.getUsername());  
        session.setAttribute("authorities", authentication.getAuthorities()); 
        /*Set target URL to redirect*/
		String targetUrl = determineTargetUrl(authentication, pageName, searchKeyWord ); 
        redirectStrategy.sendRedirect(request, response, targetUrl);
	}
 
	protected String determineTargetUrl(Authentication authentication, String pageName, String searchKeyWord){
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        
        System.out.println("authorities >>>>> "+authorities);
        if (authorities.contains(Constant.ROLE_ADMIN)) {
        	return "/admin/home";
        } else if (authorities.contains(Constant.ROLE_CANDIDATE)) {
        	if (pageName != null) {
        		return "/candidate/search?thisProduct="+searchKeyWord;
        	} else {
        		return "/candidate/home";
        	}
        } else {
            throw new IllegalStateException();
        }
    }
 
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
 
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
}