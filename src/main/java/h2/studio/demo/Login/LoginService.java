package h2.studio.demo.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) { this.loginRepository = loginRepository;}

    public Optional<Login> getUserName(String username){ return loginRepository.findBy }
}
