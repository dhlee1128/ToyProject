package com.project.scheduler.security;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.scheduler.dao.CommonMapper;
import com.project.scheduler.dto.UserDto;

@Service
public class CustomUserDetailsService implements UserDetailsService{


    @Autowired
    private CommonMapper commonMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDto userDto = commonMapper.getUserInfo(username);

        return new User(userDto.getId(), userDto.getPassword(), getAuthorities(userDto));
    }

    /**
	 * 권한 받아오는 부분
	 * @param userDto
	 * @return
	 */
	private Collection<? extends GrantedAuthority> getAuthorities(UserDto userDto) {
		String[] userRoles = convert(userDto.getMemberAuthoritiesMappingList());
		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
		return authorities;
	}
	
	/**
	 * 실제 권한 매핑 함수
	 * @param list
	 * @return
	 */
    public String[] convert(List<MemberAuthoritiesMapping> list) 
    { 
        String[] arrayOfString = new String[list.size()]; 
  
        int index = 0; 
        for (MemberAuthoritiesMapping memberAuthoritiesMapping : list) {
            arrayOfString[index++] = memberAuthoritiesMapping.getMemberAuthoritiesCode().getAuthority(); 
        }
        
        return arrayOfString; 
    } 
    
}
