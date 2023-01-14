package couponsProject.db;

import couponsProject.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmailAndPassword(String email, String password);
    Customer findIdByEmailAndPassword(String email, String password);

}
