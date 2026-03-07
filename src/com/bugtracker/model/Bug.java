package com.bugtracker.model;
import java.time.LocalDateTime;
public class Bug {
	private int bugId;
	private String title;
	private String description;
	private Priority priority;
	private Status status;
	private int assignedTo;
	private LocalDateTime createdAt;
	
	
	public Bug(int bugId, String title, String description, Priority priority, Status status, int assignedTo, LocalDateTime createdAt) {
		this.bugId=bugId;
		this.title=title;
		this.description=description;
		this.priority=priority;
		this.status=status;
		this.assignedTo=assignedTo; //user id
		this.createdAt=createdAt;
	}
	//getter & setter
	public int getBugId() {
		return bugId;
	}
	public void setBugId(int bugId) {
		this.bugId=bugId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description=description;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority=priority;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status=status;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo=assignedTo;	
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt=createdAt;
	}
	// method toString
	@Override
	 public String toString() {
        return "Bug{" +
                "id=" + bugId +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                ", assignedTo=" + assignedTo +
                ", createdAt=" + createdAt +
                '}';
    }
}
