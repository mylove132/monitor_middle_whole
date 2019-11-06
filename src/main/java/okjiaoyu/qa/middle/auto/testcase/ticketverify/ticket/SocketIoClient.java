package okjiaoyu.qa.middle.auto.testcase.ticketverify.ticket;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.net.URISyntaxException;
import java.util.Timer;

/**
 * Created by leo_wang on 2016/12/22.
 *
 * @describe
 */
public class SocketIoClient {

    private Socket socket;
    private boolean isConnected = false;
    private Object response = null;

    public void initSocket() throws URISyntaxException {
        socket = IO.socket("https://zhfd.xk12.cn:38890/");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
            }
        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
            }

        }).on("my_response", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {
                response = objects[0];
                System.out.println(response);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(response.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!jsonObject.has("reason")) {
                    // System.out.println(jsonObject.getString("cmd")+"    "+jsonObject.getString("result"));
                } else {
                    try {
                        System.out.println(jsonObject.getString("cmd") + "失败原因    " + jsonObject.getString("reason"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        socket.connect();
    }


    public void send(JSONObject obj) throws JSONException {
        socket.emit("my_event", obj);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void disconnection() {
        if (socket.connected()) {
            socket.disconnect();
        }
    }

    /**
     * 认证
     *
     * @return
     */
    public static JSONObject getObj1() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "auth");
        jsonObject.put("token", "000002220:STUDENT");
        jsonObject.put("device_version", "4.0");
        jsonObject.put("username", "刀");
        return jsonObject;
    }

    /**
     * 认证
     *
     * @return
     */
    public static JSONObject getObj1_teacher() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "auth");
        jsonObject.put("token", "333333007:TEACHER");
        jsonObject.put("device_version", "4.0");
        jsonObject.put("username", "刀削面");
        return jsonObject;
    }

    /**
     * 加入房间
     *
     * @return
     */
    public static JSONObject getObj2() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "join_room");
        jsonObject.put("room_id", "10006");
        return jsonObject;
    }

    /**
     * 离开房间
     *
     * @return
     */
    public static JSONObject getObj3() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "leave_room");
        return jsonObject;
    }

    /**
     * 举手
     *
     * @return
     */
    public static JSONObject getObj4() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "apply_speak");
        return jsonObject;
    }

    /**
     * 学生发言权限设置
     *
     * @return
     */
    public static JSONObject getObj5() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "privilege_set");
        jsonObject.put("user_id", "000002211");
        jsonObject.put("privilege", "1");
        return jsonObject;
    }

    /**
     * 白板数据转发
     *
     * @return
     */
    public static JSONObject getObj6() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "reported_board_data");
        jsonObject.put("data", "board data");
        return jsonObject;
    }

    /**
     * 获取白板当前显示全量数据
     *
     * @return
     */
    public static JSONObject getObj7() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "get_current_board_image");
        return jsonObject;
    }

    /**
     * 查看房间状况
     *
     * @return
     */
    public static JSONObject getObj8() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "query_room_info");
        return jsonObject;
    }

    /**
     * 上报网络状况
     *
     * @return
     */
    public static JSONObject getObj9() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "upload_net_state");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("start_time", "start_time");
        jsonObject1.put("end_time", "end_time");
        jsonObject1.put("app_cpu_rate", "rate");
        jsonObject1.put("sys_app_rate", "rate");
        jsonObject1.put("recv_loss_rate", "rate");
        jsonObject1.put("send_loss_rate", "rate");
        jsonObject1.put("recp_kbps", "11kbps");
        jsonObject1.put("send_kbps", "11kbps");
        jsonObject1.put("up_fps", "fps");
        jsonObject.put("data", jsonObject1);
        return jsonObject;
    }

    /**
     * 踢人
     *
     * @return
     */
    public static JSONObject getObj10() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "kick");
        jsonObject.put("user_id", "000002220");
        return jsonObject;
    }

    /**
     * 设置白板状态
     *
     * @return
     */
    public static JSONObject getObj11() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "config_board");
        jsonObject.put("board", "0");
        return jsonObject;
    }

    /**
     * 设置屏幕模式
     *
     * @return
     */
    public static JSONObject getObj12() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "config_screen");
        jsonObject.put("screen", "1");
        return jsonObject;
    }

    /**
     * 获得白板id
     *
     * @return
     */
    public static JSONObject getObj13() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "get_board_id");
        return jsonObject;
    }

    /**
     * 获得房间设置
     *
     * @return
     */
    public static JSONObject getObj14() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "config_get");
        return jsonObject;
    }

    /**
     * 下课
     *
     * @return
     */
    public static JSONObject getObj15() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "class_over");
        return jsonObject;
    }

    /**
     * 通知进入直播
     *
     * @return
     */
    public static JSONObject getObj16() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "join_live_room");
        jsonObject.put("live_room_id", "10006");
        return jsonObject;
    }

    /**
     * 直播房间是否存在
     *
     * @return
     */
    public static JSONObject getObj17() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "judge_live_room");
        jsonObject.put("live_room_id", "10006");
        return jsonObject;
    }

    /**
     * 上报直播状态
     *
     * @return
     */
    public static JSONObject getObj18() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "upload_live_room_state");
        jsonObject.put("state", "1");
        return jsonObject;
    }

    /**
     * 数据打点
     *
     * @return
     */
    public static JSONObject getObj19() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "reported_data");
        jsonObject.put("data", "webRTC reported data");
        return jsonObject;
    }

    /**
     * 非法命令响应
     *
     * @return
     */
    public static JSONObject getObj20() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cmd", "yyyyy");
        jsonObject.put("data", "webRTC reported data");
        return jsonObject;
    }

    public static void main(String agrs[]) throws URISyntaxException, InterruptedException {
        //Timer timer = new Timer();
        //timer.schedule(new com.okay.qa.timer.Student(),1000, 2000);
        Teacher teacher = new Teacher();
        Student student = new Student();

        teacher.setName("teacher");
        teacher.start();
        teacher.join();
        student.setName("student");
        student.start();
        //student.join();
    }

    @Test
    public void testWebSocket() {

    }
}

