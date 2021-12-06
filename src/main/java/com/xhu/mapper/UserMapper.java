package com.xhu.mapper;

import com.xhu.enity.Accont;
import com.xhu.enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 通过uid查询用户信息
     *
     * @return 用户账户
     */
    Accont findByUid(@Param("uid") String uid);


    User findUserByUid(@Param("uid") String uid);
}
