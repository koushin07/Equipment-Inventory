package com.miko.eprris.domain.user;

import com.miko.eprris.domain.user.role.Role;
import com.miko.eprris.domain.user.role.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service @AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("no user"));

        //create a collection of SimpleGrantedAuthority
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        /* loop collection(authorities) and add/push roles(ROLE_STUDENT, ROLE_TEACHER and, etc.) inside the collection
         * because "User" from org.framework.userDetailsUser.User expect a collection
         */
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        /*Here is the code explain above the "User" expects 3 things,
        user->username, user->password and the collection of SimpleGrantedAuthority*/
        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    public AppUser saveUser(AppUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    public void addRoleToUser(String username, String roleName) {
        AppUser user = getUser(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
        userRepository.save(user);
    }

    public List<AppUser> getAllUser() {
        return userRepository.findAll();
    }

    public AppUser getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("no userasd"));

    }


}
