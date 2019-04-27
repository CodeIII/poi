package com.lk.pojo;

import java.io.Serializable;

public class BcRegion implements Serializable {
    private String rId;

    private String province;

    private String city;

    private String district;

    private String postcode;

    private String shortcode;

    private String citycode;

    private static final long serialVersionUID = 1L;

    public String getrId() {
        return rId;
    }

    public BcRegion() {
		super();
	}

	public BcRegion(String rId, String province, String city, String district, String postcode, String shortcode,
			String citycode) {
		super();
		this.rId = rId;
		this.province = province;
		this.city = city;
		this.district = district;
		this.postcode = postcode;
		this.shortcode = shortcode;
		this.citycode = citycode;
	}

	public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode == null ? null : shortcode.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

	@Override
	public String toString() {
		return "BcRegion [rId=" + rId + ", province=" + province + ", city=" + city + ", district=" + district
				+ ", postcode=" + postcode + ", shortcode=" + shortcode + ", citycode=" + citycode + "]";
	}
    
    
}