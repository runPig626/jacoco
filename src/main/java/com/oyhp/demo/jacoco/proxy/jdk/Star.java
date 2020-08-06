package com.oyhp.demo.jacoco.proxy.jdk;

/**
 * @author OuYangHaiPing<ouyanghaiping @ pvc123.com>
 * @date 2020-08-06
 */
public class Star implements ShowService{
    private String name;

    public Star(){}

    public Star(String name) {
        this.name = name;
    }

    @Override
    public void sing(String songName) {
        System.out.println(this.name + " sing a song: " + songName);
    }

    @Override
    public void dance() {
        System.out.println(this.name + "dance");
    }
}
