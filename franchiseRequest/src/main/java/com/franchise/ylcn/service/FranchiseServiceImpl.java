package com.franchise.ylcn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.franchise.ylcn.dao.FranchiseDao;
import com.franchise.ylcn.model.Franchise;
 
@Service("franchiseService")
@Transactional
public class FranchiseServiceImpl implements FranchiseService {
 
    @Autowired
    private FranchiseDao dao;
     
 
    public void saveEmployee(Franchise franchise) {
        dao.saveEmployee(franchise);
    }
}