package com.kh.hkid.common.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.hkid.common.template.Template;

@Controller
public class ImgAjax {
    // summernote로 추가한 이미지 서버에 저장
    @ResponseBody
    @PostMapping("insertImgAjax")
    public String insertSummernoteImgAjax(List<MultipartFile> fileList, String root, HttpSession session) {
    	ArrayList<String> imgList = new ArrayList<>();
    	
    	for(MultipartFile f : fileList) {	
    		imgList.add(Template.saveFile(f, session, "/resources/image/" + root));
    	}
    	
    	return new Gson().toJson(imgList);

    }
}
