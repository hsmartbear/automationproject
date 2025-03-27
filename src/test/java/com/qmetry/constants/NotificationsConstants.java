package com.qmetry.constants;

/**
 * This interface defines NotificationsConstants.
 * 
 * @author rahul.patil
 */
public interface NotificationsConstants extends CommonConstants {
    static final String COLUMN_EVENT = "Event";
    static final String COLUMN_NOTIFICATION_RECEIVERS = "Notification Receivers";

    static final String ADD_RQ_EVENT_NOTIFICATION_RECEIVER_SUCCESS = "Notification receiver successfully added for add requirement event.";
    static final String ADD_RQ_EVENT_NOTIFICATION_RECEIVER_FAILED = "Notification receiver could not be successfully added for add requirement event.";

    static final String UPDATE_RQ_EVENT_NOTIFICATION_RECEIVER_SUCCESS = "Notification receiver successfully added for update requirement event.";
    static final String UPDATE_RQ_EVENT_NOTIFICATION_RECEIVER_FAILED = "Notification receiver could not be successfully added for update requirement event.";

    static final String ADD_RQ_EVENT_EMAIL_RECEIVER_SUCCESS = "Email received successfully for add requirement event.";
    static final String ADD_RQ_EVENT_EMAIL_RECEIVER_FAILED = "Email could not be received successfully for add requirement event.";

    static final String UPDATE_RQ_EVENT_EMAIL_RECEIVER_SUCCESS = "Email received successfully for update requirement event.";
    static final String UPDATE_RQ_EVENT_EMAIL_RECEIVER_FAILED = "Email could not be received successfully for update requirement event.";
}
