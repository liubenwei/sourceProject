package com.liu.sourceProject.design.pattern.strategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * @author liu
 * @Date 2020/11/17 16:46
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WxWorkCallBack {
	@JacksonXmlProperty(localName = "ToUserName")
	private String toUserName;
	@JacksonXmlProperty(localName = "FromUserName")
	private String fromUserName;
	@JacksonXmlProperty(localName = "CreateTime")
	private String createTime;
	@JacksonXmlProperty(localName = "MsgType")
	private String msgType;
	@JacksonXmlProperty(localName = "Event")
	private String event;
	@JacksonXmlProperty(localName = "ChangeType")
	private String changeType;
	@JacksonXmlProperty(localName = "UserID")
	private String wxWorkUserId;
	@JacksonXmlProperty(localName = "Name")
	private String name;
	@JacksonXmlProperty(localName = "Position")
	private String position;
	@JacksonXmlProperty(localName = "Gender")
	private String gender;
	@JacksonXmlProperty(localName = "Mobile")
	private String mobile;
	@JacksonXmlProperty(localName = "Department")
	private String departments;
	@JacksonXmlProperty(localName = "Id")
	private Long id;
	@JacksonXmlProperty(localName = "ParentId")
	private Long parentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getChangeType() {
		return changeType;
	}

	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}

	public String getWxWorkUserId() {
		return wxWorkUserId;
	}

	public void setWxWorkUserId(String wxWorkUserId) {
		this.wxWorkUserId = wxWorkUserId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDepartment() {
		return departments;
	}

	public void setDepartment(String departments) {
		this.departments = departments;
	}

	@Override
	public String toString() {
		return "WxWorkCallBack{" + "toUserName='" + toUserName + '\''
				+ ", fromUserName='" + fromUserName + '\'' + ", createTime='"
				+ createTime + '\'' + ", msgType='" + msgType + '\''
				+ ", event='" + event + '\'' + ", changeType='" + changeType
				+ '\'' + ", wxWorkUserId='" + wxWorkUserId + '\'' + ", name='"
				+ name + '\'' + ", position='" + position + '\'' + ", gender='"
				+ gender + '\'' + ", mobile='" + mobile + '\'' + ", department="
				+ departments + ", id=" + id + ", parentId=" + parentId + '}';
	}
}
