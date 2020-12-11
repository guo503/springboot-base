package com.tsyj.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalFileUtils {

    private final static Logger logger = LoggerFactory.getLogger(LocalFileUtils.class);


    public static void main(String[] args) {
        //String filePath = generateBmp("https://oss.pdabc.com/20181211/b44dbdf7-30aa-41d0-b2ae-4f4a20ed68b2.png");
        //System.out.println("filePath = " + filePath);
        deleteFile("D:\\cc85f18cbf874d55b0e0baae2b2c6a28.bmp");
    }


    public static void readFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void writeFile(File file, String content) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        osw.write(content);
        osw.flush();
    }

    public static void appendFile(File file, String content) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(
                new FileOutputStream(file, true), // true to append
                StandardCharsets.UTF_8
        );
        out.write(content);
        out.close();
    }


    /**
     * @param filePath
     * @param content
     * @param targetLineNum:要写入位置的行号
     * @throws Exception
     */
    public static void randomAccessAppend(String filePath, String content, int targetLineNum) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
        int currentLineNum = 0;
        if (currentLineNum > targetLineNum) {
            return;
        }
        while (raf.readLine() != null) {
            if (currentLineNum == targetLineNum) { // 定位到目标行时结束
                break;
            }
            currentLineNum++;
        }
        raf.write(("\r\n" + (content)).getBytes());
        raf.close();
    }

    public static void insert(String fileName, long pos, String content) throws IOException {
        //创建临时空文件
        File tempFile = File.createTempFile("temp", null);
        //在虚拟机终止时，请求删除此抽象路径名表示的文件或目录
        tempFile.deleteOnExit();
        FileOutputStream fos = new FileOutputStream(tempFile);

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(pos);
        byte[] buffer = new byte[4];
        int num;
        while (-1 != (num = raf.read(buffer))) {
            fos.write(buffer, 0, num);
        }
        raf.seek(pos);
        raf.write(content.getBytes());
        FileInputStream fis = new FileInputStream(tempFile);
        while (-1 != (num = fis.read(buffer))) {
            raf.write(buffer, 0, num);
        }
    }


    /**
     * 修改匹配到的行内容
     *
     * @param filePath:文件路径
     * @param oldStr:       被替换的字符串
     * @param newStr:       替换的字符串
     */
    public static void modifyLine(String filePath, String oldStr, String newStr) {
        try {
            Pattern pattern = Pattern.compile(oldStr, Pattern.CASE_INSENSITIVE); // 要匹配的字段内容，正则表达式
            Matcher matcher = pattern.matcher("");
            List<String> lines = Files.readAllLines(Paths.get(filePath)); // 读取文本文件
            if (lines == null || lines.size() == 0) {
                return;
            }
            int size = lines.size();
            if ("}".equals(oldStr)) {
                //如果是},倒叙排列
            }

            for (int i = 0; i < size; i++) {
                matcher.reset(lines.get(i));
                if (matcher.find()) { // 匹配正则表达式
                    lines.remove(i);
                    lines.add(i, newStr);
                    //如果是},倒叙排列，取第一个
                    if (oldStr.contains("package") || "}".equals(oldStr)) {
                        break;
                    }
                }
            }
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getPath(String packagePath) {
        return File.separator + packagePath.replace(".", File.separator) + File.separator;
    }


    public static void doExport(String fileUrl, HttpServletRequest request, HttpServletResponse response) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String fileName = "学生作业-" + DateUtils.formatDate(new Date(), 0) + ".xlsx";
        try {
            URL url = new URL(fileUrl);
            InputStream inputStream = url.openStream();
            request.setCharacterEncoding("UTF-8");
            String agent = request.getHeader("User-Agent").toUpperCase();
            if ((agent.indexOf("MSIE") > 0) || (agent.contains("RV") && (agent.contains("FIREFOX"))))
                fileName = URLEncoder.encode(fileName, "UTF-8");
            else {
                fileName = new String(fileName.getBytes(StandardCharsets.UTF_8), "ISO8859-1");
            }
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            //response.setHeader("Content-Length", inputStream);
            bis = new BufferedInputStream(inputStream);
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[102400];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
                bos.write(buff, 0, bytesRead);
            System.out.println("success");
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("导出文件失败！");
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
                //file.delete();
            } catch (Exception e) {
                logger.info("导出文件关闭流出错！", e);
            }
        }
    }


    public static void deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (Exception e) {
            logger.info("文件删除失败,filePath = {},[error] = {}", filePath, ExceptionUtils.getExceptionMsg(e));
        }
    }


    /**
     * 生成位图
     *
     * @param url 位图路径
     * @return float
     * @author guos
     * @date 2019/10/9 10:36
     **/
    public static String generateBmp(String url) {
        if (StringUtils.isEmpty(url)) {
            return "";
        }
        logger.info("[url] = {}", url);
        String filePath = getPath();
        try {
            BitMapUtil.image2RGBBmp(new URL(url), filePath);
        } catch (MalformedURLException e) {
            logger.info("图片转rgb位图出错,异常信息[error] = {}", ExceptionUtils.getExceptionMsg(e));
            throw new RuntimeException("图片转rgb位图出错");
        }
        return filePath;
    }

    private static String getPath() {
        return "D:\\" + StrUtils.uuid() + ".bmp";
    }
}