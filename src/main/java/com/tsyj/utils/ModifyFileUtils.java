import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 修改文件或者递归目录下文件内容
 *
 * @author: guos
 * @date: 2019/11/22 19:27
 **/
public class ModifyFileUtils {

    /**
     * @param filePath 文件路径
     * @param oldStr   搜索内容
     * @param newStr   替换内容
     * @return
     * @author guos
     * @date 2019/11/22 16:36
     **/
    public static List<String> replace(String filePath, String oldStr, String newStr) {
        List<String> fileNames = new ArrayList<>();
        if (Objects.isNull(oldStr)) {
            return fileNames;
        }
        File file = new File(filePath);
        travel(fileNames, file, oldStr, newStr);
        return fileNames;
    }


    private static void travel(List<String> fileNames, File file, String oldStr, String newStr) {
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        String name = file.getName();
        if (file.isDirectory()) {
            if (name.contains(".git") || name.contains(".target")) {
                return;
            }
            File[] fs = file.listFiles();
            if (fs == null || fs.length == 0) {
                return;
            }
            for (File f : fs) {
                travel(fileNames, f, oldStr, newStr);
            }
            String filePath = file.getPath();
            //如果是包路径替换时,在文件替换完后,将目录名也替换了
            if (oldStr.contains("package") && newStr.contains("package") && oldStr.contains(".") && newStr.contains(".")) {
                String[] o = oldStr.split("\\.");
                String[] n = newStr.split("\\.");
                int index = -1;
                for (int i = 0; i < o.length; i++) {
                    if (name.equals(o[i])) {
                        index = i;
                        break;
                    }
                }
                //旧字符串能查到,且对应位置,旧的不等于新的
                if (index >= 0 && index < n.length && !o[index].equals(n[index])) {
                    String newPath = filePath.substring(0, filePath.lastIndexOf(File.separator) + 1) + n[index];
                    System.out.println(newPath);
                    file.renameTo(new File(newPath));
                    fileNames.add(filePath);
                }
            }
        } else {
            boolean notNeed = name.contains(".gitignore") || name.contains(".iml");
            if (notNeed) {
                return;
            }
            if (replace(file, oldStr, newStr)) {
                fileNames.add(file.getPath());
            }
        }
    }

    private static boolean replace(File file, String oldStr, String newStr) {
        try {
            FileReader fis = new FileReader(file);// 创建文件输入流
            char[] data = new char[1024];// 创建缓冲字符数组
            int rn;
            StringBuilder sb = new StringBuilder();// 创建字符串构建器
            while ((rn = fis.read(data)) > 0) {// 读取文件内容到字符串构建器
                String str = String.valueOf(data, 0, rn);
                sb.append(str);
            }
            fis.close();// 关闭输入流
            // 从构建器中生成字符串，并替换搜索文本
            String str = sb.toString().replace(oldStr, newStr);
            if (str.equals(sb.toString())) {
                return false;
            }
            FileWriter fout = new FileWriter(file);// 创建文件输出流
            fout.write(str.toCharArray());// 把替换完成的字符串写入文件内
            fout.close();// 关闭输出流
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
