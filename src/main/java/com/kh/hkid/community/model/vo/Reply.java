package com.kh.hkid.community.model.vo;

import lombok.Data;

@Data // vo�� �ʿ��� �͵��� ��Ƶ� @������̼�
public class Reply {
	private String replyNo;		//��۹�ȣ
	private String boardNo;		//�Խñ� ��ȣ
	private String memberNo;	//ȸ�� ��ȣ
	private String replyContent;//��� ����
	private String replyDate;	//��� �ۼ���
	private String reReplyNo;	//�θ��� ��ȣ
}
