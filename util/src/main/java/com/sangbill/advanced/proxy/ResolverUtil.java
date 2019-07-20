package com.sangbill.advanced.proxy;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class ResolverUtil<T> {
	
	public Set<Class<? extends T>> getClasses(String packageName) {
		Collection<? extends Class<? extends T>> clazzList = getClasssFromPackage(packageName);
		Set<Class<? extends T>> matches = new HashSet<Class<? extends T>>();
		matches.addAll(clazzList);
		return matches;
	}

	 /**
     * 获得包下面的所有的class
     *
     * @param
     *
     * @return List包含所有class的实例
     */

    public  Collection<Class<T>> getClasssFromPackage(String packageName) {
        Collection<Class<T>> clazzs = new ArrayList<>();
        // 是否循环搜索子包
        boolean recursive = true;
        // 包名对应的路径名称
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs;

        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            while (dirs.hasMoreElements()) {

                URL url = dirs.nextElement();
                String protocol = url.getProtocol();

                if ("file".equals(protocol)) {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findClassInPackageByFile(packageName, filePath, recursive, clazzs);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return clazzs;
    }

    /**
     * 在package对应的路径下找到所有的class
     */
    public void findClassInPackageByFile(String packageName, String filePath, final boolean recursive,
                                                Collection<Class< T>> clazzs) {
        File dir = new File(filePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 在给定的目录下找到所有的文件，并且进行条件过滤
        File[] dirFiles = dir.listFiles(new FileFilter() {

            public boolean accept(File file) {
                boolean acceptDir = recursive && file.isDirectory();// 接受dir目录
                boolean acceptClass = file.getName().endsWith("class");// 接受class文件
                return acceptDir || acceptClass;
            }
        });

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        for (File file : dirFiles) {
            if (file.isDirectory()) {
                findClassInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, clazzs);
            } else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                	@SuppressWarnings("unchecked")
					Class<T> clazz = (Class<T>) classLoader.loadClass(packageName + "." + className);
                    clazzs.add(clazz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
