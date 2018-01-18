package com.kabank.mvc.dao;

import com.kabank.mvc.domain.MemberBean;

public interface KakaoDAO {
public void accountNumbers(String account);
public MemberBean selectByid(String id);
}
