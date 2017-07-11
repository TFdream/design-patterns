package com.mindflow.pattern.command.ch2;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-28 14:42
 */
public class StopCommand implements Command {
    private AudioPlayer audioPlayer;

    public StopCommand(AudioPlayer audioPlayer){
        this.audioPlayer = audioPlayer;
    }
    
    @Override
    public void execute() {
        this.audioPlayer.stop();
    }
}
