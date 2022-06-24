package com.khalil.junit.environment;

public class TestsEnvironment {
    private JavaSpecification javaSpecification;
    private OperationSystem operationSystem;

    public TestsEnvironment(JavaSpecification javaSpecification, OperationSystem operationSystem) {
        this.javaSpecification = javaSpecification;
        this.operationSystem = operationSystem;
    }

    public boolean isWindows() {
        return operationSystem.getName().contains("Windows");
    }

    public boolean isAmd64Architecture() {
        return operationSystem.getArchitecture().equals("amd64");
    }

    public String getJavaVersion() {
        return javaSpecification.getVersion();
    }

}