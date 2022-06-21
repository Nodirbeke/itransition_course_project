package itransition.intern.itransitioncollection.entity.authUser;

import itransition.intern.itransitioncollection.enums.AuthRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private Long id;
    private String password;
    private String username;
    private boolean blocked;
    private Set<GrantedAuthority> role;

    public UserDetails(AuthUser user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.blocked = user.getBlocked();
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
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return !this.blocked;
    }
}
