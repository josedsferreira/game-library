package dev.jf.game_library.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jf.game_library.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{

    List<Company> findByCountryOrigin(String countryOrigin);
    List<Company> findByCompanyType(String companyType);
}
