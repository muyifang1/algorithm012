package sample.callcmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestCallCmd {

    /**
     * sourcePath 项目文件路径
     */
    public String mvnPackage(String sourcePath) {
        InputStream error = null;
        try {
            StringBuffer command = new StringBuffer();
            command.append("cmd /c c:");
            //这里的&&在多条语句的情况下使用，表示等上一条语句执行成功后在执行下一条命令，
            //也可以使用&表示执行上一条后台就立刻执行下一条语句
            command.append(String.format(" && cd %s", sourcePath));
            command.append(" && mvn -Dmaven.test.skip=true package");
            // command.append(" && ping 127.0.0.1");
            String cmdStr = "ping 127.0.0.1";
            Process p = Runtime.getRuntime().exec(cmdStr);
            error = p.getErrorStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(error));
            StringBuffer buffer = new StringBuffer();
            String s = "";
            while ((s = bufferedReader.readLine()) != null) {
                buffer.append(s);
            }
            bufferedReader.close();
            p.waitFor();
            if (p.exitValue() != 0) {
                return buffer.toString();
            } else {
                return "";
            }
        } catch (Exception ex) {
            if (error != null) {
                try {
                    error.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return ex.getMessage();
        }
    }

    public static void main(String[] args) {
        TestCallCmd test = new TestCallCmd();
        test.mvnPackage("C:\\Git_Hub\\springdemo\\Chapter 1\\hello-spring");
    }
}
