package com.lucamartinelli.app.simplesite.servicediscovery.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ServiceVO implements Serializable {

	private static final long serialVersionUID = 782078936901305676L;

	private String name;
	private String displayInfo;
	private String url;
	
	public ServiceVO(String name, String displayInfo, String url) {
		super();
		this.name = name;
		this.displayInfo = displayInfo;
		this.url = url;
	}
	
	public ServiceVO() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDisplayInfo() {
		return displayInfo;
	}
	public void setDisplayInfo(String displayInfo) {
		this.displayInfo = displayInfo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayInfo == null) ? 0 : displayInfo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceVO other = (ServiceVO) obj;
		if (displayInfo == null) {
			if (other.displayInfo != null)
				return false;
		} else if (!displayInfo.equals(other.displayInfo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceVo [name=" + name + ", displayInfo=" + displayInfo + ", url=" + url + "]";
	}
}
