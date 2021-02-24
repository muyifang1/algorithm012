package sample.callcmd;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Command {
    public static void exeCmd(String commandStr) {
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream(), "gbk"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
//        String commandStr = "ping 127.0.0.1";
        // mvn 打包执行没问题
//        String cmdTest = "cmd /c cd C:\\Git_Hub\\springdemo\\Chapter 1\\hello-spring && mvn -Dmaven.test.skip=true package";
        // 执行jar包 感觉好像卡住了
//        String cmdTest = "cmd /c cd C:\\Git_Hub\\springdemo\\Chapter 1\\hello-spring && java -jar hello-spring-0.0.1-SNAPSHOT.jar";
        // 最终目的想 类似这样 先打一个jar，然后执行。 这个执行没反应
        String cmdTest = "cmd /c cd C:\\Git_Hub\\springdemo\\Chapter 1\\hello-spring && mvn -Dmaven.test.skip=true package && cd C:\\Git_Hub\\springdemo\\Chapter 1\\hello-spring\\target && java -jar hello-spring-0.0.1-SNAPSHOT.jar";
        Command.exeCmd(cmdTest);
//        Command.exeCmd("cmd /c && java -version");
    }
}
