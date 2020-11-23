package fr.ensiie.Hotelfiltering.repository;

import fr.ensiie.Hotelfiltering.entity.Hotel;
import fr.ensiie.Hotelfiltering.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {
    User getUserById(int id);

    @Query("select u from User u where u.firstname =:User_Name and u.password = :User_Password")
    User findByUserNAmeAndPassword(@Param("User_Name") String username, @Param("User_Password")String password);

}
