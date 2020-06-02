package pers.paopa.map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Map;

public class ClaimTest {
    public static void main(String[] args) throws Exception {
        String emailToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYXZpZC53YW5nKzNAc2lzLmFpIiwiaW52aXRvciI6NSwiYWNjb3VudElkIjoxLCJtYWlsRGF0YSI6eyJtYWlsIjoiZGF2aWQud2FuZyszQHNpcy5haSIsImFjY291bnRSb2xlIjo0LCJncm91cElkIjoxfSwiaWF0IjoxNTkwNTQ2NDM2fQ.eGPQgeRwb5Hc3Ofh5vLj4RZm-ffJH2IUmh_eD0J9xLC-Gzl0Q-Xlg7c62DSiVqycG-nMH9NYZ_4xM6lhM9_Ndw";
        Claims parseToken = Jwts.parser()
                .setSigningKey("REGISTER_SECRET".getBytes())
                .parseClaimsJws(emailToken)
                .getBody();
        Map<String, Object> mailData = parseToken.get("mailData", Map.class);
        System.out.println(mailData.get("mail").toString());
    }
}
