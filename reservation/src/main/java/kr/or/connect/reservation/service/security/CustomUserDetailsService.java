package kr.or.connect.reservation.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserDbService userDbService;
	
	@Override
	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		UserEntity customUser = userDbService.getUser(loginId);
		if(customUser == null) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
		}
		
		CustomUserDetails customUserDetails = new CustomUserDetails(
				customUser.getLoginUserId(), customUser.getPassword());
		
		List<UserRoleEntity> customRoles = userDbService.getUserRoles(loginId);
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(customRoles != null) {
			for(UserRoleEntity customRole : customRoles) {
				authorities.add(new SimpleGrantedAuthority(customRole.getRoleName()));
			}
		}
		
		customUserDetails.setAuthorities(authorities);
        customUserDetails.setEnabled(true);
        customUserDetails.setAccountNonExpired(true);
        customUserDetails.setAccountNonLocked(true);
        customUserDetails.setCredentialsNonExpired(true);
		
		return customUserDetails;
	}
}