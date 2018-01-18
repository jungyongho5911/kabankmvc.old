package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.KakaoDaoImpl;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.service.KakaoService;

public class KakaoServiceImpl implements KakaoService {
	public static KakaoService getInstance() {
		return new KakaoServiceImpl();
	}
	private KakaoServiceImpl() {
	}
	public void accountNumber() {
		String res = 
				String.valueOf(String.format("%04d", (int) (Math.random()*10000)))+"-"+
				String.valueOf(String.format("%04d", (int) (Math.random()*10000)))+"-"+
				String.valueOf(String.format("%04d", (int) (Math.random()*10000)));
		String account = res;
		KakaoDaoImpl.getInstance().accountNumbers(account);
	}
	@Override
	public MemberBean findAccount(String id) {
		return KakaoDaoImpl.getInstance().selectByid(id);
	}
}

