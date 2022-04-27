package com.example.CrudApplication.repository;

import com.example.CrudApplication.model.Login;
import com.example.CrudApplication.model.loginDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<Login,Integer> {
    Login findByUsernameAndPassword(String username, String password);
   Optional<Login> findById(Integer id);


   @Modifying(clearAutomatically = true)
   @Query("update loginDetails l set l.isLogin =:isLogin where l.username =:username")



   // @Modifying
  //  @Query("update loginDetails  l set l.isLogin = 'isLogin' where l.username=:username ")
    void updateLogindetail(@Param("username") String username,@Param("isLogin") boolean isLogin);


    Optional<loginDetails> findById(String username);
}
