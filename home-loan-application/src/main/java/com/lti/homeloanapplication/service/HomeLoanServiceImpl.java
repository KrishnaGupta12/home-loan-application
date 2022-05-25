package com.lti.homeloanapplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.homeloanapplication.dao.HomeLoanDao;
import com.lti.homeloanapplication.entiti.Owner;
import com.lti.homeloanapplication.exception.OwnerAddException;

@Service
@Component
public class HomeLoanServiceImpl implements HomeLoanService {

	@Autowired
	private HomeLoanDao homeLoanDao;

//for Adding owner 
	@Override
	public Owner addOwner(Owner owner) throws OwnerAddException {
	
		if (owner.getName() == "" || owner.getSalary() == null) {
			throw new OwnerAddException();
		}
		homeLoanDao.save(owner);
		return owner;
	}

	@Override
	public List<Owner> getOwner() {
		List<Owner> ol;
		ol = homeLoanDao.findAll();
		return ol;
	}

	@Override
	public Owner getOneOwner(Long ownerId) {
		Optional<Owner> s = homeLoanDao.findById(ownerId);
		return s.get();
	}

}
