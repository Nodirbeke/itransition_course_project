package itransition.intern.itransitioncollection.configuration;

import itransition.intern.itransitioncollection.entity.authUser.UserDetails;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class SecurityAuditorAware implements AuditorAware<Long> {

    @Override
    @NonNull
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication) ||
                !authentication.isAuthenticated())
            return Optional.empty();
        UserDetails userDetails = (UserDetails) authentication;
        return Optional.of(userDetails.getId());
    }

}