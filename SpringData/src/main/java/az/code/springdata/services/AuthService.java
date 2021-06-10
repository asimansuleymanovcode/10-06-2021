package az.code.springdata.services;


import az.code.springdata.models.Role;
import az.code.springdata.models.MyUser;
import az.code.springdata.repositories.UserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AuthService implements UserDetailsService {
    UserRepo repo;

    public AuthService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser = repo.findUserByUsername(username);
        List<GrantedAuthority> springRoles = prepareRoles(myUser.getRoles());
        return new User(myUser.getUsername(), myUser.getPassword(), springRoles);
    }

    private List<GrantedAuthority> prepareRoles(Set<Role> roleSet) {
        List<GrantedAuthority> myRoles = new ArrayList<>();
        roleSet.forEach(role -> myRoles.add(new SimpleGrantedAuthority(role.getRoleName())));
        return myRoles;
    }
}
