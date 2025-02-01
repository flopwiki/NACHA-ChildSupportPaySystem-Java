@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem
@rem SPDX-License-Identifier: Apache-2.0
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  nacha-paymentsystem startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and NACHA_PAYMENTSYSTEM_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\nacha-paymentsystem-1.0-SNAPSHOT-plain.jar;%APP_HOME%\lib\spring-boot-starter-web-3.3.4.jar;%APP_HOME%\lib\dependency-check-gradle-10.0.2.jar;%APP_HOME%\lib\spring-boot-starter-data-jpa-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-security-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-amqp-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-json-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-aop-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-jdbc-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-3.3.4.jar;%APP_HOME%\lib\spring-boot-starter-logging-3.3.4.jar;%APP_HOME%\lib\logback-classic-1.4.11.jar;%APP_HOME%\lib\dependency-check-core-10.0.2.jar;%APP_HOME%\lib\dependency-check-utils-10.0.2.jar;%APP_HOME%\lib\spring-data-jpa-3.3.4.jar;%APP_HOME%\lib\jcs3-slf4j-1.0.5.jar;%APP_HOME%\lib\cpe-parser-2.1.0.jar;%APP_HOME%\lib\velocity-engine-core-2.3.jar;%APP_HOME%\lib\ossindex-service-client-1.8.2.jar;%APP_HOME%\lib\packager-rpm-0.19.0.jar;%APP_HOME%\lib\HikariCP-5.1.0.jar;%APP_HOME%\lib\spring-data-commons-3.3.4.jar;%APP_HOME%\lib\spring-rabbit-3.1.7.jar;%APP_HOME%\lib\amqp-client-5.21.0.jar;%APP_HOME%\lib\log4j-to-slf4j-2.23.1.jar;%APP_HOME%\lib\jul-to-slf4j-2.0.16.jar;%APP_HOME%\lib\open-vulnerability-clients-6.1.2.jar;%APP_HOME%\lib\httpclient5-5.3.1.jar;%APP_HOME%\lib\ossindex-service-api-1.8.2.jar;%APP_HOME%\lib\jcl-over-slf4j-2.0.16.jar;%APP_HOME%\lib\slf4j-api-2.0.9.jar;%APP_HOME%\lib\kotlin-reflect-1.9.25.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.9.25.jar;%APP_HOME%\lib\kotlin-stdlib-1.9.25.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.9.25.jar;%APP_HOME%\lib\h2-2.2.224.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-3.3.4.jar;%APP_HOME%\lib\spring-webmvc-6.1.13.jar;%APP_HOME%\lib\spring-security-web-6.3.3.jar;%APP_HOME%\lib\spring-web-6.1.13.jar;%APP_HOME%\lib\slack-webhook-1.4.0.jar;%APP_HOME%\lib\hibernate-core-6.5.3.Final.jar;%APP_HOME%\lib\spring-aspects-6.1.13.jar;%APP_HOME%\lib\spring-security-config-6.3.3.jar;%APP_HOME%\lib\spring-boot-autoconfigure-3.3.4.jar;%APP_HOME%\lib\spring-boot-3.3.4.jar;%APP_HOME%\lib\spring-security-core-6.3.3.jar;%APP_HOME%\lib\spring-context-6.1.13.jar;%APP_HOME%\lib\spring-aop-6.1.13.jar;%APP_HOME%\lib\spring-messaging-6.1.13.jar;%APP_HOME%\lib\logback-core-1.5.8.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\spring-orm-6.1.13.jar;%APP_HOME%\lib\spring-jdbc-6.1.13.jar;%APP_HOME%\lib\spring-tx-6.1.13.jar;%APP_HOME%\lib\spring-beans-6.1.13.jar;%APP_HOME%\lib\spring-expression-6.1.13.jar;%APP_HOME%\lib\spring-amqp-3.1.7.jar;%APP_HOME%\lib\spring-core-6.1.13.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.17.2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.17.2.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.17.2.jar;%APP_HOME%\lib\jackson-module-afterburner-2.17.2.jar;%APP_HOME%\lib\jackson-module-blackbird-2.17.2.jar;%APP_HOME%\lib\jackson-databind-2.17.2.jar;%APP_HOME%\lib\jackson-annotations-2.17.2.jar;%APP_HOME%\lib\jackson-core-2.17.2.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.17.2.jar;%APP_HOME%\lib\snakeyaml-2.2.jar;%APP_HOME%\lib\tomcat-embed-websocket-10.1.30.jar;%APP_HOME%\lib\tomcat-embed-core-10.1.30.jar;%APP_HOME%\lib\tomcat-embed-el-10.1.30.jar;%APP_HOME%\lib\micrometer-observation-1.13.4.jar;%APP_HOME%\lib\jdiagnostics-1.0.7.jar;%APP_HOME%\lib\pecoff4j-0.0.2.1.jar;%APP_HOME%\lib\commons-jcs3-core-3.2.1.jar;%APP_HOME%\lib\packageurl-java-1.5.0.jar;%APP_HOME%\lib\semver4j-5.3.0.jar;%APP_HOME%\lib\commons-collections4-4.4.jar;%APP_HOME%\lib\commons-compress-1.26.2.jar;%APP_HOME%\lib\commons-io-2.16.1.jar;%APP_HOME%\lib\commons-text-1.12.0.jar;%APP_HOME%\lib\commons-lang3-3.14.0.jar;%APP_HOME%\lib\commons-dbcp2-2.12.0.jar;%APP_HOME%\lib\lucene-analyzers-common-8.11.3.jar;%APP_HOME%\lib\lucene-queryparser-8.11.3.jar;%APP_HOME%\lib\lucene-core-8.11.3.jar;%APP_HOME%\lib\javax.json-1.1.4.jar;%APP_HOME%\lib\jsoup-1.17.2.jar;%APP_HOME%\lib\retirejs-core-3.0.4.jar;%APP_HOME%\lib\guava-33.2.1-jre.jar;%APP_HOME%\lib\toml4j-0.7.2.jar;%APP_HOME%\lib\aho-corasick-double-array-trie-1.2.3.jar;%APP_HOME%\lib\commons-validator-1.9.0.jar;%APP_HOME%\lib\commons-beanutils-1.9.4.jar;%APP_HOME%\lib\gson-2.10.1.jar;%APP_HOME%\lib\aspectjweaver-1.9.22.1.jar;%APP_HOME%\lib\jakarta.persistence-api-3.1.0.jar;%APP_HOME%\lib\jakarta.transaction-api-2.0.1.jar;%APP_HOME%\lib\jboss-logging-3.5.3.Final.jar;%APP_HOME%\lib\hibernate-commons-annotations-6.0.6.Final.jar;%APP_HOME%\lib\jandex-3.1.2.jar;%APP_HOME%\lib\classmate-1.7.0.jar;%APP_HOME%\lib\byte-buddy-1.14.19.jar;%APP_HOME%\lib\jaxb-runtime-4.0.5.jar;%APP_HOME%\lib\jaxb-core-4.0.5.jar;%APP_HOME%\lib\jakarta.xml.bind-api-4.0.2.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.1.jar;%APP_HOME%\lib\antlr4-runtime-4.13.0.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\spring-jcl-6.1.13.jar;%APP_HOME%\lib\micrometer-commons-1.13.4.jar;%APP_HOME%\lib\jmustache-1.16.jar;%APP_HOME%\lib\commons-codec-1.16.1.jar;%APP_HOME%\lib\commons-pool2-2.12.0.jar;%APP_HOME%\lib\commons-logging-1.3.2.jar;%APP_HOME%\lib\lucene-queries-8.11.3.jar;%APP_HOME%\lib\lucene-sandbox-8.11.3.jar;%APP_HOME%\lib\android-json-0.0.20131108.vaadin1.jar;%APP_HOME%\lib\minlog-1.3.1.jar;%APP_HOME%\lib\compiler-0.9.6.jar;%APP_HOME%\lib\javax.inject-1.jar;%APP_HOME%\lib\joda-time-2.10.4.jar;%APP_HOME%\lib\jaxb-api-2.3.1.jar;%APP_HOME%\lib\failureaccess-1.0.2.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-3.42.0.jar;%APP_HOME%\lib\error_prone_annotations-2.26.1.jar;%APP_HOME%\lib\commons-digester-2.1.jar;%APP_HOME%\lib\commons-collections-3.2.2.jar;%APP_HOME%\lib\packager-core-0.19.0.jar;%APP_HOME%\lib\xz-1.9.jar;%APP_HOME%\lib\angus-activation-2.0.2.jar;%APP_HOME%\lib\jakarta.activation-api-2.1.3.jar;%APP_HOME%\lib\spring-security-crypto-6.3.3.jar;%APP_HOME%\lib\spring-retry-2.0.9.jar;%APP_HOME%\lib\log4j-api-2.23.1.jar;%APP_HOME%\lib\httpcore5-h2-5.2.5.jar;%APP_HOME%\lib\httpcore5-5.2.5.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\package-url-java-1.1.1.jar;%APP_HOME%\lib\javax.activation-api-1.2.0.jar;%APP_HOME%\lib\bcpg-jdk18on-1.71.jar;%APP_HOME%\lib\bcprov-jdk18on-1.71.jar;%APP_HOME%\lib\txw2-4.0.5.jar;%APP_HOME%\lib\istack-commons-runtime-4.1.2.jar


@rem Execute nacha-paymentsystem
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %NACHA_PAYMENTSYSTEM_OPTS%  -classpath "%CLASSPATH%" org.nacha.paymentsystem.Main %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable NACHA_PAYMENTSYSTEM_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%NACHA_PAYMENTSYSTEM_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
