package itransition.intern.itransitioncollection.entity.authUser;

import itransition.intern.itransitioncollection.enums.AuthRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    @Getter
    private Long id;
    @Getter
    private String password;
    @Getter
    private String username;
    @Getter
    private String email;
    @Getter
    private boolean blocked;
    @Getter
    private Set<GrantedAuthority> role;

    public UserDetails(AuthUser user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.blocked = user.isBlocked();
        this.role = processAuthorities(user.getRole());
    }

    private Set<GrantedAuthority> processAuthorities(AuthRole role) {
        return new HashSet<>(Collections.singleton(new SimpleGrantedAuthority(role.getValue())));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.role;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
