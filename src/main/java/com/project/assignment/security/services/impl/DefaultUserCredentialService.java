package com.project.assignment.security.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.assignment.security.entites.UserCredential;
import com.project.assignment.security.models.mapinterface.UserCredentialMapper;
import com.project.assignment.security.models.response.CurrentUserResModel;
import com.project.assignment.security.repositories.UserRepository;
import com.project.assignment.security.services.UserCredentialService;

@Service
public class DefaultUserCredentialService implements UserCredentialService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserCredentialMapper userCredentialMapper;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
    PasswordEncoder passwordEncoder;

	@Override
	public CurrentUserResModel getUserById(long id) {
		UserCredential userCredential = userRepository.findById(id).get();
		return userCredentialMapper.mapToCurrentUserResModel(userCredential);
	}

	@Override
	public CurrentUserResModel getUserByUserName(String userName) {
		UserCredential userCredential=userRepository.findByUsername(userName);
		return userCredentialMapper.mapToCurrentUserResModel(userCredential);
	}

	@Override
	public UserCredential createUser(UserCredential userCredential) {
		userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
		return userRepository.save(userCredential);
	}

	@Override
	public List<CurrentUserResModel> findAllUsers() {
		return  userCredentialMapper.mapToCurrentUserResModel(userRepository.findAll());
	}


	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EntityGraph<UserCredential> entityGraph = entityManager.createEntityGraph(UserCredential.class);
        entityGraph.addAttributeNodes("roles");

        UserCredential userCredential = userRepository.findByUsername(username);
        if (userCredential == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(userCredential.getUsername(), userCredential.getPassword(), getAuthorities(userCredential));
    }
	
	private static List<GrantedAuthority> getAuthorities(UserCredential userCredential){
		List<GrantedAuthority> authorities=new ArrayList<>();
		if(!userCredential.getRoles().isEmpty()) {
			userCredential.getRoles().forEach(role->{
				authorities.add(new SimpleGrantedAuthority(role.getName()));
			});
		}
		return authorities;

	}
	

		

}