package com.mta.ehotel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mta.ehotel.dao.NhanVienDao;
import com.mta.ehotel.entity.DbNhanVien;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private NhanVienDao nhanVienDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        DbNhanVien dbNhanVien = this.nhanVienDao.findUserAccount(userName);

        if (dbNhanVien == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + dbNhanVien);

        

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+dbNhanVien.getRole().toString());
        grantList.add(authority);

        UserDetails userDetails = (UserDetails) new User(dbNhanVien.getCode(), //
        		dbNhanVien.getPassword(),true,true,true,true, grantList);

        return userDetails;
    }

}
