package com.example.starter.utils;

import java.time.Duration;
import java.util.Date;

import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

/**
 * jwt工具，宣告為final
 */
@Slf4j
public final class JwtUtil {
	
//	私鑰KEY
	private final static String SECRET_KEY = "YGXjm94eoTGJ";
	
//	過期時效，預設兩小時
	private final static Duration EXPIRATION = Duration.ofHours(2);
	
	/**
	 * 生成JWT
	 * 
	 * base64(Header) + base64(Payload) + base64(Signature)
	 * xxxxx.yyyyy.zzzzz
	 * 
	 * Header: Token的種類及產生簽章（Signature）要使用的雜湊演算法
	 * Payload: 帶有欲存放的資訊（例如用戶資訊）
	 * Signature: 編譯後的Header、Payload與密鑰透過雜湊演算法所產生
	 * 
	 * Payload 和 Header 被轉換成 Base64 編碼後，能夠被輕易的轉換回來
	 * 因此不應該把如用戶密碼等重要資料存取在 Payload 當中
	 * 
	 * @param userName 用戶名稱
	 * @return
	 */
	public static String generateJWT(String userName) {
		Date expiryDate = new Date(System.currentTimeMillis() + EXPIRATION.toMillis());
		
		return Jwts.builder()
				.setSubject(userName)
				.setIssuedAt(new Date())
				.setExpiration(expiryDate)
//				設定hash演算，且用私鑰生成簽章
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
				.compact();
	}
	
	/**
	 * 解析JWT
	 * @param token
	 * @return
	 */
	public static Claims parseJWT(String token) {
		if (StringUtils.hasText(token)) {
			log.warn("[+] [parseJWT] receive token empty，data: {} ", token);
			return null;
		}
		
//		包含簽發時間、過期時間、存放的數據等資料
		Claims claims = null;
		try {
			claims = Jwts.parser()
					.setSigningKey(SECRET_KEY)
					.parseClaimsJws(token)
					.getBody();
		} catch (Exception x) {
			log.error("[+] [parseJWT] parse token error: {} ", x);
		}
		
		return claims;
	}
	
	
	
}
