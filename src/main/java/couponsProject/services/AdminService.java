package couponsProject.services;

import couponsProject.beans.Company;
import couponsProject.beans.Customer;
import couponsProject.db.CompanyRepository;
import couponsProject.db.CouponRepository;
import couponsProject.db.CustomerRepository;
import couponsProject.exceptions.DoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService extends ClientService {


    public AdminService(CustomerRepository customerRepository, CouponRepository couponRepository, CompanyRepository companyRepository) {
        super(customerRepository, couponRepository, companyRepository);
    }

    @Override
    public int login(String email, String password) {
        if (email.equals("admin@admin.com") && (password.equals("admin")))
            return 1;
        return -1;
    }

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public Company updateCompany(Company company) throws DoesNotExistException {
        if(!companyRepository.existsById(company.getId()))
            throw new DoesNotExistException("cannot update, company doesn't exist");
        return companyRepository.save(company);
    }

    public void deleteCompany(int id){
        couponRepository.deleteById(id);
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    public Company getOneCompany(int id) throws DoesNotExistException {
        return companyRepository.findById(id).orElseThrow(()->new DoesNotExistException("cannot find company"));
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) throws DoesNotExistException {
        if(!customerRepository.existsById(customer.getId()))
            throw new DoesNotExistException("customer doesn't exist");
        return customerRepository.save(customer);
    }

    public void deleteCustomer(int id){
        customerRepository.deleteById(id);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer getOneCustomer(int id) throws DoesNotExistException {
        return customerRepository.findById(id).orElseThrow(()->new DoesNotExistException("cannot find customer"));
    }

}
