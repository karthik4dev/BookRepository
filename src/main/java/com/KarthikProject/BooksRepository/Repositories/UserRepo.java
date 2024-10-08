package com.KarthikProject.BooksRepository.Repositories;

import com.KarthikProject.BooksRepository.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public  interface UserRepo extends JpaRepository<Users,Integer> {
   Optional<Users> findByuserName(String userName );

}
