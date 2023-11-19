package devinhouse.tech.trackingemployee.repository;

import devinhouse.tech.trackingemployee.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
}
