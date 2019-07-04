package com.shaunk.utils;

import com.google.common.collect.Maps;
import com.shaunk.core.vo.UserInfo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Project shaun
 * @Package com.shaun.utils
 * @Name JwtUtil
 * @Version 1.0
 * @Data: 2019/4/28
 * @Author: shaunk
 * @Description: Jwt 工具类
 */
public class JwtUtil {

    /**
     * 秘钥
     */
    public static final String SECRET = "xiaodaxiansheng";

    /**
     * 头部标识
     */
    public static final String HEADER_AUTH = "Authorization";

    /**
     * 签发有效期 默认7天
     */
    public static final long exp = 1000 * 60 * 60 * 24 * 7;


    /**
     *  生成token
     * @param user
     * @return
     */
    public static String generateToken(UserInfo user){

        HashMap<String, Object> claims = Maps.newHashMap();
        claims.put("userId", user.getId());
        //生成签发人
        String subject = user.getUsername();

        String jwt = Jwts.builder()
                // 私有声明
                .setClaims(claims)
                // 主题
                .setSubject(subject)
                // 唯一标识
                .setId(UUID.randomUUID().toString())
                // 签发时间
                .setIssuedAt(new Date())
                // 算法
                .signWith(SignatureAlgorithm.HS256, SECRET)
                // 有效期 7天
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .compact();
        return jwt;

    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static String validateToken(String token) {
        Map<String,Object> body = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token)
                .getBody();
        String userId =  String.valueOf(body.get("userId"));
        return userId;
    }

    public static void main(String[] args) {

    }

}
