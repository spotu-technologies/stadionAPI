package com.stadion.api.entity;

public class WodRecordInfo {

	@Override
	public String toString() {
		return "WodRecordInfo [idx=" + idx + ", wodIdx=" + wodIdx + ", wodStepIdx=" + wodStepIdx
				+ ", wodItemCategoryIdx=" + wodItemCategoryIdx + ", wodItemIdx=" + wodItemIdx + ", useScaled="
				+ useScaled + ", kind=" + kind + ", recordType=" + recordType + ", recordUnit=" + recordUnit
				+ ", orderType=" + orderType + ", isRmAdjust=" + isRmAdjust + ", explanation=" + explanation
				+ ", writer=" + writer + ", status=" + status + ", regUnixtime=" + regUnixtime + ", lastUpdatetime="
				+ lastUpdatetime + ", scaleGrade=" + scaleGrade + "]";
	}
	public Integer idx;
	public Integer wodIdx;
	public Integer wodStepIdx;
	public Integer wodItemCategoryIdx;
	public Integer wodItemIdx;
	
	public String useScaled;
	public String kind;
	public Integer recordType;
	public Integer recordUnit;
	public String orderType;
	public String isRmAdjust;
	public String explanation;
	
	public Integer writer;
	public Integer status;
	public Integer regUnixtime;
	public Integer lastUpdatetime;
	public Integer scaleGrade;
}
