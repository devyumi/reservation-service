package kr.or.connect.reservation.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FileInfoDB {
	private int id;
	private String fileName;
	private String saveFileName;
	private String contentType;
	private int deleteFlag;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime modifyDate;
	
	public FileInfoDB() {
		super();
	}
	
	public FileInfoDB(String fileName, String saveFileName, String contentType, int deleteFlag,
			LocalDateTime createDate, LocalDateTime modifyDate) {
		super();
		this.fileName = fileName;
		this.saveFileName = saveFileName;
		this.contentType = contentType;
		this.deleteFlag = deleteFlag;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getSaveFileName() {
		return saveFileName;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public int getDeleteFlag() {
		return deleteFlag;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
	public LocalDateTime getModifyDate() {
		return modifyDate;
	}
	
	@Override
	public String toString() {
		return "FileInfoDB [id=" + id + ", fileName=" + fileName + ", saveFileName=" + saveFileName + ", contentType="
				+ contentType + ", deleteFlag=" + deleteFlag + ", createDate=" + createDate + ", modifyDate="
				+ modifyDate + "]";
	}
}