package couponsProject.services;

import couponsProject.beans.Category;
import couponsProject.beans.Coupon;
import couponsProject.beans.Customer;
import couponsProject.db.CompanyRepository;
import couponsProject.db.CouponRepository;
import couponsProject.db.CustomerRepository;
import couponsProject.exceptions.DoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService extends ClientService {



        private int id;

    public CustomerService(CustomerRepository customerRepository, CouponRepository couponRepository, CompanyRepository companyRepository) {
        super(customerRepository, couponRepository, companyRepository);
    }


    @Override
    public int login(String email, String password) {
        if(customerRepository.existsByEmailAndPassword(email, password))
            return customerRepository.findIdByEmailAndPassword(email,password).getId();
        return -1;
    }


    public void purchaseCoupon(Coupon coupon){
        couponRepository.addCouponIntoCouponsVsCustomers(coupon.getId(), id);
    }

    public List<Coupon> getCustomerCoupons() throws DoesNotExistException {
        Customer c=customerRepository.findById(id).orElseThrow(()->new DoesNotExistException("couldn't find customer"));
        return c.getCoupons();
    }

    public List<Coupon> getCustomerCoupons(Category category){
        return couponRepository.findCouponsByCategory(category);
    }

    public List<Coupon> getCustomerCoupons(double maxPrice){
        return couponRepository.findCouponsByPriceLessThan(maxPrice);
    }

    public Customer getCustomerDetails() throws DoesNotExistException {
        return customerRepository.findById(id).orElseThrow(()->new DoesNotExistException("couldn't find customer"));
    }

}
