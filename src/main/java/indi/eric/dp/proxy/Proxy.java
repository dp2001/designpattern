package indi.eric.dp.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by qinsheng on 2018/8/19.
 */
public class Proxy {
    public static Object newProxyInstance(Class infce, InvocationHandler h) throws Exception {
        String rt = "\r";
        String methodString = "";
        Method[] methods = infce.getMethods();
        for(Method method : methods) {
            methodString += "    public void " + method.getName() + "(){" + rt +
                    "        try {" + rt +
                    "            Method md = " + infce.getName() + ".class.getMethod(\"" + method.getName() + "\");" + rt +
                    "            h.invoke(this, md);" + rt +
                    "        }catch(Exception e) {e.printStackTrace();}" + rt +
                    "    }";
        }


        String src =
                "package indi.eric.dp.proxy;" + rt +
                "import java.lang.reflect.Method;" + rt +
                "public class $Proxy1 implements " + infce.getName() + "{" + rt +

                "    public $Proxy1(InvocationHandler h){" + rt +
                "        this.h = h;" + rt +
                "    }" + rt +
                "    indi.eric.dp.proxy.InvocationHandler h;" + rt +

                methodString + rt +

                "}";

        System.out.println(System.getProperty("user.dir"));
        String fileName = System.getProperty("user.dir") + "/src/main/java/indi/eric/dp/proxy/$Proxy1.java";

        File f = new File(fileName);

        FileWriter fw = new FileWriter(f);
        fw.write(src);
        fw.flush();
        fw.close();

        //compile
        JavaCompiler compiler = (JavaCompiler) ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable iterable = fileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, iterable);
        task.call();
        fileManager.close();

        //load into memory and create an instance
        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src/main/java/")};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class c = urlClassLoader.loadClass("indi.eric.dp.proxy.$Proxy1");
        System.out.println(c);

        Constructor constructor = c.getConstructor(InvocationHandler.class);
        Object m = constructor.newInstance(h);

        return m;
    }
}
