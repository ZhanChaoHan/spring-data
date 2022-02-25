package com.jachs.springbootr2db.dao;

import com.jachs.springbootr2db.entity.User;
import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/***
 * 1.ReactiveCrudRepository, 用于您的通用 CRUD 存储库和<br>
 * 2.ReactiveSortingRepository 用于额外的排序功能。
 * @author zhanchaohan
 */
@Repository
public interface UserRepository extends ReactiveCrudRepository<User, String> {
    @Modifying
    @Query("insert into users (id,firstname,lastname) values (:userId,:firstName,:lastName)")
    Mono<Integer> addUser(String userId, String firstName, String lastName);
}
