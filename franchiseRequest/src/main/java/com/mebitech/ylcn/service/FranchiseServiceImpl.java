package com.mebitech.ylcn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mebitech.ylcn.dao.FranchiseDao;
import com.mebitech.ylcn.model.Franchise;
 
@Service("franchiseService")
@Transactional
public class FranchiseServiceImpl implements FranchiseService {
 
    @Autowired
    private FranchiseDao dao;
     
 
    public void saveEmployee(Franchise franchise) {
        dao.saveEmployee(franchise);
    }
}