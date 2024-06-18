package com.pcwk.ehr.cmn;

public class MessageVO extends DTO {
	
	private String messageId;
	private String msgContents;
	
	public MessageVO() {
		super();
	}

	public MessageVO(String messageId, String msgContents) {
		super();
		this.messageId = messageId;
		this.msgContents = msgContents;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMsgContents() {
		return msgContents;
	}

	public void setMsgContents(String msgContents) {
		this.msgContents = msgContents;
	}

	@Override
	public String toString() {
		return "MessageVO [messageId=" + messageId + ", msgContents=" + msgContents + "]";
	}
	
}
