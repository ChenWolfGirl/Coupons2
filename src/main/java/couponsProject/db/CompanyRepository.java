package couponsProject.db;


import couponsProject.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByEmailAndPassword(String email, String password);
    int findIdByEmailAndPassword(String email, String password);


}
