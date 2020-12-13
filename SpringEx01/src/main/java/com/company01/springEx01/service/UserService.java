package com.company01.springEx01.service;

import com.company01.springEx01.logic.Members;

public interface UserService {

	Members getUserOne(String common, String col);

	int userJoin(Members members);

}
