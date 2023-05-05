package kz.bitlab.springsecuritytesting.services;

import kz.bitlab.springsecuritytesting.entities.Permission;
import kz.bitlab.springsecuritytesting.entities.Users;
import kz.bitlab.springsecuritytesting.repositories.PermissionRepository;
import kz.bitlab.springsecuritytesting.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public String registerUser(String fullName, String email, String password, String rePassword){
        String flag = "user_exists";
        Users checkUser = usersRepository.findByEmail(email);
        if(checkUser == null){
            flag = "password_not_match";
            if(password.equals(rePassword)){
                List<Permission> permissionList = new ArrayList<>();
                Permission permission = permissionRepository.findByRole("ROLE_USER");
                permissionList.add(permission);
                Users user = Users.builder()
                        .fullName(fullName)
                        .email(email)
                        .password(passwordEncoder.encode(password))
                        .permissions(permissionList)
                        .build();
                if(usersRepository.save(user) != null){
                    flag = "user_register_success";
                }
            }
        }
        return flag;
    }

    public String changePassword(String email,String oldPassword,String newPassword,String rePassword){
        String flag = "user_not_found";
        Users checkUser = usersRepository.findByEmail(email);
        if(checkUser != null){
            flag = "incorrect_old_password";
            if(passwordEncoder.matches(oldPassword,checkUser.getPassword()) == true){
                flag = "new_password_not_match";
                if(newPassword.equals(rePassword)){
                    Users user = usersRepository.findByEmail(email);
                    user.setEmail(email);
                    user.setPassword(passwordEncoder.encode(newPassword));
                    if(usersRepository.save(user) != null){
                        flag = "change_password_success";
                    }
                }
            }
        }
        return flag;
    }
}
