package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;

//uri로 넘어오는 command와 컨트롤러 매핑
public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<>();
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoard.do",new GetBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}

}
