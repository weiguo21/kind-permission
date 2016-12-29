package com.kind.perm.web.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kind.common.web.Token;

/**
 * Created by weiguo.liu on 2016/12/29.
 */
public class TokenCheckController {
	@RequestMapping("/save")
	@Token(needRemoveToken = true)
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
		//<input type="hidden" name="token" value="${token}">
		return null;
	}

	@RequestMapping("/edit")
	@Token(needAddToken = true)
	public ModelAndView edit(Integer id, HttpServletRequest request) {
		return null;
	}
}
