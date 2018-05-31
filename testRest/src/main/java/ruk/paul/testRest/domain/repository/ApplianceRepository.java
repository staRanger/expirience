package ruk.paul.testRest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ruk.paul.testRest.domain.model.Appliance;

/**
 * Created by paul on 30.05.18.
 */
public interface ApplianceRepository extends JpaRepository<Appliance, Integer> {

    @Query("SELECT apl FROM Appliance apl WHERE apl.id = :id")
    Appliance find(@Param("id")Integer id);
}
