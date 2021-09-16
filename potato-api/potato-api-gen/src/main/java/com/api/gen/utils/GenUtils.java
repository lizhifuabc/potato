package com.api.gen.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成
 *
 * @author lizhifu
 * @date 2021/9/16
 */
public class GenUtils {
    private final static String ENTITY = "template/Entity.java.vm";
    private final static String MAPPER = "template/Mapper.java.vm";
    private final static String MAPPERXML = "template/Mapper.xml.vm";
    private final static String SERVICE = "template/Service.java.vm";
    private final static String SERVICEIMPL = "template/ServiceImpl.java.vm";
    private final static String CONTROLLER = "template/Controller.java.vm";
    private final static String PACKAGE = "package";
    private final static String MODULE_NAME = "moduleName";

    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add(ENTITY);
        templates.add(MAPPER);
        templates.add(MAPPERXML);
        templates.add(SERVICE);
        templates.add(SERVICEIMPL);
        templates.add(CONTROLLER);
        return templates;
    }
}
