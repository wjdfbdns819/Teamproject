package com.callor.jack;

import com.callor.jack.service.TotalService;
import com.callor.jack.service.impl.MenuServiceImpl;

public class Start {

	public static void main(String[] args) {
		
		TotalService tService = new MenuServiceImpl();
		
		tService.selectMenu();
		
	}
}