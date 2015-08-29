package com.jiujiucms.modules.cms.entity;

import java.util.List;

public class Template {
	private String cms_id;
	private String cms_name;
	private String template_url;
	private String cms_chinesename;
	private String cms_content;
	private String parent_id;
	private String cms_order;
	private String cms_icon;
	private String cms_type;
	
	private Template parentTemplate;
	private List<Template> subTemplate;
	
	public String getCms_id() {
		return cms_id;
	}
	public void setCms_id(String cms_id) {
		this.cms_id = cms_id;
	}
	public String getCms_name() {
		return cms_name;
	}
	public void setCms_name(String cms_name) {
		this.cms_name = cms_name;
	}
	public String getCms_chinesename() {
		return cms_chinesename;
	}
	public void setCms_chinesename(String cms_chinesename) {
		this.cms_chinesename = cms_chinesename;
	}
	public String getCms_content() {
		return cms_content;
	}
	public void setCms_content(String cms_content) {
		this.cms_content = cms_content;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getCms_order() {
		return cms_order;
	}
	public void setCms_order(String cms_order) {
		this.cms_order = cms_order;
	}
	public String getCms_icon() {
		return cms_icon;
	}
	public void setCms_icon(String cms_icon) {
		this.cms_icon = cms_icon;
	}
	public String getCms_type() {
		return cms_type;
	}
	public void setCms_type(String cms_type) {
		this.cms_type = cms_type;
	}
	public Template getParentTemplate() {
		return parentTemplate;
	}
	public void setParentTemplate(Template parentTemplate) {
		this.parentTemplate = parentTemplate;
	}
	public List<Template> getSubTemplate() {
		return subTemplate;
	}
	public void setSubTemplate(List<Template> subTemplate) {
		this.subTemplate = subTemplate;
	}
	public String getTemplate_url() {
		return template_url;
	}
	public void setTemplate_url(String template_url) {
		this.template_url = template_url;
	}
	
	
}
