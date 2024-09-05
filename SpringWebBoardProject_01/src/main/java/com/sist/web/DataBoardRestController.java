package com.sist.web;

import java.io.File;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.*;
import com.sist.vo.*;;

@RestController
public class DataBoardRestController {
	@Autowired
	private DataBoardDAO dao;

	@PostMapping(value = "databoard/updateOk.do", produces = "text/html;charset=UTF-8")
	public String boardUpdateOK(BoardVO vo) {
		String js = "";
		boolean bCheck = false;
		if (bCheck) {
			js += "<script>" + "location.href='detail.do?no=" + vo.getNo() + "'" + "</script>";
		} else {
			js += "<script>" + "alert('비밀번호가 틀립니다')\n" + "history.back()" + "</script>";
		}
		return js;
	}

	@PostMapping(value = "databoard/deleteOk.do", produces = "text/html;charset=UTF-8")
	public String boardDeleteOk(DataBoardVO vo) {
		DataBoardVO vo2 = dao.databoardFileInfo(vo.getNo());
		String js = "";
		boolean bCheck = dao.databoardDelete(vo.getNo(), vo.getPwd());
		if (bCheck) {
			try {
				String files = vo2.getFilename();
				if (vo2.getFilecount() != 0) // 파일이 있는 경우
				{
					StringTokenizer st = new StringTokenizer(files, ",");
					while (st.hasMoreTokens()) {
						File file = new File("c:\\springUpload\\" + st.nextToken());
						file.delete();
					}
				}
			} catch (Exception e) {
			}
			js += "<script>" + "location.href='list.do'" + "</script>";
		} else {
			js += "<script>" + "alert('비밀번호가 틀립니다')\n" + "history.back()" + "</script>";
		}
		return js;
	}
}
