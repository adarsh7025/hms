/*
 * create table NOTIFICATION(
	NOTIFICATION_ID int primary key auto_increment,
FROM_USER_ID int,
TO_USER_ID int,
NOTIFICATION_TYPE varchar(30),
NOTIFICATION_TEXT text,
APPROVED_STATUS varchar(20),
NOTIFICATION_DATE datetime,
FOREIGN KEY(FROM_USER_ID) REFERENCES USER(ID),
FOREIGN KEY(TO_USER_ID) REFERENCES USER(ID)
);

*/

package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "NOTIFICATION")
public class Notification {

	@Id
	@Column(name = "NOTIFICATION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int NotificationId;

	@Column(name = "FROM_USER_ID")
	private int fromUserId;

	@Column(name = "TO_USER_ID")
	private int toUserId;

	@Column(name = "NOTIFICATION_TYPE")
	private String notificationType;
	
	@Column(name = "NOTIFICATION_TEXT")
	private String notificationText;
	
	@Column(name = "APPROVED_STATUS")
	private String approvedStatus;
	
	@Column(name = "NOTIFICATION_DATE")
	private Timestamp notificationDate;

	public Notification() {
		super();
	}

	public Notification(int notificationId, int fromUserId, int toUserId, String notificationType,
			String notificationText, String approvedStatus, Timestamp notificationDate) {
		super();
		NotificationId = notificationId;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.notificationType = notificationType;
		this.notificationText = notificationText;
		this.approvedStatus = approvedStatus;
		this.notificationDate = notificationDate;
	}

	public int getNotificationId() {
		return NotificationId;
	}

	public void setNotificationId(int notificationId) {
		NotificationId = notificationId;
	}

	public int getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}

	public int getToUserId() {
		return toUserId;
	}

	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationText() {
		return notificationText;
	}

	public void setNotificationText(String notificationText) {
		this.notificationText = notificationText;
	}

	public String getApprovedStatus() {
		return approvedStatus;
	}

	public void setApprovedStatus(String approvedStatus) {
		this.approvedStatus = approvedStatus;
	}

	public Timestamp getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Timestamp notificationDate) {
		this.notificationDate = notificationDate;
	}

	@Override
	public String toString() {
		return "Notification [NotificationId=" + NotificationId + ", fromUserId=" + fromUserId + ", toUserId="
				+ toUserId + ", notificationType=" + notificationType + ", notificationText=" + notificationText
				+ ", approvedStatus=" + approvedStatus + ", notificationDate=" + notificationDate + "]";
	}

	
	
	
	
	


}