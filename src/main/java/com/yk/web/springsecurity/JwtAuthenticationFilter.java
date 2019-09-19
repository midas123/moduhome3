package com.yk.web.springsecurity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import ch.qos.logback.core.net.SyslogOutputStream;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {
	   @Autowired
	    private JwtTokenProvider tokenProvider;

	    @Autowired
	    private CustomUserDetailsService customUserDetailsService;

	    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	    @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
	        try {
	            String jwt = getJwtFromRequest(request);

	            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) { //토큰 유효성 검사
	                Long userId = tokenProvider.getUserIdFromJWT(jwt); //토큰에서 유저ID 추출
	                UserDetails userDetails = customUserDetailsService.loadUserById(userId); //사용자 정보로 UserDetails 객체 생성(
	                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); //요청 객체에 정보(ip주소, 세션id)를 authentication 객채에 저장
	                SecurityContextHolder.getContext().setAuthentication(authentication); //principal를 포함하는 security context를 SecurityContextHolder에 저장
	            }
	        } catch (Exception ex) {
	            logger.error("토큰을 인증할 수 없습니다.", ex);
	        }

	        filterChain.doFilter(request, response);
	    }

	    private String getJwtFromRequest(HttpServletRequest request) {
	        String bearerToken = request.getHeader("Authorization");
	        System.out.println("bearerToken: "+bearerToken);
	        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
	            return bearerToken.substring(7, bearerToken.length());
	        }
	        return null;
	    }
}
