package okjiaoyu.qa.tools;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by zhang_000 on 2015/10/27.
 */
public class NetworkInterfaceTest {
    public static void main(String[] args) {

        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface netCard = NetworkInterface.getByInetAddress(address);
            byte[] addr = netCard.getHardwareAddress();

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < addr.length; i++) {
                if (addr[i] != 0) {
                    sb.append("-");
                }

                String string = Integer.toHexString(addr[i] & 0xff);
                sb.append(string.length() == 1 ? "0" + string : string);
            }

            System.out.println(sb.toString().toUpperCase());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

//        Enumeration<NetworkInterface> interfaces = null;
//        try {
//            interfaces = NetworkInterface.getNetworkInterfaces();
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//        while (interfaces.hasMoreElements()) {
//            final NetworkInterface ni = interfaces.nextElement();
//            try {
//                if (ni.isLoopback() || ni.isPointToPoint() || ni.isVirtual())
//                    continue;
//            } catch (SocketException e) {
//                e.printStackTrace();
//            }
//            byte[] macAddress = null;
//            try {
//                macAddress = ni.getHardwareAddress();
//            } catch (SocketException e) {
//                e.printStackTrace();
//            }
//            if (macAddress != null && macAddress.length > 0)
//                try {
//                    System.out.println(new String(macAddress,"gbk"));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//        }

    }
}
