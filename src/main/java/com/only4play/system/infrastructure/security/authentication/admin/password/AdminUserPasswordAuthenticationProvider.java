package com.only4play.system.infrastructure.security.authentication.admin.password;

import com.only4play.security.base.BaseAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class AdminUserPasswordAuthenticationProvider extends BaseAuthenticationProvider implements
    AuthenticationProvider {

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    return null;
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return false;
  }
}
