package zw.co.zetdc.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import zw.co.zetdc.entities.User;
import zw.co.zetdc.enums.Role;
import zw.co.zetdc.repository.UserRepository;
import zw.co.zetdc.service.impl.AuthenticationServiceImpl;
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationServiceImpl authenticationServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        // Create super admin user
        createSuperAdmin();

    }

    private void createSuperAdmin() {
        if (!userRepository.findByEmail("csmszetdc@zetdc.co.zw").isPresent()) {
            User superAdmin = new User();
            superAdmin.setFirstname("Csms");
            superAdmin.setLastname("Admin");
            superAdmin.setEmail("csmszetdc@zetdc.co.zw");
            superAdmin.setPassword(passwordEncoder.encode("Password@123"));
            superAdmin.setRole(Role.ADMIN);
            superAdmin.setTemporaryPassword(false);

            userRepository.save(superAdmin);
            System.out.println("Default ADMIN user created.");
        } else {
            System.out.println("ADMIN user already exists.");
        }
    }

}
