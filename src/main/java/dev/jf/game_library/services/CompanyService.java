package dev.jf.game_library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.jf.game_library.models.Company;
import dev.jf.game_library.repositories.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Optional<Company> getCompanyById(Integer id) {
        return repository.findById(id);
    }

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public Company saveCompany(Company company) {
        return repository.save(company);
    }

    public List<Company> getAllCompaniesByOrigin(String origin){
        return repository.findByCountryOrigin(origin);
    }

    public List<Company> getAllCompaniesByType(String type){
        return repository.findByCompanyType(type);
    }

}
