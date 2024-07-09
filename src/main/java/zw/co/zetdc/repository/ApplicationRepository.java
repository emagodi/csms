package zw.co.zetdc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zw.co.zetdc.entities.Application;
import zw.co.zetdc.enums.District;
import zw.co.zetdc.enums.Region;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByDistrict(District district);
//    List<Application> findByEmail(String email);

    List<Application> findByRegion(Region region);

    public List<Application> getApplicationByCreatedBy(String createdby);


}
