package com.franchise.ylcn.dao;

import org.springframework.stereotype.Repository;

import com.franchise.ylcn.model.Franchise;
 
@Repository("franchiseDao")
public class FranchiseDaoImpl extends AbstractDao<Integer, Franchise> implements FranchiseDao {
 
    public void saveEmployee(Franchise franchise) {
        persist(franchise);
    }
 
}