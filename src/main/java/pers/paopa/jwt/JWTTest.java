package pers.paopa.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTTest {
    public static void main(String[] args) {

        String token = Jwts.builder()
                .setSubject("robot_access_tokend")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, "ROBOT_SECRET".getBytes())
                .compact();
        System.out.println(token);

        String xxx = Jwts.parser()
                .setSigningKey("ROBOT_SECRET".getBytes())
                .parseClaimsJws(token)
                .getBody().getSubject();
        System.out.println(xxx);



    }


}
