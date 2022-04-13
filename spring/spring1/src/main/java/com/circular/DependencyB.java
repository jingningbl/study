package com.circular;

/**
 * @author bai
 * @version V1.0
 * @Package com.circular
 * @date 2022/2/5 10:37
 * @describe
 */
public class DependencyB {
    private DependencyA dependencyA;

    public DependencyB() {
    }

    public DependencyB(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }

    public DependencyA getDependencyA() {
        return dependencyA;
    }

    public void setDependencyA(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }
}
