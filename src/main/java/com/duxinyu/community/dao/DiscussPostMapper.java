package com.duxinyu.community.dao;

import com.duxinyu.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//数据库中的每张表对应一个Mapper
@Repository
public interface DiscussPostMapper {

    //开发个人主页时用到 offset:每一页起始的行号， limit:每页显示的数据
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名(@Param).
    int selectDiscussPostRows(@Param("userId") int userId);
}
