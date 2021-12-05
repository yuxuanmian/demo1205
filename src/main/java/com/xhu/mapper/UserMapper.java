package com.xhu.mapper;

import com.xhu.enity.Accont;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 通过uid查询用户信息
     * @return 用户信息
     */
     Accont findByUid(String uid);
}
