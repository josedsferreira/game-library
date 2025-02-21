package dev.jf.game_library.models;

import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "platform")
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "platform_id")
    private Integer platformId;

    @Column(name="platform_name", nullable = false)
    private String platformName;

    @Column(name="platform_abreviation", length = 10)
    private String platformAbreviation;

    @ManyToOne
    @JoinColumn(name="manufacturer", referencedColumnName="company_id", nullable = true)
    @OnDelete(action=OnDeleteAction.SET_NULL)
    private Company manufacturer;

    @Column(name="product_family")
    private String productFamily;

    @Column(name="platform_release_date_NA")
    private LocalDate platformReleaseDateNA;

    @Column(name="platform_release_date_JP")
    private LocalDate platformReleaseDateJP;

    @Column(name="platform_release_date_EU")
    private LocalDate platformReleaseDateEu;

    @Column(name = "generation")
    private Integer generation;

    @OneToMany(mappedBy="platform")
    Set<GamePlatforms> games;

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformAbreviation() {
        return platformAbreviation;
    }

    public void setPlatformAbreviation(String platformAbreviation) {
        this.platformAbreviation = platformAbreviation;
    }

    public Company getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Company manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProductFamily() {
        return productFamily;
    }

    public void setProductFamily(String productFamily) {
        this.productFamily = productFamily;
    }

    public LocalDate getPlatformReleaseDateNA() {
        return platformReleaseDateNA;
    }

    public void setPlatformReleaseDateNA(LocalDate platformReleaseDateNA) {
        this.platformReleaseDateNA = platformReleaseDateNA;
    }

    public LocalDate getPlatformReleaseDateJP() {
        return platformReleaseDateJP;
    }

    public void setPlatformReleaseDateJP(LocalDate platformReleaseDateJP) {
        this.platformReleaseDateJP = platformReleaseDateJP;
    }

    public LocalDate getPlatformReleaseDateEu() {
        return platformReleaseDateEu;
    }

    public void setPlatformReleaseDateEu(LocalDate platformReleaseDateEu) {
        this.platformReleaseDateEu = platformReleaseDateEu;
    }

    public Integer getGeneration() {
        return generation;
    }

    public void setGeneration(Integer generation) {
        this.generation = generation;
    }

    public Set<GamePlatforms> getGames() {
        return games;
    }

    public void setGames(Set<GamePlatforms> games) {
        this.games = games;
    }
    
}
