package tws.repository;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.Parcel;

import java.util.List;

@Mapper
public interface ParcelMapper {
    List<Parcel> selectAll();

	void addParcel(@Param("parcel") Parcel parcel);

	void updateParcel(@Param("id")String id,@Param("parcel")Parcel parcel);

	void deleteParcel(@Param("id")String id);
}