package zw.co.zetdc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.zetdc.entities.Application;
import zw.co.zetdc.enums.District;
import zw.co.zetdc.enums.Region;

import java.util.List;
import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByDistrict(String district);
//    List<Application> findByEmail(String email);

    Page<Application> findByDistrict(String district, Pageable page);

    List<Application> findByRegion(Region region);

    public List<Application> getApplicationByCreatedBy(String createdby);


    public boolean existsByReferenceNo(String refNo);

    Optional<Application> findByReferenceNo(String pjob);
}
