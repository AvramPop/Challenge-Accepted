package com.paperpigeon.service;

import com.stormpath.sdk.account.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @since 1.0.RC5
 */
@Service
public class HelloService {
    @PreAuthorize("hasAuthority('https://api.stormpath.com/v1/groups/5f46JL3cvieUFlAgBhhjsy')")
    public String sayHello(Account account) {
        return "Hello, " + account.getGivenName() +
            ". You have the required permissions to access this restricted resource.";
    }
}
