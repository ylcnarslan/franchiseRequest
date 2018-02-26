package com.mebitech.ylcn.dao;

import org.springframework.stereotype.Repository;

import com.mebitech.ylcn.model.Franchise;
 
@Repository("franchiseDao")
public class FranchiseDaoImpl extends AbstractDao<Integer, Franchise> implements FranchiseDao {
 
    public void saveEmployee(Franchise franchise) {
        persist(franchise);
    }
 
}