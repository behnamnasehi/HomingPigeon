package com.behnamnasehi.supportconnection.utilitis;

import com.behnamnasehi.supportconnection.socket.HomingPigeon;

public class Constant {
    public static final String BASE_URL = "http://192.168.1.9:8000";
    public static final String URL_GET_MESSAGE = BASE_URL + "/v1/message/{room_id}/{pageNo}/{limit}";
    public static final int REQUEST_TIME_OUT = 10;

    public static final String
            EXTRA_DATA = "extra_data_message",
            EXTRA_INBOX_ID = "extra_room_id",
            EXTRA_EVENT_TYPE = "extra_event_type";

    public static final int
            EVENT_TYPE_CONNECT = 1,
            EVENT_TYPE_DISCONNECT = 2,
            EVENT_TYPE_CONNECT_ERROR = 3,
            EVENT_TYPE_CONNECT_TIMEOUT = 4,
            EVENT_TYPE_MESSAGE = 5,
            EVENT_TYPE_ERROR = 0;

    public static final String
            EVENT_TAG_MESSAGE = "message",
            EVENT_TAG_JOIN = "join",
            EVENT_TAG_CHANGE = "change",
            EVENT_TAG_ERROR = "server_error",
            EVENT_TAG_READY = "ready",
             EVENT_TAG_RECEIVED = "received",
            EVENT_TAG_TYPING = "typing",
             EVENT_TAG_CHECK_USER = "message_detection";

    public static final String KEY_USER_SIGNATURE = "KEY_USER_SIGNATURE";
    public static final String KEY_USER_IDENTITY = "KEY_USER_IDENTITY";

    public static String PROJECT_API_KEY = null;


}
