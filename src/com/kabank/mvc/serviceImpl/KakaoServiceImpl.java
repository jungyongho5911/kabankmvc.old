package com.kabank.mvc.serviceImpl;

import com.kabank.mvc.daoImpl.KakaoDaoImpl;
import com.kabank.mvc.service.KakaoService;

public class KakaoServiceImpl implements KakaoService {
	public static KakaoServiceImpl getInstance() {
		return new KakaoServiceImpl();
	}
	private KakaoServiceImpl() {
	}
	public void accountNumber(int i) {
		
		KakaoDaoImpl.getInstance().accountNumbers(i);
	}
}

