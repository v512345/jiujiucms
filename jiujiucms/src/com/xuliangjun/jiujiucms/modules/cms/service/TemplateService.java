package com.xuliangjun.jiujiucms.modules.cms.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xuliangjun.jiujiucms.common.dao.DaoSupport;
import com.xuliangjun.jiujiucms.modules.cms.entity.Template;

@Service("templateService")
public class TemplateService {
	@Resource(name = "daoSupport") 
	private DaoSupport dao;
	
	public List<Template> findTemplateList()throws Exception{
		return (List<Template>)dao.findForList("TemplateMapper.findTemplate", null);
	}
	
	public List<Template> findParentTemplateList()throws Exception{
		return (List<Template>)dao.findForList("TemplateMapper.listAllParentTemplate", null);
	}
}
