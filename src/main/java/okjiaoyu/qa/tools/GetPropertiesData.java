package okjiaoyu.qa.tools;

import java.util.ResourceBundle;

/**
 * Created by leo on 17/5/10.
 */
//获取普通的配置文件内容
public class GetPropertiesData {
    public String getData(String str) {
        String result = null;
        switch (RunningParameter.projectName) {

            case "teacherspace":
                ResourceBundle teacherspace = ResourceBundle.getBundle("teacherweb");
                result = teacherspace.getString(str);
                break;
            case "studentpad":
                ResourceBundle studentpad = ResourceBundle.getBundle("pad");
                result = studentpad.getString(str);
                break;
            case "parentapp":
                ResourceBundle parentapp = ResourceBundle.getBundle("parentapp");
                result = parentapp.getString(str);
                break;
            case "teacherpad":
                ResourceBundle teacherpad = ResourceBundle.getBundle("teacherpad");
                result = teacherpad.getString(str);
                break;
            case "PlatformResource":
                ResourceBundle platformresource = ResourceBundle.getBundle("platformresource");
                result = platformresource.getString(str);
                break;
            case "ticketverify":
                ResourceBundle ticketverify = ResourceBundle.getBundle("ticketverify");
                result = ticketverify.getString(str);
                break;
            case "mall":
                ResourceBundle mall = ResourceBundle.getBundle("mall");
                result = mall.getString(str);
                break;
            case "stupad":
                ResourceBundle stupad = ResourceBundle.getBundle("stupad");
                result = stupad.getString(str);
                break;
            case "publicweb":
                ResourceBundle publicweb = ResourceBundle.getBundle("publicweb");
                result = publicweb.getString(str);
                break;
            case "privateweb":
                ResourceBundle privateweb = ResourceBundle.getBundle("privateweb");
                result = privateweb.getString(str);
                break;
            case "crm":
                ResourceBundle crm = ResourceBundle.getBundle("crm");
                result = crm.getString(str);
                break;
            case "trafficmonitor":
                ResourceBundle trafficmonitor = ResourceBundle.getBundle("trafficmonitor");
                result = trafficmonitor.getString(str);
                break;
            default:
        }
        return result;
    }

    //    获取数组类型文件内容
    public String[] getDatas(String str) {
        String result = null;
        String[] datas = null;
        switch (RunningParameter.projectName) {
            case "teacherspace":
                ResourceBundle teacherspace = ResourceBundle.getBundle("teacherweb");
                result = teacherspace.getString(str);
                datas = new String[]{result};
                break;
            case "studentpad":
                ResourceBundle studentpad = ResourceBundle.getBundle("pad");
                result = studentpad.getString(str);
                datas = new String[]{result};
                break;
            case "parentapp":
                ResourceBundle parentapp = ResourceBundle.getBundle("parentapp");
                result = parentapp.getString(str);
                datas = new String[]{result};
                break;
            case "teacherpad":
                ResourceBundle teacherpad = ResourceBundle.getBundle("teacherpad");
                result = teacherpad.getString(str);
                datas = new String[]{result};
                break;
            case "PlatformResource":
                ResourceBundle platformresource = ResourceBundle.getBundle("platformresource");
                result = platformresource.getString(str);
                datas = new String[]{result};
                break;
            case "ticketverify":
                ResourceBundle ticketverify = ResourceBundle.getBundle("ticketverify");
                result = ticketverify.getString(str);
                datas = new String[]{result};
                break;
            case "mall":
                ResourceBundle mall = ResourceBundle.getBundle("mall");
                result = mall.getString(str);
                datas = new String[]{result};
                break;
            case "stupad":
                ResourceBundle stupad = ResourceBundle.getBundle("stupad");
                result = stupad.getString(str);
                datas = new String[]{result};
                break;
            case "publicweb":
                ResourceBundle publicweb = ResourceBundle.getBundle("publicweb");
                result = publicweb.getString(str);
                datas = new String[]{result};
                break;
            case "privateweb":
                ResourceBundle privateweb = ResourceBundle.getBundle("privateweb");
                result = privateweb.getString(str);
                datas = new String[]{result};
                break;
            case "crm":
                ResourceBundle crm = ResourceBundle.getBundle("crm");
                result = crm.getString(str);
                datas = new String[]{result};
                break;
            case "trafficmonitor":
                ResourceBundle trafficmonitor = ResourceBundle.getBundle("trafficmonitor");
                result = trafficmonitor.getString(str);
                datas = new String[]{result};
                break;
            default:
        }
        return datas;
    }

    //获取日志打印目录
    public String[] getLogPath(String str) {
        String result;
        String[] logpath = null;
        switch (RunningParameter.projectName) {
            case "teacherspace":
                ResourceBundle teacherspace = ResourceBundle.getBundle("teacherweb");
                result = teacherspace.getString(str);
                logpath = getMachine(result);
                break;
            case "studentpad":
                ResourceBundle studentpad = ResourceBundle.getBundle("pad");
                result = studentpad.getString(str);
                logpath = getMachine(result);
                break;
            case "parentapp":
                ResourceBundle parentapp = ResourceBundle.getBundle("parentapp");
                result = parentapp.getString(str);
                logpath = getMachine(result);
                break;
            case "teacherpad":
                ResourceBundle teacherpad = ResourceBundle.getBundle("teacherpad");
                result = teacherpad.getString(str);
                logpath = getMachine(result);
                break;
            case "PlatformResource":
                ResourceBundle platformresource = ResourceBundle.getBundle("platformresource");
                result = platformresource.getString(str);
                logpath = getMachine(result);
                break;
            case "ticketverify":
                ResourceBundle ticketverify = ResourceBundle.getBundle("ticketverify");
                result = ticketverify.getString(str);
                logpath = getMachine(result);
                break;
            case "mall":
                ResourceBundle mall = ResourceBundle.getBundle("mall");
                result = mall.getString(str);
                logpath = getMachine(result);
                break;
            case "stupad":
                ResourceBundle stupad = ResourceBundle.getBundle("stupad");
                result = stupad.getString(str);
                logpath = getMachine(result);
                break;
            case "publicweb":
                ResourceBundle publicweb = ResourceBundle.getBundle("publicweb");
                result = publicweb.getString(str);
                logpath = getMachine(result);
                break;
            case "privateweb":
                ResourceBundle privateweb = ResourceBundle.getBundle("privateweb");
                result = privateweb.getString(str);
                logpath = getMachine(result);
                break;
            case "crm":
                ResourceBundle crm = ResourceBundle.getBundle("crm");
                result = crm.getString(str);
                logpath = getMachine(result);
                break;
            case "trafficmonitor":
                ResourceBundle trafficmonitor = ResourceBundle.getBundle("trafficmonitor");
                result = trafficmonitor.getString(str);
                logpath = getMachine(result);
                break;
            default:
        }
        return logpath;
    }

    public String[] getMachine(String machine) {
        String[] errorLogPaths = null;
        GetPropertiesData getPropertiesData = new GetPropertiesData();
        if (machine.equals("windows")) {
            errorLogPaths = new String[]{getPropertiesData.getData("errorlogPath-windows") + ",error.log"};
        } else if (machine.equals("linux")) {
//            errorLogPaths = new String[] {getPropertiesData.getData("errorlogPath-linux")};
            errorLogPaths = new String[]{getPropertiesData.getData("errorlogPath-linux") + ",error.log"};
        }
        return errorLogPaths;
    }
}
