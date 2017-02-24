package com.wuhanhongdev.cas;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;

import javax.security.auth.login.FailedLoginException;
import java.security.GeneralSecurityException;

/**
 * Created with IntelliJ IDEA.
 * User: YM10154
 * Date: 17-2-24
 * Time: 下午5:55
 * To change this template use File | Settings | File Templates.
 */
public class UserAuthenticationHandler extends AbstractUsernamePasswordAuthenticationHandler {
    @Override
    protected HandlerResult authenticateUsernamePasswordInternal(UsernamePasswordCredential transformedCredential) throws GeneralSecurityException, PreventedException {
        String username = transformedCredential.getUsername();
        String password = transformedCredential.getPassword();
        if(username.equals(password)){
            return createHandlerResult(transformedCredential, this.principalFactory.createPrincipal(username), null);
        }
        throw new FailedLoginException();
    }
}
