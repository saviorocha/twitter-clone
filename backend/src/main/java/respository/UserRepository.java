package respository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Usuario;

public interface UserRepository extends JpaRepository<Usuario, Long>{

}
