package com.rishu.service;

import com.rishu.entities.Fee;
import com.rishu.entities.User;
import com.rishu.repository.FeeRepo;
import com.rishu.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeService {

    @Autowired
    private FeeRepo feeRepo;
    @Autowired
    private UserRepo userRepo;

    //payfee or create
    public Fee payFee(Fee feeData)
    {
        Fee fee=new Fee();
        fee.setMonth(feeData.getMonth());
        fee.setAmount(feeData.getAmount());
        fee.setGivenBy(feeData.getGivenBy());
        fee.setDescription(feeData.getDescription());
        fee.setDate(feeData.getDate());
        User u=this.userRepo.findById(feeData.getUser().getId()).get();
        fee.setUser(u);
        return this.feeRepo.save(fee);
    }

}
