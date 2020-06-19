package com.spring.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.exam.dao.HomeDao;
import com.spring.exam.model.User;

@Service
public class HomeServiceImp implements HomeService {
	@Autowired
	private HomeDao homedao;
	
	@Transactional
	public String getCustomer() {
		
                // do some business processing here ...
    		//now call DAO layer
		return HomeDao.getCustomer(null);
	}

  }