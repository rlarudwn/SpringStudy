package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.MusicMapper;
import com.sist.vo.MusicVO;
@Repository("dao")
public class MusicDAO {
	@Autowired
	MusicMapper mapper;
	public List<MusicVO> musicListData(){
		return mapper.musicListData();
	}
	public List<MusicVO> musicTitleFindData(String title){
		return mapper.musicTitleFindData(title);
	}
	public List<MusicVO> musicSingerFindData(String singer){
		return mapper.musicSingerFindData(singer);
	}
	public List<MusicVO> musicAlbumFindData(String album){
		return mapper.musicAlbumFindData(album);
	}
}
