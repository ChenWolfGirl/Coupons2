package couponsProject.loginManager;

import couponsProject.exceptions.LoginFailedException;
import couponsProject.services.AdminService;
import couponsProject.services.ClientService;
import couponsProject.services.CompanyService;
import couponsProject.services.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class LoginManager {

    private final ApplicationContext applicationContext;

    public LoginManager(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ClientService login(String email, String password, ClientType type) throws LoginFailedException {
        switch(type){
            case ADMIN:
                AdminService adminService = applicationContext.getBean(AdminService.class);
                if(adminService.login(email, password)==-1)
                    throw new LoginFailedException();
                return adminService;


            case COMPANY:
                CompanyService companyService= applicationContext.getBean(CompanyService.class);
                if(companyService.login(email, password)==-1)
                    throw new LoginFailedException();
                return companyService;


            case CUSTOMER:
                CustomerService customerService= applicationContext.getBean(CustomerService.class);
                if (customerService.login(email, password) == -1)
                    throw new LoginFailedException();
                return customerService;
        }
        return null;
    }
}


