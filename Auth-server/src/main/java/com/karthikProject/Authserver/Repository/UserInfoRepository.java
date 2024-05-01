package com.karthikProject.Authserver.Repository;

import com.karthikProject.Authserver.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    Optional<UserInfo> findByName(String username);
    List<UserInfo> findAllByName(String username);
}
