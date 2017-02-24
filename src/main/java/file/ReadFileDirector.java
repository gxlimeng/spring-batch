package file;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/20.
 */
public class ReadFileDirector {

    // 排除的目录
    public static String[] EXCLUDE_DIRECTOR = new String[]{".svn", "target","www"};

    // 包含的文件
    public static String[] INCLUDE_FILE = new String[]{".xml"};

    public static Integer fileCount = 0;

    public static Map<String, String> TABLE_MAP = new HashMap<String, String>();

    public static void main(String[] args) {
        try {
//            readfile("D:\\Partner\\ecworkspace\\ocj");
//            initAllTable("D:\\Partner\\ecworkspace\\ocj\\TABLE.TXT");
            initAllTable("D:\\Partner\\ecworkspace\\ocj\\VIEWS.TXT");

            readfile("D:\\Partner\\ecworkspace\\ocj");

            System.out.println("SIZE="+TABLE_MAP.size());
            Iterator iter = TABLE_MAP.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                if(!entry.getValue().equals("0")) {
                    System.out.println("================"+entry.getKey() +" ===" + entry.getValue());
                }
            }


            //System.out.println("xml文件共计: " + fileCount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("ok");
    }

    private static void initAllTable(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            while ((tempString = reader.readLine()) != null) {
                //System.out.println(tempString);
                if (!TABLE_MAP.containsKey(tempString.toUpperCase().trim())) {
                    TABLE_MAP.put(tempString.toUpperCase().trim(), "0");
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readfile(String filepath) throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory() && matchExcludeFilePath(file.getName(), INCLUDE_FILE)) {
                fileCount++;
//                System.out.println("文件");
//                System.out.println("path=" + file.getPath());
//                System.out.println("absolutepath=" + file.getAbsolutePath());
//                System.out.println("name=" + file.getName());
                readFileByLines(file.getAbsolutePath());

            } else if (file.isDirectory() && !matchExcludeFilePath(file.getName(), EXCLUDE_DIRECTOR)) {
//                System.out.println("文件夹" + file.getAbsolutePath());
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory() && matchExcludeFilePath(readfile.getName(), INCLUDE_FILE)) {
                        fileCount++;
//                        System.out.println("path=" + readfile.getPath());
//                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
//                        System.out.println("name=" + readfile.getName());
                        readFileByLines(readfile.getAbsolutePath());

                    } else if (readfile.isDirectory() && !matchExcludeFilePath(file.getName(), EXCLUDE_DIRECTOR)) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
        return true;
    }


    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */

    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
//              System.out.println("line " + line + ": " + tempString);
                //System.out.println(tempString);
                if (matchTableName(tempString.trim().toUpperCase(),fileName)) {
                    //System.out.println(tempString);
                }
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    public static boolean matchTableName(String lineStr,String fileName){
        Iterator iter = TABLE_MAP.entrySet().iterator();
        boolean match = false;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            if(lineStr.indexOf(entry.getKey().toString()) != -1){
                TABLE_MAP.put(entry.getKey().toString(), fileName +"======"+lineStr);
                match = true;
            }
        }
        return match;
    }


    /**
     * 是否匹配 排除的目录
     *
     * @return
     */
    public static boolean matchExcludeFilePath(String pathString, String[] excludeStr) {
        for (String str : excludeStr) {
            if (pathString.indexOf(str) != -1) {
                return true;
            }
        }
        return false;
    }


}
