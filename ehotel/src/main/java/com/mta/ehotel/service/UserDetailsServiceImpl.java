package com.mta.ehotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mta.ehotel.dao.NhanVienDao;
import com.mta.ehotel.entity.DbNhanVien;
import com.mta.ehotel.object.CtxUser;

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
		

		return (UserDetails) new CtxUser(dbNhanVien);
	}

}
