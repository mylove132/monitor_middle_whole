package okjiaoyu.qa.middle.auto.testcase.ticketverify.ticket;

import org.json.JSONException;

import java.net.URISyntaxException;

class Student extends Thread {

    @Override
    public void run() {
        System.out.println("Student===================in");
        SocketIoClient socketIoClient = new SocketIoClient();
        try {
            socketIoClient.initSocket();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
//        socketIoClient.send(SocketIoClient.getObj1());
//        socketIoClient.send(SocketIoClient.getObj2());
//        //socketIoClient.send(SocketIoClient.getObj3());
//        //socketIoClient.send(SocketIoClient.getObj4());
////        socketIoClient.send(SocketIoClient.getObj6());
////        socketIoClient.send(SocketIoClient.getObj7());
////        socketIoClient.send(SocketIoClient.getObj8());
////        socketIoClient.send(SocketIoClient.getObj9());
//       // socketIoClient.send(SocketIoClient.getObj10());
//        socketIoClient.send(SocketIoClient.getObj13());
//        socketIoClient.send(SocketIoClient.getObj14());
//        socketIoClient.send(SocketIoClient.getObj17());
//        socketIoClient.send(SocketIoClient.getObj18());
//        socketIoClient.send(SocketIoClient.getObj19());
        try {
            socketIoClient.send(SocketIoClient.getObj20());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
