package couponsProject.services;

import couponsProject.db.CompanyRepository;
import couponsProject.db.CouponRepository;
import couponsProject.db.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    protected CustomerRepository customerRepository;
    protected CouponRepository couponRepository;
    protected CompanyRepository companyRepository;


    public ClientService(CustomerRepository customerRepository, CouponRepository couponRepository, CompanyRepository companyRepository) {
        this.customerRepository = customerRepository;
        this.couponRepository = couponRepository;
        this.companyRepository = companyRepository;
    }

    public abstract int login(String email, String password);

}
