package module_14_exceptions_debug_test_log._14_7_lecture_logs;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

//import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class Logs {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logs.class);

    public Logs() {

        // 14.7

        /**
         * для упаковки файла в jar нужно установить maven plugin
         * maven-assembly-plugin
         *
         * далее в меню maven (что с права) нажать - install
         *
         * далее в папке target появиться два файлика *.jar
         * наш тот что с длинным именем
         */

        /*
        <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        </plugin>


        <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>3.3.0</version>
        <executions>
        <execution>
        <phase>package</phase>
        <goals>
        <goal>single</goal>
        </goals>
        </execution>
        </executions>
        <configuration>
        <archive>
        <manifest>
        <addClasspath>true</addClasspath>
        <mainClass>Main</mainClass>
        </manifest>
        </archive>
        <descriptorRefs>
        <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        </configuration>
        </plugin>
         */

        /**/

        /**
         * ИЛИ
         * https://javadevblog.com/sozdaem-yspolnyaemyj-jar-v-intellij-idea.html
         *
         * далее идем в терминал, и пишем:
         * java -jar SkillBox_Java_project.jar
         *
         * Создаст файл и запишет в него ошибки:
         * java -jar SkillBox_Java_project.jar > 2 error.log
         */

        System.err.println("test error");

        /* ----------------------------------------------------------------- */

        // 14.8
        /**
         * более удобное логирование происходит через log4j2
         */

        /*
        ставим через Maven конфиг:

        https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.19.0</version>
        </dependency>

        ставим в ручную:
        File - Project Structure - Libraries - + - From Maven -
        org.apache.logging.log4j - выбираем -
        org.apache.logging.log4j:log4j-1.2-api:2.19.0
         */

        /*
        xml конфиг, ложиться в resources/log4j2.xml

        <?xml version="1.0" encoding="UTF-8"?>
        <configuration status="WARN">
          <appenders>
            <Console name="Console" target="SYSTEM_OUT">
              <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
            </Console>

            <File name="MyFile" fileName="logs/app.log" immediateFlush="true">
                <PatternLayout pattern="%d{yyy-MM-dd HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
            </File>

          </appenders>
          <loggers>

            <logger name="filelogger" level="error">
                <appender-ref ref="MyFile"/>
            </logger>

            <root level="info">
              <appender-ref ref="Console"/>
            </root>
          </loggers>
        </configuration>
        */

        // создаем корневой логгер (org.apache.logging.log4j)
        // Logger logger = (Logger) LogManager.getRootLogger();

        // вариант №1
        logger.error("logger error");
        logger.info("logger info");
        logger.warn("logger warn");

        // вариант №2 - или регистрируем логи так (вроде так правильнее)
        logger.log(Level.ERROR, "Сообщение об ошибке");
        logger.log(Level.WARN, "Сообщение об ошибке");
        logger.log(Level.INFO, "Сообщение об ошибке");
    }
}
