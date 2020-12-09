package com.example.demo.entity;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
    @Value("${server.port:8080}")
    private int port = 8080;
    private String serverIp = "localhost";
    private Map<String, ApplicationProperties.Resource> slaves = new HashMap();
    public ApplicationProperties.Resource masterStore = new ApplicationProperties.Resource("/.application/files", "/files");
    private ApplicationProperties.Resource logStore = new ApplicationProperties.Resource("/.application/logs", "/logs");
    private ApplicationProperties.Cors cors = new ApplicationProperties.Cors();
    private ApplicationProperties.Docs docs = new ApplicationProperties.Docs();
    private ApplicationProperties.TaskExecutor taskExecutor = new ApplicationProperties.TaskExecutor();
    private List<Integer> ignoreErrors = new ArrayList();
    private ApplicationProperties.Email email = new ApplicationProperties.Email();

    public ApplicationProperties() {
    }

    public String getServerIp() {
        return this.serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public Map<String, ApplicationProperties.Resource> getSlaves() {
        return this.slaves;
    }

    public void setSlaves(Map<String, ApplicationProperties.Resource> slaves) {
        this.slaves = slaves;
    }

    public ApplicationProperties.Resource getMasterStore() {
        return this.masterStore;
    }

    public void setMasterStore(ApplicationProperties.Resource masterStore) {
        this.masterStore = masterStore;
    }

    public ApplicationProperties.Resource getLogStore() {
        return this.logStore;
    }

    public void setLogStore(ApplicationProperties.Resource logStore) {
        this.logStore = logStore;
    }

    public ApplicationProperties.Cors getCors() {
        return this.cors;
    }

    public void setCors(ApplicationProperties.Cors cors) {
        this.cors = cors;
    }

    public ApplicationProperties.Docs getDocs() {
        return this.docs;
    }

    public void setDocs(ApplicationProperties.Docs docs) {
        this.docs = docs;
    }

    public ApplicationProperties.TaskExecutor getTaskExecutor() {
        return this.taskExecutor;
    }

    public void setTaskExecutor(ApplicationProperties.TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public List<Integer> getIgnoreErrors() {
        return this.ignoreErrors;
    }

    public void setIgnoreErrors(List<Integer> ignoreErrors) {
        this.ignoreErrors = ignoreErrors;
    }

    public ApplicationProperties.Email getEmail() {
        return this.email;
    }

    public void setEmail(ApplicationProperties.Email email) {
        this.email = email;
    }

    public class Email {
        private String host;
        private int port = 465;
        private String from;
        private String username;
        private String password;
        private boolean useSsl = true;

        public Email() {
        }

        public String getHost() {
            return this.host;
        }

        public int getPort() {
            return this.port;
        }

        public String getFrom() {
            return this.from;
        }

        public String getUsername() {
            return this.username;
        }

        public String getPassword() {
            return this.password;
        }

        public boolean isUseSsl() {
            return this.useSsl;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setUseSsl(boolean useSsl) {
            this.useSsl = useSsl;
        }
    }

    public static class TaskExecutor {
        private int corePoolSize = 200;
        private int maxPoolSize = 300;

        public TaskExecutor() {
        }

        public int getCorePoolSize() {
            return this.corePoolSize;
        }

        public int getMaxPoolSize() {
            return this.maxPoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }
    }

    public static class Docs {
        private boolean enable = true;
        private String title = "系统接口文档";
        private String description;
        private String version = "1.0";
        private String basePackage = "cn.proem.projects";

        public Docs() {
        }

        public boolean isEnable() {
            return this.enable;
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public String getVersion() {
            return this.version;
        }

        public String getBasePackage() {
            return this.basePackage;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public void setBasePackage(String basePackage) {
            this.basePackage = basePackage;
        }
    }

    public static class Cors {
        private String[] allowDomains;
        private String[] headers;

        public Cors() {
        }

        public String[] getAllowDomains() {
            return this.allowDomains;
        }

        public String[] getHeaders() {
            return this.headers;
        }

        public void setAllowDomains(String[] allowDomains) {
            this.allowDomains = allowDomains;
        }

        public void setHeaders(String[] headers) {
            this.headers = headers;
        }
    }

    public static class Resource {
        private String path;
        private String mapping;

        public Resource() {
        }

        public Resource(String path, String mapping) {
            this.path = System.getProperty("user.dir").replace("\\", "/") + path;
            this.mapping = mapping;
        }

        public String getPath() {
            return this.path;
        }

        public String getMapping() {
            return this.mapping;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public void setMapping(String mapping) {
            this.mapping = mapping;
        }
    }
}
