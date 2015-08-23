package com.xuliangjun.jiujiucms.modules.cms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xuliangjun.jiujiucms.common.controller.BaseController;
import com.xuliangjun.jiujiucms.modules.cms.entity.Template;
import com.xuliangjun.jiujiucms.modules.cms.service.TemplateService;
@Controller
@RequestMapping(value="/template")
public class TemplateController extends BaseController{
	@Resource(name="templateService")
	private TemplateService templateService;
	@RequestMapping(value="/list")
	public ModelAndView list()throws Exception{
		String s="";
		ModelAndView mv = this.getModelAndView();
		List<Template> templatelist=templateService.findTemplateList();
		for(int i=0;i<templatelist.size();i++){
			String id=templatelist.get(i).getCms_id();
			String name=templatelist.get(i).getCms_name();
			s=s+"{"+"id:"+id+",name:"+"\""+name+"\""+"},";
		}
		s="["+s+"]";
		mv.setViewName("cms/template/template_list");
		mv.addObject("s",s);
		return mv;
	}
	
	@RequestMapping(value="/parentTemplateList")
	public ModelAndView parentTemplateList() throws Exception{
		ModelAndView mv = this.getModelAndView();
		List<Template> templateparentList=templateService.findParentTemplateList();
		mv.setViewName("cms/template/templatemanager_list");
		mv.addObject("templateparentList",templateparentList);
		return mv;
	}
	
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd() throws Exception{
		ModelAndView mv = this.getModelAndView();
		List<Template> templateparentList=templateService.findParentTemplateList();
		mv.setViewName("cms/template/templatemanager_add");
		mv.addObject("templateparentList",templateparentList);
		return mv;
	}
}
