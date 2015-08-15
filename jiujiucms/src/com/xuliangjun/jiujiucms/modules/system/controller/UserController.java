package com.xuliangjun.jiujiucms.modules.system.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xuliangjun.jiujiucms.common.controller.BaseController;
import com.xuliangjun.jiujiucms.common.entity.Page;
import com.xuliangjun.jiujiucms.common.util.Const;
import com.xuliangjun.jiujiucms.modules.system.entry.User;
import com.xuliangjun.jiujiucms.modules.system.service.UserService;

/** 
 * 类名称：UserController
 * 创建人：FH 
 * 创建时间：2014年6月28日
 * @version
 */
@Controller
@RequestMapping(value="/user")
public class UserController extends BaseController {
	
	@Resource(name="userService")
	private UserService userService;


	/**
	 * 显示用户列表(tab方式)
	 */
	@RequestMapping(value="/listtabUsers")
	public ModelAndView listtabUsers(Page page)throws Exception{
		ModelAndView mv = this.getModelAndView();
		List<User> user = userService.getUserByNameAndPwd(null);			//列出用户列表
		System.out.println(user.size());
		System.out.println(user.get(0).getNAME());
		mv.setViewName("system/user/user_tb_list");
//		mv.addObject("pd", pd);
//		mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		return mv;
	}
	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
}
