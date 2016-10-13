package com.plantplaces.service;

import com.plantplaces.DTO.User;

/*
* This class pulls in the user data and runs calculations on it
*/
public interface ICalculator {
        
        public float calculateBFPercentage (User user) throws Exception;
}
