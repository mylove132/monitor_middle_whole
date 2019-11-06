package okjiaoyu.qa.middle.auto.testcase.ticketverify.ticket;

import org.json.JSONException;

import java.net.URISyntaxException;

class Teacher extends Thread {


    @Override
    public void run() {
        System.out.println("Teacher===================in");
        SocketIoClient socketIoClient = new SocketIoClient();
        try {
            socketIoClient.initSocket();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            socketIoClient.send(SocketIoClient.getObj1_teacher());
            socketIoClient.send(SocketIoClient.getObj2());
            // socketIoClient.send(SocketIoClient.getObj3());
            //socketIoClient.send(SocketIoClient.getObj5());
            //socketIoClient.send(SocketIoClient.getObj6());
            socketIoClient.send(SocketIoClient.getObj11());
            socketIoClient.send(SocketIoClient.getObj12());

            socketIoClient.send(SocketIoClient.getObj13());

            socketIoClient.send(SocketIoClient.getObj14());
            socketIoClient.send(SocketIoClient.getObj15());
            socketIoClient.send(SocketIoClient.getObj16());
            socketIoClient.send(SocketIoClient.getObj17());
            socketIoClient.send(SocketIoClient.getObj18());
            socketIoClient.send(SocketIoClient.getObj19());
            socketIoClient.send(SocketIoClient.getObj20());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
