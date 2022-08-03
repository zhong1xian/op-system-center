package com.only4play.system.infrastructure.security.authentication.admin.password;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class AdminUserPasswordLoginFilter extends AbstractAuthenticationProcessingFilter {

  protected AdminUserPasswordLoginFilter(String defaultFilterProcessesUrl,
      AuthenticationManager authenticationManager) {
    super(defaultFilterProcessesUrl, authenticationManager);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
    return null;
  }
}
