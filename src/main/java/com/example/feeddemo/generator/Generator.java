package com.example.feeddemo.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Generator {
    /**
     * 读取控制台内容
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * RUN THIS
     */
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");//获取当前工程路径
        // 1. 全局配置
        GlobalConfig config = new GlobalConfig();
        config.setOutputDir(projectPath + "/src/main/java")
                .setActiveRecord(true) // 是否支持AR模式
                .setAuthor("xiedong")//生成作者注释
                .setOpen(false)//生成后是否打开资源管理器
                .setFileOverride(true) // 是否覆盖已有文件
//                .setSwagger2(true) //开启Swagger2模式- 实体属性 Swagger2 注解
                .setActiveRecord(false) // 不需要ActiveRecord特性的请改为false
                .setEnableCache(false)  // XML 二级缓存
                .setBaseResultMap(false)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setIdType(IdType.AUTO) // 主键策略
                .setDateType(DateType.ONLY_DATE)//定义生成的实体类中日期类型
                .setServiceName("%sService")  //默认service接口名IXXXService 自定义指定之后就不会用I开头了
                .setBaseResultMap(true)//生成基本的resultMap
                .setBaseColumnList(true);//生成基本的SQL片段
       /* //全局配置
        GlobalConfig config = new GlobalConfig();
        //获取当前系统目录

        config.setOutputDir(projectPath + "/src/main/java");
        config.setAuthor("dong");  //生成作者注释
        config.setOpen(false); //生成后是否打开资源管理器
        config.setFileOverride(false); //重新生成时文件是否覆盖
        config.setServiceName("%sService"); //去掉Service接口的首字母I
        config.setIdType(IdType.ID_WORKER); //主键策略
        config.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        config.setSwagger2(false);//开启Swagger2模式*/



        // 2. 数据源配置
        DataSourceConfig dsConfig = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)//数据库类型
                .setUrl("jdbc:mysql://www.xdblog.site:3308/feed_demo?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8")  //url
                .setSchemaName("feed_demo")
                .setDriverName("com.mysql.jdbc.Driver") //数据库驱动
                .setUsername("root")//数据库账号
                .setPassword("1234567");//数据库密码


        // 3.包配置
        PackageConfig pkConfig = new PackageConfig();
//        pkConfig.setModuleName(scanner("模块名"));//模块名,可以不设置
        pkConfig.setParent("com.example.feeddemo");//放在哪个包下


        // 4. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)// lombok 模型 @Accessors(chain = true) setter链式操作
                //  .setInclude(scanner("表名"))//对哪一张表生成代码(控制台输入的方式)
                .setInclude("user")//对哪一张表生成代码
                .setSuperEntityColumns("id")
                .setControllerMappingHyphenStyle(true)//url中驼峰转连字符
                .setTablePrefix(pkConfig.getModuleName() + "_")//生成实体时去掉表前缀
//                .setLogicDeleteFieldName("deleted") //逻辑删除字段设置
                .setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略

        // 5. 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return projectPath + "/src/main/resources/mappers/" + pkConfig.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);

        /**
         *          // 自定义实体父类
         *   strategy.setSuperEntityClass("com.zhaonian.plusdemo.generator.common.BaseEntity");
         *         // 自定义 service 实现类父类
         *   strategy.setSuperServiceImplClass("com.anta.it.hr.model.service.BaseService");
         *         // 自定义 controller 父类
         *   strategy.setSuperControllerClass("com.zhaonian.plusdemo.generator.common.BaseController");
         */
        // 创建代码生成器对象
        AutoGenerator mpg = new AutoGenerator();
        //6. 整合配置
        mpg.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setPackageInfo(pkConfig);
//                .setStrategy(stConfig);
        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setCfg(cfg);
        mpg.setTemplate(new TemplateConfig().setXml(null));


        //7.执行
        mpg.execute();

    }
}
