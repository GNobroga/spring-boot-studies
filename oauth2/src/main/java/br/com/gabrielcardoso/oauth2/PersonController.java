package br.com.gabrielcardoso.oauth2;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PersonController {
    
    @GetMapping("/public")
    public String routePublic() {
        return "email: %s";
    }

    @GetMapping("/private")
    public String routePrivate(@AuthenticationPrincipal OidcUser user, @AuthenticationPrincipal Jwt jwt) {
        System.out.println(jwt != null);
        return "dsdsd";
    }

}
