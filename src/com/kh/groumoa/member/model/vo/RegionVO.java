package com.kh.groumoa.member.model.vo;

public class RegionVO implements java.io.Serializable {
	private String RnCode;
	private String regionName;
	private String regionSpecific;

	public RegionVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public RegionVO(String rnCode, String regionName, String regionSpecific) {
		super();
		RnCode = rnCode;
		this.regionName = regionName;
		this.regionSpecific = regionSpecific;
	}

	public String getRnCode() {
		return RnCode;
	}

	public void setRnCode(String rnCode) {
		RnCode = rnCode;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionSpecific() {
		return regionSpecific;
	}

	public void setRegionSpecific(String regionSpecific) {
		this.regionSpecific = regionSpecific;
	}

	@Override
	public String toString() {
		return "RegionVO [RnCode=" + RnCode + ", regionName=" + regionName + ", regionSpecific=" + regionSpecific + "]";
	}
	
	
	
}
