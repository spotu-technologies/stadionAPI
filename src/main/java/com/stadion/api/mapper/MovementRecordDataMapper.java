package com.stadion.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.stadion.api.entity.AccountInfo;
import com.stadion.api.entity.LevelData;
import com.stadion.api.entity.MovementRecordData;
import com.stadion.api.entity.MovementRecordDataDetail;
import com.stadion.api.entity.NoticeBoard;

@Mapper
public interface MovementRecordDataMapper {

	//public List<AccountInfo> getAccountInfoList();
	public List<MovementRecordDataDetail> getMovementRecordData(long accoutIdx);
	public List<MovementRecordData> getMovementRecordDataAll();
	public List<MovementRecordData> getMovementRecordDataRecent(long accountIdx);
	public List<MovementRecordData> getMovementRecordDataBest(long accountIdx);
	public List<MovementRecordData> getMovementRecordDataYearBest(@Param ("accountIdx") long accountIdx, @Param ("currentYear") long dateYear);
	public List<MovementRecordData> getMovementRecordDataDetail(@Param ("accountIdx") long accountIdx, @Param ("movementIdx") long movementIdx);
	public List<MovementRecordData> getMovementRecordDataRecentDetail(@Param ("accountIdx") long accountIdx, @Param ("movementIdx") long movementIdx);
	public List<MovementRecordData> getMovementRecordDatMomLevel(long accountIdx);
	public List<MovementRecordData> getMovementRecordDatChallenge(long accountIdx);
	public int insertRecordData(MovementRecordData arg);
	public Long getmovementRecordDataMtcCount(long momIdx);
	
}
