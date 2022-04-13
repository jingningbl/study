package com.circular;

/**
 * @author bai
 * @version V1.0
 * @Package com.circular
 * @date 2022/2/5 10:36
 * @describe
 */
public class DependencyA {
    private DependencyB dependencyB;

    public DependencyA() {
    }

    public DependencyA(DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }

    public DependencyB getDependencyB() {
        return dependencyB;
    }

    public void setDependencyB(DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }
}
