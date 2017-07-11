package com.mindflow.pattern.command.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 14:47
 */
public class Keypad {
    private Command playCommand;
    private Command rewindCommand;
    private Command stopCommand;

    public Keypad(Command playCommand, Command rewindCommand, Command stopCommand) {
        this.playCommand = playCommand;
        this.rewindCommand = rewindCommand;
        this.stopCommand = stopCommand;
    }

    /**
     * 执行播放方法
     */
    public void play(){
        playCommand.execute();
    }

    /**
     * 执行倒带方法
     */
    public void rewind(){
        rewindCommand.execute();
    }

    /**
     * 执行播放方法
     */
    public void stop(){
        stopCommand.execute();
    }
}
