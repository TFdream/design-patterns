package com.bytebeats.pattern.command.ch2;

/**
 * 接收者角色，由录音机类扮演
 *
 * @author Ricky Fung
 * @date 2017-02-28 14:41
 */
public class AudioPlayer {

    public void play(){
        System.out.println("播放...");
    }

    public void rewind(){
        System.out.println("倒带...");
    }

    public void stop(){
        System.out.println("停止...");
    }
}
