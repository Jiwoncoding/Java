package com.icia.spring.example09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icia.spring.example09.service.BoardService;

@Component
public class BoardController {
	@Autowired
	private BoardService boardService;
}
