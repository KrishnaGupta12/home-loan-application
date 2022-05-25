package com.lti.homeloanapplication.service;

import java.util.List;

import com.lti.homeloanapplication.entiti.Owner;
import com.lti.homeloanapplication.exception.MyException;
import com.lti.homeloanapplication.exception.OwnerAddException;

public interface HomeLoanService {

	public Owner addOwner(Owner owner) throws OwnerAddException;

	public List<Owner> getOwner();

	public Owner getOneOwner(Long ownerId);

}
